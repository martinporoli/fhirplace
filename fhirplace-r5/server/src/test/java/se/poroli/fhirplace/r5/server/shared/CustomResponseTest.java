package se.poroli.fhirplace.r5.server.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;

/** Handlers choosing their own responses: custom outcomes, statuses and headers, and reading the request. */
public class CustomResponseTest {

    @Test
    void handlersCanAnswerNotFoundWithTheirOwnOutcome() {
        TestServer.Reply reply = TestServer.get("Patient/" + PatientHandler.ARCHIVED);

        assertEquals(404, reply.status());
        OperationOutcome.Issue issue = Fixtures.outcome(reply).issue().getFirst();
        assertEquals("Patient is archived", issue.details().text().value());
        assertEquals("Patient/archived was archived; ask the records office", issue.diagnostics().value());
    }

    @Test
    void unexpectedHandlerFailuresAreInternalServerErrorsWithoutDetails() {
        TestServer.Reply reply = TestServer.get("Patient/" + PatientHandler.CRASH);

        assertEquals(500, reply.status());
        OperationOutcome.Issue issue = Fixtures.outcome(reply).issue().getFirst();
        assertEquals("fatal", issue.severity().valueAsString());
        assertEquals("exception", issue.code().valueAsString());
        assertEquals("Internal server error", issue.diagnostics().value());
        assertTrue(!reply.body().contains("password"), "no internals in the response");
    }

    @Test
    void resourcesThatCannotBeSerializedAreInternalServerErrorsWithoutDetails() {
        TestServer.Reply reply = TestServer.get("Patient/" + PatientHandler.BROKEN, "Accept", "application/fhir+xml");

        assertEquals(500, reply.status());
        assertTrue(reply.header("Content-Type").startsWith("application/fhir+json"));
        OperationOutcome.Issue issue = Fixtures.outcome(reply).issue().getFirst();
        assertEquals("fatal", issue.severity().valueAsString());
        assertEquals("exception", issue.code().valueAsString());
        assertEquals("Internal server error", issue.diagnostics().value());
        assertTrue(!reply.body().contains("XHTML"), "no internals in the response");
    }

    @Test
    void errorsCanCarryHeaders() {
        TestServer.Reply reply = TestServer.get("Patient/" + PatientHandler.BUSY);

        assertEquals(503, reply.status());
        assertEquals("120", reply.header("Retry-After"));
        assertEquals("transient", Fixtures.outcome(reply).issue().getFirst().code().valueAsString());
    }

    @Test
    void handlersCanReadTheRequestAndAddHeaders() {
        TestServer.Reply reply = TestServer.post("Patient",
                FhirJson.write(Fixtures.patient(Fixtures.uniqueFamily())), "X-Correlation-Id", "abc-123");

        assertEquals(201, reply.status());
        assertEquals("abc-123", reply.header("X-Correlation-Id"));
        assertEquals("W/\"1\"", reply.header("ETag"));
        assertTrue(reply.header("Location").contains("/Patient/"));
    }

    @Test
    void handlersCanChooseTheSuccessStatusAndBody() {
        Patient patient = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply reply = TestServer.delete("Patient/" + patient.id(), "X-Delete-Mode", "async");

        assertEquals(202, reply.status());
        assertEquals("Deletion of Patient/" + patient.id() + " is scheduled",
                Fixtures.outcome(reply).issue().getFirst().diagnostics().value());
    }
}
