package se.poroli.fhirplace.r5.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Count;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.DeviceNameType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Device with all elements and checks the builder and validation. */
class DeviceTest {

    @Test
    void device() {
        Device resource = Device.builder()
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
                .displayName(FhirString.of("text"))
                .definition(CodeableReference.builder().build())
                .addUdiCarrier(Device.UdiCarrier.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .deviceIdentifier(FhirString.of("text"))
                        .issuer(FhirUri.of("http://example.org/uri"))
                        .jurisdiction(FhirUri.of("http://example.org/uri"))
                        .carrierAIDC(FhirBase64Binary.of("aGk="))
                        .carrierHRF(FhirString.of("text"))
                        .entryType(FhirEnum.of(UDIEntryType.values()[0]))
                        .build())
                .status(FhirEnum.of(FHIRDeviceStatus.values()[0]))
                .availabilityStatus(CodeableConcept.builder().build())
                .biologicalSourceEvent(Identifier.builder().build())
                .manufacturer(FhirString.of("text"))
                .manufactureDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .expirationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .lotNumber(FhirString.of("text"))
                .serialNumber(FhirString.of("text"))
                .addName(Device.Name.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .value(FhirString.of("text"))
                        .type(FhirEnum.of(DeviceNameType.values()[0]))
                        .display(FhirBoolean.of(true))
                        .build())
                .modelNumber(FhirString.of("text"))
                .partNumber(FhirString.of("text"))
                .addCategory(CodeableConcept.builder().build())
                .addType(CodeableConcept.builder().build())
                .addVersion(Device.Version.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .component(Identifier.builder().build())
                        .installDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .value(FhirString.of("text"))
                        .build())
                .addConformsTo(Device.ConformsTo.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .specification(CodeableConcept.builder().build())
                        .version(FhirString.of("text"))
                        .build())
                .addProperty(Device.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(Quantity.builder().build())
                        .build())
                .mode(CodeableConcept.builder().build())
                .cycle(Count.builder().build())
                .duration(Duration.builder().build())
                .owner(Reference.builder().build())
                .addContact(ContactPoint.builder().build())
                .location(Reference.builder().build())
                .url(FhirUri.of("http://example.org/uri"))
                .addEndpoint(Reference.builder().build())
                .addGateway(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addSafety(CodeableConcept.builder().build())
                .parent(Reference.builder().build())
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
        assertNotNull(resource.displayName());
        assertNotNull(resource.definition());
        assertFalse(resource.udiCarrier().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.availabilityStatus());
        assertNotNull(resource.biologicalSourceEvent());
        assertNotNull(resource.manufacturer());
        assertNotNull(resource.manufactureDate());
        assertNotNull(resource.expirationDate());
        assertNotNull(resource.lotNumber());
        assertNotNull(resource.serialNumber());
        assertFalse(resource.name().isEmpty());
        assertNotNull(resource.modelNumber());
        assertNotNull(resource.partNumber());
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.version().isEmpty());
        assertFalse(resource.conformsTo().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertNotNull(resource.mode());
        assertNotNull(resource.cycle());
        assertNotNull(resource.duration());
        assertNotNull(resource.owner());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.location());
        assertNotNull(resource.url());
        assertFalse(resource.endpoint().isEmpty());
        assertFalse(resource.gateway().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.safety().isEmpty());
        assertNotNull(resource.parent());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(FHIRDeviceStatus.values(), FHIRDeviceStatus::fromCode);
        assertCodes(UDIEntryType.values(), UDIEntryType::fromCode);
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
