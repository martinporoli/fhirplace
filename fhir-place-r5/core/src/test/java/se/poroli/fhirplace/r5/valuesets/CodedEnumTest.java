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
                codes(AggregationMode.values(), AggregationMode::fromCode),
                codes(BindingStrength.values(), BindingStrength::fromCode),
                codes(CapabilityStatementKind.values(), CapabilityStatementKind::fromCode),
                codes(ClaimProcessingCodes.values(), ClaimProcessingCodes::fromCode),
                codes(CodeSystemContentMode.values(), CodeSystemContentMode::fromCode),
                codes(CommonLanguages.values(), CommonLanguages::fromCode),
                codes(CompartmentType.values(), CompartmentType::fromCode),
                codes(CompositionStatus.values(), CompositionStatus::fromCode),
                codes(ConsentDataMeaning.values(), ConsentDataMeaning::fromCode),
                codes(ConsentProvisionType.values(), ConsentProvisionType::fromCode),
                codes(ConstraintSeverity.values(), ConstraintSeverity::fromCode),
                codes(ContactPointSystem.values(), ContactPointSystem::fromCode),
                codes(ContactPointUse.values(), ContactPointUse::fromCode),
                codes(ContributorType.values(), ContributorType::fromCode),
                codes(DaysOfWeek.values(), DaysOfWeek::fromCode),
                codes(DeviceNameType.values(), DeviceNameType::fromCode),
                codes(DiscriminatorType.values(), DiscriminatorType::fromCode),
                codes(EncounterStatus.values(), EncounterStatus::fromCode),
                codes(EventStatus.values(), EventStatus::fromCode),
                codes(EvidenceVariableHandling.values(), EvidenceVariableHandling::fromCode),
                codes(ExampleScenarioActorType.values(), ExampleScenarioActorType::fromCode),
                codes(FHIRTypes.values(), FHIRTypes::fromCode),
                codes(FHIRVersion.values(), FHIRVersion::fromCode),
                codes(FilterOperator.values(), FilterOperator::fromCode),
                codes(FinancialResourceStatusCodes.values(), FinancialResourceStatusCodes::fromCode),
                codes(IdentifierUse.values(), IdentifierUse::fromCode),
                codes(ListMode.values(), ListMode::fromCode),
                codes(NameUse.values(), NameUse::fromCode),
                codes(NarrativeStatus.values(), NarrativeStatus::fromCode),
                codes(ObservationStatus.values(), ObservationStatus::fromCode),
                codes(OperationParameterUse.values(), OperationParameterUse::fromCode),
                codes(PriceComponentType.values(), PriceComponentType::fromCode),
                codes(PropertyRepresentation.values(), PropertyRepresentation::fromCode),
                codes(PublicationStatus.values(), PublicationStatus::fromCode),
                codes(QuantityComparator.values(), QuantityComparator::fromCode),
                codes(ReferenceVersionRules.values(), ReferenceVersionRules::fromCode),
                codes(RelatedArtifactType.values(), RelatedArtifactType::fromCode),
                codes(RequestIntent.values(), RequestIntent::fromCode),
                codes(RequestPriority.values(), RequestPriority::fromCode),
                codes(RequestStatus.values(), RequestStatus::fromCode),
                codes(ResourceType.values(), ResourceType::fromCode),
                codes(SearchComparator.values(), SearchComparator::fromCode),
                codes(SearchModifierCode.values(), SearchModifierCode::fromCode),
                codes(SearchParamType.values(), SearchParamType::fromCode),
                codes(SlicingRules.values(), SlicingRules::fromCode),
                codes(SortDirection.values(), SortDirection::fromCode),
                codes(SubscriptionStatusCodes.values(), SubscriptionStatusCodes::fromCode),
                codes(TriggerType.values(), TriggerType::fromCode),
                codes(UnitsOfTime.values(), UnitsOfTime::fromCode),
                codes(Use.values(), Use::fromCode),
                codes(ValueFilterComparator.values(), ValueFilterComparator::fromCode));
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
        assertSame(RelatedArtifactType.CITED_BY, RelatedArtifactType.fromCode("cited-by"));
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
