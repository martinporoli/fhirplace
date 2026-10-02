package se.poroli.fhirplace.r5.packagedproductdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a PackagedProductDefinition with all elements and checks the builder and validation. */
class PackagedProductDefinitionTest {

    @Test
    void packagedProductDefinition() {
        PackagedProductDefinition resource = PackagedProductDefinition.builder()
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
                .name(FhirString.of("text"))
                .type(CodeableConcept.builder().build())
                .addPackageFor(Reference.builder().build())
                .status(CodeableConcept.builder().build())
                .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addContainedItemQuantity(Quantity.builder().build())
                .description(FhirMarkdown.of("text"))
                .addLegalStatusOfSupply(PackagedProductDefinition.LegalStatusOfSupply.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .jurisdiction(CodeableConcept.builder().build())
                        .build())
                .addMarketingStatus(MarketingStatus.builder()
                        .status(CodeableConcept.builder().build())
                        .build())
                .copackagedIndicator(FhirBoolean.of(true))
                .addManufacturer(Reference.builder().build())
                .addAttachedDocument(Reference.builder().build())
                .packaging(PackagedProductDefinition.Packaging.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .type(CodeableConcept.builder().build())
                        .componentPart(FhirBoolean.of(true))
                        .quantity(FhirInteger.of(1))
                        .addMaterial(CodeableConcept.builder().build())
                        .addAlternateMaterial(CodeableConcept.builder().build())
                        .addShelfLifeStorage(ProductShelfLife.builder().build())
                        .addManufacturer(Reference.builder().build())
                        .addProperty(PackagedProductDefinition.Packaging.Property.builder()
                                .type(CodeableConcept.builder().build())
                                .build())
                        .addContainedItem(PackagedProductDefinition.Packaging.ContainedItem.builder()
                                .item(CodeableReference.builder().build())
                                .build())
                        .addPackaging(PackagedProductDefinition.Packaging.builder().build())
                        .build())
                .addCharacteristic(PackagedProductDefinition.Packaging.Property.builder()
                        .type(CodeableConcept.builder().build())
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
        assertNotNull(resource.name());
        assertNotNull(resource.type());
        assertFalse(resource.packageFor().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusDate());
        assertFalse(resource.containedItemQuantity().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.legalStatusOfSupply().isEmpty());
        assertFalse(resource.marketingStatus().isEmpty());
        assertNotNull(resource.copackagedIndicator());
        assertFalse(resource.manufacturer().isEmpty());
        assertFalse(resource.attachedDocument().isEmpty());
        assertNotNull(resource.packaging());
        assertFalse(resource.characteristic().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
