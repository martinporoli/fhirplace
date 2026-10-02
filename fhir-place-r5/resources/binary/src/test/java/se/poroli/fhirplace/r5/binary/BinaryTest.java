package se.poroli.fhirplace.r5.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Reference;

/** Builds a Binary with all elements and checks the builder and validation. */
class BinaryTest {

    @Test
    void binary() {
        Binary resource = Binary.builder()
                .id("id1")
                .meta(Meta.builder().build())
                .implicitRules(FhirUri.of("http://example.org/uri"))
                .language(FhirCode.of("code"))
                .contentType(FhirCode.of("code"))
                .securityContext(Reference.builder().build())
                .data(FhirBase64Binary.of("aGk="))
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.contentType());
        assertNotNull(resource.securityContext());
        assertNotNull(resource.data());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Binary.contentType is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().contentType((FhirCode) null).build()).getMessage());
    }
}
