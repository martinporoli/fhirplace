package se.poroli.fhirplace.r5.medicationknowledge;

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
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a MedicationKnowledge with all elements and checks the builder and validation. */
class MedicationKnowledgeTest {

    @Test
    void medicationKnowledge() {
        MedicationKnowledge resource = MedicationKnowledge.builder()
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
                .code(CodeableConcept.builder().build())
                .status(FhirEnum.of(MedicationKnowledgeStatusCodes.values()[0]))
                .author(Reference.builder().build())
                .addIntendedJurisdiction(CodeableConcept.builder().build())
                .addName(FhirString.of("text"))
                .addRelatedMedicationKnowledge(MedicationKnowledge.RelatedMedicationKnowledge.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addReference(Reference.builder().build())
                        .build())
                .addAssociatedMedication(Reference.builder().build())
                .addProductType(CodeableConcept.builder().build())
                .addMonograph(MedicationKnowledge.Monograph.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .source(Reference.builder().build())
                        .build())
                .preparationInstruction(FhirMarkdown.of("text"))
                .addCost(MedicationKnowledge.Cost.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addEffectiveDate(Period.builder().build())
                        .type(CodeableConcept.builder().build())
                        .source(FhirString.of("text"))
                        .cost(Money.builder().build())
                        .build())
                .addMonitoringProgram(MedicationKnowledge.MonitoringProgram.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .name(FhirString.of("text"))
                        .build())
                .addIndicationGuideline(MedicationKnowledge.IndicationGuideline.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIndication(CodeableReference.builder().build())
                        .addDosingGuideline(MedicationKnowledge.IndicationGuideline.DosingGuideline.builder()
                                
                                .build())
                        .build())
                .addMedicineClassification(MedicationKnowledge.MedicineClassification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .source(FhirString.of("text"))
                        .addClassification(CodeableConcept.builder().build())
                        .build())
                .addPackaging(MedicationKnowledge.Packaging.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addCost(MedicationKnowledge.Cost.builder()
                                .type(CodeableConcept.builder().build())
                                .cost(Money.builder().build())
                                .build())
                        .packagedProduct(Reference.builder().build())
                        .build())
                .addClinicalUseIssue(Reference.builder().build())
                .addStorageGuideline(MedicationKnowledge.StorageGuideline.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .reference(FhirUri.of("http://example.org/uri"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .stabilityDuration(Duration.builder().build())
                        .addEnvironmentalSetting(MedicationKnowledge.StorageGuideline.EnvironmentalSetting.builder()
                                .type(CodeableConcept.builder().build())
                                .value(Quantity.builder().build())
                                .build())
                        .build())
                .addRegulatory(MedicationKnowledge.Regulatory.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .regulatoryAuthority(Reference.builder().build())
                        .addSubstitution(MedicationKnowledge.Regulatory.Substitution.builder()
                                .type(CodeableConcept.builder().build())
                                .allowed(FhirBoolean.of(true))
                                .build())
                        .addSchedule(CodeableConcept.builder().build())
                        .maxDispense(MedicationKnowledge.Regulatory.MaxDispense.builder()
                                .quantity(Quantity.builder().build())
                                .build())
                        .build())
                .definitional(MedicationKnowledge.Definitional.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addDefinition(Reference.builder().build())
                        .doseForm(CodeableConcept.builder().build())
                        .addIntendedRoute(CodeableConcept.builder().build())
                        .addIngredient(MedicationKnowledge.Definitional.Ingredient.builder()
                                .item(CodeableReference.builder().build())
                                .build())
                        .addDrugCharacteristic(MedicationKnowledge.Definitional.DrugCharacteristic.builder().build())
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
        assertNotNull(resource.code());
        assertNotNull(resource.status());
        assertNotNull(resource.author());
        assertFalse(resource.intendedJurisdiction().isEmpty());
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.relatedMedicationKnowledge().isEmpty());
        assertFalse(resource.associatedMedication().isEmpty());
        assertFalse(resource.productType().isEmpty());
        assertFalse(resource.monograph().isEmpty());
        assertNotNull(resource.preparationInstruction());
        assertFalse(resource.cost().isEmpty());
        assertFalse(resource.monitoringProgram().isEmpty());
        assertFalse(resource.indicationGuideline().isEmpty());
        assertFalse(resource.medicineClassification().isEmpty());
        assertFalse(resource.packaging().isEmpty());
        assertFalse(resource.clinicalUseIssue().isEmpty());
        assertFalse(resource.storageGuideline().isEmpty());
        assertFalse(resource.regulatory().isEmpty());
        assertNotNull(resource.definitional());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(MedicationKnowledgeStatusCodes.values(), MedicationKnowledgeStatusCodes::fromCode);
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
