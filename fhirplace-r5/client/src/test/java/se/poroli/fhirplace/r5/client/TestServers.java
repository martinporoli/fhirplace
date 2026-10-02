package se.poroli.fhirplace.r5.client;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResponse;
import se.poroli.fhirplace.r5.server.FhirServer;
import se.poroli.fhirplace.r5.server.shared.ObservationHandler;
import se.poroli.fhirplace.r5.server.shared.PatientHandler;

/** HTTP servers for the client tests, on the JDK's built-in HTTP server. */
final class TestServers {

    private static URI fhir;

    private TestServers() {
    }

    /** A fhirplace server with the shared test handlers, started once. */
    static synchronized URI fhir() {
        if (fhir == null) {
            FhirServer server = FhirServer.builder()
                    .handler(new PatientHandler())
                    .handler(new ObservationHandler())
                    .build();
            fhir = start("/fhir/", exchange -> {
                URI uri = exchange.getRequestURI();
                FhirResponse response = server.handle(new FhirRequest(exchange.getRequestMethod(),
                        uri.getRawPath().substring("/fhir/".length()), uri.getRawQuery(),
                        new HashMap<>(exchange.getRequestHeaders()), exchange.getRequestBody().readAllBytes(),
                        base(exchange, "/fhir/")));
                respond(exchange, response.status(), response.headers(), response.body());
            });
        }
        return fhir;
    }

    /** Starts a server for one context path with the given handler, stopped when the JVM exits. */
    static URI start(String path, HttpHandler handler) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
            server.createContext(path, exchange -> {
                try (exchange) {
                    handler.handle(exchange);
                }
            });
            server.start();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> server.stop(0)));
            return URI.create("http://localhost:" + server.getAddress().getPort() + path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    static URI base(HttpExchange exchange, String path) {
        return URI.create("http://localhost:" + exchange.getLocalAddress().getPort() + path);
    }

    static void respond(HttpExchange exchange, int status, Map<String, List<String>> headers, byte[] body)
            throws IOException {
        headers.forEach((name, values) -> exchange.getResponseHeaders().put(name, values));
        exchange.sendResponseHeaders(status, body.length == 0 ? -1 : body.length);
        if (body.length > 0) {
            try (OutputStream out = exchange.getResponseBody()) {
                out.write(body);
            }
        }
    }
}
