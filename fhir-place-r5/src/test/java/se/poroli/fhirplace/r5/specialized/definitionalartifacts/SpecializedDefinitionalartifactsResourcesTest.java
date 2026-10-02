package se.poroli.fhirplace.r5.specialized.definitionalartifacts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Age;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.ProductShelfLife;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.datatypes.TriggerDefinition;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.ActionCardinalityBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionConditionKind;
import se.poroli.fhirplace.r5.valuesets.ActionGroupingBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionParticipantType;
import se.poroli.fhirplace.r5.valuesets.ActionPrecheckBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionRelationshipType;
import se.poroli.fhirplace.r5.valuesets.ActionRequiredBehavior;
import se.poroli.fhirplace.r5.valuesets.ActionSelectionBehavior;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;
import se.poroli.fhirplace.r5.valuesets.ConditionPreconditionType;
import se.poroli.fhirplace.r5.valuesets.ConditionQuestionnairePurpose;
import se.poroli.fhirplace.r5.valuesets.ConformanceExpectation;
import se.poroli.fhirplace.r5.valuesets.DeviceCorrectiveActionScope;
import se.poroli.fhirplace.r5.valuesets.DeviceDefinitionRegulatoryIdentifierType;
import se.poroli.fhirplace.r5.valuesets.DeviceNameType;
import se.poroli.fhirplace.r5.valuesets.DeviceProductionIdentifierInUDI;
import se.poroli.fhirplace.r5.valuesets.EnableWhenBehavior;
import se.poroli.fhirplace.r5.valuesets.ExampleScenarioActorType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.ObservationDataType;
import se.poroli.fhirplace.r5.valuesets.ObservationRangeCategory;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.QuestionnaireAnswerConstraint;
import se.poroli.fhirplace.r5.valuesets.QuestionnaireItemDisabledDisplay;
import se.poroli.fhirplace.r5.valuesets.QuestionnaireItemOperator;
import se.poroli.fhirplace.r5.valuesets.QuestionnaireItemType;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.RequestIntent;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;
import se.poroli.fhirplace.r5.valuesets.RequestResourceTypes;
import se.poroli.fhirplace.r5.valuesets.ResourceType;
import se.poroli.fhirplace.r5.valuesets.SpecimenContainedPreference;
import se.poroli.fhirplace.r5.valuesets.TriggerType;

/** Builds every specialized.definitionalartifacts resource with all elements and checks the builders and validation. */
class SpecializedDefinitionalartifactsResourcesTest {

