package se.poroli.fhirplace.r5.provenance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Provenance with all elements and checks the builder and validation. */
class ProvenanceTest {

    @Test
    void provenance() {
        Provenance resource = Provenance.builder()
                .id("id1")
                .meta(Meta.builder().build())
                .implicitRules(FhirUri.of("http://example.org/uri"))
                .language(FhirCode.of("code"))
                .text(Narrative.builder()
                        .status(FhirEnum.of(NarrativeStatus.values()[0]))
                        .div(FhirXhtml.of("<div xmlns=\"http://www.w3.org/1999/xhtml\"/>"))
                        .build())
                .addContained(Patient.builder().build())
                .addExtension(Extension.builder().url("http://example.org/extension").build())
                .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                .addTarget(Reference.builder().build())
                .occurred(Period.builder().build())
                .recorded(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPolicy(FhirUri.of("http://example.org/uri"))
                .location(Reference.builder().build())
                .addAuthorization(CodeableReference.builder().build())
                .activity(CodeableConcept.builder().build())
                .addBasedOn(Reference.builder().build())
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addAgent(Provenance.Agent.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addRole(CodeableConcept.builder().build())
                        .who(Reference.builder().build())
                        .onBehalfOf(Reference.builder().build())
                        .build())
                .addEntity(Provenance.Entity.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(FhirEnum.of(ProvenanceEntityRole.values()[0]))
                        .what(Reference.builder().build())
                        .addAgent(Provenance.Agent.builder().who(Reference.builder().build()).build())
                        .build())
                .addSignature(Signature.builder().build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertFalse(resource.target().isEmpty());
        assertNotNull(resource.occurred());
        assertNotNull(resource.recorded());
        assertFalse(resource.policy().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.authorization().isEmpty());
        assertNotNull(resource.activity());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertFalse(resource.agent().isEmpty());
        assertFalse(resource.entity().isEmpty());
        assertFalse(resource.signature().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Provenance.target requires at least one value", assertThrows(
                IllegalArgumentException.class,
                () -> resource.toBuilder().target((java.util.List<Reference>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ProvenanceEntityRole.values(), ProvenanceEntityRole::fromCode);
    }

    private static <E extends CodedEnum> void assertCodes(E[] values, Function<String, E> fromCode) {
        for (E value : values) {
            assertSame(value, fromCode.apply(value.code()));
            assertTrue(URI.create(value.system()).isAbsolute());
            assertFalse(value.display().isBlank());
        }
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply("no-such-code"));
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply(values[0].code().toUpperCase() + "X"));
    }
}
