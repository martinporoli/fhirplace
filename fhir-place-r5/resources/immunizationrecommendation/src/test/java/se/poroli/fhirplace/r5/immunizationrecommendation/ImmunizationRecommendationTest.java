package se.poroli.fhirplace.r5.immunizationrecommendation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
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
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a ImmunizationRecommendation with all elements and checks the builder and validation. */
class ImmunizationRecommendationTest {

    @Test
    void immunizationRecommendation() {
        ImmunizationRecommendation resource = ImmunizationRecommendation.builder()
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
                .patient(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authority(Reference.builder().build())
                .addRecommendation(ImmunizationRecommendation.Recommendation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addVaccineCode(CodeableConcept.builder().build())
                        .addTargetDisease(CodeableConcept.builder().build())
                        .addContraindicatedVaccineCode(CodeableConcept.builder().build())
                        .forecastStatus(CodeableConcept.builder().build())
                        .addForecastReason(CodeableConcept.builder().build())
                        .addDateCriterion(ImmunizationRecommendation.Recommendation.DateCriterion.builder()
                                .code(CodeableConcept.builder().build())
                                .value(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                                .build())
                        .description(FhirMarkdown.of("text"))
                        .series(FhirString.of("text"))
                        .doseNumber(FhirString.of("text"))
                        .seriesDoses(FhirString.of("text"))
                        .addSupportingImmunization(Reference.builder().build())
                        .addSupportingPatientInformation(Reference.builder().build())
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
        assertNotNull(resource.patient());
        assertNotNull(resource.date());
        assertNotNull(resource.authority());
        assertFalse(resource.recommendation().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImmunizationRecommendation.patient is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().patient((Reference) null).build()).getMessage());
    }
}
