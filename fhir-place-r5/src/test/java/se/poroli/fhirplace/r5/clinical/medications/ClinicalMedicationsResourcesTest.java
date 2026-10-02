package se.poroli.fhirplace.r5.clinical.medications;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.FormularyItemStatusCodes;
import se.poroli.fhirplace.r5.valuesets.ImmunizationEvaluationStatusCodes;
import se.poroli.fhirplace.r5.valuesets.ImmunizationStatusCodes;
import se.poroli.fhirplace.r5.valuesets.MedicationAdministrationStatusCodes;
import se.poroli.fhirplace.r5.valuesets.MedicationDispenseStatusCodes;
import se.poroli.fhirplace.r5.valuesets.MedicationKnowledgeStatusCodes;
import se.poroli.fhirplace.r5.valuesets.MedicationRequestIntent;
import se.poroli.fhirplace.r5.valuesets.MedicationStatementStatusCodes;
import se.poroli.fhirplace.r5.valuesets.MedicationStatusCodes;
import se.poroli.fhirplace.r5.valuesets.MedicationrequestStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;

/** Builds every clinical.medications resource with all elements and checks the builders and validation. */
class ClinicalMedicationsResourcesTest {

    @Test
    void medicationRequest() {
        MedicationRequest resource = MedicationRequest.builder()
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
                .priorPrescription(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(MedicationrequestStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .statusChanged(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .intent(FhirEnum.of(MedicationRequestIntent.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .doNotPerform(FhirBoolean.of(true))
                .medication(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .addInformationSource(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .reported(FhirBoolean.of(true))
                .performerType(CodeableConcept.builder().build())
                .addPerformer(Reference.builder().build())
                .addDevice(CodeableReference.builder().build())
                .recorder(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .courseOfTherapyType(CodeableConcept.builder().build())
                .addInsurance(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .renderedDosageInstruction(FhirMarkdown.of("text"))
                .effectiveDosePeriod(Period.builder().build())
                .addDosageInstruction(Dosage.builder().build())
                .dispenseRequest(MedicationRequest.DispenseRequest.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .initialFill(MedicationRequest.DispenseRequest.InitialFill.builder().build())
                        .dispenseInterval(Duration.builder().build())
                        .validityPeriod(Period.builder().build())
                        .numberOfRepeatsAllowed(FhirUnsignedInt.of(0))
                        .quantity(Quantity.builder().build())
                        .expectedSupplyDuration(Duration.builder().build())
                        .dispenser(Reference.builder().build())
                        .addDispenserInstruction(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .doseAdministrationAid(CodeableConcept.builder().build())
                        .build())
                .substitution(MedicationRequest.Substitution.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .allowed(FhirBoolean.of(true))
                        .reason(CodeableConcept.builder().build())
                        .build())
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
        assertNotNull(resource.priorPrescription());
        assertNotNull(resource.groupIdentifier());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.statusChanged());
        assertNotNull(resource.intent());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.priority());
        assertNotNull(resource.doNotPerform());
        assertNotNull(resource.medication());
        assertNotNull(resource.subject());
        assertFalse(resource.informationSource().isEmpty());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.requester());
        assertNotNull(resource.reported());
        assertNotNull(resource.performerType());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.device().isEmpty());
        assertNotNull(resource.recorder());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.courseOfTherapyType());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.renderedDosageInstruction());
        assertNotNull(resource.effectiveDosePeriod());
        assertFalse(resource.dosageInstruction().isEmpty());
        assertNotNull(resource.dispenseRequest());
        assertNotNull(resource.substitution());
        assertFalse(resource.eventHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MedicationRequest.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<MedicationrequestStatus>) null).build()).getMessage());
    }

    @Test
    void medicationAdministration() {
        MedicationAdministration resource = MedicationAdministration.builder()
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
                .status(FhirEnum.of(MedicationAdministrationStatusCodes.values()[0]))
                .addStatusReason(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .medication(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .occurence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .recorded(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .isSubPotent(FhirBoolean.of(true))
                .addSubPotentReason(CodeableConcept.builder().build())
                .addPerformer(MedicationAdministration.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(CodeableReference.builder().build())
                        .build())
                .addReason(CodeableReference.builder().build())
                .request(Reference.builder().build())
                .addDevice(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .dosage(MedicationAdministration.MedicationAdministrationDosage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .text(FhirString.of("text"))
                        .site(CodeableConcept.builder().build())
                        .route(CodeableConcept.builder().build())
                        .method(CodeableConcept.builder().build())
                        .dose(Quantity.builder().build())
                        .rate(Ratio.builder().build())
                        .build())
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
        assertFalse(resource.statusReason().isEmpty());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.medication());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertNotNull(resource.occurence());
        assertNotNull(resource.recorded());
        assertNotNull(resource.isSubPotent());
        assertFalse(resource.subPotentReason().isEmpty());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.request());
        assertFalse(resource.device().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.dosage());
        assertFalse(resource.eventHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MedicationAdministration.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<MedicationAdministrationStatusCodes>) null).build()).getMessage());
    }

