package se.poroli.fhirplace.r5.server.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement.Rest.RestResource;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement;
import se.poroli.fhirplace.r5.json.FhirJson;

/** The capabilities interaction, generated from the handlers. */
public class CapabilitiesTest {

    @Test
    void metadataDescribesTheHandlers() {
        TestServer.Reply reply = TestServer.get("metadata");

        assertEquals(200, reply.status());
        CapabilityStatement statement = FhirJson.read(reply.body(), CapabilityStatement.class);
        assertEquals("5.0.0", statement.fhirVersion().valueAsString());
        assertEquals("server", statement.rest().getFirst().mode().valueAsString());
        Map<String, RestResource> resources = statement.rest().getFirst().resource().stream()
                .collect(Collectors.toMap(r -> r.type().valueAsString(), r -> r));
        assertEquals(List.of("Observation", "Patient"), resources.keySet().stream().sorted().toList());
        assertEquals(List.of("read"), codes(resources.get("Observation")));
        assertEquals(List.of("read", "vread", "update", "delete", "create", "search-type"),
                codes(resources.get("Patient")));
        assertEquals("versioned", resources.get("Patient").versioning().valueAsString());
        assertEquals(Map.of("birthdate", "date", "family", "string", "general-practitioner", "reference",
                        "identifier", "token"),
                resources.get("Patient").searchParam().stream().collect(Collectors.toMap(
                        p -> p.name().value(), p -> p.type().valueAsString())));
    }

    private static List<String> codes(RestResource resource) {
        return resource.interaction().stream().map(i -> i.code().valueAsString()).toList();
    }
}
