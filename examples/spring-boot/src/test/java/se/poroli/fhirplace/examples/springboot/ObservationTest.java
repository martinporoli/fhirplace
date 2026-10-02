package se.poroli.fhirplace.examples.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/** Uses the Observation endpoints, which support only read, create and search. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ObservationTest {

    @Value("${local.server.port}")
    private int port;

    private RestClient client;

    @BeforeEach
    void createClient() {
        client = FhirClient.create(port);
    }

    private static Observation heartRate(String patient) {
        return Observation.builder()
                .status(ObservationStatus.FINAL)
                .code(CodeableConcept.builder()
                        .addCoding(Coding.builder().system("http://loinc.org").code("8867-4").display("Heart rate")
                                .build())
                        .build())
                .subject(Reference.builder().reference(patient).build())
                .value(Quantity.builder().value(new BigDecimal("72")).unit("beats/minute").build())
                .build();
    }

    private Bundle search(String patient, String code) {
        String body = client.get()
                .uri(uri -> uri.path("/Observation").queryParam("subject", "{subject}").queryParam("code", "{code}")
                        .build(patient, code))
                .retrieve().body(String.class);
        return FhirJson.read(body, Bundle.class);
    }

    @Test
    void createAndSearchBySubjectAndCode() {
        String patient = "Patient/" + UUID.randomUUID();
        String body = client.post().uri("/Observation").contentType(FhirClient.FHIR_JSON)
                .body(FhirJson.write(heartRate(patient))).retrieve().body(String.class);
        Observation created = FhirJson.read(body, Observation.class);

        assertEquals(List.of(created.id()), search(patient, "http://loinc.org|8867-4").entry().stream()
                .map(entry -> entry.resource().id()).toList());
        assertEquals(0, search(patient, "http://loinc.org|1234-5").total().value());
    }

    @Test
    void interactionsTheHandlerDoesNotImplementAreNotAllowed() {
        assertEquals(405, client.delete().uri("/Observation/1").retrieve().toBodilessEntity().getStatusCode()
                .value());
    }
}
