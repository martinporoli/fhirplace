package se.poroli.fhirplace.r5.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.DomainResource;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NameUse;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

class PatientTest {

    private static Patient janeDoe() {
        return Patient.builder()
                .id("jane")
                .addIdentifier(Identifier.builder().system("urn:oid:1.2.36.146.595.217.0.1").value("12345").build())
                .active(true)
                .addName(HumanName.builder().use(NameUse.OFFICIAL).family("Doe").addGiven("Jane").addGiven("Q").build())
                .gender(AdministrativeGender.FEMALE)
                .birthDate(LocalDate.of(1974, 12, 25))
                .deceased(false)
                .multipleBirth(2)
                .addContact(Patient.Contact.builder()
                        .name(HumanName.builder().family("Doe").addGiven("John").build())
                        .gender(AdministrativeGender.MALE)
                        .build())
                .addCommunication(Patient.Communication.builder()
                        .language(CodeableConcept.builder().text("Swedish").build())
                        .preferred(true)
                        .build())
                .addLink(Patient.Link.builder()
                        .other(Reference.builder().reference("Patient/old-jane").build())
                        .type(LinkType.REPLACES)
                        .build())
                .build();
    }

    @Test
    void builderSetsElementsWrappedInPrimitives() {
        Patient patient = janeDoe();

        assertEquals("jane", patient.id());
        assertEquals(true, patient.active().value());
        assertEquals(AdministrativeGender.FEMALE, patient.gender().value());
        assertEquals("female", patient.gender().valueAsString());
        assertEquals("1974-12-25", patient.birthDate().valueAsString());
        assertEquals(List.of("Jane", "Q"), patient.name().getFirst().given().stream().map(g -> g.value()).toList());
        assertEquals(FhirBoolean.of(false), patient.deceased());
        assertEquals(FhirInteger.of(2), patient.multipleBirth());
        assertEquals(AdministrativeGender.MALE, patient.contact().getFirst().gender().value());
        assertEquals("Patient/old-jane", patient.link().getFirst().other().reference().value());
    }

    @Test
    void absentElementsAreNullOrEmpty() {
        Patient patient = Patient.builder().build();

        assertNull(patient.id());
        assertNull(patient.gender());
        assertNull(patient.deceased());
        assertTrue(patient.name().isEmpty());
        assertTrue(patient.contained().isEmpty());
        assertTrue(patient.modifierExtension().isEmpty());
    }

    @Test
    void toBuilderRoundTripsAllValues() {
        Patient patient = janeDoe();

        assertEquals(patient, patient.toBuilder().build());
    }

    @Test
    void toBuilderChangesDoNotAffectTheOriginal() {
        Patient patient = janeDoe();

        Patient changed = patient.toBuilder()
                .gender(AdministrativeGender.OTHER)
                .addName(HumanName.builder().text("JD").build())
                .build();

        assertEquals(AdministrativeGender.FEMALE, patient.gender().value());
        assertEquals(1, patient.name().size());
        assertEquals(AdministrativeGender.OTHER, changed.gender().value());
        assertEquals(2, changed.name().size());
        assertNotEquals(patient, changed);
    }

    @Test
    void listsAreImmutableAndIndependentOfTheirSource() {
        List<HumanName> names = new ArrayList<>(List.of(HumanName.builder().family("Doe").build()));
        Patient patient = Patient.builder().name(names).build();

        names.add(HumanName.builder().family("Smith").build());

        assertEquals(1, patient.name().size());
        assertThrows(UnsupportedOperationException.class, () -> patient.name().add(names.getLast()));
    }

    @Test
    void choiceElementAcceptsEachAllowedType() {
        Patient byBoolean = Patient.builder().deceased(true).build();
        Patient byDateTime = Patient.builder().deceased(Year.of(2020)).build();

        assertEquals(FhirBoolean.of(true), byBoolean.deceased());
        FhirDateTime deceased = assertInstanceOf(FhirDateTime.class, byDateTime.deceased());
        assertEquals("2020", deceased.valueAsString());
    }

    @Test
    void requiredElementMustBePresent() {
        Patient.Link.Builder link = Patient.Link.builder().type(LinkType.REFER);

        NullPointerException e = assertThrows(NullPointerException.class, link::build);
        assertEquals("Patient.link.other is required", e.getMessage());
    }

    @Test
    void primitiveCanCarryExtensionsWithoutValue() {
        Extension absent = Extension.builder()
                .url("http://hl7.org/fhir/StructureDefinition/data-absent-reason")
                .value(FhirCode.of("unknown"))
                .build();

        Patient patient = Patient.builder().birthDate(new FhirDate("bd", List.of(absent), null)).build();

        assertNull(patient.birthDate().value());
        assertEquals("bd", patient.birthDate().id());
        assertEquals(List.of(absent), patient.birthDate().extension());
    }

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
    void exposesMetaNarrativeAndContainedResourcesThroughDomainResource() {
        Patient contained = Patient.builder()
                .id("p1")
                .meta(Meta.builder()
                        .versionId("1")
                        .addProfile("http://example.org/StructureDefinition/my-profile")
                        .addTag(Coding.builder().system("http://example.org/tags").code("test").build())
                        .build())
                .text(Narrative.builder()
                        .status(NarrativeStatus.GENERATED)
                        .div("<div xmlns=\"http://www.w3.org/1999/xhtml\">Example</div>")
                        .build())
                .build();
        DomainResource container = Patient.builder().addContained(contained).build();

        assertEquals("1", contained.meta().versionId().value());
        assertEquals("http://example.org/StructureDefinition/my-profile", contained.meta().profile().getFirst().value());
        assertEquals("generated", contained.text().status().valueAsString());
        assertEquals(contained, container.contained().getFirst());
        assertTrue(container.modifierExtension().isEmpty());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(LinkType.values(), LinkType::fromCode);
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