    @Test
    void medicationDispense() {
        MedicationDispense resource = MedicationDispense.builder()
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
                .status(FhirEnum.of(MedicationDispenseStatusCodes.values()[0]))
                .notPerformedReason(CodeableReference.builder().build())
                .statusChanged(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addCategory(CodeableConcept.builder().build())
                .medication(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .addPerformer(MedicationDispense.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .location(Reference.builder().build())
                .addAuthorizingPrescription(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .quantity(Quantity.builder().build())
                .daysSupply(Quantity.builder().build())
                .recorded(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .whenPrepared(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .whenHandedOver(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .destination(Reference.builder().build())
                .addReceiver(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .renderedDosageInstruction(FhirMarkdown.of("text"))
                .addDosageInstruction(Dosage.builder().build())
                .substitution(MedicationDispense.Substitution.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .wasSubstituted(FhirBoolean.of(true))
                        .type(CodeableConcept.builder().build())
                        .addReason(CodeableConcept.builder().build())
                        .responsibleParty(Reference.builder().build())
                        .build())
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
        assertNotNull(resource.notPerformedReason());
        assertNotNull(resource.statusChanged());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.medication());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.authorizingPrescription().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.quantity());
        assertNotNull(resource.daysSupply());
        assertNotNull(resource.recorded());
        assertNotNull(resource.whenPrepared());
        assertNotNull(resource.whenHandedOver());
        assertNotNull(resource.destination());
        assertFalse(resource.receiver().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.renderedDosageInstruction());
        assertFalse(resource.dosageInstruction().isEmpty());
        assertNotNull(resource.substitution());
        assertFalse(resource.eventHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MedicationDispense.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<MedicationDispenseStatusCodes>) null).build()).getMessage());
    }

    @Test
    void medicationStatement() {
        MedicationStatement resource = MedicationStatement.builder()
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
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(MedicationStatementStatusCodes.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .medication(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .effective(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .dateAsserted(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addInformationSource(Reference.builder().build())
                .addDerivedFrom(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addRelatedClinicalInformation(Reference.builder().build())
                .renderedDosageInstruction(FhirMarkdown.of("text"))
                .addDosage(Dosage.builder().build())
                .adherence(MedicationStatement.Adherence.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .reason(CodeableConcept.builder().build())
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
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.medication());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.effective());
        assertNotNull(resource.dateAsserted());
        assertFalse(resource.informationSource().isEmpty());
        assertFalse(resource.derivedFrom().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.relatedClinicalInformation().isEmpty());
        assertNotNull(resource.renderedDosageInstruction());
        assertFalse(resource.dosage().isEmpty());
        assertNotNull(resource.adherence());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MedicationStatement.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<MedicationStatementStatusCodes>) null).build()).getMessage());
    }

    @Test
    void medication() {
        Medication resource = Medication.builder()
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
                .status(FhirEnum.of(MedicationStatusCodes.values()[0]))
                .marketingAuthorizationHolder(Reference.builder().build())
                .doseForm(CodeableConcept.builder().build())
                .totalVolume(Quantity.builder().build())
                .addIngredient(Medication.Ingredient.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .item(CodeableReference.builder().build())
                        .isActive(FhirBoolean.of(true))
                        .strength(Ratio.builder().build())
                        .build())
                .batch(Medication.Batch.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .lotNumber(FhirString.of("text"))
                        .expirationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .definition(Reference.builder().build())
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
        assertNotNull(resource.marketingAuthorizationHolder());
        assertNotNull(resource.doseForm());
        assertNotNull(resource.totalVolume());
        assertFalse(resource.ingredient().isEmpty());
        assertNotNull(resource.batch());
        assertNotNull(resource.definition());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

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
    void immunization() {
        Immunization resource = Immunization.builder()
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
                .status(FhirEnum.of(ImmunizationStatusCodes.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .vaccineCode(CodeableConcept.builder().build())
                .administeredProduct(CodeableReference.builder().build())
                .manufacturer(CodeableReference.builder().build())
                .lotNumber(FhirString.of("text"))
                .expirationDate(FhirDate.parse("2024-01-01"))
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .primarySource(FhirBoolean.of(true))
                .informationSource(CodeableReference.builder().build())
                .location(Reference.builder().build())
                .site(CodeableConcept.builder().build())
                .route(CodeableConcept.builder().build())
                .doseQuantity(Quantity.builder().build())
                .addPerformer(Immunization.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addReason(CodeableReference.builder().build())
                .isSubpotent(FhirBoolean.of(true))
                .addSubpotentReason(CodeableConcept.builder().build())
                .addProgramEligibility(Immunization.ProgramEligibility.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .program(CodeableConcept.builder().build())
                        .programStatus(CodeableConcept.builder().build())
                        .build())
                .fundingSource(CodeableConcept.builder().build())
                .addReaction(Immunization.Reaction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .manifestation(CodeableReference.builder().build())
                        .reported(FhirBoolean.of(true))
                        .build())
                .addProtocolApplied(Immunization.ProtocolApplied.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .series(FhirString.of("text"))
                        .authority(Reference.builder().build())
                        .addTargetDisease(CodeableConcept.builder().build())
                        .doseNumber(FhirString.of("text"))
                        .seriesDoses(FhirString.of("text"))
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
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.vaccineCode());
        assertNotNull(resource.administeredProduct());
        assertNotNull(resource.manufacturer());
        assertNotNull(resource.lotNumber());
        assertNotNull(resource.expirationDate());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.primarySource());
        assertNotNull(resource.informationSource());
        assertNotNull(resource.location());
        assertNotNull(resource.site());
        assertNotNull(resource.route());
        assertNotNull(resource.doseQuantity());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.isSubpotent());
        assertFalse(resource.subpotentReason().isEmpty());
        assertFalse(resource.programEligibility().isEmpty());
        assertNotNull(resource.fundingSource());
        assertFalse(resource.reaction().isEmpty());
        assertFalse(resource.protocolApplied().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Immunization.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ImmunizationStatusCodes>) null).build()).getMessage());
    }

    @Test
    void immunizationEvaluation() {
        ImmunizationEvaluation resource = ImmunizationEvaluation.builder()
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
                .status(FhirEnum.of(ImmunizationEvaluationStatusCodes.values()[0]))
                .patient(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authority(Reference.builder().build())
                .targetDisease(CodeableConcept.builder().build())
                .immunizationEvent(Reference.builder().build())
                .doseStatus(CodeableConcept.builder().build())
                .addDoseStatusReason(CodeableConcept.builder().build())
                .description(FhirMarkdown.of("text"))
                .series(FhirString.of("text"))
                .doseNumber(FhirString.of("text"))
                .seriesDoses(FhirString.of("text"))
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
        assertNotNull(resource.patient());
        assertNotNull(resource.date());
        assertNotNull(resource.authority());
        assertNotNull(resource.targetDisease());
        assertNotNull(resource.immunizationEvent());
        assertNotNull(resource.doseStatus());
        assertFalse(resource.doseStatusReason().isEmpty());
        assertNotNull(resource.description());
        assertNotNull(resource.series());
        assertNotNull(resource.doseNumber());
        assertNotNull(resource.seriesDoses());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImmunizationEvaluation.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<ImmunizationEvaluationStatusCodes>) null).build()).getMessage());
    }

