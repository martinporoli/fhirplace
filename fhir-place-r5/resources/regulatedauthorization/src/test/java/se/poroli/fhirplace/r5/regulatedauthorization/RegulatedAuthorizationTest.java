package se.poroli.fhirplace.r5.regulatedauthorization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a RegulatedAuthorization with all elements and checks the builder and validation. */
class RegulatedAuthorizationTest {

    @Test
    void regulatedAuthorization() {
        RegulatedAuthorization resource = RegulatedAuthorization.builder()
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
                .addSubject(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .description(FhirMarkdown.of("text"))
                .addRegion(CodeableConcept.builder().build())
                .status(CodeableConcept.builder().build())
                .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .validityPeriod(Period.builder().build())
                .addIndication(CodeableReference.builder().build())
                .intendedUse(CodeableConcept.builder().build())
                .addBasis(CodeableConcept.builder().build())
                .holder(Reference.builder().build())
                .regulator(Reference.builder().build())
                .addAttachedDocument(Reference.builder().build())
                .caseValue(RegulatedAuthorization.CaseValue.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identifier(Identifier.builder().build())
                        .type(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .date(Period.builder().build())
                        .addApplication(RegulatedAuthorization.CaseValue.builder().build())
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
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.description());
        assertFalse(resource.region().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusDate());
        assertNotNull(resource.validityPeriod());
        assertFalse(resource.indication().isEmpty());
        assertNotNull(resource.intendedUse());
        assertFalse(resource.basis().isEmpty());
        assertNotNull(resource.holder());
        assertNotNull(resource.regulator());
        assertFalse(resource.attachedDocument().isEmpty());
        assertNotNull(resource.caseValue());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
