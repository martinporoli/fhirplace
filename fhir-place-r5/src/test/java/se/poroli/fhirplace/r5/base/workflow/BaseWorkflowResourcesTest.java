package se.poroli.fhirplace.r5.base.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.AppointmentStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.ParticipationStatus;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.SlotStatus;
import se.poroli.fhirplace.r5.valuesets.TaskStatus;
import se.poroli.fhirplace.r5.valuesets.TransportStatus;
import se.poroli.fhirplace.r5.valuesets.VerificationResultStatus;

/** Builds every base.workflow resource with all elements and checks the builders and validation. */
class BaseWorkflowResourcesTest {

    @Test
    void task() {
        Task resource = Task.builder()
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
                .instantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .instantiatesUri(FhirUri.of("http://example.org/uri"))
                .addBasedOn(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(TaskStatus.values()[0]))
                .statusReason(CodeableReference.builder().build())
                .businessStatus(CodeableConcept.builder().build())
                .intent(FhirCode.of("code"))
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .doNotPerform(FhirBoolean.of(true))
                .code(CodeableConcept.builder().build())
                .description(FhirString.of("text"))
                .focus(Reference.builder().build())
                .forValue(Reference.builder().build())
                .encounter(Reference.builder().build())
                .requestedPeriod(Period.builder().build())
                .executionPeriod(Period.builder().build())
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .lastModified(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .addRequestedPerformer(CodeableReference.builder().build())
                .owner(Reference.builder().build())
                .addPerformer(Task.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .location(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addInsurance(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addRelevantHistory(Reference.builder().build())
                .restriction(Task.Restriction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .repetitions(FhirPositiveInt.of(1))
                        .period(Period.builder().build())
                        .addRecipient(Reference.builder().build())
                        .build())
                .addInput(Task.Input.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBase64Binary.of("aGk="))
                        .build())
                .addOutput(Task.Output.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBase64Binary.of("aGk="))
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
        assertNotNull(resource.instantiatesCanonical());
        assertNotNull(resource.instantiatesUri());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.groupIdentifier());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.businessStatus());
        assertNotNull(resource.intent());
        assertNotNull(resource.priority());
        assertNotNull(resource.doNotPerform());
        assertNotNull(resource.code());
        assertNotNull(resource.description());
        assertNotNull(resource.focus());
        assertNotNull(resource.forValue());
        assertNotNull(resource.encounter());
        assertNotNull(resource.requestedPeriod());
        assertNotNull(resource.executionPeriod());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.lastModified());
        assertNotNull(resource.requester());
        assertFalse(resource.requestedPerformer().isEmpty());
        assertNotNull(resource.owner());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.relevantHistory().isEmpty());
        assertNotNull(resource.restriction());
        assertFalse(resource.input().isEmpty());
        assertFalse(resource.output().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Task.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<TaskStatus>) null).build()).getMessage());
    }

    @Test
    void transport() {
        Transport resource = Transport.builder()
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
                .instantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .instantiatesUri(FhirUri.of("http://example.org/uri"))
                .addBasedOn(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(TransportStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .intent(FhirCode.of("code"))
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .code(CodeableConcept.builder().build())
                .description(FhirString.of("text"))
                .focus(Reference.builder().build())
                .forValue(Reference.builder().build())
                .encounter(Reference.builder().build())
                .completionTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .lastModified(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .addPerformerType(CodeableConcept.builder().build())
                .owner(Reference.builder().build())
                .location(Reference.builder().build())
                .addInsurance(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addRelevantHistory(Reference.builder().build())
                .restriction(Transport.Restriction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .repetitions(FhirPositiveInt.of(1))
                        .period(Period.builder().build())
                        .addRecipient(Reference.builder().build())
                        .build())
                .addInput(Transport.Parameter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBase64Binary.of("aGk="))
                        .build())
                .addOutput(Transport.Output.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBase64Binary.of("aGk="))
                        .build())
                .requestedLocation(Reference.builder().build())
                .currentLocation(Reference.builder().build())
                .reason(CodeableReference.builder().build())
                .history(Reference.builder().build())
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
        assertNotNull(resource.instantiatesCanonical());
        assertNotNull(resource.instantiatesUri());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.groupIdentifier());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.intent());
        assertNotNull(resource.priority());
        assertNotNull(resource.code());
        assertNotNull(resource.description());
        assertNotNull(resource.focus());
        assertNotNull(resource.forValue());
        assertNotNull(resource.encounter());
        assertNotNull(resource.completionTime());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.lastModified());
        assertNotNull(resource.requester());
        assertFalse(resource.performerType().isEmpty());
        assertNotNull(resource.owner());
        assertNotNull(resource.location());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.relevantHistory().isEmpty());
        assertNotNull(resource.restriction());
        assertFalse(resource.input().isEmpty());
        assertFalse(resource.output().isEmpty());
        assertNotNull(resource.requestedLocation());
        assertNotNull(resource.currentLocation());
        assertNotNull(resource.reason());
        assertNotNull(resource.history());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Transport.intent is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().intent((FhirCode) null).build()).getMessage());
    }

    @Test
    void appointment() {
        Appointment resource = Appointment.builder()
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
                .status(FhirEnum.of(AppointmentStatus.values()[0]))
                .cancellationReason(CodeableConcept.builder().build())
                .addClassValue(CodeableConcept.builder().build())
                .addServiceCategory(CodeableConcept.builder().build())
                .addServiceType(CodeableReference.builder().build())
                .addSpecialty(CodeableConcept.builder().build())
                .appointmentType(CodeableConcept.builder().build())
                .addReason(CodeableReference.builder().build())
                .priority(CodeableConcept.builder().build())
                .description(FhirString.of("text"))
                .addReplaces(Reference.builder().build())
                .addVirtualService(VirtualServiceDetail.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .previousAppointment(Reference.builder().build())
                .originatingAppointment(Reference.builder().build())
                .start(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .end(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .minutesDuration(FhirPositiveInt.of(1))
                .addRequestedPeriod(Period.builder().build())
                .addSlot(Reference.builder().build())
                .addAccount(Reference.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .cancellationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addPatientInstruction(CodeableReference.builder().build())
                .addBasedOn(Reference.builder().build())
                .subject(Reference.builder().build())
                .addParticipant(Appointment.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addType(CodeableConcept.builder().build())
                        .period(Period.builder().build())
                        .actor(Reference.builder().build())
                        .required(FhirBoolean.of(true))
                        .status(FhirEnum.of(ParticipationStatus.values()[0]))
                        .build())
                .recurrenceId(FhirPositiveInt.of(1))
                .occurrenceChanged(FhirBoolean.of(true))
                .addRecurrenceTemplate(Appointment.RecurrenceTemplate.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .timezone(CodeableConcept.builder().build())
                        .recurrenceType(CodeableConcept.builder().build())
                        .lastOccurrenceDate(FhirDate.parse("2024-01-01"))
                        .occurrenceCount(FhirPositiveInt.of(1))
                        .addOccurrenceDate(FhirDate.parse("2024-01-01"))
                        .weeklyTemplate(Appointment.RecurrenceTemplate.WeeklyTemplate.builder().build())
                        .monthlyTemplate(Appointment.RecurrenceTemplate.MonthlyTemplate.builder()
                                .monthInterval(FhirPositiveInt.of(1))
                                .build())
                        .yearlyTemplate(Appointment.RecurrenceTemplate.YearlyTemplate.builder()
                                .yearInterval(FhirPositiveInt.of(1))
                                .build())
                        .addExcludingDate(FhirDate.parse("2024-01-01"))
                        .addExcludingRecurrenceId(FhirPositiveInt.of(1))
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
        assertNotNull(resource.cancellationReason());
        assertFalse(resource.classValue().isEmpty());
        assertFalse(resource.serviceCategory().isEmpty());
        assertFalse(resource.serviceType().isEmpty());
        assertFalse(resource.specialty().isEmpty());
        assertNotNull(resource.appointmentType());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.priority());
        assertNotNull(resource.description());
        assertFalse(resource.replaces().isEmpty());
        assertFalse(resource.virtualService().isEmpty());
        assertFalse(resource.supportingInformation().isEmpty());
        assertNotNull(resource.previousAppointment());
        assertNotNull(resource.originatingAppointment());
        assertNotNull(resource.start());
        assertNotNull(resource.end());
        assertNotNull(resource.minutesDuration());
        assertFalse(resource.requestedPeriod().isEmpty());
        assertFalse(resource.slot().isEmpty());
        assertFalse(resource.account().isEmpty());
        assertNotNull(resource.created());
        assertNotNull(resource.cancellationDate());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.patientInstruction().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.subject());
        assertFalse(resource.participant().isEmpty());
        assertNotNull(resource.recurrenceId());
        assertNotNull(resource.occurrenceChanged());
        assertFalse(resource.recurrenceTemplate().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Appointment.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<AppointmentStatus>) null).build()).getMessage());
    }

    @Test
    void appointmentResponse() {
        AppointmentResponse resource = AppointmentResponse.builder()
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
                .appointment(Reference.builder().build())
                .proposedNewTime(FhirBoolean.of(true))
                .start(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .end(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addParticipantType(CodeableConcept.builder().build())
                .actor(Reference.builder().build())
                .participantStatus(FhirCode.of("code"))
                .comment(FhirMarkdown.of("text"))
                .recurring(FhirBoolean.of(true))
                .occurrenceDate(FhirDate.parse("2024-01-01"))
                .recurrenceId(FhirPositiveInt.of(1))
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
        assertNotNull(resource.appointment());
        assertNotNull(resource.proposedNewTime());
        assertNotNull(resource.start());
        assertNotNull(resource.end());
        assertFalse(resource.participantType().isEmpty());
        assertNotNull(resource.actor());
        assertNotNull(resource.participantStatus());
        assertNotNull(resource.comment());
        assertNotNull(resource.recurring());
        assertNotNull(resource.occurrenceDate());
        assertNotNull(resource.recurrenceId());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("AppointmentResponse.appointment is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().appointment((Reference) null).build()).getMessage());
    }

    @Test
    void schedule() {
        Schedule resource = Schedule.builder()
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
                .active(FhirBoolean.of(true))
                .addServiceCategory(CodeableConcept.builder().build())
                .addServiceType(CodeableReference.builder().build())
                .addSpecialty(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .addActor(Reference.builder().build())
                .planningHorizon(Period.builder().build())
                .comment(FhirMarkdown.of("text"))
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
        assertNotNull(resource.active());
        assertFalse(resource.serviceCategory().isEmpty());
        assertFalse(resource.serviceType().isEmpty());
        assertFalse(resource.specialty().isEmpty());
        assertNotNull(resource.name());
        assertFalse(resource.actor().isEmpty());
        assertNotNull(resource.planningHorizon());
        assertNotNull(resource.comment());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Schedule.actor requires at least one value", assertThrows(
                IllegalArgumentException.class,
                () -> resource.toBuilder().actor((java.util.List<Reference>) null).build()).getMessage());
    }

    @Test
    void slot() {
        Slot resource = Slot.builder()
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
                .addServiceCategory(CodeableConcept.builder().build())
                .addServiceType(CodeableReference.builder().build())
                .addSpecialty(CodeableConcept.builder().build())
                .addAppointmentType(CodeableConcept.builder().build())
                .schedule(Reference.builder().build())
                .status(FhirEnum.of(SlotStatus.values()[0]))
                .start(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .end(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .overbooked(FhirBoolean.of(true))
                .comment(FhirString.of("text"))
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
        assertFalse(resource.serviceCategory().isEmpty());
        assertFalse(resource.serviceType().isEmpty());
        assertFalse(resource.specialty().isEmpty());
        assertFalse(resource.appointmentType().isEmpty());
        assertNotNull(resource.schedule());
        assertNotNull(resource.status());
        assertNotNull(resource.start());
        assertNotNull(resource.end());
        assertNotNull(resource.overbooked());
        assertNotNull(resource.comment());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Slot.schedule is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().schedule((Reference) null).build()).getMessage());
    }

    @Test
    void verificationResult() {
        VerificationResult resource = VerificationResult.builder()
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
                .addTarget(Reference.builder().build())
                .addTargetLocation(FhirString.of("text"))
                .need(CodeableConcept.builder().build())
                .status(FhirEnum.of(VerificationResultStatus.values()[0]))
                .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .validationType(CodeableConcept.builder().build())
                .addValidationProcess(CodeableConcept.builder().build())
                .frequency(Timing.builder().build())
                .lastPerformed(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .nextScheduled(FhirDate.parse("2024-01-01"))
                .failureAction(CodeableConcept.builder().build())
                .addPrimarySource(VerificationResult.PrimarySource.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .who(Reference.builder().build())
                        .addType(CodeableConcept.builder().build())
                        .addCommunicationMethod(CodeableConcept.builder().build())
                        .validationStatus(CodeableConcept.builder().build())
                        .validationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .canPushUpdates(CodeableConcept.builder().build())
                        .addPushTypeAvailable(CodeableConcept.builder().build())
                        .build())
                .attestation(VerificationResult.Attestation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .who(Reference.builder().build())
                        .onBehalfOf(Reference.builder().build())
                        .communicationMethod(CodeableConcept.builder().build())
                        .date(FhirDate.parse("2024-01-01"))
                        .sourceIdentityCertificate(FhirString.of("text"))
                        .proxyIdentityCertificate(FhirString.of("text"))
                        .proxySignature(Signature.builder().build())
                        .sourceSignature(Signature.builder().build())
                        .build())
                .addValidator(VerificationResult.Validator.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .organization(Reference.builder().build())
                        .identityCertificate(FhirString.of("text"))
                        .attestationSignature(Signature.builder().build())
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
        assertFalse(resource.target().isEmpty());
        assertFalse(resource.targetLocation().isEmpty());
        assertNotNull(resource.need());
        assertNotNull(resource.status());
        assertNotNull(resource.statusDate());
        assertNotNull(resource.validationType());
        assertFalse(resource.validationProcess().isEmpty());
        assertNotNull(resource.frequency());
        assertNotNull(resource.lastPerformed());
        assertNotNull(resource.nextScheduled());
        assertNotNull(resource.failureAction());
        assertFalse(resource.primarySource().isEmpty());
        assertNotNull(resource.attestation());
        assertFalse(resource.validator().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("VerificationResult.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<VerificationResultStatus>) null).build()).getMessage());
    }
}
