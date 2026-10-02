package se.poroli.fhirplace.r5.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Availability;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ExtendedContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Location with all elements and checks the builder and validation. */
class LocationTest {

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

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(LocationMode.values(), LocationMode::fromCode);
        assertCodes(LocationStatus.values(), LocationStatus::fromCode);
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
