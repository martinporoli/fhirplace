package se.poroli.fhirplace.r5.server.jaxrs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.server.shared.TestServer;

/** The FHIR routes do not shadow the application's own Jakarta REST resources. */
class CoexistenceTest {

    @Test
    void ownResourcesStillAnswer() {
        TestServer.Reply status = TestServer.get("status");

        assertEquals(200, status.status());
        assertEquals("up", status.body());
        assertEquals(200, TestServer.get("metadata").status());
    }
}
