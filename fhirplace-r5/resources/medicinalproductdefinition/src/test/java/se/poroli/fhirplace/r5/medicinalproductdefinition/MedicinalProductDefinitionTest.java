package se.poroli.fhirplace.r5.medicinalproductdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a MedicinalProductDefinition with all elements and checks the builder and validation. */
class MedicinalProductDefinitionTest {

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
}
