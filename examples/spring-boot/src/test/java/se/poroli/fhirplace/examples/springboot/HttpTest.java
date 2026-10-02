package se.poroli.fhirplace.examples.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

/** What the API looks like on the wire, for clients that do not use fhirplace. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpTest {

    @Value("${local.server.port}")
    private int port;

    private RestClient http;

    @BeforeEach
    void createClient() {
        http = RestClient.builder()
                .baseUrl("http://localhost:" + port + "/fhir")
                .defaultStatusHandler(status -> true, (request, response) -> {
                })
                .build();
    }

    @Test
    void createAnswersWithFhirJsonLocationAndVersion() {
        ResponseEntity<String> created = http.post().uri("/Patient")
                .contentType(MediaType.valueOf("application/fhir+json"))
                .body("{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Wire\"}]}")
                .retrieve().toEntity(String.class);

        assertEquals(201, created.getStatusCode().value());
        assertTrue(created.getHeaders().getContentType().toString().startsWith("application/fhir+json"));
        assertEquals("W/\"1\"", created.getHeaders().getETag());
        assertTrue(created.getHeaders().getLocation().toString().endsWith("/_history/1"));
    }

    @Test
    void formatParameterAndErrorsAsOperationOutcome() {
        ResponseEntity<String> xml = http.get().uri("/metadata?_format=xml").retrieve().toEntity(String.class);
        ResponseEntity<String> missing = http.get().uri("/Patient/12345678")
                .accept(MediaType.valueOf("application/fhir+json")).retrieve().toEntity(String.class);

        assertTrue(xml.getHeaders().getContentType().toString().startsWith("application/fhir+xml"));
        assertEquals(404, missing.getStatusCode().value());
        assertTrue(missing.getHeaders().getContentType().toString().startsWith("application/fhir+json"));
    }
}
