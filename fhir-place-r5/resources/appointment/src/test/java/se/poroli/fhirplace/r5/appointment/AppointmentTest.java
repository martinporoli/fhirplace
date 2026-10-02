package se.poroli.fhirplace.r5.appointment;

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
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
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
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Appointment with all elements and checks the builder and validation. */
class AppointmentTest {

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
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(AppointmentStatus.values(), AppointmentStatus::fromCode);
        assertCodes(ParticipationStatus.values(), ParticipationStatus::fromCode);
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
