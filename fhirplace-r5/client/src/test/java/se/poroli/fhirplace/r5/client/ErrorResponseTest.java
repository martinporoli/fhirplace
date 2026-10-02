package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.patient.Patient;

/** Errors from something in front of a FHIR server, such as a proxy, that does not answer with FHIR. */
class ErrorResponseTest {

    private static final URI BASE = TestServers.start("/broken/", exchange -> {
        String path = exchange.getRequestURI().getPath();
        if (path.endsWith("/html")) {
            TestServers.respond(exchange, 502, Map.of("Content-Type", List.of("text/html")),
                    "<html><body>Bad Gateway</body></html>".getBytes(StandardCharsets.UTF_8));
        } else {
            TestServers.respond(exchange, 503, Map.of("Content-Type", List.of("application/fhir+json"),
                    "Retry-After", List.of("30")), "{not json".getBytes(StandardCharsets.UTF_8));
        }
    });

    @Test
    void nonFhirErrorBodiesKeepTheStatusAndHeaders() {
        FhirClient fhir = FhirClient.of(BASE);

        FhirClientException html = assertThrows(FhirClientException.class, () -> fhir.read(Patient.class, "html"));
        FhirClientException malformed = assertThrows(FhirClientException.class, () -> fhir.read(Patient.class, "x"));

        assertEquals(502, html.status());
        assertNull(html.outcome());
        assertEquals("HTTP 502", html.getMessage());
        assertEquals(503, malformed.status());
        assertNull(malformed.outcome());
        assertEquals("30", malformed.header("Retry-After"));
        assertEquals("HTTP 503", malformed.getMessage());
    }
}
