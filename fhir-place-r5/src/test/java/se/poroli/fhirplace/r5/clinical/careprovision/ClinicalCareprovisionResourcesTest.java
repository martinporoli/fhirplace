package se.poroli.fhirplace.r5.clinical.careprovision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.valuesets.ActionCardinalityBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionConditionKind;
import se.poroli.fhirplace.r5.valuesets.ActionGroupingBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionPrecheckBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionRelationshipType;
import se.poroli.fhirplace.r5.valuesets.ActionRequiredBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionSelectionBehavior;
import se.poroli.fhirplace.r5.valuesets.CarePlanIntent;
import se.poroli.fhirplace.r5.valuesets.CareTeamStatus;
import se.poroli.fhirplace.r5.valuesets.EventStatus;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.GoalLifecycleStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;
import se.poroli.fhirplace.r5.valuesets.VisionBase;
import se.poroli.fhirplace.r5.valuesets.VisionEyes;

/** Builds every clinical.careprovision resource with all elements and checks the builders and validation. */
class ClinicalCareprovisionResourcesTest {

    @Test
    void carePlan() {
        CarePlan resource = CarePlan.builder()
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
                .addBasedOn(Reference.builder().build())
                .addReplaces(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(RequestStatus.values()[0]))
                .intent(FhirEnum.of(CarePlanIntent.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .title(FhirString.of("text"))
                .description(FhirString.of("text"))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .period(Period.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .custodian(Reference.builder().build())
                .addContributor(Reference.builder().build())
                .addCareTeam(Reference.builder().build())
                .addAddresses(CodeableReference.builder().build())
                .addSupportingInfo(Reference.builder().build())
                .addGoal(Reference.builder().build())
                .addActivity(CarePlan.Activity.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addPerformedActivity(CodeableReference.builder().build())
                        .addProgress(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .plannedActivityReference(Reference.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.replaces().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.intent());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.title());
        assertNotNull(resource.description());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.period());
        assertNotNull(resource.created());
        assertNotNull(resource.custodian());
        assertFalse(resource.contributor().isEmpty());
        assertFalse(resource.careTeam().isEmpty());
        assertFalse(resource.addresses().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.goal().isEmpty());
        assertFalse(resource.activity().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CarePlan.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<RequestStatus>) null).build()).getMessage());
    }

