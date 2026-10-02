package se.poroli.fhirplace.r5.specialized.medicationdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
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
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.ClinicalUseDefinitionType;
import se.poroli.fhirplace.r5.valuesets.IngredientManufacturerRole;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/** Builds every specialized.medicationdefinition resource with all elements and checks the builders and validation. */
class SpecializedMedicationdefinitionResourcesTest {

    @Test
    void medicinalProductDefinition() {
        MedicinalProductDefinition resource = MedicinalProductDefinition.builder()
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
                .domain(CodeableConcept.builder().build())
                .version(FhirString.of("text"))
                .status(CodeableConcept.builder().build())
                .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .description(FhirMarkdown.of("text"))
                .combinedPharmaceuticalDoseForm(CodeableConcept.builder().build())
                .addRoute(CodeableConcept.builder().build())
                .indication(FhirMarkdown.of("text"))
                .legalStatusOfSupply(CodeableConcept.builder().build())
                .additionalMonitoringIndicator(CodeableConcept.builder().build())
                .addSpecialMeasures(CodeableConcept.builder().build())
                .pediatricUseIndicator(CodeableConcept.builder().build())
                .addClassification(CodeableConcept.builder().build())
                .addMarketingStatus(MarketingStatus.builder()
                        .status(CodeableConcept.builder().build())
                        .build())
                .addPackagedMedicinalProduct(CodeableConcept.builder().build())
                .addComprisedOf(Reference.builder().build())
                .addIngredient(CodeableConcept.builder().build())
                .addImpurity(CodeableReference.builder().build())
                .addAttachedDocument(Reference.builder().build())
                .addMasterFile(Reference.builder().build())
                .addContact(MedicinalProductDefinition.Contact.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .contact(Reference.builder().build())
                        .build())
                .addClinicalTrial(Reference.builder().build())
                .addCode(Coding.builder().build())
                .addName(MedicinalProductDefinition.Name.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .productName(FhirString.of("text"))
                        .type(CodeableConcept.builder().build())
                        .addPart(MedicinalProductDefinition.Name.Part.builder()
                                .part(FhirString.of("text"))
                                .type(CodeableConcept.builder().build())
                                .build())
                        .addUsage(MedicinalProductDefinition.Name.Usage.builder()
                                .country(CodeableConcept.builder().build())
                                .language(CodeableConcept.builder().build())
                                .build())
                        .build())
                .addCrossReference(MedicinalProductDefinition.CrossReference.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .product(CodeableReference.builder().build())
                        .type(CodeableConcept.builder().build())
                        .build())
                .addOperation(MedicinalProductDefinition.Operation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableReference.builder().build())
                        .effectiveDate(Period.builder().build())
                        .addOrganization(Reference.builder().build())
                        .confidentialityIndicator(CodeableConcept.builder().build())
                        .build())
                .addCharacteristic(MedicinalProductDefinition.Characteristic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
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
        assertNotNull(resource.domain());
        assertNotNull(resource.version());
        assertNotNull(resource.status());
        assertNotNull(resource.statusDate());
        assertNotNull(resource.description());
        assertNotNull(resource.combinedPharmaceuticalDoseForm());
        assertFalse(resource.route().isEmpty());
        assertNotNull(resource.indication());
        assertNotNull(resource.legalStatusOfSupply());
        assertNotNull(resource.additionalMonitoringIndicator());
        assertFalse(resource.specialMeasures().isEmpty());
        assertNotNull(resource.pediatricUseIndicator());
        assertFalse(resource.classification().isEmpty());
        assertFalse(resource.marketingStatus().isEmpty());
        assertFalse(resource.packagedMedicinalProduct().isEmpty());
        assertFalse(resource.comprisedOf().isEmpty());
        assertFalse(resource.ingredient().isEmpty());
        assertFalse(resource.impurity().isEmpty());
        assertFalse(resource.attachedDocument().isEmpty());
        assertFalse(resource.masterFile().isEmpty());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.clinicalTrial().isEmpty());
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.crossReference().isEmpty());
        assertFalse(resource.operation().isEmpty());
        assertFalse(resource.characteristic().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MedicinalProductDefinition.name requires at least one value", assertThrows(
                IllegalArgumentException.class,
                (
                        ) -> resource.toBuilder().name((java.util.List<MedicinalProductDefinition.Name>) null).build()).getMessage());
    }

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

    @Test
    void administrableProductDefinition() {
        AdministrableProductDefinition resource = AdministrableProductDefinition.builder()
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
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .addFormOf(Reference.builder().build())
                .administrableDoseForm(CodeableConcept.builder().build())
                .unitOfPresentation(CodeableConcept.builder().build())
                .addProducedFrom(Reference.builder().build())
                .addIngredient(CodeableConcept.builder().build())
                .device(Reference.builder().build())
                .description(FhirMarkdown.of("text"))
                .addProperty(AdministrableProductDefinition.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .build())
                .addRouteOfAdministration(AdministrableProductDefinition.RouteOfAdministration.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .firstDose(Quantity.builder().build())
                        .maxSingleDose(Quantity.builder().build())
                        .maxDosePerDay(Quantity.builder().build())
                        .maxDosePerTreatmentPeriod(Ratio.builder().build())
                        .maxTreatmentPeriod(Duration.builder().build())
                        .addTargetSpecies(AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.builder()
                                .code(CodeableConcept.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.formOf().isEmpty());
        assertNotNull(resource.administrableDoseForm());
        assertNotNull(resource.unitOfPresentation());
        assertFalse(resource.producedFrom().isEmpty());
        assertFalse(resource.ingredient().isEmpty());
        assertNotNull(resource.device());
        assertNotNull(resource.description());
        assertFalse(resource.property().isEmpty());
        assertFalse(resource.routeOfAdministration().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("AdministrableProductDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void manufacturedItemDefinition() {
        ManufacturedItemDefinition resource = ManufacturedItemDefinition.builder()
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
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .name(FhirString.of("text"))
                .manufacturedDoseForm(CodeableConcept.builder().build())
                .unitOfPresentation(CodeableConcept.builder().build())
                .addManufacturer(Reference.builder().build())
                .addMarketingStatus(MarketingStatus.builder()
                        .status(CodeableConcept.builder().build())
                        .build())
                .addIngredient(CodeableConcept.builder().build())
                .addProperty(ManufacturedItemDefinition.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addComponent(ManufacturedItemDefinition.Component.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addFunction(CodeableConcept.builder().build())
                        .addAmount(Quantity.builder().build())
                        .addConstituent(ManufacturedItemDefinition.Component.Constituent.builder().build())
                        .addProperty(ManufacturedItemDefinition.Property.builder()
                                .type(CodeableConcept.builder().build())
                                .build())
                        .addComponent(ManufacturedItemDefinition.Component.builder()
                                .type(CodeableConcept.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.name());
        assertNotNull(resource.manufacturedDoseForm());
        assertNotNull(resource.unitOfPresentation());
        assertFalse(resource.manufacturer().isEmpty());
        assertFalse(resource.marketingStatus().isEmpty());
        assertFalse(resource.ingredient().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertFalse(resource.component().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ManufacturedItemDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void ingredient() {
        Ingredient resource = Ingredient.builder()
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
                .identifier(Identifier.builder().build())
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .addForValue(Reference.builder().build())
                .role(CodeableConcept.builder().build())
                .addFunction(CodeableConcept.builder().build())
                .group(CodeableConcept.builder().build())
                .allergenicIndicator(FhirBoolean.of(true))
                .comment(FhirMarkdown.of("text"))
                .addManufacturer(Ingredient.Manufacturer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(FhirEnum.of(IngredientManufacturerRole.values()[0]))
                        .manufacturer(Reference.builder().build())
                        .build())
                .substance(Ingredient.Substance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableReference.builder().build())
                        .addStrength(Ingredient.Substance.Strength.builder().build())
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
        assertNotNull(resource.identifier());
        assertNotNull(resource.status());
        assertFalse(resource.forValue().isEmpty());
        assertNotNull(resource.role());
        assertFalse(resource.function().isEmpty());
        assertNotNull(resource.group());
        assertNotNull(resource.allergenicIndicator());
        assertNotNull(resource.comment());
        assertFalse(resource.manufacturer().isEmpty());
        assertNotNull(resource.substance());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Ingredient.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void clinicalUseDefinition() {
        ClinicalUseDefinition resource = ClinicalUseDefinition.builder()
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
                .type(FhirEnum.of(ClinicalUseDefinitionType.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .addSubject(Reference.builder().build())
                .status(CodeableConcept.builder().build())
                .contraindication(ClinicalUseDefinition.Contraindication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .diseaseSymptomProcedure(CodeableReference.builder().build())
                        .diseaseStatus(CodeableReference.builder().build())
                        .addComorbidity(CodeableReference.builder().build())
                        .addIndication(Reference.builder().build())
                        .applicability(Expression.builder().build())
                        .addOtherTherapy(ClinicalUseDefinition.Contraindication.OtherTherapy.builder()
                                .relationshipType(CodeableConcept.builder().build())
                                .treatment(CodeableReference.builder().build())
                                .build())
                        .build())
                .indication(ClinicalUseDefinition.Indication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .diseaseSymptomProcedure(CodeableReference.builder().build())
                        .diseaseStatus(CodeableReference.builder().build())
                        .addComorbidity(CodeableReference.builder().build())
                        .intendedEffect(CodeableReference.builder().build())
                        .duration(Range.builder().build())
                        .addUndesirableEffect(Reference.builder().build())
                        .applicability(Expression.builder().build())
                        .addOtherTherapy(ClinicalUseDefinition.Contraindication.OtherTherapy.builder()
                                .relationshipType(CodeableConcept.builder().build())
                                .treatment(CodeableReference.builder().build())
                                .build())
                        .build())
                .interaction(ClinicalUseDefinition.Interaction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addInteractant(ClinicalUseDefinition.Interaction.Interactant.builder()
                                .item(Reference.builder().build())
                                .build())
                        .type(CodeableConcept.builder().build())
                        .effect(CodeableReference.builder().build())
                        .incidence(CodeableConcept.builder().build())
                        .addManagement(CodeableConcept.builder().build())
                        .build())
                .addPopulation(Reference.builder().build())
                .addLibrary(FhirCanonical.of("http://example.org/canonical"))
                .undesirableEffect(ClinicalUseDefinition.UndesirableEffect.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .symptomConditionEffect(CodeableReference.builder().build())
                        .classification(CodeableConcept.builder().build())
                        .frequencyOfOccurrence(CodeableConcept.builder().build())
                        .build())
                .warning(ClinicalUseDefinition.Warning.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .code(CodeableConcept.builder().build())
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
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.contraindication());
        assertNotNull(resource.indication());
        assertNotNull(resource.interaction());
        assertFalse(resource.population().isEmpty());
        assertFalse(resource.library().isEmpty());
        assertNotNull(resource.undesirableEffect());
        assertNotNull(resource.warning());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ClinicalUseDefinition.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((FhirEnum<ClinicalUseDefinitionType>) null).build()).getMessage());
    }

    @Test
    void regulatedAuthorization() {
        RegulatedAuthorization resource = RegulatedAuthorization.builder()
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
                .addSubject(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .description(FhirMarkdown.of("text"))
                .addRegion(CodeableConcept.builder().build())
                .status(CodeableConcept.builder().build())
                .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .validityPeriod(Period.builder().build())
                .addIndication(CodeableReference.builder().build())
                .intendedUse(CodeableConcept.builder().build())
                .addBasis(CodeableConcept.builder().build())
                .holder(Reference.builder().build())
                .regulator(Reference.builder().build())
                .addAttachedDocument(Reference.builder().build())
                .caseValue(RegulatedAuthorization.CaseValue.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identifier(Identifier.builder().build())
                        .type(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .date(Period.builder().build())
                        .addApplication(RegulatedAuthorization.CaseValue.builder().build())
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
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.description());
        assertFalse(resource.region().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusDate());
        assertNotNull(resource.validityPeriod());
        assertFalse(resource.indication().isEmpty());
        assertNotNull(resource.intendedUse());
        assertFalse(resource.basis().isEmpty());
        assertNotNull(resource.holder());
        assertNotNull(resource.regulator());
        assertFalse(resource.attachedDocument().isEmpty());
        assertNotNull(resource.caseValue());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void substanceDefinition() {
        SubstanceDefinition resource = SubstanceDefinition.builder()
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
                .version(FhirString.of("text"))
                .status(CodeableConcept.builder().build())
                .addClassification(CodeableConcept.builder().build())
                .domain(CodeableConcept.builder().build())
                .addGrade(CodeableConcept.builder().build())
                .description(FhirMarkdown.of("text"))
                .addInformationSource(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addManufacturer(Reference.builder().build())
                .addSupplier(Reference.builder().build())
                .addMoiety(SubstanceDefinition.Moiety.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(CodeableConcept.builder().build())
                        .identifier(Identifier.builder().build())
                        .name(FhirString.of("text"))
                        .stereochemistry(CodeableConcept.builder().build())
                        .opticalActivity(CodeableConcept.builder().build())
                        .molecularFormula(FhirString.of("text"))
                        .amount(Quantity.builder().build())
                        .measurementType(CodeableConcept.builder().build())
                        .build())
                .addCharacterization(SubstanceDefinition.Characterization.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .technique(CodeableConcept.builder().build())
                        .form(CodeableConcept.builder().build())
                        .description(FhirMarkdown.of("text"))
                        .addFile(Attachment.builder().build())
                        .build())
                .addProperty(SubstanceDefinition.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .referenceInformation(Reference.builder().build())
                .addMolecularWeight(SubstanceDefinition.MolecularWeight.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .method(CodeableConcept.builder().build())
                        .type(CodeableConcept.builder().build())
                        .amount(Quantity.builder().build())
                        .build())
                .structure(SubstanceDefinition.Structure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .stereochemistry(CodeableConcept.builder().build())
                        .opticalActivity(CodeableConcept.builder().build())
                        .molecularFormula(FhirString.of("text"))
                        .molecularFormulaByMoiety(FhirString.of("text"))
                        .molecularWeight(SubstanceDefinition.MolecularWeight.builder()
                                .amount(Quantity.builder().build())
                                .build())
                        .addTechnique(CodeableConcept.builder().build())
                        .addSourceDocument(Reference.builder().build())
                        .addRepresentation(SubstanceDefinition.Structure.Representation.builder().build())
                        .build())
                .addCode(SubstanceDefinition.Code.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .addSource(Reference.builder().build())
                        .build())
                .addName(SubstanceDefinition.Name.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .type(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .preferred(FhirBoolean.of(true))
                        .addLanguage(CodeableConcept.builder().build())
                        .addDomain(CodeableConcept.builder().build())
                        .addJurisdiction(CodeableConcept.builder().build())
                        .addSynonym(SubstanceDefinition.Name.builder().name(FhirString.of("text")).build())
                        .addTranslation(SubstanceDefinition.Name.builder().name(FhirString.of("text")).build())
                        .addOfficial(SubstanceDefinition.Name.Official.builder().build())
                        .addSource(Reference.builder().build())
                        .build())
                .addRelationship(SubstanceDefinition.Relationship.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .substanceDefinition(Reference.builder().build())
                        .type(CodeableConcept.builder().build())
                        .isDefining(FhirBoolean.of(true))
                        .amount(Quantity.builder().build())
                        .ratioHighLimitAmount(Ratio.builder().build())
                        .comparator(CodeableConcept.builder().build())
                        .addSource(Reference.builder().build())
                        .build())
                .nucleicAcid(Reference.builder().build())
                .polymer(Reference.builder().build())
                .protein(Reference.builder().build())
                .sourceMaterial(SubstanceDefinition.SourceMaterial.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .genus(CodeableConcept.builder().build())
                        .species(CodeableConcept.builder().build())
                        .part(CodeableConcept.builder().build())
                        .addCountryOfOrigin(CodeableConcept.builder().build())
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
        assertNotNull(resource.version());
        assertNotNull(resource.status());
        assertFalse(resource.classification().isEmpty());
        assertNotNull(resource.domain());
        assertFalse(resource.grade().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.informationSource().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.manufacturer().isEmpty());
        assertFalse(resource.supplier().isEmpty());
        assertFalse(resource.moiety().isEmpty());
        assertFalse(resource.characterization().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertNotNull(resource.referenceInformation());
        assertFalse(resource.molecularWeight().isEmpty());
        assertNotNull(resource.structure());
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.relationship().isEmpty());
        assertNotNull(resource.nucleicAcid());
        assertNotNull(resource.polymer());
        assertNotNull(resource.protein());
        assertNotNull(resource.sourceMaterial());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void substanceNucleicAcid() {
        SubstanceNucleicAcid resource = SubstanceNucleicAcid.builder()
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
                .sequenceType(CodeableConcept.builder().build())
                .numberOfSubunits(FhirInteger.of(1))
                .areaOfHybridisation(FhirString.of("text"))
                .oligoNucleotideType(CodeableConcept.builder().build())
                .addSubunit(SubstanceNucleicAcid.Subunit.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .subunit(FhirInteger.of(1))
                        .sequence(FhirString.of("text"))
                        .length(FhirInteger.of(1))
                        .sequenceAttachment(Attachment.builder().build())
                        .fivePrime(CodeableConcept.builder().build())
                        .threePrime(CodeableConcept.builder().build())
                        .addLinkage(SubstanceNucleicAcid.Subunit.Linkage.builder().build())
                        .addSugar(SubstanceNucleicAcid.Subunit.Sugar.builder().build())
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
        assertNotNull(resource.sequenceType());
        assertNotNull(resource.numberOfSubunits());
        assertNotNull(resource.areaOfHybridisation());
        assertNotNull(resource.oligoNucleotideType());
        assertFalse(resource.subunit().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void substancePolymer() {
        SubstancePolymer resource = SubstancePolymer.builder()
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
                .identifier(Identifier.builder().build())
                .classValue(CodeableConcept.builder().build())
                .geometry(CodeableConcept.builder().build())
                .addCopolymerConnectivity(CodeableConcept.builder().build())
                .modification(FhirString.of("text"))
                .addMonomerSet(SubstancePolymer.MonomerSet.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .ratioType(CodeableConcept.builder().build())
                        .addStartingMaterial(SubstancePolymer.MonomerSet.StartingMaterial.builder().build())
                        .build())
                .addRepeat(SubstancePolymer.Repeat.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .averageMolecularFormula(FhirString.of("text"))
                        .repeatUnitAmountType(CodeableConcept.builder().build())
                        .addRepeatUnit(SubstancePolymer.Repeat.RepeatUnit.builder().build())
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
        assertNotNull(resource.identifier());
        assertNotNull(resource.classValue());
        assertNotNull(resource.geometry());
        assertFalse(resource.copolymerConnectivity().isEmpty());
        assertNotNull(resource.modification());
        assertFalse(resource.monomerSet().isEmpty());
        assertFalse(resource.repeat().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void substanceProtein() {
        SubstanceProtein resource = SubstanceProtein.builder()
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
                .sequenceType(CodeableConcept.builder().build())
                .numberOfSubunits(FhirInteger.of(1))
                .addDisulfideLinkage(FhirString.of("text"))
                .addSubunit(SubstanceProtein.Subunit.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .subunit(FhirInteger.of(1))
                        .sequence(FhirString.of("text"))
                        .length(FhirInteger.of(1))
                        .sequenceAttachment(Attachment.builder().build())
                        .nTerminalModificationId(Identifier.builder().build())
                        .nTerminalModification(FhirString.of("text"))
                        .cTerminalModificationId(Identifier.builder().build())
                        .cTerminalModification(FhirString.of("text"))
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
        assertNotNull(resource.sequenceType());
        assertNotNull(resource.numberOfSubunits());
        assertFalse(resource.disulfideLinkage().isEmpty());
        assertFalse(resource.subunit().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void substanceReferenceInformation() {
        SubstanceReferenceInformation resource = SubstanceReferenceInformation.builder()
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
                .comment(FhirString.of("text"))
                .addGene(SubstanceReferenceInformation.Gene.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .geneSequenceOrigin(CodeableConcept.builder().build())
                        .gene(CodeableConcept.builder().build())
                        .addSource(Reference.builder().build())
                        .build())
                .addGeneElement(SubstanceReferenceInformation.GeneElement.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .element(Identifier.builder().build())
                        .addSource(Reference.builder().build())
                        .build())
                .addTarget(SubstanceReferenceInformation.Target.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .target(Identifier.builder().build())
                        .type(CodeableConcept.builder().build())
                        .interaction(CodeableConcept.builder().build())
                        .organism(CodeableConcept.builder().build())
                        .organismType(CodeableConcept.builder().build())
                        .amount(Quantity.builder().build())
                        .amountType(CodeableConcept.builder().build())
                        .addSource(Reference.builder().build())
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
        assertNotNull(resource.comment());
        assertFalse(resource.gene().isEmpty());
        assertFalse(resource.geneElement().isEmpty());
        assertFalse(resource.target().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void substanceSourceMaterial() {
        SubstanceSourceMaterial resource = SubstanceSourceMaterial.builder()
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
                .sourceMaterialClass(CodeableConcept.builder().build())
                .sourceMaterialType(CodeableConcept.builder().build())
                .sourceMaterialState(CodeableConcept.builder().build())
                .organismId(Identifier.builder().build())
                .organismName(FhirString.of("text"))
                .addParentSubstanceId(Identifier.builder().build())
                .addParentSubstanceName(FhirString.of("text"))
                .addCountryOfOrigin(CodeableConcept.builder().build())
                .addGeographicalLocation(FhirString.of("text"))
                .developmentStage(CodeableConcept.builder().build())
                .addFractionDescription(SubstanceSourceMaterial.FractionDescription.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .fraction(FhirString.of("text"))
                        .materialType(CodeableConcept.builder().build())
                        .build())
                .organism(SubstanceSourceMaterial.Organism.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .family(CodeableConcept.builder().build())
                        .genus(CodeableConcept.builder().build())
                        .species(CodeableConcept.builder().build())
                        .intraspecificType(CodeableConcept.builder().build())
                        .intraspecificDescription(FhirString.of("text"))
                        .addAuthor(SubstanceSourceMaterial.Organism.Author.builder().build())
                        .hybrid(SubstanceSourceMaterial.Organism.Hybrid.builder().build())
                        .organismGeneral(SubstanceSourceMaterial.Organism.OrganismGeneral.builder().build())
                        .build())
                .addPartDescription(SubstanceSourceMaterial.PartDescription.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .part(CodeableConcept.builder().build())
                        .partLocation(CodeableConcept.builder().build())
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
        assertNotNull(resource.sourceMaterialClass());
        assertNotNull(resource.sourceMaterialType());
        assertNotNull(resource.sourceMaterialState());
        assertNotNull(resource.organismId());
        assertNotNull(resource.organismName());
        assertFalse(resource.parentSubstanceId().isEmpty());
        assertFalse(resource.parentSubstanceName().isEmpty());
        assertFalse(resource.countryOfOrigin().isEmpty());
        assertFalse(resource.geographicalLocation().isEmpty());
        assertNotNull(resource.developmentStage());
        assertFalse(resource.fractionDescription().isEmpty());
        assertNotNull(resource.organism());
        assertFalse(resource.partDescription().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
