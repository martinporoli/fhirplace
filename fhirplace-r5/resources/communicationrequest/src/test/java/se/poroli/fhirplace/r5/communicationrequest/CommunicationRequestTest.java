package se.poroli.fhirplace.r5.communicationrequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
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
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/** Builds a CommunicationRequest with all elements and checks the builder and validation. */
class CommunicationRequestTest {

    @Test
    void communicationRequest() {
        CommunicationRequest resource = CommunicationRequest.builder()
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
                .addBasedOn(Reference.builder().build())
                .addReplaces(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(RequestStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .intent(FhirEnum.of(RequestIntent.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .doNotPerform(FhirBoolean.of(true))
                .addMedium(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .addAbout(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addPayload(CommunicationRequest.Payload.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .content(Attachment.builder().build())
                        .build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .addRecipient(Reference.builder().build())
                .addInformationProvider(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.replaces().isEmpty());
        assertNotNull(resource.groupIdentifier());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.intent());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.priority());
        assertNotNull(resource.doNotPerform());
        assertFalse(resource.medium().isEmpty());
        assertNotNull(resource.subject());
        assertFalse(resource.about().isEmpty());
        assertNotNull(resource.encounter());
        assertFalse(resource.payload().isEmpty());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.requester());
        assertFalse(resource.recipient().isEmpty());
        assertFalse(resource.informationProvider().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CommunicationRequest.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<RequestStatus>) null).build()).getMessage());
    }
}
