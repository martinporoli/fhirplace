package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.patient.Patient;

/** {@code withTimeout} bounds the wait for each response, against a server that answers late. */
class TimeoutTest {

    private static final Duration DELAY = Duration.ofSeconds(2);
    private static final Duration TIMEOUT = Duration.ofMillis(200);

    private static final URI SLOW = TestServers.start("/slow/", exchange -> {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        TestServers.respond(exchange, 200, Map.of("Content-Type", List.of("application/fhir+json")),
                FhirJson.write(Patient.builder().id("123").build()).getBytes(StandardCharsets.UTF_8));
    });

    @Test
    void readTimesOut() {
        FhirClient fhir = FhirClient.of(SLOW).withTimeout(TIMEOUT);
        long start = System.nanoTime();
        UncheckedIOException e = assertThrows(UncheckedIOException.class, () -> fhir.read(Patient.class, "123"));
        assertInstanceOf(HttpTimeoutException.class, e.getCause());
        assertTrue(Duration.ofNanos(System.nanoTime() - start).compareTo(DELAY) < 0);
    }

    @Test
    void readAsyncFailsWithTimeout() {
        FhirClient fhir = FhirClient.of(SLOW).withTimeout(TIMEOUT);
        ExecutionException e = assertThrows(ExecutionException.class,
                () -> fhir.readAsync(Patient.class, "123").get());
        assertInstanceOf(HttpTimeoutException.class, e.getCause());
    }

    @Test
    void derivedClientsKeepTheTimeout() {
        FhirClient fhir = FhirClient.of("https://elsewhere.example/fhir").withTimeout(TIMEOUT)
                .withHeader("Authorization", "Bearer secret").withFormat(FhirFormat.JSON).at(SLOW);
        UncheckedIOException e = assertThrows(UncheckedIOException.class, () -> fhir.read(Patient.class, "123"));
        assertInstanceOf(HttpTimeoutException.class, e.getCause());
    }

    @Test
    void rejectsNonPositiveTimeout() {
        FhirClient fhir = FhirClient.of(SLOW);
        assertThrows(IllegalArgumentException.class, () -> fhir.withTimeout(Duration.ZERO));
        assertThrows(IllegalArgumentException.class, () -> fhir.withTimeout(Duration.ofSeconds(-1)));
    }
}
