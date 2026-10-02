package se.poroli.fhirplace.r5.encounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
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
import se.poroli.fhirplace.r5.valuesets.EncounterStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Encounter with all elements and checks the builder and validation. */
class EncounterTest {

    @Test
    void encounter() {
        Encounter resource = Encounter.builder()
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
                .status(FhirEnum.of(EncounterStatus.values()[0]))
                .addClassValue(CodeableConcept.builder().build())
                .priority(CodeableConcept.builder().build())
                .addType(CodeableConcept.builder().build())
                .addServiceType(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .subjectStatus(CodeableConcept.builder().build())
                .addEpisodeOfCare(Reference.builder().build())
                .addBasedOn(Reference.builder().build())
                .addCareTeam(Reference.builder().build())
                .partOf(Reference.builder().build())
                .serviceProvider(Reference.builder().build())
                .addParticipant(Encounter.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addType(CodeableConcept.builder().build())
                        .period(Period.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addAppointment(Reference.builder().build())
                .addVirtualService(VirtualServiceDetail.builder().build())
                .actualPeriod(Period.builder().build())
                .plannedStartDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .plannedEndDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .length(Duration.builder().build())
                .addReason(Encounter.Reason.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addUse(CodeableConcept.builder().build())
                        .addValue(CodeableReference.builder().build())
                        .build())
                .addDiagnosis(Encounter.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addCondition(CodeableReference.builder().build())
                        .addUse(CodeableConcept.builder().build())
                        .build())
                .addAccount(Reference.builder().build())
                .addDietPreference(CodeableConcept.builder().build())
                .addSpecialArrangement(CodeableConcept.builder().build())
                .addSpecialCourtesy(CodeableConcept.builder().build())
                .admission(Encounter.Admission.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .preAdmissionIdentifier(Identifier.builder().build())
                        .origin(Reference.builder().build())
                        .admitSource(CodeableConcept.builder().build())
                        .reAdmission(CodeableConcept.builder().build())
                        .destination(Reference.builder().build())
                        .dischargeDisposition(CodeableConcept.builder().build())
                        .build())
                .addLocation(Encounter.Location.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .location(Reference.builder().build())
                        .status(FhirEnum.of(EncounterLocationStatus.values()[0]))
                        .form(CodeableConcept.builder().build())
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
        assertNotNull(resource.status());
        assertFalse(resource.classValue().isEmpty());
        assertNotNull(resource.priority());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.serviceType().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.subjectStatus());
        assertFalse(resource.episodeOfCare().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.careTeam().isEmpty());
        assertNotNull(resource.partOf());
        assertNotNull(resource.serviceProvider());
        assertFalse(resource.participant().isEmpty());
        assertFalse(resource.appointment().isEmpty());
        assertFalse(resource.virtualService().isEmpty());
        assertNotNull(resource.actualPeriod());
        assertNotNull(resource.plannedStartDate());
        assertNotNull(resource.plannedEndDate());
        assertNotNull(resource.length());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertFalse(resource.account().isEmpty());
        assertFalse(resource.dietPreference().isEmpty());
        assertFalse(resource.specialArrangement().isEmpty());
        assertFalse(resource.specialCourtesy().isEmpty());
        assertNotNull(resource.admission());
        assertFalse(resource.location().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Encounter.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EncounterStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(EncounterLocationStatus.values(), EncounterLocationStatus::fromCode);
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
