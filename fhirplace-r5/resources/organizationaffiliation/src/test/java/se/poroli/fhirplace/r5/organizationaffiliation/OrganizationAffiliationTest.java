package se.poroli.fhirplace.r5.organizationaffiliation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a OrganizationAffiliation with all elements and checks the builder and validation. */
class OrganizationAffiliationTest {

    @Test
    void organizationAffiliation() {
        OrganizationAffiliation resource = OrganizationAffiliation.builder()
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
                .period(Period.builder().build())
                .organization(Reference.builder().build())
                .participatingOrganization(Reference.builder().build())
                .addNetwork(Reference.builder().build())
                .addCode(CodeableConcept.builder().build())
                .addSpecialty(CodeableConcept.builder().build())
                .addLocation(Reference.builder().build())
                .addHealthcareService(Reference.builder().build())
                .addContact(ExtendedContactDetail.builder().build())
                .addEndpoint(Reference.builder().build())
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
        assertNotNull(resource.period());
        assertNotNull(resource.organization());
        assertNotNull(resource.participatingOrganization());
        assertFalse(resource.network().isEmpty());
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.specialty().isEmpty());
        assertFalse(resource.location().isEmpty());
        assertFalse(resource.healthcareService().isEmpty());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
