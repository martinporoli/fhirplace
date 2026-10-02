package se.poroli.fhirplace.r5.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

class ExtensionTest {

    @Test
    void holdsAValueOrNestedExtensions() {
        Extension simple = Extension.builder().url("http://example.org/a").value(FhirString.of("x")).build();
        Extension complex = Extension.builder().url("http://example.org/b").addExtension(simple).build();

        assertEquals(FhirString.of("x"), simple.value());
        assertTrue(simple.extension().isEmpty());
        assertEquals(List.of(simple), complex.extension());
    }

    @Test
    void acceptsComplexDatatypeValues() {
        HumanName name = HumanName.builder().family("Doe").build();

        Extension extension = Extension.builder().url("http://example.org/name").value(name).build();

        assertEquals(name, extension.value());
    }

    @Test
    void requiresUrl() {
        assertThrows(NullPointerException.class, () -> Extension.builder().value(FhirBoolean.of(true)).build());
    }

    @Test
    void rejectsValueTypesNotAllowedByFhir() {
        Narrative narrative = Narrative.builder().status(NarrativeStatus.EMPTY).div("<div/>").build();

        assertThrows(IllegalArgumentException.class,
                () -> new Extension(null, List.of(), "http://example.org/n", narrative));
    }
}
