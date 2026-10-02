package se.poroli.fhirplace.r5.base.individuals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;
import se.poroli.fhirplace.r5.valuesets.LinkType;
import se.poroli.fhirplace.r5.valuesets.NameUse;

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
}
