package se.poroli.fhirplace.r5.server.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/** The create, update and delete interactions. */
public class WriteTest {

    @Test
    void createAnswersCreatedWithLocationAndTheStoredResource() {
        TestServer.Reply reply = TestServer.post("Patient", FhirJson.write(Fixtures.patient(Fixtures.uniqueFamily())));

        assertEquals(201, reply.status());
        Patient stored = FhirJson.read(reply.body(), Patient.class);
        assertEquals(TestServer.base().resolve("Patient/" + stored.id() + "/_history/1").toString(),
                reply.header("Location"));
        assertEquals("W/\"1\"", reply.header("ETag"));
    }

    @Test
    void createHonoursPreferReturn() {
        String body = FhirJson.write(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply minimal = TestServer.post("Patient", body, "Prefer", "return=minimal");
        TestServer.Reply outcome = TestServer.post("Patient", body, "Prefer", "return=OperationOutcome");

        assertEquals(201, minimal.status());
        assertEquals("", minimal.body());
        assertTrue(minimal.header("Location").contains("/Patient/"));
        assertEquals(201, outcome.status());
        assertEquals("information", Fixtures.outcome(outcome).issue().getFirst().severity().valueAsString());
    }

    @Test
    void updateOfAnExistingResourceCreatesANewVersion() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply reply = TestServer.put("Patient/" + created.id(),
                FhirJson.write(created.toBuilder().active(true).build()));

        assertEquals(200, reply.status());
        assertEquals("W/\"2\"", reply.header("ETag"));
        assertEquals(true, FhirJson.read(reply.body(), Patient.class).active().value());
    }

    @Test
    void updateOfANewIdCreatesTheResource() {
        String id = "new-" + Fixtures.uniqueFamily().toLowerCase();

        TestServer.Reply reply = TestServer.put("Patient/" + id,
                FhirJson.write(Fixtures.patient(Fixtures.uniqueFamily()).toBuilder().id(id).build()));

        assertEquals(201, reply.status());
        assertTrue(reply.header("Location").endsWith("/Patient/" + id + "/_history/1"));
    }

    @Test
    void updateChecksIfMatchAgainstTheCurrentVersion() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));
        String body = FhirJson.write(created);

        assertEquals(412, TestServer.put("Patient/" + created.id(), body, "If-Match", "W/\"7\"").status());
        assertEquals(200, TestServer.put("Patient/" + created.id(), body, "If-Match", "W/\"1\"").status());
    }

    @Test
    void updateRejectsAnIdThatDiffersFromTheUrl() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply reply = TestServer.put("Patient/other", FhirJson.write(created));

        assertEquals(400, reply.status());
        assertTrue(Fixtures.diagnostics(reply).contains("does not match"));
    }

    @Test
    void deleteAnswersNoContent() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        assertEquals(412, TestServer.delete("Patient/" + created.id(), "If-Match", "W/\"2\"").status());
        assertEquals(204, TestServer.delete("Patient/" + created.id()).status());
    }

    @Test
    void interactionsWithoutAHandlerMethodAreNotAllowed() {
        TestServer.Reply reply = TestServer.post("Observation", FhirJson.write(Observation.builder()
                .status(ObservationStatus.FINAL)
                .code(CodeableConcept.builder().text("x").build())
                .build()));

        assertEquals(405, reply.status());
        assertTrue(Fixtures.diagnostics(reply).contains("create"));
    }

    @Test
    void invalidContentIsABadRequest() {
        TestServer.Reply malformed = TestServer.post("Patient", "{\"resourceType\":\"Patient\",\"foo\":1}");
        TestServer.Reply wrongType = TestServer.post("Patient", "{\"resourceType\":\"Basic\",\"code\":{\"text\":\"x\"}}");

        assertEquals(400, malformed.status());
        assertTrue(Fixtures.diagnostics(malformed).contains("unknown element 'foo'"));
        assertEquals(400, wrongType.status());
    }
}
