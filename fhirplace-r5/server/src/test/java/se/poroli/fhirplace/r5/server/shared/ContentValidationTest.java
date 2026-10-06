package se.poroli.fhirplace.r5.server.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;

/**
 * Invalid content: content that cannot be read is answered with 400 or 422 and an issue that says what and where, and
 * a handler's validator decides the rest.
 */
public class ContentValidationTest {

    private static OperationOutcome.Issue issue(TestServer.Reply reply) {
        return Fixtures.outcome(reply).issue().getFirst();
    }

    private static String expression(TestServer.Reply reply) {
        return issue(reply).expression().getFirst().value();
    }

    @Test
    void malformedContentIsABadRequest() {
        TestServer.Reply reply = TestServer.post("Patient", "{\"resourceType\":\"Patient\",");

        assertEquals(400, reply.status());
        assertEquals("invalid", issue(reply).code().valueAsString());
    }

    @Test
    void malformedUrlEncodingIsABadRequest() {
        // Some web servers reject these before fhirplace sees them; either way the answer is 400.
        assertEquals(400, TestServer.get("Patient?family=%ZZ").status());
        assertEquals(400, TestServer.get("Patient/a%ZZ").status());
    }

    @Test
    void unknownElementsAreABadRequest() {
        TestServer.Reply reply = TestServer.post("Patient", "{\"resourceType\":\"Patient\",\"shoeSize\":42}");

        assertEquals(400, reply.status());
        assertEquals("structure", issue(reply).code().valueAsString());
        assertEquals("Patient", expression(reply));
        assertEquals("unknown element 'shoeSize'", issue(reply).diagnostics().value());
    }

    @Test
    void missingRequiredElementsAreUnprocessable() {
        TestServer.Reply reply = TestServer.post("Patient",
                "{\"resourceType\":\"Patient\",\"link\":[{\"type\":\"refer\"}]}");

        assertEquals(422, reply.status());
        assertEquals("required", issue(reply).code().valueAsString());
        assertEquals("Patient.link[0]", expression(reply));
    }

    @Test
    void invalidValuesAreUnprocessableInJsonAndXml() {
        TestServer.Reply json = TestServer.post("Patient",
                "{\"resourceType\":\"Patient\",\"birthDate\":\"1974-13-45\"}");
        TestServer.Reply xml = TestServer.post("Patient",
                "<Patient xmlns=\"http://hl7.org/fhir\"><birthDate value=\"1974-13-45\"/></Patient>",
                "Content-Type", "application/fhir+xml");

        assertEquals(422, json.status());
        assertEquals("value", issue(json).code().valueAsString());
        assertEquals("Patient.birthDate", expression(json));
        assertEquals(422, xml.status());
        assertEquals("Patient.birthDate", expression(xml));
    }

    @Test
    void handlerValidationErrorsAreAnsweredWithTheirIssues() {
        TestServer.Reply reply = TestServer.post("Patient", FhirJson.write(Fixtures.patient("Rejected")));

        assertEquals(422, reply.status());
        assertEquals("business-rule", issue(reply).code().valueAsString());
        assertEquals("The family name Rejected is not accepted", issue(reply).details().text().value());
        assertNull(issue(reply).diagnostics());
        assertEquals("Patient.name[0].family", expression(reply));
    }

    @Test
    void handlerValidationWarningsDoNotBlock() {
        TestServer.Reply reply = TestServer.post("Patient", "{\"resourceType\":\"Patient\",\"active\":true}");

        assertEquals(201, reply.status());
    }
}
