package se.poroli.fhirplace.r5.server;

import java.util.List;
import java.util.Map;

/**
 * The HTTP response to a {@link FhirRequest}, for a web framework adapter to send as is.
 *
 * @param status the HTTP status
 * @param headers the response headers, including {@code Content-Type} when there is a body
 * @param body the serialized body, empty if there is none
 */
public record FhirResponse(int status, Map<String, List<String>> headers, byte[] body) {

    /** Creates the response, copying the headers. */
    public FhirResponse {
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
}
