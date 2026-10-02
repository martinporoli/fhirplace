package se.poroli.fhirplace.r5.devicedefinition;

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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.DeviceNameType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;

/** Builds a DeviceDefinition with all elements and checks the builder and validation. */
class DeviceDefinitionTest {

    @Test
    void deviceDefinition() {
        DeviceDefinition resource = DeviceDefinition.builder()
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
                .description(FhirMarkdown.of("text"))
                .addIdentifier(Identifier.builder().build())
                .addUdiDeviceIdentifier(DeviceDefinition.UdiDeviceIdentifier.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .deviceIdentifier(FhirString.of("text"))
                        .issuer(FhirUri.of("http://example.org/uri"))
                        .jurisdiction(FhirUri.of("http://example.org/uri"))
                        .addMarketDistribution(DeviceDefinition.UdiDeviceIdentifier.UdiDeviceIdentifierMarketDistribution.builder()
                                .marketPeriod(Period.builder().build())
                                .subJurisdiction(FhirUri.of("http://example.org/uri"))
                                .build())
                        .build())
                .addRegulatoryIdentifier(DeviceDefinition.RegulatoryIdentifier.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(DeviceDefinitionRegulatoryIdentifierType.values()[0]))
                        .deviceIdentifier(FhirString.of("text"))
                        .issuer(FhirUri.of("http://example.org/uri"))
                        .jurisdiction(FhirUri.of("http://example.org/uri"))
                        .build())
                .partNumber(FhirString.of("text"))
                .manufacturer(Reference.builder().build())
                .addDeviceName(DeviceDefinition.DeviceName.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .type(FhirEnum.of(DeviceNameType.values()[0]))
                        .build())
                .modelNumber(FhirString.of("text"))
                .addClassification(DeviceDefinition.Classification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addJustification(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .build())
                .addConformsTo(DeviceDefinition.ConformsTo.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .specification(CodeableConcept.builder().build())
                        .addVersion(FhirString.of("text"))
                        .addSource(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .build())
                .addHasPart(DeviceDefinition.HasPart.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .reference(Reference.builder().build())
                        .count(FhirInteger.of(1))
                        .build())
                .addPackaging(DeviceDefinition.Packaging.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identifier(Identifier.builder().build())
                        .type(CodeableConcept.builder().build())
                        .count(FhirInteger.of(1))
                        .addDistributor(DeviceDefinition.Packaging.PackagingDistributor.builder().build())
                        .addUdiDeviceIdentifier(DeviceDefinition.UdiDeviceIdentifier.builder()
                                .deviceIdentifier(FhirString.of("text"))
                                .issuer(FhirUri.of("http://example.org/uri"))
                                .jurisdiction(FhirUri.of("http://example.org/uri"))
                                .build())
                        .addPackaging(DeviceDefinition.Packaging.builder().build())
                        .build())
                .addVersion(DeviceDefinition.Version.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .component(Identifier.builder().build())
                        .value(FhirString.of("text"))
                        .build())
                .addSafety(CodeableConcept.builder().build())
                .addShelfLifeStorage(ProductShelfLife.builder().build())
                .addLanguageCode(CodeableConcept.builder().build())
                .addProperty(DeviceDefinition.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(Quantity.builder().build())
                        .build())
                .owner(Reference.builder().build())
                .addContact(ContactPoint.builder().build())
                .addLink(DeviceDefinition.Link.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .relation(Coding.builder().build())
                        .relatedDevice(CodeableReference.builder().build())
                        .build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addMaterial(DeviceDefinition.Material.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .substance(CodeableConcept.builder().build())
                        .alternate(FhirBoolean.of(true))
                        .allergenicIndicator(FhirBoolean.of(true))
                        .build())
                .addProductionIdentifierInUDI(FhirEnum.of(DeviceProductionIdentifierInUDI.values()[0]))
                .guideline(DeviceDefinition.Guideline.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addUseContext(UsageContext.builder()
                                .code(Coding.builder().build())
                                .value(CodeableConcept.builder().build())
                                .build())
                        .usageInstruction(FhirMarkdown.of("text"))
                        .addRelatedArtifact(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .addIndication(CodeableConcept.builder().build())
                        .addContraindication(CodeableConcept.builder().build())
                        .addWarning(CodeableConcept.builder().build())
                        .intendedUse(FhirString.of("text"))
                        .build())
                .correctiveAction(DeviceDefinition.CorrectiveAction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .recall(FhirBoolean.of(true))
                        .scope(FhirEnum.of(DeviceCorrectiveActionScope.values()[0]))
                        .period(Period.builder().build())
                        .build())
                .addChargeItem(DeviceDefinition.ChargeItem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .chargeItemCode(CodeableReference.builder().build())
                        .count(Quantity.builder().build())
                        .effectivePeriod(Period.builder().build())
                        .addUseContext(UsageContext.builder()
                                .code(Coding.builder().build())
                                .value(CodeableConcept.builder().build())
                                .build())
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
        assertNotNull(resource.description());
        assertFalse(resource.identifier().isEmpty());
        assertFalse(resource.udiDeviceIdentifier().isEmpty());
        assertFalse(resource.regulatoryIdentifier().isEmpty());
        assertNotNull(resource.partNumber());
        assertNotNull(resource.manufacturer());
        assertFalse(resource.deviceName().isEmpty());
        assertNotNull(resource.modelNumber());
        assertFalse(resource.classification().isEmpty());
        assertFalse(resource.conformsTo().isEmpty());
        assertFalse(resource.hasPart().isEmpty());
        assertFalse(resource.packaging().isEmpty());
        assertFalse(resource.version().isEmpty());
        assertFalse(resource.safety().isEmpty());
        assertFalse(resource.shelfLifeStorage().isEmpty());
        assertFalse(resource.languageCode().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertNotNull(resource.owner());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.link().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.material().isEmpty());
        assertFalse(resource.productionIdentifierInUDI().isEmpty());
        assertNotNull(resource.guideline());
        assertNotNull(resource.correctiveAction());
        assertFalse(resource.chargeItem().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(DeviceCorrectiveActionScope.values(), DeviceCorrectiveActionScope::fromCode);
        assertCodes(DeviceDefinitionRegulatoryIdentifierType.values(), DeviceDefinitionRegulatoryIdentifierType::fromCode);
        assertCodes(DeviceProductionIdentifierInUDI.values(), DeviceProductionIdentifierInUDI::fromCode);
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
