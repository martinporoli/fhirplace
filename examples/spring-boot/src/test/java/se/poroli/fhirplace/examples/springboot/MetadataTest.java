package se.poroli.fhirplace.examples.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement;
import se.poroli.fhirplace.r5.json.FhirJson;

/** The CapabilityStatement that fhirplace generates from the handlers. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MetadataTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    void capabilityStatementListsTheHandlers() {
        String body = FhirClient.create(port).get().uri("/metadata").retrieve().body(String.class);

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
