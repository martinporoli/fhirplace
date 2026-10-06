package se.poroli.fhirplace.r5.client;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.rest.FhirHttpException;
import se.poroli.fhirplace.r5.xml.FhirXml;

/**
 * Response body handlers for {@code java.net.http.HttpClient} that read FHIR JSON or XML, chosen by the response's
 * {@code Content-Type}.
 *
 * <p>For an error status (400 and above) the handler fails with a {@link FhirHttpException} carrying the server's
 * OperationOutcome: {@code HttpClient.send} throws it wrapped in an {@code IOException}, and {@code sendAsync}
 * completes with it. {@link FhirClient} unwraps it for you.
 */
public final class FhirBodyHandlers {

    private FhirBodyHandlers() {
    }

    /**
     * Returns a handler that reads the body as a resource of the given type.
     *
     * @param type the expected resource class
     * @param <T> the resource type
     * @return the handler; the body is {@code null} if the response has none
     */
    public static <T extends Resource> HttpResponse.BodyHandler<T> of(Class<T> type) {
        return info -> HttpResponse.BodySubscribers.mapping(HttpResponse.BodySubscribers.ofByteArray(),
                bytes -> read(info.statusCode(), info.headers(), bytes, type));
    }

    /**
     * Returns a handler that reads the body as a resource of whatever type it is.
     *
     * @return the handler; the body is {@code null} if the response has none
     */
    public static HttpResponse.BodyHandler<Resource> ofResource() {
        return of(Resource.class);
    }

    static <T extends Resource> T read(int status, HttpHeaders headers, byte[] body, Class<T> type) {
        if (status >= 400) {
            Resource error;
            try {
                error = body.length == 0 ? null : parse(headers, body);
            } catch (IllegalArgumentException e) {
                error = null;   // not FHIR content; the status still tells what happened
            }
            throw new FhirHttpException(status, error instanceof OperationOutcome outcome ? outcome : null,
                    headers.map());
        }
        Resource resource = body.length == 0 ? null : parse(headers, body);
        if (resource != null && !type.isInstance(resource)) {
            throw new IllegalArgumentException("Expected a " + type.getSimpleName() + " but the server sent a "
                    + resource.getClass().getSimpleName());
        }
        return type.cast(resource);
    }

    private static Resource parse(HttpHeaders headers, byte[] body) {
        String contentType = headers.firstValue("Content-Type").orElse("").toLowerCase(Locale.ROOT);
        Reader reader = new InputStreamReader(new ByteArrayInputStream(body), charset(contentType));
        boolean xml = contentType.contains("xml");
        boolean json = contentType.contains("json");
        if (!xml && !json) {
            return null;
        }
        return xml ? FhirXml.read(reader) : FhirJson.read(reader);
    }

    private static Charset charset(String contentType) {
        int index = contentType.indexOf("charset=");
        if (index < 0) {
            return StandardCharsets.UTF_8;
        }
        String name = contentType.substring(index + "charset=".length()).split(";")[0].strip().replace("\"", "");
        return Charset.isSupported(name) ? Charset.forName(name) : StandardCharsets.UTF_8;
    }
}
