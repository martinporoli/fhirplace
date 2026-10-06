package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.rest.FhirHttpException;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirServer;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Errors from something in front of a FHIR server, such as a proxy, that does not answer with FHIR. */
public class ErrorResponseTest {

    private static final URI BASE = TestServers.start("/broken/", exchange -> {
        String path = exchange.getRequestURI().getPath();
        if (path.endsWith("/html")) {
            TestServers.respond(exchange, 502, Map.of("Content-Type", List.of("text/html")),
                    "<html><body>Bad Gateway</body></html>".getBytes(StandardCharsets.UTF_8));
        } else if (path.endsWith("/outcome")) {
            TestServers.respond(exchange, 422, Map.of("Content-Type", List.of("application/fhir+json"),
                    "Retry-After", List.of("30")), """
                    { "resourceType": "OperationOutcome", "issue": [
                      { "severity": "error", "code": "business-rule", "diagnostics": "Try again" }
                    ] }
                    """.getBytes(StandardCharsets.UTF_8));
        } else {
            TestServers.respond(exchange, 503, Map.of("Content-Type", List.of("application/fhir+json"),
                    "Retry-After", List.of("30")), "{not json".getBytes(StandardCharsets.UTF_8));
        }
    });

    @Test
    void nonFhirErrorBodiesKeepTheStatusAndHeaders() {
        FhirClient fhir = FhirClient.of(BASE);

        FhirHttpException html = assertThrows(FhirHttpException.class, () -> fhir.read(Patient.class, "html"));
        FhirHttpException malformed = assertThrows(FhirHttpException.class, () -> fhir.read(Patient.class, "x"));

        assertEquals(502, html.status());
        assertNull(html.outcome());
        assertEquals("HTTP 502", html.getMessage());
        assertEquals(503, malformed.status());
        assertNull(malformed.outcome());
        assertEquals("30", malformed.header("Retry-After"));
        assertEquals("HTTP 503", malformed.getMessage());
    }

    @Test
    void rethrownClientErrorsWithoutOutcomesDoNotRetainBackendBodyHeaders() {
        FhirServer server = FhirServer.builder().handler(new ForwardingHandler(FhirClient.of(BASE))).build();
        for (String id : List.of("html", "x")) {
            var response = server.handle(new FhirRequest("GET", "Patient/" + id, null,
                    Map.of(), new byte[0], URI.create("http://localhost/fhir/")));

            assertEquals(id.equals("html") ? 502 : 503, response.status());
            assertEquals(0, response.body().length);
            assertNull(response.header("Content-Length"));
            assertNull(response.header("Content-Type"));
            assertEquals(id.equals("html") ? null : "30", response.header("Retry-After"));
        }
    }

    @Test
    void rethrownClientOutcomesAreReserializedWithFreshBodyHeaders() {
        FhirServer server = FhirServer.builder().handler(new ForwardingHandler(FhirClient.of(BASE))).build();
        var response = server.handle(new FhirRequest("GET", "Patient/outcome", null,
                Map.of("Accept", List.of("application/fhir+xml")), new byte[0],
                URI.create("http://localhost/fhir/")));

        assertEquals(422, response.status());
        assertEquals("30", response.header("Retry-After"));
        assertNull(response.header("Content-Length"));
        assertEquals("application/fhir+xml;charset=UTF-8", response.header("Content-Type"));
        OperationOutcome outcome = FhirXml.read(new String(response.body(), StandardCharsets.UTF_8),
                OperationOutcome.class);
        assertEquals("Try again", outcome.issue().getFirst().diagnostics().value());
    }

    /** Calls a backend without translating its HTTP errors. */
    @FhirResource(Patient.class)
    public record ForwardingHandler(FhirClient client) {
        /** Returns the backend's Patient, allowing its errors to propagate. */
        @Read
        public Patient read(@Id String id) {
            return client.read(Patient.class, id).body();
        }
    }
}
