package se.poroli.fhirplace.r5.healthcareservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
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

/** Builds a HealthcareService with all elements and checks the builder and validation. */
class HealthcareServiceTest {

    @Test
    void healthcareService() {
        HealthcareService resource = HealthcareService.builder()
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
                .providedBy(Reference.builder().build())
                .addOfferedIn(Reference.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .addType(CodeableConcept.builder().build())
                .addSpecialty(CodeableConcept.builder().build())
                .addLocation(Reference.builder().build())
                .name(FhirString.of("text"))
                .comment(FhirMarkdown.of("text"))
                .extraDetails(FhirMarkdown.of("text"))
                .photo(Attachment.builder().build())
                .addContact(ExtendedContactDetail.builder().build())
                .addCoverageArea(Reference.builder().build())
                .addServiceProvisionCode(CodeableConcept.builder().build())
                .addEligibility(HealthcareService.Eligibility.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .comment(FhirMarkdown.of("text"))
                        .build())
                .addProgram(CodeableConcept.builder().build())
                .addCharacteristic(CodeableConcept.builder().build())
                .addCommunication(CodeableConcept.builder().build())
                .addReferralMethod(CodeableConcept.builder().build())
                .appointmentRequired(FhirBoolean.of(true))
                .addAvailability(Availability.builder().build())
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
        assertNotNull(resource.providedBy());
        assertFalse(resource.offeredIn().isEmpty());
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.specialty().isEmpty());
        assertFalse(resource.location().isEmpty());
        assertNotNull(resource.name());
        assertNotNull(resource.comment());
        assertNotNull(resource.extraDetails());
        assertNotNull(resource.photo());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.coverageArea().isEmpty());
        assertFalse(resource.serviceProvisionCode().isEmpty());
        assertFalse(resource.eligibility().isEmpty());
        assertFalse(resource.program().isEmpty());
        assertFalse(resource.characteristic().isEmpty());
        assertFalse(resource.communication().isEmpty());
        assertFalse(resource.referralMethod().isEmpty());
        assertNotNull(resource.appointmentRequired());
        assertFalse(resource.availability().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
