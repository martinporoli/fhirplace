package se.poroli.fhirplace.r5.familymemberhistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
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
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a FamilyMemberHistory with all elements and checks the builder and validation. */
class FamilyMemberHistoryTest {

    @Test
    void familyMemberHistory() {
        FamilyMemberHistory resource = FamilyMemberHistory.builder()
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
                .addInstantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .addInstantiatesUri(FhirUri.of("http://example.org/uri"))
                .status(FhirEnum.of(FamilyHistoryStatus.values()[0]))
                .dataAbsentReason(CodeableConcept.builder().build())
                .patient(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addParticipant(FamilyMemberHistory.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .name(FhirString.of("text"))
                .relationship(CodeableConcept.builder().build())
                .sex(CodeableConcept.builder().build())
                .born(Period.builder().build())
                .age(Age.builder().build())
                .estimatedAge(FhirBoolean.of(true))
                .deceased(FhirBoolean.of(true))
                .addReason(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addCondition(FamilyMemberHistory.Condition.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .outcome(CodeableConcept.builder().build())
                        .contributedToDeath(FhirBoolean.of(true))
                        .onset(Age.builder().build())
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .build())
                .addProcedure(FamilyMemberHistory.Procedure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .outcome(CodeableConcept.builder().build())
                        .contributedToDeath(FhirBoolean.of(true))
                        .performed(Age.builder().build())
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
        assertFalse(resource.instantiatesCanonical().isEmpty());
        assertFalse(resource.instantiatesUri().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.dataAbsentReason());
        assertNotNull(resource.patient());
        assertNotNull(resource.date());
        assertFalse(resource.participant().isEmpty());
        assertNotNull(resource.name());
        assertNotNull(resource.relationship());
        assertNotNull(resource.sex());
        assertNotNull(resource.born());
        assertNotNull(resource.age());
        assertNotNull(resource.estimatedAge());
        assertNotNull(resource.deceased());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.condition().isEmpty());
        assertFalse(resource.procedure().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("FamilyMemberHistory.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<FamilyHistoryStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(FamilyHistoryStatus.values(), FamilyHistoryStatus::fromCode);
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
