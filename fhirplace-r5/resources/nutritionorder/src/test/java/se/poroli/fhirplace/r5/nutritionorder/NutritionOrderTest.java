package se.poroli.fhirplace.r5.nutritionorder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
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
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/** Builds a NutritionOrder with all elements and checks the builder and validation. */
class NutritionOrderTest {

    @Test
    void nutritionOrder() {
        NutritionOrder resource = NutritionOrder.builder()
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
                .addInstantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .addInstantiatesUri(FhirUri.of("http://example.org/uri"))
                .addInstantiates(FhirUri.of("http://example.org/uri"))
                .addBasedOn(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(RequestStatus.values()[0]))
                .intent(FhirEnum.of(RequestIntent.values()[0]))
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .dateTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .orderer(Reference.builder().build())
                .addPerformer(CodeableReference.builder().build())
                .addAllergyIntolerance(Reference.builder().build())
                .addFoodPreferenceModifier(CodeableConcept.builder().build())
                .addExcludeFoodModifier(CodeableConcept.builder().build())
                .outsideFoodAllowed(FhirBoolean.of(true))
                .oralDiet(NutritionOrder.OralDiet.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addType(CodeableConcept.builder().build())
                        .schedule(NutritionOrder.OralDiet.OralDietSchedule.builder().build())
                        .addNutrient(NutritionOrder.OralDiet.Nutrient.builder().build())
                        .addTexture(NutritionOrder.OralDiet.Texture.builder().build())
                        .addFluidConsistencyType(CodeableConcept.builder().build())
                        .instruction(FhirString.of("text"))
                        .build())
                .addSupplement(NutritionOrder.Supplement.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableReference.builder().build())
                        .productName(FhirString.of("text"))
                        .schedule(NutritionOrder.Supplement.SupplementSchedule.builder().build())
                        .quantity(Quantity.builder().build())
                        .instruction(FhirString.of("text"))
                        .build())
                .enteralFormula(NutritionOrder.EnteralFormula.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .baseFormulaType(CodeableReference.builder().build())
                        .baseFormulaProductName(FhirString.of("text"))
                        .addDeliveryDevice(CodeableReference.builder().build())
                        .addAdditive(NutritionOrder.EnteralFormula.Additive.builder().build())
                        .caloricDensity(Quantity.builder().build())
                        .routeOfAdministration(CodeableConcept.builder().build())
                        .addAdministration(NutritionOrder.EnteralFormula.Administration.builder().build())
                        .maxVolumeToDeliver(Quantity.builder().build())
                        .administrationInstruction(FhirMarkdown.of("text"))
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
        assertFalse(resource.identifier().isEmpty());
        assertFalse(resource.instantiatesCanonical().isEmpty());
        assertFalse(resource.instantiatesUri().isEmpty());
        assertFalse(resource.instantiates().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.groupIdentifier());
        assertNotNull(resource.status());
        assertNotNull(resource.intent());
        assertNotNull(resource.priority());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertNotNull(resource.dateTime());
        assertNotNull(resource.orderer());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.allergyIntolerance().isEmpty());
        assertFalse(resource.foodPreferenceModifier().isEmpty());
        assertFalse(resource.excludeFoodModifier().isEmpty());
        assertNotNull(resource.outsideFoodAllowed());
        assertNotNull(resource.oralDiet());
        assertFalse(resource.supplement().isEmpty());
        assertNotNull(resource.enteralFormula());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("NutritionOrder.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<RequestStatus>) null).build()).getMessage());
    }
}
