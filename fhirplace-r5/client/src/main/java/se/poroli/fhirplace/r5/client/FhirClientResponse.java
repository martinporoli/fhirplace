package se.poroli.fhirplace.r5.client;

import java.net.URI;
import java.util.List;
import java.util.Map;
import se.poroli.fhirplace.r5.Resource;

/**
 * A successful response from a FHIR server.
 *
 * @param status the HTTP status
 * @param headers the response headers
 * @param body the resource in the body, or {@code null} if there was none
 * @param <T> the resource type
 */
public record FhirClientResponse<T extends Resource>(int status, Map<String, List<String>> headers, T body) {

    /** Creates the response, copying the headers. */
    public FhirClientResponse {
        headers = Map.copyOf(headers);
    }

    /**
     * Returns the first value of a header.
     *
     * @param name the header name, matched case-insensitively
     * @return the value, or {@code null} if the header is absent
     */
    public String header(String name) {
        return headers.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(name) && !entry.getValue().isEmpty())
                .map(entry -> entry.getValue().getFirst())
                .findFirst()
                .orElse(null);
    }

    /**
     * Returns the {@code ETag} header, such as {@code W/"3"}.
     *
     * @return the entity tag, or {@code null} if absent
     */
    public String etag() {
        return header("ETag");
    }

    /**
     * Returns the {@code Location} header, such as {@code https://example.org/fhir/Patient/123/_history/1}.
     *
     * @return the location, or {@code null} if absent
     */
    public URI location() {
        String location = header("Location");
        return location == null ? null : URI.create(location);
    }
}
