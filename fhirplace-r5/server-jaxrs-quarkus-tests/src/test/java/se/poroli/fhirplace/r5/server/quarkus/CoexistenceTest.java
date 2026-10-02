package se.poroli.fhirplace.r5.server.quarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.server.shared.TestServer;

/** The FHIR routes do not shadow the application's own Jakarta REST resources. */
@QuarkusTest
class CoexistenceTest {

    @Test
    void ownResourcesStillAnswer() {
        TestServer.Reply status = TestServer.get("status");

        assertEquals(200, status.status());
        assertEquals("up", status.body());
        assertEquals(200, TestServer.get("metadata").status());
    }
}