    @Test
    void immunizationRecommendation() {
        ImmunizationRecommendation resource = ImmunizationRecommendation.builder()
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
                .patient(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authority(Reference.builder().build())
                .addRecommendation(ImmunizationRecommendation.Recommendation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addVaccineCode(CodeableConcept.builder().build())
                        .addTargetDisease(CodeableConcept.builder().build())
                        .addContraindicatedVaccineCode(CodeableConcept.builder().build())
                        .forecastStatus(CodeableConcept.builder().build())
                        .addForecastReason(CodeableConcept.builder().build())
                        .addDateCriterion(ImmunizationRecommendation.Recommendation.DateCriterion.builder()
                                .code(CodeableConcept.builder().build())
                                .value(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                                .build())
                        .description(FhirMarkdown.of("text"))
                        .series(FhirString.of("text"))
                        .doseNumber(FhirString.of("text"))
                        .seriesDoses(FhirString.of("text"))
                        .addSupportingImmunization(Reference.builder().build())
                        .addSupportingPatientInformation(Reference.builder().build())
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
        assertNotNull(resource.patient());
        assertNotNull(resource.date());
        assertNotNull(resource.authority());
        assertFalse(resource.recommendation().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImmunizationRecommendation.patient is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().patient((Reference) null).build()).getMessage());
    }

    @Test
    void formularyItem() {
        FormularyItem resource = FormularyItem.builder()
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
                .status(FhirEnum.of(FormularyItemStatusCodes.values()[0]))
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
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
