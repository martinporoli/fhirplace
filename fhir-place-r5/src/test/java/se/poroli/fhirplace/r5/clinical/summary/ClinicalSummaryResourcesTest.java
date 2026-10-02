package se.poroli.fhirplace.r5.clinical.summary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
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
import se.poroli.fhirplace.r5.valuesets.AdverseEventActuality;
import se.poroli.fhirplace.r5.valuesets.AdverseEventStatus;
import se.poroli.fhirplace.r5.valuesets.AllergyIntoleranceCategory;
import se.poroli.fhirplace.r5.valuesets.AllergyIntoleranceCriticality;
import se.poroli.fhirplace.r5.valuesets.AllergyIntoleranceSeverity;
import se.poroli.fhirplace.r5.valuesets.DetectedIssueSeverity;
import se.poroli.fhirplace.r5.valuesets.EventStatus;
import se.poroli.fhirplace.r5.valuesets.FamilyHistoryStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds every clinical.summary resource with all elements and checks the builders and validation. */
class ClinicalSummaryResourcesTest {

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
    void condition() {
        Condition resource = Condition.builder()
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
                .addCategory(CodeableConcept.builder().build())
                .severity(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .addBodySite(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .onset(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .abatement(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .recordedDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addParticipant(Condition.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addStage(Condition.Stage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .summary(CodeableConcept.builder().build())
                        .addAssessment(Reference.builder().build())
                        .type(CodeableConcept.builder().build())
                        .build())
                .addEvidence(CodeableReference.builder().build())
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
        assertNotNull(resource.clinicalStatus());
        assertNotNull(resource.verificationStatus());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.severity());
        assertNotNull(resource.code());
        assertFalse(resource.bodySite().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.onset());
        assertNotNull(resource.abatement());
        assertNotNull(resource.recordedDate());
        assertFalse(resource.participant().isEmpty());
        assertFalse(resource.stage().isEmpty());
        assertFalse(resource.evidence().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Condition.clinicalStatus is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().clinicalStatus((CodeableConcept) null).build()).getMessage());
    }

    @Test
    void procedure() {
        Procedure resource = Procedure.builder()
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
                .addBasedOn(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(EventStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .focus(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .recorded(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .recorder(Reference.builder().build())
                .reported(FhirBoolean.of(true))
                .addPerformer(Procedure.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .onBehalfOf(Reference.builder().build())
                        .period(Period.builder().build())
                        .build())
                .location(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addBodySite(CodeableConcept.builder().build())
                .outcome(CodeableConcept.builder().build())
                .addReport(Reference.builder().build())
                .addComplication(CodeableReference.builder().build())
                .addFollowUp(CodeableConcept.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addFocalDevice(Procedure.FocalDevice.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .action(CodeableConcept.builder().build())
                        .manipulated(Reference.builder().build())
                        .build())
                .addUsed(CodeableReference.builder().build())
                .addSupportingInfo(Reference.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.focus());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.recorded());
        assertNotNull(resource.recorder());
        assertNotNull(resource.reported());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.bodySite().isEmpty());
        assertNotNull(resource.outcome());
        assertFalse(resource.report().isEmpty());
        assertFalse(resource.complication().isEmpty());
        assertFalse(resource.followUp().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.focalDevice().isEmpty());
        assertFalse(resource.used().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Procedure.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EventStatus>) null).build()).getMessage());
    }

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
    void clinicalImpression() {
        ClinicalImpression resource = ClinicalImpression.builder()
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
                .status(FhirEnum.of(EventStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .description(FhirString.of("text"))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .effective(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .performer(Reference.builder().build())
                .previous(Reference.builder().build())
                .addProblem(Reference.builder().build())
                .changePattern(CodeableConcept.builder().build())
                .addProtocol(FhirUri.of("http://example.org/uri"))
                .summary(FhirString.of("text"))
                .addFinding(ClinicalImpression.Finding.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(CodeableReference.builder().build())
                        .basis(FhirString.of("text"))
                        .build())
                .addPrognosisCodeableConcept(CodeableConcept.builder().build())
                .addPrognosisReference(Reference.builder().build())
                .addSupportingInfo(Reference.builder().build())
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
        assertNotNull(resource.statusReason());
        assertNotNull(resource.description());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.effective());
        assertNotNull(resource.date());
        assertNotNull(resource.performer());
        assertNotNull(resource.previous());
        assertFalse(resource.problem().isEmpty());
        assertNotNull(resource.changePattern());
        assertFalse(resource.protocol().isEmpty());
        assertNotNull(resource.summary());
        assertFalse(resource.finding().isEmpty());
        assertFalse(resource.prognosisCodeableConcept().isEmpty());
        assertFalse(resource.prognosisReference().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ClinicalImpression.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EventStatus>) null).build()).getMessage());
    }

    @Test
    void detectedIssue() {
        DetectedIssue resource = DetectedIssue.builder()
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
                .status(FhirCode.of("code"))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .severity(FhirEnum.of(DetectedIssueSeverity.values()[0]))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .identified(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .author(Reference.builder().build())
                .addImplicated(Reference.builder().build())
                .addEvidence(DetectedIssue.Evidence.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addCode(CodeableConcept.builder().build())
                        .addDetail(Reference.builder().build())
                        .build())
                .detail(FhirMarkdown.of("text"))
                .reference(FhirUri.of("http://example.org/uri"))
                .addMitigation(DetectedIssue.Mitigation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .action(CodeableConcept.builder().build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .author(Reference.builder().build())
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
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.severity());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.identified());
        assertNotNull(resource.author());
        assertFalse(resource.implicated().isEmpty());
        assertFalse(resource.evidence().isEmpty());
        assertNotNull(resource.detail());
        assertNotNull(resource.reference());
        assertFalse(resource.mitigation().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DetectedIssue.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirCode) null).build()).getMessage());
    }
}
