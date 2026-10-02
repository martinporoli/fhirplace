package se.poroli.fhirplace.r5.encounterhistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.EncounterStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a EncounterHistory with all elements and checks the builder and validation. */
class EncounterHistoryTest {

    @Test
    void encounterHistory() {
        EncounterHistory resource = EncounterHistory.builder()
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
                .encounter(Reference.builder().build())
                .addIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(EncounterStatus.values()[0]))
                .classValue(CodeableConcept.builder().build())
                .addType(CodeableConcept.builder().build())
                .addServiceType(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .subjectStatus(CodeableConcept.builder().build())
                .actualPeriod(Period.builder().build())
                .plannedStartDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .plannedEndDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .length(Duration.builder().build())
                .addLocation(EncounterHistory.Location.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .location(Reference.builder().build())
                        .form(CodeableConcept.builder().build())
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
        assertNotNull(resource.encounter());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.classValue());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.serviceType().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.subjectStatus());
        assertNotNull(resource.actualPeriod());
        assertNotNull(resource.plannedStartDate());
        assertNotNull(resource.plannedEndDate());
        assertNotNull(resource.length());
        assertFalse(resource.location().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("EncounterHistory.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EncounterStatus>) null).build()).getMessage());
    }
}
