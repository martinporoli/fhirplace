package se.poroli.fhirplace.r5.allergyintolerance;

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
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a AllergyIntolerance with all elements and checks the builder and validation. */
class AllergyIntoleranceTest {

    @Test
    void allergyIntolerance() {
        AllergyIntolerance resource = AllergyIntolerance.builder()
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
                .clinicalStatus(CodeableConcept.builder().build())
                .verificationStatus(CodeableConcept.builder().build())
                .type(CodeableConcept.builder().build())
                .addCategory(FhirEnum.of(AllergyIntoleranceCategory.values()[0]))
                .criticality(FhirEnum.of(AllergyIntoleranceCriticality.values()[0]))
                .code(CodeableConcept.builder().build())
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .onset(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .recordedDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addParticipant(AllergyIntolerance.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .lastOccurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addReaction(AllergyIntolerance.Reaction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .substance(CodeableConcept.builder().build())
                        .addManifestation(CodeableReference.builder().build())
                        .description(FhirString.of("text"))
                        .onset(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .severity(FhirEnum.of(AllergyIntoleranceSeverity.values()[0]))
                        .exposureRoute(CodeableConcept.builder().build())
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
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
        assertNotNull(resource.clinicalStatus());
        assertNotNull(resource.verificationStatus());
        assertNotNull(resource.type());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.criticality());
        assertNotNull(resource.code());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertNotNull(resource.onset());
        assertNotNull(resource.recordedDate());
        assertFalse(resource.participant().isEmpty());
        assertNotNull(resource.lastOccurrence());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.reaction().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("AllergyIntolerance.patient is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().patient((Reference) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(AllergyIntoleranceCategory.values(), AllergyIntoleranceCategory::fromCode);
        assertCodes(AllergyIntoleranceCriticality.values(), AllergyIntoleranceCriticality::fromCode);
        assertCodes(AllergyIntoleranceSeverity.values(), AllergyIntoleranceSeverity::fromCode);
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
