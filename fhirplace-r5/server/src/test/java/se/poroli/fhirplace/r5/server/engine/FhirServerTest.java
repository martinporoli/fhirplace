package se.poroli.fhirplace.r5.server.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResponse;
import se.poroli.fhirplace.r5.server.FhirServer;
import se.poroli.fhirplace.r5.server.shared.PatientHandler;

/**
 * {@link FhirServer#handle} with requests that web servers may not let through over HTTP, so the engine's own answer
 * is tested directly: whatever an adapter passes on gets a FHIR response, never an exception.
 */
class FhirServerTest {

    private static final FhirServer SERVER = FhirServer.builder().handler(new PatientHandler()).build();

    private static FhirResponse handle(String method, String path, String query, String contentType, String body) {
        Map<String, List<String>> headers =
                contentType == null ? Map.of() : Map.of("Content-Type", List.of(contentType));
        return SERVER.handle(new FhirRequest(method, path, query, headers, body.getBytes(StandardCharsets.UTF_8),
                URI.create("http://localhost/fhir/")));
    }

    private static OperationOutcome.Issue issue(FhirResponse response) {
        return FhirJson.read(new String(response.body(), StandardCharsets.UTF_8), OperationOutcome.class)
                .issue().getFirst();
    }

    @Test
    void malformedEncodingInTheQueryPathOrFormIsABadRequest() {
        FhirResponse query = handle("GET", "Patient", "family=%ZZ", null, "");
        FhirResponse path = handle("GET", "Patient/a%ZZ", null, null, "");
        FhirResponse form = handle("POST", "Patient/_search", null, "application/x-www-form-urlencoded", "family=%Z");

        assertEquals(400, query.status());
        assertEquals("invalid", issue(query).code().valueAsString());
        assertEquals("Malformed URL encoding in '%ZZ'", issue(query).diagnostics().value());
        assertEquals(400, path.status());
        assertEquals(400, form.status());
    }

    @Test
    void handlerFailuresBecomeInternalServerErrors() {
        FhirResponse response = handle("GET", "Patient/crash", null, null, "");

        assertEquals(500, response.status());
        assertEquals("exception", issue(response).code().valueAsString());
    }
}