    @Test
    void careTeam() {
        CareTeam resource = CareTeam.builder()
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
                .status(FhirEnum.of(CareTeamStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .subject(Reference.builder().build())
                .period(Period.builder().build())
                .addParticipant(CareTeam.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(CodeableConcept.builder().build())
                        .member(Reference.builder().build())
                        .onBehalfOf(Reference.builder().build())
                        .coverage(Period.builder().build())
                        .build())
                .addReason(CodeableReference.builder().build())
                .addManagingOrganization(Reference.builder().build())
                .addTelecom(ContactPoint.builder().build())
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
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.name());
        assertNotNull(resource.subject());
        assertNotNull(resource.period());
        assertFalse(resource.participant().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.managingOrganization().isEmpty());
        assertFalse(resource.telecom().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void goal() {
        Goal resource = Goal.builder()
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
                .lifecycleStatus(FhirEnum.of(GoalLifecycleStatus.values()[0]))
                .achievementStatus(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .continuous(FhirBoolean.of(true))
                .priority(CodeableConcept.builder().build())
                .description(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .start(FhirDate.parse("2024-01-01"))
                .addTarget(Goal.Target.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .measure(CodeableConcept.builder().build())
                        .detail(Quantity.builder().build())
                        .due(FhirDate.parse("2024-01-01"))
                        .build())
                .statusDate(FhirDate.parse("2024-01-01"))
                .statusReason(FhirString.of("text"))
                .source(Reference.builder().build())
                .addAddresses(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addOutcome(CodeableReference.builder().build())
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
        assertNotNull(resource.lifecycleStatus());
        assertNotNull(resource.achievementStatus());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.continuous());
        assertNotNull(resource.priority());
        assertNotNull(resource.description());
        assertNotNull(resource.subject());
        assertNotNull(resource.start());
        assertFalse(resource.target().isEmpty());
        assertNotNull(resource.statusDate());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.source());
        assertFalse(resource.addresses().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.outcome().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Goal.lifecycleStatus is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().lifecycleStatus((FhirEnum<GoalLifecycleStatus>) null).build()).getMessage());
    }

    @Test
    void serviceRequest() {
        ServiceRequest resource = ServiceRequest.builder()
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
                .addBasedOn(Reference.builder().build())
                .addReplaces(Reference.builder().build())
                .requisition(Identifier.builder().build())
                .status(FhirEnum.of(RequestStatus.values()[0]))
                .intent(FhirEnum.of(RequestIntent.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .doNotPerform(FhirBoolean.of(true))
                .code(CodeableReference.builder().build())
                .addOrderDetail(ServiceRequest.OrderDetail.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .parameterFocus(CodeableReference.builder().build())
                        .addParameter(ServiceRequest.OrderDetail.Parameter.builder()
                                .code(CodeableConcept.builder().build())
                                .value(Quantity.builder().build())
                                .build())
                        .build())
                .quantity(Quantity.builder().build())
                .subject(Reference.builder().build())
                .addFocus(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .asNeeded(FhirBoolean.of(true))
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .performerType(CodeableConcept.builder().build())
                .addPerformer(Reference.builder().build())
                .addLocation(CodeableReference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addInsurance(Reference.builder().build())
                .addSupportingInfo(CodeableReference.builder().build())
                .addSpecimen(Reference.builder().build())
                .addBodySite(CodeableConcept.builder().build())
                .bodyStructure(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addPatientInstruction(ServiceRequest.PatientInstruction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .instruction(FhirMarkdown.of("text"))
                        .build())
                .addRelevantHistory(Reference.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.replaces().isEmpty());
        assertNotNull(resource.requisition());
        assertNotNull(resource.status());
        assertNotNull(resource.intent());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.priority());
        assertNotNull(resource.doNotPerform());
        assertNotNull(resource.code());
        assertFalse(resource.orderDetail().isEmpty());
        assertNotNull(resource.quantity());
        assertNotNull(resource.subject());
        assertFalse(resource.focus().isEmpty());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.asNeeded());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.requester());
        assertNotNull(resource.performerType());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.location().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.specimen().isEmpty());
        assertFalse(resource.bodySite().isEmpty());
        assertNotNull(resource.bodyStructure());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.patientInstruction().isEmpty());
        assertFalse(resource.relevantHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ServiceRequest.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<RequestStatus>) null).build()).getMessage());
    }

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

