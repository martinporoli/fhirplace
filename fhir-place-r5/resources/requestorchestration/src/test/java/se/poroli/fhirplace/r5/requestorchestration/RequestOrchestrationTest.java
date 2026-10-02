package se.poroli.fhirplace.r5.requestorchestration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
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
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.ActionCardinalityBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionConditionKind;
import se.poroli.fhirplace.r5.valuesets.ActionGroupingBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionPrecheckBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionRelationshipType;
import se.poroli.fhirplace.r5.valuesets.ActionRequiredBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionSelectionBehavior;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/** Builds a RequestOrchestration with all elements and checks the builder and validation. */
class RequestOrchestrationTest {

    @Test
    void requestOrchestration() {
        RequestOrchestration resource = RequestOrchestration.builder()
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
                .addReplaces(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(RequestStatus.values()[0]))
                .intent(FhirEnum.of(RequestIntent.values()[0]))
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .author(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addGoal(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addAction(RequestOrchestration.Action.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .prefix(FhirString.of("text"))
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .textEquivalent(FhirMarkdown.of("text"))
                        .priority(FhirEnum.of(RequestPriority.values()[0]))
                        .addCode(CodeableConcept.builder().build())
                        .addDocumentation(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .addGoal(Reference.builder().build())
                        .addCondition(RequestOrchestration.Action.Condition.builder()
                                .kind(FhirEnum.of(ActionConditionKind.values()[0]))
                                .build())
                        .addInput(RequestOrchestration.Action.Input.builder().build())
                        .addOutput(RequestOrchestration.Action.Output.builder().build())
                        .addRelatedAction(RequestOrchestration.Action.RelatedAction.builder()
                                .targetId(FhirId.of("id1"))
                                .relationship(FhirEnum.of(ActionRelationshipType.values()[0]))
                                .build())
                        .timing(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .location(CodeableReference.builder().build())
                        .addParticipant(RequestOrchestration.Action.Participant.builder().build())
                        .type(CodeableConcept.builder().build())
                        .groupingBehavior(FhirEnum.of(ActionGroupingBehavior.values()[0]))
                        .selectionBehavior(FhirEnum.of(ActionSelectionBehavior.values()[0]))
                        .requiredBehavior(FhirEnum.of(ActionRequiredBehavior.values()[0]))
                        .precheckBehavior(FhirEnum.of(ActionPrecheckBehavior.values()[0]))
                        .cardinalityBehavior(FhirEnum.of(ActionCardinalityBehavior.values()[0]))
                        .resource(Reference.builder().build())
                        .definition(FhirCanonical.of("http://example.org/canonical"))
                        .transform(FhirCanonical.of("http://example.org/canonical"))
                        .addDynamicValue(RequestOrchestration.Action.DynamicValue.builder().build())
                        .addAction(RequestOrchestration.Action.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.replaces().isEmpty());
        assertNotNull(resource.groupIdentifier());
        assertNotNull(resource.status());
        assertNotNull(resource.intent());
        assertNotNull(resource.priority());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.author());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.goal().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.action().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("RequestOrchestration.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<RequestStatus>) null).build()).getMessage());
    }
}
