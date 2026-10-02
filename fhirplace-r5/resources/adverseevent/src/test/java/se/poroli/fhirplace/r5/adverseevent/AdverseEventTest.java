package se.poroli.fhirplace.r5.adverseevent;

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
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a AdverseEvent with all elements and checks the builder and validation. */
class AdverseEventTest {

    @Test
    void adverseEvent() {
        AdverseEvent resource = AdverseEvent.builder()
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
                .status(FhirEnum.of(AdverseEventStatus.values()[0]))
                .actuality(FhirEnum.of(AdverseEventActuality.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .detected(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .recordedDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addResultingEffect(Reference.builder().build())
                .location(Reference.builder().build())
                .seriousness(CodeableConcept.builder().build())
                .addOutcome(CodeableConcept.builder().build())
                .recorder(Reference.builder().build())
                .addParticipant(AdverseEvent.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addStudy(Reference.builder().build())
                .expectedInResearchStudy(FhirBoolean.of(true))
                .addSuspectEntity(AdverseEvent.SuspectEntity.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .instance(CodeableConcept.builder().build())
                        .causality(AdverseEvent.SuspectEntity.Causality.builder().build())
                        .build())
                .addContributingFactor(AdverseEvent.ContributingFactor.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(Reference.builder().build())
                        .build())
                .addPreventiveAction(AdverseEvent.PreventiveAction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(Reference.builder().build())
                        .build())
                .addMitigatingAction(AdverseEvent.MitigatingAction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(Reference.builder().build())
                        .build())
                .addSupportingInfo(AdverseEvent.SupportingInfo.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(Reference.builder().build())
                        .build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
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
        assertNotNull(resource.status());
        assertNotNull(resource.actuality());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.detected());
        assertNotNull(resource.recordedDate());
        assertFalse(resource.resultingEffect().isEmpty());
        assertNotNull(resource.location());
        assertNotNull(resource.seriousness());
        assertFalse(resource.outcome().isEmpty());
        assertNotNull(resource.recorder());
        assertFalse(resource.participant().isEmpty());
        assertFalse(resource.study().isEmpty());
        assertNotNull(resource.expectedInResearchStudy());
        assertFalse(resource.suspectEntity().isEmpty());
        assertFalse(resource.contributingFactor().isEmpty());
        assertFalse(resource.preventiveAction().isEmpty());
        assertFalse(resource.mitigatingAction().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("AdverseEvent.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<AdverseEventStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(AdverseEventActuality.values(), AdverseEventActuality::fromCode);
        assertCodes(AdverseEventStatus.values(), AdverseEventStatus::fromCode);
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
