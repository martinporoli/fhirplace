package se.poroli.fhirplace.r5.researchstudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;

/** Builds a ResearchStudy with all elements and checks the builder and validation. */
class ResearchStudyTest {

    @Test
    void researchStudy() {
        ResearchStudy resource = ResearchStudy.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .addLabel(ResearchStudy.Label.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirString.of("text"))
                        .build())
                .addProtocol(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .primaryPurposeType(CodeableConcept.builder().build())
                .phase(CodeableConcept.builder().build())
                .addStudyDesign(CodeableConcept.builder().build())
                .addFocus(CodeableReference.builder().build())
                .addCondition(CodeableConcept.builder().build())
                .addKeyword(CodeableConcept.builder().build())
                .addRegion(CodeableConcept.builder().build())
                .descriptionSummary(FhirMarkdown.of("text"))
                .description(FhirMarkdown.of("text"))
                .period(Period.builder().build())
                .addSite(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addClassifier(CodeableConcept.builder().build())
                .addAssociatedParty(ResearchStudy.AssociatedParty.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .role(CodeableConcept.builder().build())
                        .addPeriod(Period.builder().build())
                        .addClassifier(CodeableConcept.builder().build())
                        .party(Reference.builder().build())
                        .build())
                .addProgressStatus(ResearchStudy.ProgressStatus.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .state(CodeableConcept.builder().build())
                        .actual(FhirBoolean.of(true))
                        .period(Period.builder().build())
                        .build())
                .whyStopped(CodeableConcept.builder().build())
                .recruitment(ResearchStudy.Recruitment.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .targetNumber(FhirUnsignedInt.of(0))
                        .actualNumber(FhirUnsignedInt.of(0))
                        .eligibility(Reference.builder().build())
                        .actualGroup(Reference.builder().build())
                        .build())
                .addComparisonGroup(ResearchStudy.ComparisonGroup.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirId.of("id1"))
                        .name(FhirString.of("text"))
                        .type(CodeableConcept.builder().build())
                        .description(FhirMarkdown.of("text"))
                        .addIntendedExposure(Reference.builder().build())
                        .observedGroup(Reference.builder().build())
                        .build())
                .addObjective(ResearchStudy.Objective.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .type(CodeableConcept.builder().build())
                        .description(FhirMarkdown.of("text"))
                        .build())
                .addOutcomeMeasure(ResearchStudy.OutcomeMeasure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .addType(CodeableConcept.builder().build())
                        .description(FhirMarkdown.of("text"))
                        .reference(Reference.builder().build())
                        .build())
                .addResult(Reference.builder().build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertFalse(resource.label().isEmpty());
        assertFalse(resource.protocol().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.date());
        assertNotNull(resource.status());
        assertNotNull(resource.primaryPurposeType());
        assertNotNull(resource.phase());
        assertFalse(resource.studyDesign().isEmpty());
        assertFalse(resource.focus().isEmpty());
        assertFalse(resource.condition().isEmpty());
        assertFalse(resource.keyword().isEmpty());
        assertFalse(resource.region().isEmpty());
        assertNotNull(resource.descriptionSummary());
        assertNotNull(resource.description());
        assertNotNull(resource.period());
        assertFalse(resource.site().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.classifier().isEmpty());
        assertFalse(resource.associatedParty().isEmpty());
        assertFalse(resource.progressStatus().isEmpty());
        assertNotNull(resource.whyStopped());
        assertNotNull(resource.recruitment());
        assertFalse(resource.comparisonGroup().isEmpty());
        assertFalse(resource.objective().isEmpty());
        assertFalse(resource.outcomeMeasure().isEmpty());
        assertFalse(resource.result().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ResearchStudy.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
