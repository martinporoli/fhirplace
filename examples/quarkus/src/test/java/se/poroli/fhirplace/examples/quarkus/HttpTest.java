package se.poroli.fhirplace.examples.quarkus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/** What the API looks like on the wire, for clients that do not use fhirplace. */
@QuarkusTest
class HttpTest {

    @Test
    void createAnswersWithFhirJsonLocationAndVersion() {
        given().contentType("application/fhir+json; charset=UTF-8")
                .body("{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Wire\"}]}")
                .when().post("/fhir/Patient")
                .then().statusCode(201)
                .contentType(startsWith("application/fhir+json"))
                .header("ETag", "W/\"1\"")
                .header("Location", endsWith("/_history/1"));
    }

    @Test
    void formatParameterAndErrorsAsOperationOutcome() {
        given().when().get("/fhir/metadata?_format=xml")
                .then().statusCode(200).contentType(startsWith("application/fhir+xml"));
        given().accept("application/fhir+json").when().get("/fhir/Patient/12345678")
                .then().statusCode(404).contentType(startsWith("application/fhir+json"));
    }
}
