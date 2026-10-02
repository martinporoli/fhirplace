package se.poroli.fhirplace.r5.clinical.requestresponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.BiologicallyDerivedProductDispenseCodes;
import se.poroli.fhirplace.r5.valuesets.CommonLanguages;
import se.poroli.fhirplace.r5.valuesets.DeviceDispenseStatusCodes;
import se.poroli.fhirplace.r5.valuesets.DeviceUsageStatus;
import se.poroli.fhirplace.r5.valuesets.EventStatus;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.GuidanceResponseStatus;
import se.poroli.fhirplace.r5.valuesets.InventoryCountType;
import se.poroli.fhirplace.r5.valuesets.InventoryItemStatusCodes;
import se.poroli.fhirplace.r5.valuesets.InventoryReportStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;
import se.poroli.fhirplace.r5.valuesets.SupplyDeliveryStatus;
import se.poroli.fhirplace.r5.valuesets.SupplyRequestStatus;

/** Builds every clinical.requestresponse resource with all elements and checks the builders and validation. */
class ClinicalRequestresponseResourcesTest {

    @Test
    void communication() {
        Communication resource = Communication.builder()
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
                .addInResponseTo(Reference.builder().build())
                .status(FhirEnum.of(EventStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .addMedium(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .topic(CodeableConcept.builder().build())
                .addAbout(Reference.builder().build())
                .encounter(Reference.builder().build())
                .sent(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .received(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addRecipient(Reference.builder().build())
                .sender(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addPayload(Communication.Payload.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .content(Attachment.builder().build())
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
        assertFalse(resource.instantiatesCanonical().isEmpty());
        assertFalse(resource.instantiatesUri().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertFalse(resource.inResponseTo().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.priority());
        assertFalse(resource.medium().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.topic());
        assertFalse(resource.about().isEmpty());
        assertNotNull(resource.encounter());
        assertNotNull(resource.sent());
        assertNotNull(resource.received());
        assertFalse(resource.recipient().isEmpty());
        assertNotNull(resource.sender());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.payload().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Communication.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EventStatus>) null).build()).getMessage());
    }

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

    @Test
    void deviceRequest() {
        DeviceRequest resource = DeviceRequest.builder()
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
                .doNotPerform(FhirBoolean.of(true))
                .code(CodeableReference.builder().build())
                .quantity(FhirInteger.of(1))
                .addParameter(DeviceRequest.Parameter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .performer(CodeableReference.builder().build())
                .addReason(CodeableReference.builder().build())
                .asNeeded(FhirBoolean.of(true))
                .asNeededFor(CodeableConcept.builder().build())
                .addInsurance(Reference.builder().build())
                .addSupportingInfo(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addRelevantHistory(Reference.builder().build())
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
        assertNotNull(resource.doNotPerform());
        assertNotNull(resource.code());
        assertNotNull(resource.quantity());
        assertFalse(resource.parameter().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.requester());
        assertNotNull(resource.performer());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.asNeeded());
        assertNotNull(resource.asNeededFor());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.relevantHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DeviceRequest.intent is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().intent((FhirEnum<RequestIntent>) null).build()).getMessage());
    }

    @Test
    void deviceDispense() {
        DeviceDispense resource = DeviceDispense.builder()
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
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(DeviceDispenseStatusCodes.values()[0]))
                .statusReason(CodeableReference.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .device(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .receiver(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .addPerformer(DeviceDispense.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .location(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .quantity(Quantity.builder().build())
                .preparedDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .whenHandedOver(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .destination(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .usageInstruction(FhirMarkdown.of("text"))
                .addEventHistory(Reference.builder().build())
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
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.device());
        assertNotNull(resource.subject());
        assertNotNull(resource.receiver());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertNotNull(resource.type());
        assertNotNull(resource.quantity());
        assertNotNull(resource.preparedDate());
        assertNotNull(resource.whenHandedOver());
        assertNotNull(resource.destination());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.usageInstruction());
        assertFalse(resource.eventHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DeviceDispense.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<DeviceDispenseStatusCodes>) null).build()).getMessage());
    }

    @Test
    void deviceAssociation() {
        DeviceAssociation resource = DeviceAssociation.builder()
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
                .device(Reference.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .status(CodeableConcept.builder().build())
                .addStatusReason(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .bodyStructure(Reference.builder().build())
                .period(Period.builder().build())
                .addOperation(DeviceAssociation.Operation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .status(CodeableConcept.builder().build())
                        .addOperator(Reference.builder().build())
                        .period(Period.builder().build())
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
        assertNotNull(resource.device());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.statusReason().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.bodyStructure());
        assertNotNull(resource.period());
        assertFalse(resource.operation().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DeviceAssociation.device is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().device((Reference) null).build()).getMessage());
    }

    @Test
    void deviceUsage() {
        DeviceUsage resource = DeviceUsage.builder()
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
                .status(FhirEnum.of(DeviceUsageStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .patient(Reference.builder().build())
                .addDerivedFrom(Reference.builder().build())
                .context(Reference.builder().build())
                .timing(Timing.builder().build())
                .dateAsserted(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .usageStatus(CodeableConcept.builder().build())
                .addUsageReason(CodeableConcept.builder().build())
                .adherence(DeviceUsage.Adherence.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .addReason(CodeableConcept.builder().build())
                        .build())
                .informationSource(Reference.builder().build())
                .device(CodeableReference.builder().build())
                .addReason(CodeableReference.builder().build())
                .bodySite(CodeableReference.builder().build())
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
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.patient());
        assertFalse(resource.derivedFrom().isEmpty());
        assertNotNull(resource.context());
        assertNotNull(resource.timing());
        assertNotNull(resource.dateAsserted());
        assertNotNull(resource.usageStatus());
        assertFalse(resource.usageReason().isEmpty());
        assertNotNull(resource.adherence());
        assertNotNull(resource.informationSource());
        assertNotNull(resource.device());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.bodySite());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DeviceUsage.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<DeviceUsageStatus>) null).build()).getMessage());
    }

    @Test
    void biologicallyDerivedProductDispense() {
        BiologicallyDerivedProductDispense resource = BiologicallyDerivedProductDispense.builder()
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
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(BiologicallyDerivedProductDispenseCodes.values()[0]))
                .originRelationshipType(CodeableConcept.builder().build())
                .product(Reference.builder().build())
                .patient(Reference.builder().build())
                .matchStatus(CodeableConcept.builder().build())
                .addPerformer(BiologicallyDerivedProductDispense.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .location(Reference.builder().build())
                .quantity(Quantity.builder().build())
                .preparedDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .whenHandedOver(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .destination(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .usageInstruction(FhirString.of("text"))
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
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.originRelationshipType());
        assertNotNull(resource.product());
        assertNotNull(resource.patient());
        assertNotNull(resource.matchStatus());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertNotNull(resource.quantity());
        assertNotNull(resource.preparedDate());
        assertNotNull(resource.whenHandedOver());
        assertNotNull(resource.destination());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.usageInstruction());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("BiologicallyDerivedProductDispense.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<BiologicallyDerivedProductDispenseCodes>) null).build()).getMessage());
    }

    @Test
    void guidanceResponse() {
        GuidanceResponse resource = GuidanceResponse.builder()
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
                .requestIdentifier(Identifier.builder().build())
                .addIdentifier(Identifier.builder().build())
                .module(FhirUri.of("http://example.org/uri"))
                .status(FhirEnum.of(GuidanceResponseStatus.values()[0]))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrenceDateTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .performer(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .evaluationMessage(Reference.builder().build())
                .outputParameters(Reference.builder().build())
                .addResult(Reference.builder().build())
                .addDataRequirement(DataRequirement.builder()
                        .type(FhirEnum.of(FHIRTypes.values()[0]))
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
        assertNotNull(resource.requestIdentifier());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.module());
        assertNotNull(resource.status());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrenceDateTime());
        assertNotNull(resource.performer());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.evaluationMessage());
        assertNotNull(resource.outputParameters());
        assertFalse(resource.result().isEmpty());
        assertFalse(resource.dataRequirement().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("GuidanceResponse.module is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().module((FhirUri) null).build()).getMessage());
    }

    @Test
    void supplyRequest() {
        SupplyRequest resource = SupplyRequest.builder()
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
                .status(FhirEnum.of(SupplyRequestStatus.values()[0]))
                .addBasedOn(Reference.builder().build())
                .category(CodeableConcept.builder().build())
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .deliverFor(Reference.builder().build())
                .item(CodeableReference.builder().build())
                .quantity(Quantity.builder().build())
                .addParameter(SupplyRequest.Parameter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .addSupplier(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .deliverFrom(Reference.builder().build())
                .deliverTo(Reference.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.category());
        assertNotNull(resource.priority());
        assertNotNull(resource.deliverFor());
        assertNotNull(resource.item());
        assertNotNull(resource.quantity());
        assertFalse(resource.parameter().isEmpty());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.requester());
        assertFalse(resource.supplier().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.deliverFrom());
        assertNotNull(resource.deliverTo());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("SupplyRequest.item is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().item((CodeableReference) null).build()).getMessage());
    }

    @Test
    void supplyDelivery() {
        SupplyDelivery resource = SupplyDelivery.builder()
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
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(SupplyDeliveryStatus.values()[0]))
                .patient(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .addSuppliedItem(SupplyDelivery.SuppliedItem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .quantity(Quantity.builder().build())
                        .item(CodeableConcept.builder().build())
                        .build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .supplier(Reference.builder().build())
                .destination(Reference.builder().build())
                .addReceiver(Reference.builder().build())
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
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.patient());
        assertNotNull(resource.type());
        assertFalse(resource.suppliedItem().isEmpty());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.supplier());
        assertNotNull(resource.destination());
        assertFalse(resource.receiver().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void inventoryItem() {
        InventoryItem resource = InventoryItem.builder()
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
                .status(FhirEnum.of(InventoryItemStatusCodes.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .addCode(CodeableConcept.builder().build())
                .addName(InventoryItem.Name.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .nameType(Coding.builder().build())
                        .language(FhirEnum.of(CommonLanguages.values()[0]))
                        .name(FhirString.of("text"))
                        .build())
                .addResponsibleOrganization(InventoryItem.ResponsibleOrganization.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(CodeableConcept.builder().build())
                        .organization(Reference.builder().build())
                        .build())
                .description(InventoryItem.Description.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .language(FhirEnum.of(CommonLanguages.values()[0]))
                        .description(FhirString.of("text"))
                        .build())
                .addInventoryStatus(CodeableConcept.builder().build())
                .baseUnit(CodeableConcept.builder().build())
                .netContent(Quantity.builder().build())
                .addAssociation(InventoryItem.Association.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .associationType(CodeableConcept.builder().build())
                        .relatedItem(Reference.builder().build())
                        .quantity(Ratio.builder().build())
                        .build())
                .addCharacteristic(InventoryItem.Characteristic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .characteristicType(CodeableConcept.builder().build())
                        .value(FhirString.of("text"))
                        .build())
                .instance(InventoryItem.Instance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .lotNumber(FhirString.of("text"))
                        .expiry(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .subject(Reference.builder().build())
                        .location(Reference.builder().build())
                        .build())
                .productReference(Reference.builder().build())
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
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.responsibleOrganization().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.inventoryStatus().isEmpty());
        assertNotNull(resource.baseUnit());
        assertNotNull(resource.netContent());
        assertFalse(resource.association().isEmpty());
        assertFalse(resource.characteristic().isEmpty());
        assertNotNull(resource.instance());
        assertNotNull(resource.productReference());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("InventoryItem.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<InventoryItemStatusCodes>) null).build()).getMessage());
    }

    @Test
    void inventoryReport() {
        InventoryReport resource = InventoryReport.builder()
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
                .status(FhirEnum.of(InventoryReportStatus.values()[0]))
                .countType(FhirEnum.of(InventoryCountType.values()[0]))
                .operationType(CodeableConcept.builder().build())
                .operationTypeReason(CodeableConcept.builder().build())
                .reportedDateTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .reporter(Reference.builder().build())
                .reportingPeriod(Period.builder().build())
                .addInventoryListing(InventoryReport.InventoryListing.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .location(Reference.builder().build())
                        .itemStatus(CodeableConcept.builder().build())
                        .countingDateTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addItem(InventoryReport.InventoryListing.Item.builder()
                                .quantity(Quantity.builder().build())
                                .item(CodeableReference.builder().build())
                                .build())
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
        assertNotNull(resource.countType());
        assertNotNull(resource.operationType());
        assertNotNull(resource.operationTypeReason());
        assertNotNull(resource.reportedDateTime());
        assertNotNull(resource.reporter());
        assertNotNull(resource.reportingPeriod());
        assertFalse(resource.inventoryListing().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("InventoryReport.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<InventoryReportStatus>) null).build()).getMessage());
    }
}