    @Test
    void nutritionIntake() {
        NutritionIntake resource = NutritionIntake.builder()
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
                .addBasedOn(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(EventStatus.values()[0]))
                .addStatusReason(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .recorded(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .reported(FhirBoolean.of(true))
                .addConsumedItem(NutritionIntake.ConsumedItem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .nutritionProduct(CodeableReference.builder().build())
                        .schedule(Timing.builder().build())
                        .amount(Quantity.builder().build())
                        .rate(Quantity.builder().build())
                        .notConsumed(FhirBoolean.of(true))
                        .notConsumedReason(CodeableConcept.builder().build())
                        .build())
                .addIngredientLabel(NutritionIntake.IngredientLabel.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .nutrient(CodeableReference.builder().build())
                        .amount(Quantity.builder().build())
                        .build())
                .addPerformer(NutritionIntake.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .location(Reference.builder().build())
                .addDerivedFrom(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.statusReason().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.recorded());
        assertNotNull(resource.reported());
        assertFalse(resource.consumedItem().isEmpty());
        assertFalse(resource.ingredientLabel().isEmpty());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.derivedFrom().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("NutritionIntake.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EventStatus>) null).build()).getMessage());
    }

    @Test
    void visionPrescription() {
        VisionPrescription resource = VisionPrescription.builder()
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
                .status(FhirEnum.of(FinancialResourceStatusCodes.values()[0]))
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .dateWritten(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .prescriber(Reference.builder().build())
                .addLensSpecification(VisionPrescription.LensSpecification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .product(CodeableConcept.builder().build())
                        .eye(FhirEnum.of(VisionEyes.values()[0]))
                        .sphere(FhirDecimal.parse("1.0"))
                        .cylinder(FhirDecimal.parse("1.0"))
                        .axis(FhirInteger.of(1))
                        .addPrism(VisionPrescription.LensSpecification.Prism.builder()
                                .amount(FhirDecimal.parse("1.0"))
                                .base(FhirEnum.of(VisionBase.values()[0]))
                                .build())
                        .add(FhirDecimal.parse("1.0"))
                        .power(FhirDecimal.parse("1.0"))
                        .backCurve(FhirDecimal.parse("1.0"))
                        .diameter(FhirDecimal.parse("1.0"))
                        .duration(Quantity.builder().build())
                        .color(FhirString.of("text"))
                        .brand(FhirString.of("text"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
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
        assertNotNull(resource.created());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertNotNull(resource.dateWritten());
        assertNotNull(resource.prescriber());
        assertFalse(resource.lensSpecification().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("VisionPrescription.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<FinancialResourceStatusCodes>) null).build()).getMessage());
    }

    @Test
    void riskAssessment() {
        RiskAssessment resource = RiskAssessment.builder()
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
                .basedOn(Reference.builder().build())
                .parent(Reference.builder().build())
                .status(FhirEnum.of(ObservationStatus.values()[0]))
                .method(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .condition(Reference.builder().build())
                .performer(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addBasis(Reference.builder().build())
                .addPrediction(RiskAssessment.Prediction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .outcome(CodeableConcept.builder().build())
                        .probability(FhirDecimal.parse("1.0"))
                        .qualitativeRisk(CodeableConcept.builder().build())
                        .relativeRisk(FhirDecimal.parse("1.0"))
                        .when(Period.builder().build())
                        .rationale(FhirString.of("text"))
                        .build())
                .mitigation(FhirString.of("text"))
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
        assertNotNull(resource.basedOn());
        assertNotNull(resource.parent());
        assertNotNull(resource.status());
        assertNotNull(resource.method());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.condition());
        assertNotNull(resource.performer());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.basis().isEmpty());
        assertFalse(resource.prediction().isEmpty());
        assertNotNull(resource.mitigation());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("RiskAssessment.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ObservationStatus>) null).build()).getMessage());
    }

    @Test
    void requestOrchestration() {
        RequestOrchestration resource = RequestOrchestration.builder()
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
                .addBasedOn(Reference.builder().build())
                .addReplaces(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(RequestStatus.values()[0]))
                .intent(FhirEnum.of(RequestIntent.values()[0]))
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .author(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addGoal(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addAction(RequestOrchestration.Action.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .prefix(FhirString.of("text"))
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .textEquivalent(FhirMarkdown.of("text"))
                        .priority(FhirEnum.of(RequestPriority.values()[0]))
                        .addCode(CodeableConcept.builder().build())
                        .addDocumentation(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .addGoal(Reference.builder().build())
                        .addCondition(RequestOrchestration.Action.Condition.builder()
                                .kind(FhirEnum.of(ActionConditionKind.values()[0]))
                                .build())
                        .addInput(RequestOrchestration.Action.Input.builder().build())
                        .addOutput(RequestOrchestration.Action.Output.builder().build())
                        .addRelatedAction(RequestOrchestration.Action.RelatedAction.builder()
                                .targetId(FhirId.of("id1"))
                                .relationship(FhirEnum.of(ActionRelationshipType.values()[0]))
                                .build())
                        .timing(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .location(CodeableReference.builder().build())
                        .addParticipant(RequestOrchestration.Action.Participant.builder().build())
                        .type(CodeableConcept.builder().build())
                        .groupingBehavior(FhirEnum.of(ActionGroupingBehavior.values()[0]))
                        .selectionBehavior(FhirEnum.of(ActionSelectionBehavior.values()[0]))
                        .requiredBehavior(FhirEnum.of(ActionRequiredBehavior.values()[0]))
                        .precheckBehavior(FhirEnum.of(ActionPrecheckBehavior.values()[0]))
                        .cardinalityBehavior(FhirEnum.of(ActionCardinalityBehavior.values()[0]))
                        .resource(Reference.builder().build())
                        .definition(FhirCanonical.of("http://example.org/canonical"))
                        .transform(FhirCanonical.of("http://example.org/canonical"))
                        .addDynamicValue(RequestOrchestration.Action.DynamicValue.builder().build())
                        .addAction(RequestOrchestration.Action.builder().build())
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
        assertFalse(resource.instantiatesCanonical().isEmpty());
        assertFalse(resource.instantiatesUri().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.replaces().isEmpty());
        assertNotNull(resource.groupIdentifier());
        assertNotNull(resource.status());
        assertNotNull(resource.intent());
        assertNotNull(resource.priority());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.author());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.goal().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.action().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("RequestOrchestration.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<RequestStatus>) null).build()).getMessage());
    }
}
