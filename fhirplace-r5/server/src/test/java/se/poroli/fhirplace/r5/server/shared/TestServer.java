package se.poroli.fhirplace.r5.server.shared;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/** The server under test, started once for all tests, and an HTTP client for it. */
public final class TestServer {

    private static URI base;

    private TestServer() {
    }

    public static synchronized URI base() {
        if (base == null) {
            ServerUnderTest server = ServiceLoader.load(ServerUnderTest.class).findFirst()
                    .orElseThrow(() -> new IllegalStateException("No ServerUnderTest registered"));
            base = server.start();
        }
        return base;
    }

    /**
     * An HTTP response.
     *
     * @param status the status
     * @param headers the headers
     * @param body the body as text
     */
    public record Reply(int status, Map<String, List<String>> headers, String body) {

        public String header(String name) {
            return headers.entrySet().stream()
                    .filter(e -> e.getKey().equalsIgnoreCase(name))
                    .map(e -> String.join(",", e.getValue()))
                    .findFirst()
                    .orElse(null);
        }
    }

    public static Reply get(String path, String... headers) {
        return send("GET", path, null, headers);
    }

    public static Reply delete(String path, String... headers) {
        return send("DELETE", path, null, headers);
    }

    public static Reply post(String path, String body, String... headers) {
        return send("POST", path, body, headers);
    }

    public static Reply put(String path, String body, String... headers) {
        return send("PUT", path, body, headers);
    }

    /** Sends a request; {@code headers} are name/value pairs. JSON bodies are sent as FHIR JSON by default. */
    public static Reply send(String method, String path, String body, String... headers) {
        try {
            HttpURLConnection connection = (HttpURLConnection) base().resolve(path).toURL().openConnection();
            connection.setRequestMethod(method);
            boolean contentType = false;
            for (int i = 0; i < headers.length; i += 2) {
                connection.setRequestProperty(headers[i], headers[i + 1]);
                contentType |= headers[i].equalsIgnoreCase("Content-Type");
            }
            if (body != null) {
                if (!contentType) {
                    connection.setRequestProperty("Content-Type", "application/fhir+json");
                }
                connection.setDoOutput(true);
                try (OutputStream out = connection.getOutputStream()) {
                    out.write(body.getBytes(StandardCharsets.UTF_8));
                }
            }
            int status = connection.getResponseCode();
            InputStream in = status >= 400 ? connection.getErrorStream() : connection.getInputStream();
            String text = in == null ? "" : new String(in.readAllBytes(), StandardCharsets.UTF_8);
            Map<String, List<String>> responseHeaders = new java.util.HashMap<>();
            connection.getHeaderFields().forEach((name, values) -> {
                if (name != null) {
                    responseHeaders.put(name, values);
                }
            });
            return new Reply(status, responseHeaders, text);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
