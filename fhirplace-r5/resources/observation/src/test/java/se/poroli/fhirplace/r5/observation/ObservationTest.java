package se.poroli.fhirplace.r5.observation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/** Builds a Observation with all elements and checks the builder and validation. */
class ObservationTest {

    @Test
    void observation() {
        Observation resource = Observation.builder()
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
                .addIdentifier(Identifier.builder().build())
                .instantiates(FhirCanonical.of("http://example.org/canonical"))
                .addBasedOn(Reference.builder().build())
                .addTriggeredBy(Observation.TriggeredBy.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .observation(Reference.builder().build())
                        .type(FhirEnum.of(TriggeredBytype.values()[0]))
                        .reason(FhirString.of("text"))
                        .build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(ObservationStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .addFocus(Reference.builder().build())
                .encounter(Reference.builder().build())
                .effective(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .issued(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPerformer(Reference.builder().build())
                .value(Quantity.builder().build())
                .dataAbsentReason(CodeableConcept.builder().build())
                .addInterpretation(CodeableConcept.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .bodySite(CodeableConcept.builder().build())
                .bodyStructure(Reference.builder().build())
                .method(CodeableConcept.builder().build())
                .specimen(Reference.builder().build())
                .device(Reference.builder().build())
                .addReferenceRange(Observation.ReferenceRange.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .low(Quantity.builder().build())
                        .high(Quantity.builder().build())
                        .normalValue(CodeableConcept.builder().build())
                        .type(CodeableConcept.builder().build())
                        .addAppliesTo(CodeableConcept.builder().build())
                        .age(Range.builder().build())
                        .text(FhirMarkdown.of("text"))
                        .build())
                .addHasMember(Reference.builder().build())
                .addDerivedFrom(Reference.builder().build())
                .addComponent(Observation.Component.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .value(Quantity.builder().build())
                        .dataAbsentReason(CodeableConcept.builder().build())
                        .addInterpretation(CodeableConcept.builder().build())
                        .addReferenceRange(Observation.ReferenceRange.builder().build())
                        .build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.instantiates());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.triggeredBy().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertFalse(resource.focus().isEmpty());
        assertNotNull(resource.encounter());
        assertNotNull(resource.effective());
        assertNotNull(resource.issued());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.value());
        assertNotNull(resource.dataAbsentReason());
        assertFalse(resource.interpretation().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.bodySite());
        assertNotNull(resource.bodyStructure());
        assertNotNull(resource.method());
        assertNotNull(resource.specimen());
        assertNotNull(resource.device());
        assertFalse(resource.referenceRange().isEmpty());
        assertFalse(resource.hasMember().isEmpty());
        assertFalse(resource.derivedFrom().isEmpty());
        assertFalse(resource.component().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Observation.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ObservationStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(TriggeredBytype.values(), TriggeredBytype::fromCode);
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
