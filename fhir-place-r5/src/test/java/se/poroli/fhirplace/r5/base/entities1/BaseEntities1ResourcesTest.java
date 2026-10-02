package se.poroli.fhirplace.r5.base.entities1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.EndpointStatus;
import se.poroli.fhirplace.r5.valuesets.LocationMode;
import se.poroli.fhirplace.r5.valuesets.LocationStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds every base.entities1 resource with all elements and checks the builders and validation. */
class BaseEntities1ResourcesTest {

    @Test
    void organization() {
        Organization resource = Organization.builder()
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
                .addType(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .addAlias(FhirString.of("text"))
                .description(FhirMarkdown.of("text"))
                .addContact(ExtendedContactDetail.builder().build())
                .partOf(Reference.builder().build())
                .addEndpoint(Reference.builder().build())
                .addQualification(Organization.Qualification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .code(CodeableConcept.builder().build())
                        .period(Period.builder().build())
                        .issuer(Reference.builder().build())
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
        assertNotNull(resource.active());
        assertFalse(resource.type().isEmpty());
        assertNotNull(resource.name());
        assertFalse(resource.alias().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.partOf());
        assertFalse(resource.endpoint().isEmpty());
        assertFalse(resource.qualification().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

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

    @Test
    void endpoint() {
        Endpoint resource = Endpoint.builder()
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
                .status(FhirEnum.of(EndpointStatus.values()[0]))
                .addConnectionType(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .description(FhirString.of("text"))
                .addEnvironmentType(CodeableConcept.builder().build())
                .managingOrganization(Reference.builder().build())
                .addContact(ContactPoint.builder().build())
                .period(Period.builder().build())
                .addPayload(Endpoint.Payload.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addType(CodeableConcept.builder().build())
                        .addMimeType(FhirCode.of("code"))
                        .build())
                .address(FhirUrl.of("http://example.org/url"))
                .addHeader(FhirString.of("text"))
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
        assertFalse(resource.connectionType().isEmpty());
        assertNotNull(resource.name());
        assertNotNull(resource.description());
        assertFalse(resource.environmentType().isEmpty());
        assertNotNull(resource.managingOrganization());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.period());
        assertFalse(resource.payload().isEmpty());
        assertNotNull(resource.address());
        assertFalse(resource.header().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Endpoint.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EndpointStatus>) null).build()).getMessage());
    }

    @Test
    void location() {
        Location resource = Location.builder()
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
                .status(FhirEnum.of(LocationStatus.values()[0]))
                .operationalStatus(Coding.builder().build())
                .name(FhirString.of("text"))
                .addAlias(FhirString.of("text"))
                .description(FhirMarkdown.of("text"))
                .mode(FhirEnum.of(LocationMode.values()[0]))
                .addType(CodeableConcept.builder().build())
                .addContact(ExtendedContactDetail.builder().build())
                .address(Address.builder().build())
                .form(CodeableConcept.builder().build())
                .position(Location.Position.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .longitude(FhirDecimal.parse("1.0"))
                        .latitude(FhirDecimal.parse("1.0"))
                        .altitude(FhirDecimal.parse("1.0"))
                        .build())
                .managingOrganization(Reference.builder().build())
                .partOf(Reference.builder().build())
                .addCharacteristic(CodeableConcept.builder().build())
                .addHoursOfOperation(Availability.builder().build())
                .addVirtualService(VirtualServiceDetail.builder().build())
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
        assertNotNull(resource.status());
        assertNotNull(resource.operationalStatus());
        assertNotNull(resource.name());
        assertFalse(resource.alias().isEmpty());
        assertNotNull(resource.description());
        assertNotNull(resource.mode());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.address());
        assertNotNull(resource.form());
        assertNotNull(resource.position());
        assertNotNull(resource.managingOrganization());
        assertNotNull(resource.partOf());
        assertFalse(resource.characteristic().isEmpty());
        assertFalse(resource.hoursOfOperation().isEmpty());
        assertFalse(resource.virtualService().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
