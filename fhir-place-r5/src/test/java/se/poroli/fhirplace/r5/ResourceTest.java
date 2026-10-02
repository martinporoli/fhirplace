package se.poroli.fhirplace.r5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import se.poroli.fhirplace.r5.base.individuals.Group;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.base.individuals.Person;
import se.poroli.fhirplace.r5.base.individuals.Practitioner;
import se.poroli.fhirplace.r5.base.individuals.PractitionerRole;
import se.poroli.fhirplace.r5.base.individuals.RelatedPerson;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.foundation.other.Bundle;
import se.poroli.fhirplace.r5.valuesets.BundleType;
import se.poroli.fhirplace.r5.valuesets.ContactPointSystem;
import se.poroli.fhirplace.r5.valuesets.DaysOfWeek;
import se.poroli.fhirplace.r5.valuesets.GroupMembershipBasis;
import se.poroli.fhirplace.r5.valuesets.GroupType;
import se.poroli.fhirplace.r5.valuesets.IdentityAssuranceLevel;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

class ResourceTest {

    private static final Meta META = Meta.builder()
            .versionId("1")
            .addProfile("http://example.org/StructureDefinition/my-profile")
            .addTag(Coding.builder().system("http://example.org/tags").code("test").build())
            .build();
    private static final Narrative TEXT = Narrative.builder()
            .status(NarrativeStatus.GENERATED)
            .div("<div xmlns=\"http://www.w3.org/1999/xhtml\">Example</div>")
            .build();

    static Stream<DomainResource> resources() {
        Patient patient = Patient.builder().id("p1").meta(META).text(TEXT).build();
        return Stream.of(
                patient,
                Practitioner.builder().id("pr1").addQualification(Practitioner.Qualification.builder()
                        .code(CodeableConcept.builder().text("MD").build()).build()).build(),
                PractitionerRole.builder().id("role1")
                        .practitioner(Reference.builder().reference("Practitioner/pr1").build())
                        .addContact(ExtendedContactDetail.builder().addTelecom(ContactPoint.builder()
                                .system(ContactPointSystem.PHONE).value("+46 8 123 456").rank(1).build()).build())
                        .addAvailability(Availability.builder().addAvailableTime(Availability.AvailableTime.builder()
                                .addDaysOfWeek(DaysOfWeek.MON).availableStartTime(LocalTime.of(8, 0)).build()).build())
                        .build(),
                RelatedPerson.builder().id("rp1").patient(Reference.builder().reference("Patient/p1").build())
                        .addContained(patient).build(),
                Person.builder().id("pe1").addLink(Person.Link.builder()
                        .target(Reference.builder().reference("Patient/p1").build())
                        .assurance(IdentityAssuranceLevel.LEVEL3).build()).build(),
                Group.builder().id("g1").type(GroupType.PERSON).membership(GroupMembershipBasis.ENUMERATED).build());
    }

    @ParameterizedTest
    @MethodSource("resources")
    void resourcesShareTheResourceAndDomainResourceElements(DomainResource resource) {
        Resource base = resource;

        assertEquals(resource.id(), base.id());
        assertTrue(resource.modifierExtension().isEmpty());
    }

    @Test
    void resourcesWithoutNarrativeOrExtensionsImplementResourceDirectly() {
        Resource bundle = Bundle.builder().id("b1").type(BundleType.COLLECTION)
                .addEntry(Bundle.Entry.builder().resource(Patient.builder().id("p1").build()).build())
                .build();

        assertFalse(bundle instanceof DomainResource);
        assertEquals("p1", ((Bundle) bundle).entry().getFirst().resource().id());
    }

    @Test
    void exposesMetaNarrativeAndContainedResources() {
        Patient patient = Patient.builder().id("p1").meta(META).text(TEXT).build();
        RelatedPerson person = RelatedPerson.builder()
                .patient(Reference.builder().reference("#p1").build())
                .addContained(patient)
                .build();

        assertEquals("1", patient.meta().versionId().value());
        assertEquals("http://example.org/StructureDefinition/my-profile", patient.meta().profile().getFirst().value());
        assertEquals("generated", patient.text().status().valueAsString());
        assertEquals(patient, person.contained().getFirst());
    }
}
