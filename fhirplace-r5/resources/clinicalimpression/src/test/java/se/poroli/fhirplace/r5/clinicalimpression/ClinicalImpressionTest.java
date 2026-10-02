package se.poroli.fhirplace.r5.clinicalimpression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
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
import se.poroli.fhirplace.r5.valuesets.EventStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a ClinicalImpression with all elements and checks the builder and validation. */
class ClinicalImpressionTest {

    @Test
    void clinicalImpression() {
        ClinicalImpression resource = ClinicalImpression.builder()
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
                .status(FhirEnum.of(EventStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .description(FhirString.of("text"))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .effective(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .performer(Reference.builder().build())
                .previous(Reference.builder().build())
                .addProblem(Reference.builder().build())
                .changePattern(CodeableConcept.builder().build())
                .addProtocol(FhirUri.of("http://example.org/uri"))
                .summary(FhirString.of("text"))
                .addFinding(ClinicalImpression.Finding.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(CodeableReference.builder().build())
                        .basis(FhirString.of("text"))
                        .build())
                .addPrognosisCodeableConcept(CodeableConcept.builder().build())
                .addPrognosisReference(Reference.builder().build())
                .addSupportingInfo(Reference.builder().build())
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
        assertNotNull(resource.statusReason());
        assertNotNull(resource.description());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.effective());
        assertNotNull(resource.date());
        assertNotNull(resource.performer());
        assertNotNull(resource.previous());
        assertFalse(resource.problem().isEmpty());
        assertNotNull(resource.changePattern());
        assertFalse(resource.protocol().isEmpty());
        assertNotNull(resource.summary());
        assertFalse(resource.finding().isEmpty());
        assertFalse(resource.prognosisCodeableConcept().isEmpty());
        assertFalse(resource.prognosisReference().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ClinicalImpression.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EventStatus>) null).build()).getMessage());
    }
}
