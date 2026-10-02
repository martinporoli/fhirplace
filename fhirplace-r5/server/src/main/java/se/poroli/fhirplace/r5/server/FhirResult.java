package se.poroli.fhirplace.r5.server;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import se.poroli.fhirplace.r5.Resource;

/**
 * A successful response chosen by a handler: its own 2xx status, body and extra headers. Handler methods for
 * {@link Read}, {@link VRead}, {@link Create}, {@link Update} and {@link Delete} may return it instead of a resource.
 *
 * <p>The server still adds what it derives from the body, such as {@code ETag}, {@code Last-Modified} and
 * {@code Location}, and applies {@code Prefer: return=}; the status and the headers set here take precedence. Report
 * errors with {@link FhirException} instead.
 *
 * <pre>{@code
 * @Delete
 * public FhirResult<OperationOutcome> delete(@Id String id) {
 *     queue.scheduleDeletion(id);
 *     return FhirResult.of(202, outcome("Deletion of Patient/" + id + " is scheduled"));
 * }
 * }</pre>
 *
 * @param status the HTTP status, 200 to 299
 * @param body the response body, or {@code null} for none
 * @param headers extra response headers by name
 * @param <T> the body's resource type
 */
public record FhirResult<T extends Resource>(int status, T body, Map<String, List<String>> headers) {

    /**
     * Creates the result, copying the headers.
     *
     * @throws IllegalArgumentException if the status is not 2xx
     */
    public FhirResult {
        if (status < 200 || status > 299) {
            throw new IllegalArgumentException("Not a success status: " + status + "; throw FhirException instead");
        }
        headers = copyHeaders(headers);
    }

    /**
     * Returns a result with status 200 and the given body.
     *
     * @param body the response body
     * @param <T> the body's resource type
     * @return the result
     */
    public static <T extends Resource> FhirResult<T> ok(T body) {
        return new FhirResult<>(200, Objects.requireNonNull(body, "body"), Map.of());
    }

    /**
     * Returns a result with the given status and body.
     *
     * @param status the HTTP status, 200 to 299
     * @param body the response body, or {@code null} for none
     * @param <T> the body's resource type
     * @return the result
     */
    public static <T extends Resource> FhirResult<T> of(int status, T body) {
        return new FhirResult<>(status, body, Map.of());
    }

    /**
     * Returns a result with the given status and no body.
     *
     * @param status the HTTP status, 200 to 299
     * @param <T> the resource type the method declares
     * @return the result
     */
    public static <T extends Resource> FhirResult<T> status(int status) {
        return new FhirResult<>(status, null, Map.of());
    }

    /**
     * Returns a copy with a header value added.
     *
     * @param name the header name
     * @param value the value
     * @return the new result
     */
    public FhirResult<T> withHeader(String name, String value) {
        Map<String, List<String>> copy = new LinkedHashMap<>(headers);
        List<String> values = new ArrayList<>(copy.getOrDefault(Objects.requireNonNull(name, "name"), List.of()));
        values.add(Objects.requireNonNull(value, "value"));
        copy.put(name, values);
        return new FhirResult<>(status, body, copy);
    }

    static Map<String, List<String>> copyHeaders(Map<String, List<String>> headers) {
        Map<String, List<String>> copy = new LinkedHashMap<>();
        Objects.requireNonNull(headers, "headers").forEach((name, values) -> copy.put(name, List.copyOf(values)));
        return java.util.Collections.unmodifiableMap(copy);
    }
}
