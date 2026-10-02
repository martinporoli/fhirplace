package se.poroli.fhirplace.r5.valuesets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CodedEnumTest {

    private static Arguments codes(CodedEnum[] values, Function<String, CodedEnum> fromCode) {
        return Arguments.of(values, fromCode);
    }

    static Stream<Arguments> enums() {
        return Stream.of(
                codes(AccountStatus.values(), AccountStatus::fromCode),
                codes(ActionCardinalityBehavior.values(), ActionCardinalityBehavior::fromCode),
                codes(ActionConditionKind.values(), ActionConditionKind::fromCode),
                codes(ActionGroupingBehavior.values(), ActionGroupingBehavior::fromCode),
                codes(ActionParticipantType.values(), ActionParticipantType::fromCode),
                codes(ActionPrecheckBehavior.values(), ActionPrecheckBehavior::fromCode),
                codes(ActionRelationshipType.values(), ActionRelationshipType::fromCode),
                codes(ActionRequiredBehavior.values(), ActionRequiredBehavior::fromCode),
                codes(ActionSelectionBehavior.values(), ActionSelectionBehavior::fromCode),
                codes(AdditionalBindingPurposeVS.values(), AdditionalBindingPurposeVS::fromCode),
                codes(AddressType.values(), AddressType::fromCode),
                codes(AddressUse.values(), AddressUse::fromCode),
                codes(AdministrativeGender.values(), AdministrativeGender::fromCode),
                codes(AdverseEventActuality.values(), AdverseEventActuality::fromCode),
                codes(AdverseEventStatus.values(), AdverseEventStatus::fromCode),
                codes(AggregationMode.values(), AggregationMode::fromCode),
                codes(AllergyIntoleranceCategory.values(), AllergyIntoleranceCategory::fromCode),
                codes(AllergyIntoleranceCriticality.values(), AllergyIntoleranceCriticality::fromCode),
                codes(AllergyIntoleranceSeverity.values(), AllergyIntoleranceSeverity::fromCode),
                codes(AppointmentStatus.values(), AppointmentStatus::fromCode),
                codes(ArtifactAssessmentDisposition.values(), ArtifactAssessmentDisposition::fromCode),
                codes(ArtifactAssessmentInformationType.values(), ArtifactAssessmentInformationType::fromCode),
                codes(ArtifactAssessmentWorkflowStatus.values(), ArtifactAssessmentWorkflowStatus::fromCode),
                codes(AssertionDirectionType.values(), AssertionDirectionType::fromCode),
                codes(AssertionManualCompletionType.values(), AssertionManualCompletionType::fromCode),
                codes(AssertionOperatorType.values(), AssertionOperatorType::fromCode),
                codes(AssertionResponseTypes.values(), AssertionResponseTypes::fromCode),
                codes(AuditEventAction.values(), AuditEventAction::fromCode),
                codes(AuditEventSeverity.values(), AuditEventSeverity::fromCode),
                codes(BindingStrength.values(), BindingStrength::fromCode),
                codes(BiologicallyDerivedProductDispenseCodes.values(),
                        BiologicallyDerivedProductDispenseCodes::fromCode),
                codes(BundleType.values(), BundleType::fromCode),
                codes(CapabilityStatementKind.values(), CapabilityStatementKind::fromCode),
                codes(CarePlanIntent.values(), CarePlanIntent::fromCode),
                codes(CareTeamStatus.values(), CareTeamStatus::fromCode),
                codes(CharacteristicCombination.values(), CharacteristicCombination::fromCode),
                codes(ChargeItemStatus.values(), ChargeItemStatus::fromCode),
                codes(ClaimProcessingCodes.values(), ClaimProcessingCodes::fromCode),
                codes(ClinicalUseDefinitionType.values(), ClinicalUseDefinitionType::fromCode),
                codes(CodeSearchSupport.values(), CodeSearchSupport::fromCode),
                codes(CodeSystemContentMode.values(), CodeSystemContentMode::fromCode),
                codes(CodeSystemHierarchyMeaning.values(), CodeSystemHierarchyMeaning::fromCode),
                codes(CommonLanguages.values(), CommonLanguages::fromCode),
                codes(CompartmentType.values(), CompartmentType::fromCode),
                codes(CompositionStatus.values(), CompositionStatus::fromCode),
                codes(ConceptMapAttributeType.values(), ConceptMapAttributeType::fromCode),
                codes(ConceptMapGroupUnmappedMode.values(), ConceptMapGroupUnmappedMode::fromCode),
                codes(ConceptMapPropertyType.values(), ConceptMapPropertyType::fromCode),
                codes(ConceptMapRelationship.values(), ConceptMapRelationship::fromCode),
                codes(ConditionPreconditionType.values(), ConditionPreconditionType::fromCode),
                codes(ConditionQuestionnairePurpose.values(), ConditionQuestionnairePurpose::fromCode),
                codes(ConditionalDeleteStatus.values(), ConditionalDeleteStatus::fromCode),
                codes(ConditionalReadStatus.values(), ConditionalReadStatus::fromCode),
                codes(ConformanceExpectation.values(), ConformanceExpectation::fromCode),
                codes(ConsentDataMeaning.values(), ConsentDataMeaning::fromCode),
                codes(ConsentProvisionType.values(), ConsentProvisionType::fromCode),
                codes(ConsentState.values(), ConsentState::fromCode),
                codes(ConstraintSeverity.values(), ConstraintSeverity::fromCode),
                codes(ContactPointSystem.values(), ContactPointSystem::fromCode),
                codes(ContactPointUse.values(), ContactPointUse::fromCode),
                codes(ContractResourcePublicationStatusCodes.values(),
                        ContractResourcePublicationStatusCodes::fromCode),
                codes(ContractResourceStatusCodes.values(), ContractResourceStatusCodes::fromCode),
                codes(ContributorType.values(), ContributorType::fromCode),
                codes(CriteriaNotExistsBehavior.values(), CriteriaNotExistsBehavior::fromCode),
                codes(DaysOfWeek.values(), DaysOfWeek::fromCode),
                codes(DetectedIssueSeverity.values(), DetectedIssueSeverity::fromCode),
                codes(DeviceCorrectiveActionScope.values(), DeviceCorrectiveActionScope::fromCode),
                codes(DeviceDefinitionRegulatoryIdentifierType.values(),
                        DeviceDefinitionRegulatoryIdentifierType::fromCode),
                codes(DeviceDispenseStatusCodes.values(), DeviceDispenseStatusCodes::fromCode),
                codes(DeviceMetricCalibrationState.values(), DeviceMetricCalibrationState::fromCode),
                codes(DeviceMetricCalibrationType.values(), DeviceMetricCalibrationType::fromCode),
                codes(DeviceMetricCategory.values(), DeviceMetricCategory::fromCode),
                codes(DeviceMetricOperationalStatus.values(), DeviceMetricOperationalStatus::fromCode),
                codes(DeviceNameType.values(), DeviceNameType::fromCode),
                codes(DeviceProductionIdentifierInUDI.values(), DeviceProductionIdentifierInUDI::fromCode),
                codes(DeviceUsageStatus.values(), DeviceUsageStatus::fromCode),
                codes(DiagnosticReportStatus.values(), DiagnosticReportStatus::fromCode),
                codes(DiscriminatorType.values(), DiscriminatorType::fromCode),
                codes(DocumentMode.values(), DocumentMode::fromCode),
                codes(DocumentReferenceStatus.values(), DocumentReferenceStatus::fromCode),
                codes(EligibilityOutcome.values(), EligibilityOutcome::fromCode),
                codes(EligibilityRequestPurpose.values(), EligibilityRequestPurpose::fromCode),
                codes(EligibilityResponsePurpose.values(), EligibilityResponsePurpose::fromCode),
                codes(EnableWhenBehavior.values(), EnableWhenBehavior::fromCode),
                codes(EncounterLocationStatus.values(), EncounterLocationStatus::fromCode),
                codes(EncounterStatus.values(), EncounterStatus::fromCode),
                codes(EndpointStatus.values(), EndpointStatus::fromCode),
                codes(EnrollmentOutcome.values(), EnrollmentOutcome::fromCode),
                codes(EpisodeOfCareStatus.values(), EpisodeOfCareStatus::fromCode),
                codes(EventCapabilityMode.values(), EventCapabilityMode::fromCode),
                codes(EventStatus.values(), EventStatus::fromCode),
                codes(EvidenceVariableHandling.values(), EvidenceVariableHandling::fromCode),
                codes(ExampleScenarioActorType.values(), ExampleScenarioActorType::fromCode),
                codes(ExplanationOfBenefitStatus.values(), ExplanationOfBenefitStatus::fromCode),
                codes(ExtensionContextType.values(), ExtensionContextType::fromCode),
                codes(FHIRDeviceStatus.values(), FHIRDeviceStatus::fromCode),
                codes(FHIRSubstanceStatus.values(), FHIRSubstanceStatus::fromCode),
                codes(FHIRTypes.values(), FHIRTypes::fromCode),
                codes(FHIRVersion.values(), FHIRVersion::fromCode),
                codes(FamilyHistoryStatus.values(), FamilyHistoryStatus::fromCode),
                codes(FilterOperator.values(), FilterOperator::fromCode),
                codes(FinancialResourceStatusCodes.values(), FinancialResourceStatusCodes::fromCode),
                codes(FlagStatus.values(), FlagStatus::fromCode),
                codes(FormularyItemStatusCodes.values(), FormularyItemStatusCodes::fromCode),
                codes(GenomicStudyStatus.values(), GenomicStudyStatus::fromCode),
                codes(GoalLifecycleStatus.values(), GoalLifecycleStatus::fromCode),
                codes(GraphCompartmentRule.values(), GraphCompartmentRule::fromCode),
                codes(GraphCompartmentUse.values(), GraphCompartmentUse::fromCode),
                codes(GroupMembershipBasis.values(), GroupMembershipBasis::fromCode),
                codes(GroupType.values(), GroupType::fromCode),
                codes(GuidanceResponseStatus.values(), GuidanceResponseStatus::fromCode),
                codes(GuidePageGeneration.values(), GuidePageGeneration::fromCode),
                codes(HTTPVerb.values(), HTTPVerb::fromCode),
                codes(IdentifierUse.values(), IdentifierUse::fromCode),
                codes(IdentityAssuranceLevel.values(), IdentityAssuranceLevel::fromCode),
                codes(ImagingSelection2DGraphicType.values(), ImagingSelection2DGraphicType::fromCode),
                codes(ImagingSelection3DGraphicType.values(), ImagingSelection3DGraphicType::fromCode),
                codes(ImagingSelectionStatus.values(), ImagingSelectionStatus::fromCode),
                codes(ImagingStudyStatus.values(), ImagingStudyStatus::fromCode),
                codes(ImmunizationEvaluationStatusCodes.values(), ImmunizationEvaluationStatusCodes::fromCode),
                codes(ImmunizationStatusCodes.values(), ImmunizationStatusCodes::fromCode),
                codes(IngredientManufacturerRole.values(), IngredientManufacturerRole::fromCode),
                codes(InteractionTrigger.values(), InteractionTrigger::fromCode),
                codes(InventoryCountType.values(), InventoryCountType::fromCode),
                codes(InventoryItemStatusCodes.values(), InventoryItemStatusCodes::fromCode),
                codes(InventoryReportStatus.values(), InventoryReportStatus::fromCode),
                codes(InvoiceStatus.values(), InvoiceStatus::fromCode),
                codes(IssueSeverity.values(), IssueSeverity::fromCode),
                codes(IssueType.values(), IssueType::fromCode),
                codes(Kind.values(), Kind::fromCode),
                codes(LinkRelationTypes.values(), LinkRelationTypes::fromCode),
                codes(LinkType.values(), LinkType::fromCode),
                codes(LinkageType.values(), LinkageType::fromCode),
                codes(ListMode.values(), ListMode::fromCode),
                codes(ListStatus.values(), ListStatus::fromCode),
                codes(LocationMode.values(), LocationMode::fromCode),
                codes(LocationStatus.values(), LocationStatus::fromCode),
                codes(MeasureReportStatus.values(), MeasureReportStatus::fromCode),
                codes(MeasureReportType.values(), MeasureReportType::fromCode),
                codes(MedicationAdministrationStatusCodes.values(), MedicationAdministrationStatusCodes::fromCode),
                codes(MedicationDispenseStatusCodes.values(), MedicationDispenseStatusCodes::fromCode),
                codes(MedicationKnowledgeStatusCodes.values(), MedicationKnowledgeStatusCodes::fromCode),
                codes(MedicationRequestIntent.values(), MedicationRequestIntent::fromCode),
                codes(MedicationStatementStatusCodes.values(), MedicationStatementStatusCodes::fromCode),
                codes(MedicationStatusCodes.values(), MedicationStatusCodes::fromCode),
                codes(MedicationrequestStatus.values(), MedicationrequestStatus::fromCode),
                codes(MessageSignificanceCategory.values(), MessageSignificanceCategory::fromCode),
                codes(MessageheaderResponseRequest.values(), MessageheaderResponseRequest::fromCode),
                codes(NameUse.values(), NameUse::fromCode),
                codes(NamingSystemIdentifierType.values(), NamingSystemIdentifierType::fromCode),
                codes(NamingSystemType.values(), NamingSystemType::fromCode),
                codes(NarrativeStatus.values(), NarrativeStatus::fromCode),
                codes(NoteType.values(), NoteType::fromCode),
                codes(NutritionProductStatus.values(), NutritionProductStatus::fromCode),
                codes(ObservationDataType.values(), ObservationDataType::fromCode),
                codes(ObservationRangeCategory.values(), ObservationRangeCategory::fromCode),
                codes(ObservationStatus.values(), ObservationStatus::fromCode),
                codes(OperationKind.values(), OperationKind::fromCode),
                codes(OperationParameterScope.values(), OperationParameterScope::fromCode),
                codes(OperationParameterUse.values(), OperationParameterUse::fromCode),
                codes(OrientationType.values(), OrientationType::fromCode),
                codes(ParticipationStatus.values(), ParticipationStatus::fromCode),
                codes(PaymentOutcome.values(), PaymentOutcome::fromCode),
                codes(PermissionRuleCombining.values(), PermissionRuleCombining::fromCode),
                codes(PermissionStatus.values(), PermissionStatus::fromCode),
                codes(PriceComponentType.values(), PriceComponentType::fromCode),
                codes(PropertyRepresentation.values(), PropertyRepresentation::fromCode),
                codes(PropertyType.values(), PropertyType::fromCode),
                codes(ProvenanceEntityRole.values(), ProvenanceEntityRole::fromCode),
                codes(PublicationStatus.values(), PublicationStatus::fromCode),
                codes(QuantityComparator.values(), QuantityComparator::fromCode),
                codes(QuestionnaireAnswerConstraint.values(), QuestionnaireAnswerConstraint::fromCode),
                codes(QuestionnaireItemDisabledDisplay.values(), QuestionnaireItemDisabledDisplay::fromCode),
                codes(QuestionnaireItemOperator.values(), QuestionnaireItemOperator::fromCode),
                codes(QuestionnaireItemType.values(), QuestionnaireItemType::fromCode),
                codes(QuestionnaireResponseStatus.values(), QuestionnaireResponseStatus::fromCode),
                codes(ReferenceHandlingPolicy.values(), ReferenceHandlingPolicy::fromCode),
                codes(ReferenceVersionRules.values(), ReferenceVersionRules::fromCode),
                codes(RelatedArtifactType.values(), RelatedArtifactType::fromCode),
                codes(ReportRelationshipType.values(), ReportRelationshipType::fromCode),
                codes(RequestIntent.values(), RequestIntent::fromCode),
                codes(RequestPriority.values(), RequestPriority::fromCode),
                codes(RequestResourceTypes.values(), RequestResourceTypes::fromCode),
                codes(RequestStatus.values(), RequestStatus::fromCode),
                codes(ResourceType.values(), ResourceType::fromCode),
                codes(ResourceVersionPolicy.values(), ResourceVersionPolicy::fromCode),
                codes(ResponseType.values(), ResponseType::fromCode),
                codes(RestfulCapabilityMode.values(), RestfulCapabilityMode::fromCode),
                codes(SPDXLicense.values(), SPDXLicense::fromCode),
                codes(SearchComparator.values(), SearchComparator::fromCode),
                codes(SearchEntryMode.values(), SearchEntryMode::fromCode),
                codes(SearchModifierCode.values(), SearchModifierCode::fromCode),
                codes(SearchParamType.values(), SearchParamType::fromCode),
                codes(SearchProcessingModeType.values(), SearchProcessingModeType::fromCode),
                codes(SequenceType.values(), SequenceType::fromCode),
                codes(SlicingRules.values(), SlicingRules::fromCode),
                codes(SlotStatus.values(), SlotStatus::fromCode),
                codes(SortDirection.values(), SortDirection::fromCode),
                codes(SpecimenCombined.values(), SpecimenCombined::fromCode),
                codes(SpecimenContainedPreference.values(), SpecimenContainedPreference::fromCode),
                codes(SpecimenStatus.values(), SpecimenStatus::fromCode),
                codes(StrandType.values(), StrandType::fromCode),
                codes(StructureDefinitionKind.values(), StructureDefinitionKind::fromCode),
                codes(StructureMapGroupTypeMode.values(), StructureMapGroupTypeMode::fromCode),
                codes(StructureMapInputMode.values(), StructureMapInputMode::fromCode),
                codes(StructureMapModelMode.values(), StructureMapModelMode::fromCode),
                codes(StructureMapSourceListMode.values(), StructureMapSourceListMode::fromCode),
                codes(StructureMapTargetListMode.values(), StructureMapTargetListMode::fromCode),
                codes(StructureMapTransform.values(), StructureMapTransform::fromCode),
                codes(SubmitDataUpdateType.values(), SubmitDataUpdateType::fromCode),
                codes(SubscriptionNotificationType.values(), SubscriptionNotificationType::fromCode),
                codes(SubscriptionPayloadContent.values(), SubscriptionPayloadContent::fromCode),
                codes(SubscriptionStatusCodes.values(), SubscriptionStatusCodes::fromCode),
                codes(SupplyDeliveryStatus.values(), SupplyDeliveryStatus::fromCode),
                codes(SupplyRequestStatus.values(), SupplyRequestStatus::fromCode),
                codes(SystemRestfulInteraction.values(), SystemRestfulInteraction::fromCode),
                codes(TaskStatus.values(), TaskStatus::fromCode),
                codes(TestReportActionResult.values(), TestReportActionResult::fromCode),
                codes(TestReportParticipantType.values(), TestReportParticipantType::fromCode),
                codes(TestReportResult.values(), TestReportResult::fromCode),
                codes(TestReportStatus.values(), TestReportStatus::fromCode),
                codes(TestScriptRequestMethodCode.values(), TestScriptRequestMethodCode::fromCode),
                codes(TransportStatus.values(), TransportStatus::fromCode),
                codes(TriggerType.values(), TriggerType::fromCode),
                codes(TriggeredBytype.values(), TriggeredBytype::fromCode),
                codes(TypeDerivationRule.values(), TypeDerivationRule::fromCode),
                codes(TypeRestfulInteraction.values(), TypeRestfulInteraction::fromCode),
                codes(UDIEntryType.values(), UDIEntryType::fromCode),
                codes(UnitsOfTime.values(), UnitsOfTime::fromCode),
                codes(Use.values(), Use::fromCode),
                codes(ValueFilterComparator.values(), ValueFilterComparator::fromCode),
                codes(VerificationResultStatus.values(), VerificationResultStatus::fromCode),
                codes(VisionBase.values(), VisionBase::fromCode),
                codes(VisionEyes.values(), VisionEyes::fromCode));
    }

    @ParameterizedTest
    @MethodSource("enums")
    void fromCodeFindsEveryConstantByItsCode(CodedEnum[] values, Function<String, CodedEnum> fromCode) {
        for (CodedEnum value : values) {
            assertSame(value, fromCode.apply(value.code()));
            assertTrue(URI.create(value.system()).isAbsolute());
            assertFalse(value.display().isBlank());
        }
    }

    @ParameterizedTest
    @MethodSource("enums")
    void fromCodeRejectsUnknownAndDifferentlyCasedCodes(CodedEnum[] values, Function<String, CodedEnum> fromCode) {
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply("no-such-code"));
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply(values[0].code().toUpperCase() + "X"));
    }

    @Test
    void codesThatAreNotJavaIdentifiersHaveReadableConstants() {
        assertSame(QuantityComparator.LESS_OR_EQUAL, QuantityComparator.fromCode("<="));
        assertSame(LinkType.REPLACED_BY, LinkType.fromCode("replaced-by"));
    }

    @Test
    void camelCaseCodesBecomeSnakeCaseConstants() {
        assertSame(FHIRTypes.DATE_TIME, FHIRTypes.fromCode("dateTime"));
        assertSame(FHIRTypes.CODEABLE_CONCEPT, FHIRTypes.fromCode("CodeableConcept"));
    }

    @Test
    void valueSetsThatListTheirCodesUseThoseCodes() {
        assertEquals("http://unitsofmeasure.org", UnitsOfTime.WK.system());
        assertSame(UnitsOfTime.WK, UnitsOfTime.fromCode("wk"));
    }

    @Test
    void includesNestedCodes() {
        assertEquals("maiden", NameUse.MAIDEN.code());
    }
}
