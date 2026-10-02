package se.poroli.fhirplace.examples.proxy;

import java.net.http.HttpClient;
import java.time.Duration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * A FHIR proxy: it serves {@code Patient} at {@code /fhir} and forwards every request to the FHIR server of the region
 * named in the request's {@code X-Region} header.
 */
@SpringBootApplication
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    /**
     * The one HTTP client for all backends. It owns the connection pools and threads; the per-request
     * {@code FhirClient}s only refer to it.
     */
    @Bean
    HttpClient httpClient() {
        return HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
    }
}
