package se.poroli.fhirplace.examples.quarkus;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusTest;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/** Uses the Observation endpoints, which support only read, create and search. */
@QuarkusTest
class ObservationTest {

    private static final String FHIR_JSON = "application/fhir+json; charset=UTF-8";

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
        String patient = "Patient/" + UUID.randomUUID();
        String body = given().contentType(FHIR_JSON).body(FhirJson.write(heartRate(patient)))
                .when().post("/fhir/Observation")
                .then().statusCode(201).extract().asString();
        Observation created = FhirJson.read(body, Observation.class);

        String found = given().queryParam("subject", patient).queryParam("code", "http://loinc.org|8867-4")
                .when().get("/fhir/Observation")
                .then().statusCode(200).extract().asString();
        String otherCode = given().queryParam("subject", patient).queryParam("code", "http://loinc.org|1234-5")
                .when().get("/fhir/Observation")
                .then().statusCode(200).extract().asString();

        assertEquals(List.of(created.id()), FhirJson.read(found, Bundle.class).entry().stream()
                .map(entry -> entry.resource().id()).toList());
        assertEquals(0, FhirJson.read(otherCode, Bundle.class).total().value());
    }

    @Test
    void interactionsTheHandlerDoesNotImplementAreNotAllowed() {
        given().when().delete("/fhir/Observation/1").then().statusCode(405);
    }
}
