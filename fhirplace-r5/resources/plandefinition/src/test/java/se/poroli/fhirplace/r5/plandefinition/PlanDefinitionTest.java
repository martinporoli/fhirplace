package se.poroli.fhirplace.r5.plandefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.ActionCardinalityBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionConditionKind;
import se.poroli.fhirplace.r5.valuesets.ActionGroupingBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionPrecheckBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionRelationshipType;
import se.poroli.fhirplace.r5.valuesets.ActionRequiredBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionSelectionBehavior;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.TriggerType;

/** Builds a PlanDefinition with all elements and checks the builder and validation. */
class PlanDefinitionTest {

    @Test
    void planDefinition() {
        PlanDefinition resource = PlanDefinition.builder()
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
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .subtitle(FhirString.of("text"))
                .type(CodeableConcept.builder().build())
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .subject(CodeableConcept.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .usage(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .addLibrary(FhirCanonical.of("http://example.org/canonical"))
                .addGoal(PlanDefinition.Goal.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .description(CodeableConcept.builder().build())
                        .priority(CodeableConcept.builder().build())
                        .start(CodeableConcept.builder().build())
                        .addAddresses(CodeableConcept.builder().build())
                        .addDocumentation(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .addTarget(PlanDefinition.Goal.Target.builder().build())
                        .build())
                .addActor(PlanDefinition.Actor.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .addOption(PlanDefinition.Actor.Option.builder().build())
                        .build())
                .addAction(PlanDefinition.Action.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .prefix(FhirString.of("text"))
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .textEquivalent(FhirMarkdown.of("text"))
                        .priority(FhirEnum.of(RequestPriority.values()[0]))
                        .code(CodeableConcept.builder().build())
                        .addReason(CodeableConcept.builder().build())
                        .addDocumentation(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .addGoalId(FhirId.of("id1"))
                        .subject(CodeableConcept.builder().build())
                        .addTrigger(TriggerDefinition.builder()
                                .type(FhirEnum.of(TriggerType.values()[0]))
                                .build())
                        .addCondition(PlanDefinition.Action.Condition.builder()
                                .kind(FhirEnum.of(ActionConditionKind.values()[0]))
                                .build())
                        .addInput(PlanDefinition.Action.Input.builder().build())
                        .addOutput(PlanDefinition.Action.Output.builder().build())
                        .addRelatedAction(PlanDefinition.Action.RelatedAction.builder()
                                .targetId(FhirId.of("id1"))
                                .relationship(FhirEnum.of(ActionRelationshipType.values()[0]))
                                .build())
                        .timing(Age.builder().build())
                        .location(CodeableReference.builder().build())
                        .addParticipant(PlanDefinition.Action.Participant.builder().build())
                        .type(CodeableConcept.builder().build())
                        .groupingBehavior(FhirEnum.of(ActionGroupingBehavior.values()[0]))
                        .selectionBehavior(FhirEnum.of(ActionSelectionBehavior.values()[0]))
                        .requiredBehavior(FhirEnum.of(ActionRequiredBehavior.values()[0]))
                        .precheckBehavior(FhirEnum.of(ActionPrecheckBehavior.values()[0]))
                        .cardinalityBehavior(FhirEnum.of(ActionCardinalityBehavior.values()[0]))
                        .definition(FhirCanonical.of("http://example.org/canonical"))
                        .transform(FhirCanonical.of("http://example.org/canonical"))
                        .addDynamicValue(PlanDefinition.Action.DynamicValue.builder().build())
                        .addAction(PlanDefinition.Action.builder().build())
                        .build())
                .asNeeded(FhirBoolean.of(true))
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
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.subtitle());
        assertNotNull(resource.type());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.usage());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertFalse(resource.library().isEmpty());
        assertFalse(resource.goal().isEmpty());
        assertFalse(resource.actor().isEmpty());
        assertFalse(resource.action().isEmpty());
        assertNotNull(resource.asNeeded());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("PlanDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
