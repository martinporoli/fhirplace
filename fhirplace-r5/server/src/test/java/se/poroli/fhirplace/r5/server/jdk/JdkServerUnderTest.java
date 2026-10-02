package se.poroli.fhirplace.r5.server.jdk;

import com.sun.net.httpserver.HttpExchange;
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
import se.poroli.fhirplace.r5.server.shared.ServerUnderTest;

/**
 * Runs the engine on the JDK's built-in HTTP server, with no web framework: the smallest possible adapter, and the
 * runtime the shared tests use in this module.
 */
public final class JdkServerUnderTest implements ServerUnderTest {

    @Override
    public URI start() {
        FhirServer fhir = FhirServer.builder()
                .handler(new PatientHandler())
                .handler(new ObservationHandler())
                .build();
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
            URI base = URI.create("http://localhost:" + server.getAddress().getPort() + "/fhir/");
            server.createContext("/fhir/", exchange -> handle(fhir, base, exchange));
            server.start();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> server.stop(0)));
            return base;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void handle(FhirServer fhir, URI base, HttpExchange exchange) throws IOException {
        try (exchange) {
            URI uri = exchange.getRequestURI();
            Map<String, List<String>> headers = new HashMap<>(exchange.getRequestHeaders());
            FhirResponse response = fhir.handle(new FhirRequest(exchange.getRequestMethod(),
                    uri.getRawPath().substring(base.getRawPath().length()), uri.getRawQuery(), headers,
                    exchange.getRequestBody().readAllBytes(), base));
            response.headers().forEach((name, values) -> exchange.getResponseHeaders().put(name, values));
            exchange.sendResponseHeaders(response.status(), response.body().length == 0 ? -1 : response.body().length);
            if (response.body().length > 0) {
                try (OutputStream out = exchange.getResponseBody()) {
                    out.write(response.body());
                }
            }
        }
    }
}
