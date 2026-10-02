package se.poroli.fhirplace.r5.appointmentresponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a AppointmentResponse with all elements and checks the builder and validation. */
class AppointmentResponseTest {

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
}
