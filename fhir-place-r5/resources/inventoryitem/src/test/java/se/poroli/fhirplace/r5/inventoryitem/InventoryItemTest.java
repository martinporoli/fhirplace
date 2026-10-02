package se.poroli.fhirplace.r5.inventoryitem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.CommonLanguages;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a InventoryItem with all elements and checks the builder and validation. */
class InventoryItemTest {

    @Test
    void inventoryItem() {
        InventoryItem resource = InventoryItem.builder()
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
                .status(FhirEnum.of(InventoryItemStatusCodes.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .addCode(CodeableConcept.builder().build())
                .addName(InventoryItem.Name.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .nameType(Coding.builder().build())
                        .language(FhirEnum.of(CommonLanguages.values()[0]))
                        .name(FhirString.of("text"))
                        .build())
                .addResponsibleOrganization(InventoryItem.ResponsibleOrganization.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(CodeableConcept.builder().build())
                        .organization(Reference.builder().build())
                        .build())
                .description(InventoryItem.Description.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .language(FhirEnum.of(CommonLanguages.values()[0]))
                        .description(FhirString.of("text"))
                        .build())
                .addInventoryStatus(CodeableConcept.builder().build())
                .baseUnit(CodeableConcept.builder().build())
                .netContent(Quantity.builder().build())
                .addAssociation(InventoryItem.Association.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .associationType(CodeableConcept.builder().build())
                        .relatedItem(Reference.builder().build())
                        .quantity(Ratio.builder().build())
                        .build())
                .addCharacteristic(InventoryItem.Characteristic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .characteristicType(CodeableConcept.builder().build())
                        .value(FhirString.of("text"))
                        .build())
                .instance(InventoryItem.Instance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .lotNumber(FhirString.of("text"))
                        .expiry(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .subject(Reference.builder().build())
                        .location(Reference.builder().build())
                        .build())
                .productReference(Reference.builder().build())
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
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.responsibleOrganization().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.inventoryStatus().isEmpty());
        assertNotNull(resource.baseUnit());
        assertNotNull(resource.netContent());
        assertFalse(resource.association().isEmpty());
        assertFalse(resource.characteristic().isEmpty());
        assertNotNull(resource.instance());
        assertNotNull(resource.productReference());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("InventoryItem.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<InventoryItemStatusCodes>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(InventoryItemStatusCodes.values(), InventoryItemStatusCodes::fromCode);
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
