package se.poroli.fhirplace.r5.insuranceplan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/** Builds a InsurancePlan with all elements and checks the builder and validation. */
class InsurancePlanTest {

    @Test
    void insurancePlan() {
        InsurancePlan resource = InsurancePlan.builder()
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
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .addType(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .addAlias(FhirString.of("text"))
                .period(Period.builder().build())
                .ownedBy(Reference.builder().build())
                .administeredBy(Reference.builder().build())
                .addCoverageArea(Reference.builder().build())
                .addContact(ExtendedContactDetail.builder().build())
                .addEndpoint(Reference.builder().build())
                .addNetwork(Reference.builder().build())
                .addCoverage(InsurancePlan.Coverage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addNetwork(Reference.builder().build())
                        .addBenefit(InsurancePlan.Coverage.CoverageBenefit.builder()
                                .type(CodeableConcept.builder().build())
                                .build())
                        .build())
                .addPlan(InsurancePlan.Plan.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .type(CodeableConcept.builder().build())
                        .addCoverageArea(Reference.builder().build())
                        .addNetwork(Reference.builder().build())
                        .addGeneralCost(InsurancePlan.Plan.GeneralCost.builder().build())
                        .addSpecificCost(InsurancePlan.Plan.SpecificCost.builder()
                                .category(CodeableConcept.builder().build())
                                .build())
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
        assertFalse(resource.type().isEmpty());
        assertNotNull(resource.name());
        assertFalse(resource.alias().isEmpty());
        assertNotNull(resource.period());
        assertNotNull(resource.ownedBy());
        assertNotNull(resource.administeredBy());
        assertFalse(resource.coverageArea().isEmpty());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertFalse(resource.network().isEmpty());
        assertFalse(resource.coverage().isEmpty());
        assertFalse(resource.plan().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
