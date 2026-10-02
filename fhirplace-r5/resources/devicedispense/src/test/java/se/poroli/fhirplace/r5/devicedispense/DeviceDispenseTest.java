package se.poroli.fhirplace.r5.devicedispense;

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
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a DeviceDispense with all elements and checks the builder and validation. */
class DeviceDispenseTest {

    @Test
    void deviceDispense() {
        DeviceDispense resource = DeviceDispense.builder()
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
                .addBasedOn(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(DeviceDispenseStatusCodes.values()[0]))
                .statusReason(CodeableReference.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .device(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .receiver(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .addPerformer(DeviceDispense.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .location(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .quantity(Quantity.builder().build())
                .preparedDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .whenHandedOver(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .destination(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .usageInstruction(FhirMarkdown.of("text"))
                .addEventHistory(Reference.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.device());
        assertNotNull(resource.subject());
        assertNotNull(resource.receiver());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertNotNull(resource.type());
        assertNotNull(resource.quantity());
        assertNotNull(resource.preparedDate());
        assertNotNull(resource.whenHandedOver());
        assertNotNull(resource.destination());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.usageInstruction());
        assertFalse(resource.eventHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DeviceDispense.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<DeviceDispenseStatusCodes>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(DeviceDispenseStatusCodes.values(), DeviceDispenseStatusCodes::fromCode);
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
