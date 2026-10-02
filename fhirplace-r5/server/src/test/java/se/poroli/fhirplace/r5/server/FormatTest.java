package se.poroli.fhirplace.r5.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Content negotiation: JSON and XML, {@code _format} and {@code _pretty}. */
class FormatTest {

    @Test
    void acceptHeaderSelectsXml() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply reply = TestServer.get("Patient/" + created.id(), "Accept", "application/fhir+xml");

        assertTrue(reply.header("Content-Type").startsWith("application/fhir+xml"));
        assertEquals(created, FhirXml.read(reply.body(), Patient.class));
    }

    @Test
    void formatParameterOverridesTheAcceptHeader() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply reply = TestServer.get("Patient/" + created.id() + "?_format=xml",
                "Accept", "application/fhir+json");

        assertTrue(reply.header("Content-Type").startsWith("application/fhir+xml"));
    }

    @Test
    void prettyParameterIndentsJson() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply pretty = TestServer.get("Patient/" + created.id() + "?_pretty=true");
        TestServer.Reply compact = TestServer.get("Patient/" + created.id());

        assertTrue(pretty.body().contains("\n"));
        assertTrue(!compact.body().contains("\n"));
        assertEquals(FhirJson.read(compact.body()), FhirJson.read(pretty.body()));
    }

    @Test
    void xmlBodiesAreAccepted() {
        String xml = FhirXml.write(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply reply = TestServer.post("Patient", xml, "Content-Type", "application/fhir+xml",
                "Accept", "application/fhir+xml");

        assertEquals(201, reply.status());
        assertTrue(reply.body().startsWith("<Patient xmlns=\"http://hl7.org/fhir\">"));
    }

    @Test
    void errorsFollowTheRequestedFormat() {
        TestServer.Reply reply = TestServer.get("Patient/missing", "Accept", "application/fhir+xml");

        assertEquals(404, reply.status());
        assertTrue(reply.header("Content-Type").startsWith("application/fhir+xml"));
        assertTrue(reply.body().startsWith("<OperationOutcome"));
    }
}
