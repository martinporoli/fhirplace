package se.poroli.fhirplace.r5.server;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * An HTTP request to the FHIR API, as a web framework adapter hands it to {@link FhirServer#handle(FhirRequest)}.
 *
 * @param method the HTTP method, such as {@code GET}
 * @param path the path below the FHIR base, without leading slash and still URL-encoded, such as
 *     {@code Patient/123/_history/2}; empty for the base itself
 * @param query the raw, URL-encoded query string without {@code ?}, or {@code null}
 * @param headers the request headers; names are matched case-insensitively
 * @param body the request body, empty if there is none
 * @param base the absolute URL of the FHIR base, used in {@code Location} headers and Bundle links
 */
public record FhirRequest(
        String method, String path, String query, Map<String, List<String>> headers, byte[] body, URI base) {

    /**
     * Creates the request.
     *
     * @throws NullPointerException if the method, path, headers, body or base is {@code null}
     */
    public FhirRequest {
        Objects.requireNonNull(method, "method");
        Objects.requireNonNull(path, "path");
        headers = Map.copyOf(Objects.requireNonNull(headers, "headers"));
        Objects.requireNonNull(body, "body");
        Objects.requireNonNull(base, "base");
    }
}
