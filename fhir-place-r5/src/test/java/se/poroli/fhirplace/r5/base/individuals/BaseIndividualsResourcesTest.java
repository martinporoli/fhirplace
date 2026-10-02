package se.poroli.fhirplace.r5.base.individuals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;
import se.poroli.fhirplace.r5.valuesets.GroupMembershipBasis;
import se.poroli.fhirplace.r5.valuesets.GroupType;
import se.poroli.fhirplace.r5.valuesets.IdentityAssuranceLevel;
import se.poroli.fhirplace.r5.valuesets.LinkType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds every base.individuals resource with all elements and checks the builders and validation. */
class BaseIndividualsResourcesTest {

    @Test
    void patient() {
        Patient resource = Patient.builder()
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
                .addName(HumanName.builder().build())
                .addTelecom(ContactPoint.builder().build())
                .gender(FhirEnum.of(AdministrativeGender.values()[0]))
                .birthDate(FhirDate.parse("2024-01-01"))
                .deceased(FhirBoolean.of(true))
                .addAddress(Address.builder().build())
                .maritalStatus(CodeableConcept.builder().build())
                .multipleBirth(FhirBoolean.of(true))
                .addPhoto(Attachment.builder().build())
                .addContact(Patient.Contact.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addRelationship(CodeableConcept.builder().build())
                        .name(HumanName.builder().build())
                        .addTelecom(ContactPoint.builder().build())
                        .address(Address.builder().build())
                        .gender(FhirEnum.of(AdministrativeGender.values()[0]))
                        .organization(Reference.builder().build())
                        .period(Period.builder().build())
                        .build())
                .addCommunication(Patient.Communication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .language(CodeableConcept.builder().build())
                        .preferred(FhirBoolean.of(true))
                        .build())
                .addGeneralPractitioner(Reference.builder().build())
                .managingOrganization(Reference.builder().build())
                .addLink(Patient.Link.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .other(Reference.builder().build())
                        .type(FhirEnum.of(LinkType.values()[0]))
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
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.telecom().isEmpty());
        assertNotNull(resource.gender());
        assertNotNull(resource.birthDate());
        assertNotNull(resource.deceased());
        assertFalse(resource.address().isEmpty());
        assertNotNull(resource.maritalStatus());
        assertNotNull(resource.multipleBirth());
        assertFalse(resource.photo().isEmpty());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.communication().isEmpty());
        assertFalse(resource.generalPractitioner().isEmpty());
        assertNotNull(resource.managingOrganization());
        assertFalse(resource.link().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void practitioner() {
        Practitioner resource = Practitioner.builder()
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
                .addName(HumanName.builder().build())
                .addTelecom(ContactPoint.builder().build())
                .gender(FhirEnum.of(AdministrativeGender.values()[0]))
                .birthDate(FhirDate.parse("2024-01-01"))
                .deceased(FhirBoolean.of(true))
                .addAddress(Address.builder().build())
                .addPhoto(Attachment.builder().build())
                .addQualification(Practitioner.Qualification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .code(CodeableConcept.builder().build())
                        .period(Period.builder().build())
                        .issuer(Reference.builder().build())
                        .build())
                .addCommunication(Practitioner.Communication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .language(CodeableConcept.builder().build())
                        .preferred(FhirBoolean.of(true))
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
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.telecom().isEmpty());
        assertNotNull(resource.gender());
        assertNotNull(resource.birthDate());
        assertNotNull(resource.deceased());
        assertFalse(resource.address().isEmpty());
        assertFalse(resource.photo().isEmpty());
        assertFalse(resource.qualification().isEmpty());
        assertFalse(resource.communication().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void practitionerRole() {
        PractitionerRole resource = PractitionerRole.builder()
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
                .practitioner(Reference.builder().build())
                .organization(Reference.builder().build())
                .addCode(CodeableConcept.builder().build())
                .addSpecialty(CodeableConcept.builder().build())
                .addLocation(Reference.builder().build())
                .addHealthcareService(Reference.builder().build())
                .addContact(ExtendedContactDetail.builder().build())
                .addCharacteristic(CodeableConcept.builder().build())
                .addCommunication(CodeableConcept.builder().build())
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
        assertNotNull(resource.period());
        assertNotNull(resource.practitioner());
        assertNotNull(resource.organization());
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.specialty().isEmpty());
        assertFalse(resource.location().isEmpty());
        assertFalse(resource.healthcareService().isEmpty());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.characteristic().isEmpty());
        assertFalse(resource.communication().isEmpty());
        assertFalse(resource.availability().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void relatedPerson() {
        RelatedPerson resource = RelatedPerson.builder()
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
                .patient(Reference.builder().build())
                .addRelationship(CodeableConcept.builder().build())
                .addName(HumanName.builder().build())
                .addTelecom(ContactPoint.builder().build())
                .gender(FhirEnum.of(AdministrativeGender.values()[0]))
                .birthDate(FhirDate.parse("2024-01-01"))
                .addAddress(Address.builder().build())
                .addPhoto(Attachment.builder().build())
                .period(Period.builder().build())
                .addCommunication(RelatedPerson.Communication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .language(CodeableConcept.builder().build())
                        .preferred(FhirBoolean.of(true))
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
        assertNotNull(resource.patient());
        assertFalse(resource.relationship().isEmpty());
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.telecom().isEmpty());
        assertNotNull(resource.gender());
        assertNotNull(resource.birthDate());
        assertFalse(resource.address().isEmpty());
        assertFalse(resource.photo().isEmpty());
        assertNotNull(resource.period());
        assertFalse(resource.communication().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("RelatedPerson.patient is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().patient((Reference) null).build()).getMessage());
    }

    @Test
    void person() {
        Person resource = Person.builder()
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
                .addName(HumanName.builder().build())
                .addTelecom(ContactPoint.builder().build())
                .gender(FhirEnum.of(AdministrativeGender.values()[0]))
                .birthDate(FhirDate.parse("2024-01-01"))
                .deceased(FhirBoolean.of(true))
                .addAddress(Address.builder().build())
                .maritalStatus(CodeableConcept.builder().build())
                .addPhoto(Attachment.builder().build())
                .addCommunication(Person.Communication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .language(CodeableConcept.builder().build())
                        .preferred(FhirBoolean.of(true))
                        .build())
                .managingOrganization(Reference.builder().build())
                .addLink(Person.Link.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .target(Reference.builder().build())
                        .assurance(FhirEnum.of(IdentityAssuranceLevel.values()[0]))
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
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.telecom().isEmpty());
        assertNotNull(resource.gender());
        assertNotNull(resource.birthDate());
        assertNotNull(resource.deceased());
        assertFalse(resource.address().isEmpty());
        assertNotNull(resource.maritalStatus());
        assertFalse(resource.photo().isEmpty());
        assertFalse(resource.communication().isEmpty());
        assertNotNull(resource.managingOrganization());
        assertFalse(resource.link().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void group() {
        Group resource = Group.builder()
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
                .type(FhirEnum.of(GroupType.values()[0]))
                .membership(FhirEnum.of(GroupMembershipBasis.values()[0]))
                .code(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .description(FhirMarkdown.of("text"))
                .quantity(FhirUnsignedInt.of(0))
                .managingEntity(Reference.builder().build())
                .addCharacteristic(Group.Characteristic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .exclude(FhirBoolean.of(true))
                        .period(Period.builder().build())
                        .build())
                .addMember(Group.Member.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .entity(Reference.builder().build())
                        .period(Period.builder().build())
                        .inactive(FhirBoolean.of(true))
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
        assertNotNull(resource.type());
        assertNotNull(resource.membership());
        assertNotNull(resource.code());
        assertNotNull(resource.name());
        assertNotNull(resource.description());
        assertNotNull(resource.quantity());
        assertNotNull(resource.managingEntity());
        assertFalse(resource.characteristic().isEmpty());
        assertFalse(resource.member().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Group.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((FhirEnum<GroupType>) null).build()).getMessage());
    }
}
