package se.poroli.fhirplace.r5.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.valuesets.ResourceType;

/** Checks that the example round-trips cover every FHIR R5 resource type. */
class CoverageTest {

    @Test
    void everyResourceTypeHasAModelClassAndAnExample() throws Exception {
        Set<String> withExamples =
                Example.all().stream().map(Example::resourceType).collect(Collectors.toSet());
        List<String> missing = Arrays.stream(ResourceType.values())
                .map(ResourceType::code)
                .filter(type -> !withExamples.contains(type))
                .toList();

        assertEquals(List.of(), missing);
        for (ResourceType type : ResourceType.values()) {
            String className = "se.poroli.fhirplace.r5." + type.code().toLowerCase(Locale.ROOT) + "." + type.code();
            assertTrue(Resource.class.isAssignableFrom(Class.forName(className)), className);
        }
    }
}
