package se.poroli.fhirplace.examples.quarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement;
import se.poroli.fhirplace.r5.client.FhirClient;

/** The CapabilityStatement that fhirplace generates from the handlers. */
@QuarkusTest
class MetadataTest {

    @TestHTTPResource("fhir")
    URI base;

    @Test
    void capabilityStatementListsTheHandlers() {
        FhirClient fhir = FhirClient.of(base);
        CapabilityStatement statement = fhir.send(fhir.request("metadata").GET(), CapabilityStatement.class).body();

        Map<String, List<String>> interactions = statement.rest().getFirst().resource().stream()
                .collect(Collectors.toMap(resource -> resource.type().valueAsString(),
                        resource -> resource.interaction().stream().map(i -> i.code().valueAsString()).toList()));

        assertEquals(Map.of(
                        "Patient", List.of("read", "vread", "update", "delete", "create", "search-type"),
                        "Observation", List.of("read", "create", "search-type")),
                interactions);
    }
}
