package se.poroli.fhirplace.r5.base.entities2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Count;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.DeviceMetricCalibrationState;
import se.poroli.fhirplace.r5.valuesets.DeviceMetricCalibrationType;
import se.poroli.fhirplace.r5.valuesets.DeviceMetricCategory;
import se.poroli.fhirplace.r5.valuesets.DeviceMetricOperationalStatus;
import se.poroli.fhirplace.r5.valuesets.DeviceNameType;
import se.poroli.fhirplace.r5.valuesets.FHIRDeviceStatus;
import se.poroli.fhirplace.r5.valuesets.FHIRSubstanceStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.NutritionProductStatus;
import se.poroli.fhirplace.r5.valuesets.UDIEntryType;

/** Builds every base.entities2 resource with all elements and checks the builders and validation. */
class BaseEntities2ResourcesTest {

    @Test
    void substance() {
        Substance resource = Substance.builder()
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
                .instance(FhirBoolean.of(true))
                .status(FhirEnum.of(FHIRSubstanceStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableReference.builder().build())
                .description(FhirMarkdown.of("text"))
                .expiry(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .quantity(Quantity.builder().build())
                .addIngredient(Substance.Ingredient.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .quantity(Ratio.builder().build())
                        .substance(CodeableConcept.builder().build())
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
        assertNotNull(resource.instance());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.description());
        assertNotNull(resource.expiry());
        assertNotNull(resource.quantity());
        assertFalse(resource.ingredient().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Substance.instance is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().instance((FhirBoolean) null).build()).getMessage());
    }

    @Test
    void biologicallyDerivedProduct() {
        BiologicallyDerivedProduct resource = BiologicallyDerivedProduct.builder()
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
                .productCategory(Coding.builder().build())
                .productCode(CodeableConcept.builder().build())
                .addParent(Reference.builder().build())
                .addRequest(Reference.builder().build())
                .addIdentifier(Identifier.builder().build())
                .biologicalSourceEvent(Identifier.builder().build())
                .addProcessingFacility(Reference.builder().build())
                .division(FhirString.of("text"))
                .productStatus(Coding.builder().build())
                .expirationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .collection(BiologicallyDerivedProduct.Collection.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .collector(Reference.builder().build())
                        .source(Reference.builder().build())
                        .collected(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .storageTempRequirements(Range.builder().build())
                .addProperty(BiologicallyDerivedProduct.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBoolean.of(true))
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
        assertNotNull(resource.productCategory());
        assertNotNull(resource.productCode());
        assertFalse(resource.parent().isEmpty());
        assertFalse(resource.request().isEmpty());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.biologicalSourceEvent());
        assertFalse(resource.processingFacility().isEmpty());
        assertNotNull(resource.division());
        assertNotNull(resource.productStatus());
        assertNotNull(resource.expirationDate());
        assertNotNull(resource.collection());
        assertNotNull(resource.storageTempRequirements());
        assertFalse(resource.property().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

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
    void deviceMetric() {
        DeviceMetric resource = DeviceMetric.builder()
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
                .type(CodeableConcept.builder().build())
                .unit(CodeableConcept.builder().build())
                .device(Reference.builder().build())
                .operationalStatus(FhirEnum.of(DeviceMetricOperationalStatus.values()[0]))
                .color(FhirCode.of("code"))
                .category(FhirEnum.of(DeviceMetricCategory.values()[0]))
                .measurementFrequency(Quantity.builder().build())
                .addCalibration(DeviceMetric.Calibration.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(DeviceMetricCalibrationType.values()[0]))
                        .state(FhirEnum.of(DeviceMetricCalibrationState.values()[0]))
                        .time(FhirInstant.parse("2024-01-01T00:00:00Z"))
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
        assertNotNull(resource.type());
        assertNotNull(resource.unit());
        assertNotNull(resource.device());
        assertNotNull(resource.operationalStatus());
        assertNotNull(resource.color());
        assertNotNull(resource.category());
        assertNotNull(resource.measurementFrequency());
        assertFalse(resource.calibration().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DeviceMetric.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((CodeableConcept) null).build()).getMessage());
    }

    @Test
    void nutritionProduct() {
        NutritionProduct resource = NutritionProduct.builder()
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
                .code(CodeableConcept.builder().build())
                .status(FhirEnum.of(NutritionProductStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .addManufacturer(Reference.builder().build())
                .addNutrient(NutritionProduct.Nutrient.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(CodeableReference.builder().build())
                        .addAmount(Ratio.builder().build())
                        .build())
                .addIngredient(NutritionProduct.Ingredient.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(CodeableReference.builder().build())
                        .addAmount(Ratio.builder().build())
                        .build())
                .addKnownAllergen(CodeableReference.builder().build())
                .addCharacteristic(NutritionProduct.Characteristic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addInstance(NutritionProduct.Instance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .quantity(Quantity.builder().build())
                        .addIdentifier(Identifier.builder().build())
                        .name(FhirString.of("text"))
                        .lotNumber(FhirString.of("text"))
                        .expiry(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .useBy(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .biologicalSourceEvent(Identifier.builder().build())
                        .build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.manufacturer().isEmpty());
        assertFalse(resource.nutrient().isEmpty());
        assertFalse(resource.ingredient().isEmpty());
        assertFalse(resource.knownAllergen().isEmpty());
        assertFalse(resource.characteristic().isEmpty());
        assertFalse(resource.instance().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("NutritionProduct.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<NutritionProductStatus>) null).build()).getMessage());
    }
}