    @Test
    void activityDefinition() {
        ActivityDefinition resource = ActivityDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .subtitle(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .subject(CodeableConcept.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .usage(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .addLibrary(FhirCanonical.of("http://example.org/canonical"))
                .kind(FhirEnum.of(RequestResourceTypes.values()[0]))
                .profile(FhirCanonical.of("http://example.org/canonical"))
                .code(CodeableConcept.builder().build())
                .intent(FhirEnum.of(RequestIntent.values()[0]))
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .doNotPerform(FhirBoolean.of(true))
                .timing(Timing.builder().build())
                .asNeeded(FhirBoolean.of(true))
                .location(CodeableReference.builder().build())
                .addParticipant(ActivityDefinition.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(ActionParticipantType.values()[0]))
                        .typeCanonical(FhirCanonical.of("http://example.org/canonical"))
                        .typeReference(Reference.builder().build())
                        .role(CodeableConcept.builder().build())
                        .function(CodeableConcept.builder().build())
                        .build())
                .product(Reference.builder().build())
                .quantity(Quantity.builder().build())
                .addDosage(Dosage.builder().build())
                .addBodySite(CodeableConcept.builder().build())
                .addSpecimenRequirement(FhirCanonical.of("http://example.org/canonical"))
                .addObservationRequirement(FhirCanonical.of("http://example.org/canonical"))
                .addObservationResultRequirement(FhirCanonical.of("http://example.org/canonical"))
                .transform(FhirCanonical.of("http://example.org/canonical"))
                .addDynamicValue(ActivityDefinition.DynamicValue.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .path(FhirString.of("text"))
                        .expression(Expression.builder().build())
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
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.subtitle());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.usage());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertFalse(resource.library().isEmpty());
        assertNotNull(resource.kind());
        assertNotNull(resource.profile());
        assertNotNull(resource.code());
        assertNotNull(resource.intent());
        assertNotNull(resource.priority());
        assertNotNull(resource.doNotPerform());
        assertNotNull(resource.timing());
        assertNotNull(resource.asNeeded());
        assertNotNull(resource.location());
        assertFalse(resource.participant().isEmpty());
        assertNotNull(resource.product());
        assertNotNull(resource.quantity());
        assertFalse(resource.dosage().isEmpty());
        assertFalse(resource.bodySite().isEmpty());
        assertFalse(resource.specimenRequirement().isEmpty());
        assertFalse(resource.observationRequirement().isEmpty());
        assertFalse(resource.observationResultRequirement().isEmpty());
        assertNotNull(resource.transform());
        assertFalse(resource.dynamicValue().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ActivityDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void conditionDefinition() {
        ConditionDefinition resource = ConditionDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .subtitle(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .severity(CodeableConcept.builder().build())
                .bodySite(CodeableConcept.builder().build())
                .stage(CodeableConcept.builder().build())
                .hasSeverity(FhirBoolean.of(true))
                .hasBodySite(FhirBoolean.of(true))
                .hasStage(FhirBoolean.of(true))
                .addDefinition(FhirUri.of("http://example.org/uri"))
                .addObservation(ConditionDefinition.Observation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .code(CodeableConcept.builder().build())
                        .build())
                .addMedication(ConditionDefinition.Medication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .code(CodeableConcept.builder().build())
                        .build())
                .addPrecondition(ConditionDefinition.Precondition.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(ConditionPreconditionType.values()[0]))
                        .code(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addTeam(Reference.builder().build())
                .addQuestionnaire(ConditionDefinition.Questionnaire.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .purpose(FhirEnum.of(ConditionQuestionnairePurpose.values()[0]))
                        .reference(Reference.builder().build())
                        .build())
                .addPlan(ConditionDefinition.Plan.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(CodeableConcept.builder().build())
                        .reference(Reference.builder().build())
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
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.subtitle());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.severity());
        assertNotNull(resource.bodySite());
        assertNotNull(resource.stage());
        assertNotNull(resource.hasSeverity());
        assertNotNull(resource.hasBodySite());
        assertNotNull(resource.hasStage());
        assertFalse(resource.definition().isEmpty());
        assertFalse(resource.observation().isEmpty());
        assertFalse(resource.medication().isEmpty());
        assertFalse(resource.precondition().isEmpty());
        assertFalse(resource.team().isEmpty());
        assertFalse(resource.questionnaire().isEmpty());
        assertFalse(resource.plan().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ConditionDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

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
    void eventDefinition() {
        EventDefinition resource = EventDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .subtitle(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .subject(CodeableConcept.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .usage(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .addTrigger(TriggerDefinition.builder()
                        .type(FhirEnum.of(TriggerType.values()[0]))
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
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.subtitle());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.usage());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertFalse(resource.trigger().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("EventDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void observationDefinition() {
        ObservationDefinition resource = ObservationDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .identifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addDerivedFromCanonical(FhirCanonical.of("http://example.org/canonical"))
                .addDerivedFromUri(FhirUri.of("http://example.org/uri"))
                .addSubject(CodeableConcept.builder().build())
                .performerType(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .addPermittedDataType(FhirEnum.of(ObservationDataType.values()[0]))
                .multipleResultsAllowed(FhirBoolean.of(true))
                .bodySite(CodeableConcept.builder().build())
                .method(CodeableConcept.builder().build())
                .addSpecimen(Reference.builder().build())
                .addDevice(Reference.builder().build())
                .preferredReportName(FhirString.of("text"))
                .addPermittedUnit(Coding.builder().build())
                .addQualifiedValue(ObservationDefinition.QualifiedValue.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .context(CodeableConcept.builder().build())
                        .addAppliesTo(CodeableConcept.builder().build())
                        .gender(FhirEnum.of(AdministrativeGender.values()[0]))
                        .age(Range.builder().build())
                        .gestationalAge(Range.builder().build())
                        .condition(FhirString.of("text"))
                        .rangeCategory(FhirEnum.of(ObservationRangeCategory.values()[0]))
                        .range(Range.builder().build())
                        .validCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .normalCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .abnormalCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .criticalCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .build())
                .addHasMember(Reference.builder().build())
                .addComponent(ObservationDefinition.Component.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .addPermittedDataType(FhirEnum.of(ObservationDataType.values()[0]))
                        .addPermittedUnit(Coding.builder().build())
                        .addQualifiedValue(ObservationDefinition.QualifiedValue.builder().build())
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
        assertNotNull(resource.url());
        assertNotNull(resource.identifier());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.derivedFromCanonical().isEmpty());
        assertFalse(resource.derivedFromUri().isEmpty());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.performerType());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertFalse(resource.permittedDataType().isEmpty());
        assertNotNull(resource.multipleResultsAllowed());
        assertNotNull(resource.bodySite());
        assertNotNull(resource.method());
        assertFalse(resource.specimen().isEmpty());
        assertFalse(resource.device().isEmpty());
        assertNotNull(resource.preferredReportName());
        assertFalse(resource.permittedUnit().isEmpty());
        assertFalse(resource.qualifiedValue().isEmpty());
        assertFalse(resource.hasMember().isEmpty());
        assertFalse(resource.component().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ObservationDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void planDefinition() {
        PlanDefinition resource = PlanDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .subtitle(FhirString.of("text"))
                .type(CodeableConcept.builder().build())
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .subject(CodeableConcept.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .usage(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .addLibrary(FhirCanonical.of("http://example.org/canonical"))
                .addGoal(PlanDefinition.Goal.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .description(CodeableConcept.builder().build())
                        .priority(CodeableConcept.builder().build())
                        .start(CodeableConcept.builder().build())
                        .addAddresses(CodeableConcept.builder().build())
                        .addDocumentation(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .addTarget(PlanDefinition.Goal.Target.builder().build())
                        .build())
                .addActor(PlanDefinition.Actor.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .addOption(PlanDefinition.Actor.Option.builder().build())
                        .build())
                .addAction(PlanDefinition.Action.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .prefix(FhirString.of("text"))
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .textEquivalent(FhirMarkdown.of("text"))
                        .priority(FhirEnum.of(RequestPriority.values()[0]))
                        .code(CodeableConcept.builder().build())
                        .addReason(CodeableConcept.builder().build())
                        .addDocumentation(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .addGoalId(FhirId.of("id1"))
                        .subject(CodeableConcept.builder().build())
                        .addTrigger(TriggerDefinition.builder()
                                .type(FhirEnum.of(TriggerType.values()[0]))
                                .build())
                        .addCondition(PlanDefinition.Action.Condition.builder()
                                .kind(FhirEnum.of(ActionConditionKind.values()[0]))
                                .build())
                        .addInput(PlanDefinition.Action.Input.builder().build())
                        .addOutput(PlanDefinition.Action.Output.builder().build())
                        .addRelatedAction(PlanDefinition.Action.RelatedAction.builder()
                                .targetId(FhirId.of("id1"))
                                .relationship(FhirEnum.of(ActionRelationshipType.values()[0]))
                                .build())
                        .timing(Age.builder().build())
                        .location(CodeableReference.builder().build())
                        .addParticipant(PlanDefinition.Action.Participant.builder().build())
                        .type(CodeableConcept.builder().build())
                        .groupingBehavior(FhirEnum.of(ActionGroupingBehavior.values()[0]))
                        .selectionBehavior(FhirEnum.of(ActionSelectionBehavior.values()[0]))
                        .requiredBehavior(FhirEnum.of(ActionRequiredBehavior.values()[0]))
                        .precheckBehavior(FhirEnum.of(ActionPrecheckBehavior.values()[0]))
                        .cardinalityBehavior(FhirEnum.of(ActionCardinalityBehavior.values()[0]))
                        .definition(FhirCanonical.of("http://example.org/canonical"))
                        .transform(FhirCanonical.of("http://example.org/canonical"))
                        .addDynamicValue(PlanDefinition.Action.DynamicValue.builder().build())
                        .addAction(PlanDefinition.Action.builder().build())
                        .build())
                .asNeeded(FhirBoolean.of(true))
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.subtitle());
        assertNotNull(resource.type());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.usage());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertFalse(resource.library().isEmpty());
        assertFalse(resource.goal().isEmpty());
        assertFalse(resource.actor().isEmpty());
        assertFalse(resource.action().isEmpty());
        assertNotNull(resource.asNeeded());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("PlanDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void questionnaire() {
        Questionnaire resource = Questionnaire.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .addDerivedFrom(FhirCanonical.of("http://example.org/canonical"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .addSubjectType(FhirEnum.of(ResourceType.values()[0]))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addCode(Coding.builder().build())
                .addItem(Questionnaire.Item.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .definition(FhirUri.of("http://example.org/uri"))
                        .addCode(Coding.builder().build())
                        .prefix(FhirString.of("text"))
                        .text(FhirString.of("text"))
                        .type(FhirEnum.of(QuestionnaireItemType.values()[0]))
                        .addEnableWhen(Questionnaire.Item.EnableWhen.builder()
                                .question(FhirString.of("text"))
                                .operator(FhirEnum.of(QuestionnaireItemOperator.values()[0]))
                                .answer(FhirBoolean.of(true))
                                .build())
                        .enableBehavior(FhirEnum.of(EnableWhenBehavior.values()[0]))
                        .disabledDisplay(FhirEnum.of(QuestionnaireItemDisabledDisplay.values()[0]))
                        .required(FhirBoolean.of(true))
                        .repeats(FhirBoolean.of(true))
                        .readOnly(FhirBoolean.of(true))
                        .maxLength(FhirInteger.of(1))
                        .answerConstraint(FhirEnum.of(QuestionnaireAnswerConstraint.values()[0]))
                        .answerValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .addAnswerOption(Questionnaire.Item.AnswerOption.builder()
                                .value(FhirInteger.of(1))
                                .build())
                        .addInitial(Questionnaire.Item.Initial.builder()
                                .value(FhirBoolean.of(true))
                                .build())
                        .addItem(Questionnaire.Item.builder()
                                .linkId(FhirString.of("text"))
                                .type(FhirEnum.of(QuestionnaireItemType.values()[0]))
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
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertFalse(resource.derivedFrom().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertFalse(resource.subjectType().isEmpty());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.item().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Questionnaire.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void specimenDefinition() {
        SpecimenDefinition resource = SpecimenDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .identifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .addDerivedFromCanonical(FhirCanonical.of("http://example.org/canonical"))
                .addDerivedFromUri(FhirUri.of("http://example.org/uri"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .subject(CodeableConcept.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .typeCollected(CodeableConcept.builder().build())
                .addPatientPreparation(CodeableConcept.builder().build())
                .timeAspect(FhirString.of("text"))
                .addCollection(CodeableConcept.builder().build())
                .addTypeTested(SpecimenDefinition.TypeTested.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .isDerived(FhirBoolean.of(true))
                        .type(CodeableConcept.builder().build())
                        .preference(FhirEnum.of(SpecimenContainedPreference.values()[0]))
                        .container(SpecimenDefinition.TypeTested.Container.builder().build())
                        .requirement(FhirMarkdown.of("text"))
                        .retentionTime(Duration.builder().build())
                        .singleUse(FhirBoolean.of(true))
                        .addRejectionCriterion(CodeableConcept.builder().build())
                        .addHandling(SpecimenDefinition.TypeTested.Handling.builder().build())
                        .addTestingDestination(CodeableConcept.builder().build())
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
        assertNotNull(resource.url());
        assertNotNull(resource.identifier());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertFalse(resource.derivedFromCanonical().isEmpty());
        assertFalse(resource.derivedFromUri().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertNotNull(resource.typeCollected());
        assertFalse(resource.patientPreparation().isEmpty());
        assertNotNull(resource.timeAspect());
        assertFalse(resource.collection().isEmpty());
        assertFalse(resource.typeTested().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("SpecimenDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void exampleScenario() {
        ExampleScenario resource = ExampleScenario.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .addActor(ExampleScenario.Actor.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .key(FhirString.of("text"))
                        .type(FhirEnum.of(ExampleScenarioActorType.values()[0]))
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .build())
                .addInstance(ExampleScenario.Instance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .key(FhirString.of("text"))
                        .structureType(Coding.builder().build())
                        .structureVersion(FhirString.of("text"))
                        .structureProfile(FhirCanonical.of("http://example.org/canonical"))
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .content(Reference.builder().build())
                        .addVersion(ExampleScenario.Instance.Version.builder()
                                .key(FhirString.of("text"))
                                .title(FhirString.of("text"))
                                .build())
                        .addContainedInstance(ExampleScenario.Instance.ContainedInstance.builder()
                                .instanceReference(FhirString.of("text"))
                                .build())
                        .build())
                .addProcess(ExampleScenario.Process.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .title(FhirString.of("text"))
                        .description(FhirMarkdown.of("text"))
                        .preConditions(FhirMarkdown.of("text"))
                        .postConditions(FhirMarkdown.of("text"))
                        .addStep(ExampleScenario.Process.Step.builder().build())
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
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertFalse(resource.actor().isEmpty());
        assertFalse(resource.instance().isEmpty());
        assertFalse(resource.process().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ExampleScenario.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void actorDefinition() {
        ActorDefinition resource = ActorDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .type(FhirEnum.of(ExampleScenarioActorType.values()[0]))
                .documentation(FhirMarkdown.of("text"))
                .addReference(FhirUrl.of("http://example.org/url"))
                .capabilities(FhirCanonical.of("http://example.org/canonical"))
                .addDerivedFrom(FhirCanonical.of("http://example.org/canonical"))
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.type());
        assertNotNull(resource.documentation());
        assertFalse(resource.reference().isEmpty());
        assertNotNull(resource.capabilities());
        assertFalse(resource.derivedFrom().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ActorDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void requirements() {
        Requirements resource = Requirements.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .addDerivedFrom(FhirCanonical.of("http://example.org/canonical"))
                .addReference(FhirUrl.of("http://example.org/url"))
                .addActor(FhirCanonical.of("http://example.org/canonical"))
                .addStatement(Requirements.Statement.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .key(FhirId.of("id1"))
                        .label(FhirString.of("text"))
                        .addConformance(FhirEnum.of(ConformanceExpectation.values()[0]))
                        .conditionality(FhirBoolean.of(true))
                        .requirement(FhirMarkdown.of("text"))
                        .derivedFrom(FhirString.of("text"))
                        .parent(FhirString.of("text"))
                        .addSatisfiedBy(FhirUrl.of("http://example.org/url"))
                        .addReference(FhirUrl.of("http://example.org/url"))
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
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertFalse(resource.derivedFrom().isEmpty());
        assertFalse(resource.reference().isEmpty());
        assertFalse(resource.actor().isEmpty());
        assertFalse(resource.statement().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Requirements.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
