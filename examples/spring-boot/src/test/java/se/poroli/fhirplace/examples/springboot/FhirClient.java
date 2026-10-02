package se.poroli.fhirplace.examples.springboot;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

/** A {@link RestClient} for the FHIR base that returns error responses instead of throwing. */
final class FhirClient {

    static final MediaType FHIR_JSON = MediaType.valueOf("application/fhir+json");
    static final MediaType FHIR_XML = MediaType.valueOf("application/fhir+xml");

    private FhirClient() {
    }

    static RestClient create(int port) {
        return RestClient.builder()
                .baseUrl("http://localhost:" + port + "/fhir")
                .defaultStatusHandler(status -> true, (request, response) -> {
                })
                .build();
    }
}
