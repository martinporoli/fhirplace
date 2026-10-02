package se.poroli.fhirplace.r5.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.patient.Patient;

/** The read and vread interactions. */
class ReadTest {

    @Test
    void readReturnsTheResourceWithVersionHeaders() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        TestServer.Reply reply = TestServer.get("Patient/" + created.id());

        assertEquals(200, reply.status());
        assertTrue(reply.header("Content-Type").startsWith("application/fhir+json"));
        assertEquals("W/\"1\"", reply.header("ETag"));
        assertNotNull(reply.header("Last-Modified"));
        assertEquals(created, FhirJson.read(reply.body(), Patient.class));
    }

    @Test
    void conditionalReadAnswersNotModified() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));

        assertEquals(304, TestServer.get("Patient/" + created.id(), "If-None-Match", "W/\"1\"").status());
        assertEquals(200, TestServer.get("Patient/" + created.id(), "If-None-Match", "W/\"0\"").status());
        String lastModified = TestServer.get("Patient/" + created.id()).header("Last-Modified");
        assertEquals(304, TestServer.get("Patient/" + created.id(), "If-Modified-Since", lastModified).status());
    }

    @Test
    void unknownResourceIsNotFoundWithAnOperationOutcome() {
        TestServer.Reply reply = TestServer.get("Patient/does-not-exist");

        assertEquals(404, reply.status());
        assertEquals("not-found", Fixtures.outcome(reply).issue().getFirst().code().valueAsString());
    }

    @Test
    void deletedResourceIsGone() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));
        TestServer.delete("Patient/" + created.id());

        assertEquals(410, TestServer.get("Patient/" + created.id()).status());
    }

    @Test
    void invalidIdIsRejected() {
        TestServer.Reply reply = TestServer.get("Patient/not_valid!");

        assertEquals(400, reply.status());
        assertTrue(Fixtures.diagnostics(reply).contains("not a valid resource id"));
    }

    @Test
    void unsupportedResourceTypeIsNotFound() {
        TestServer.Reply reply = TestServer.get("Medication/1");

        assertEquals(404, reply.status());
        assertTrue(Fixtures.diagnostics(reply).contains("'Medication' is not supported"));
    }

    @Test
    void vreadReturnsEachVersion() {
        Patient created = Fixtures.created(Fixtures.patient(Fixtures.uniqueFamily()));
        Patient changed = created.toBuilder().active(true).build();
        TestServer.put("Patient/" + created.id(), FhirJson.write(changed));

        TestServer.Reply first = TestServer.get("Patient/" + created.id() + "/_history/1");
        TestServer.Reply second = TestServer.get("Patient/" + created.id() + "/_history/2");

        assertEquals(200, first.status());
        assertEquals("W/\"1\"", first.header("ETag"));
        assertEquals(null, FhirJson.read(first.body(), Patient.class).active());
        assertEquals(true, FhirJson.read(second.body(), Patient.class).active().value());
        assertEquals(404, TestServer.get("Patient/" + created.id() + "/_history/9").status());
    }
}
