package se.poroli.fhirplace.examples.quarkus;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement;
import se.poroli.fhirplace.r5.json.FhirJson;

/** The CapabilityStatement that fhirplace generates from the handlers. */
@QuarkusTest
class MetadataTest {

    @Test
    void capabilityStatementListsTheHandlers() {
        String body = given().when().get("/fhir/metadata").then().statusCode(200).extract().asString();

        CapabilityStatement statement = FhirJson.read(body, CapabilityStatement.class);
        Map<String, List<String>> interactions = statement.rest().getFirst().resource().stream()
                .collect(Collectors.toMap(resource -> resource.type().valueAsString(),
                        resource -> resource.interaction().stream().map(i -> i.code().valueAsString()).toList()));

        assertEquals(Map.of(
                        "Patient", List.of("read", "vread", "update", "delete", "create", "search-type"),
                        "Observation", List.of("read", "create", "search-type")),
                interactions);
    }
}
