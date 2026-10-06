package se.poroli.fhirplace.examples.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import se.poroli.fhirplace.r5.client.FhirClient;
import se.poroli.fhirplace.r5.client.SearchQuery;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.rest.FhirHttpException;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/** Uses the Observation endpoints, which support only read, create and search. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ObservationTest {

    @Value("${local.server.port}")
    private int port;

    private URI base;

    @BeforeEach
    void setBase() {
        base = URI.create("http://localhost:" + port + "/fhir");
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

    @Test
    void createAndSearchBySubjectAndCode() {
        FhirClient fhir = FhirClient.of(base);
        String patient = "Patient/" + UUID.randomUUID();
        Observation created = fhir.create(heartRate(patient)).body();

        try (var found = fhir.searchAll(Observation.class, SearchQuery.where("subject", patient)
                .and("code", SearchQuery.token("http://loinc.org", "8867-4")))) {
            assertEquals(List.of(created.id()), found.map(Observation::id).toList());
        }
        assertEquals(0, fhir.search(Observation.class, SearchQuery.where("subject", patient)
                .and("code", SearchQuery.token("http://loinc.org", "1234-5"))).body().total().value());
    }

    @Test
    void interactionsTheHandlerDoesNotImplementAreNotAllowed() {
        assertEquals(405, assertThrows(FhirHttpException.class,
                () -> FhirClient.of(base).delete(Observation.class, "1")).status());
    }
}
