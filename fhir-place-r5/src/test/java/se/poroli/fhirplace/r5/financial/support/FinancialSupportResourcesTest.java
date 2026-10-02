package se.poroli.fhirplace.r5.financial.support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
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
import se.poroli.fhirplace.r5.valuesets.EligibilityOutcome;
import se.poroli.fhirplace.r5.valuesets.EligibilityRequestPurpose;
import se.poroli.fhirplace.r5.valuesets.EligibilityResponsePurpose;
import se.poroli.fhirplace.r5.valuesets.EnrollmentOutcome;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.Kind;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds every financial.support resource with all elements and checks the builders and validation. */
class FinancialSupportResourcesTest {

    @Test
    void coverage() {
        Coverage resource = Coverage.builder()
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
                .kind(FhirEnum.of(Kind.values()[0]))
                .addPaymentBy(Coverage.PaymentBy.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .party(Reference.builder().build())
                        .responsibility(FhirString.of("text"))
                        .build())
                .type(CodeableConcept.builder().build())
                .policyHolder(Reference.builder().build())
                .subscriber(Reference.builder().build())
                .addSubscriberId(Identifier.builder().build())
                .beneficiary(Reference.builder().build())
                .dependent(FhirString.of("text"))
                .relationship(CodeableConcept.builder().build())
                .period(Period.builder().build())
                .insurer(Reference.builder().build())
                .addClassValue(Coverage.CoverageClass.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(Identifier.builder().build())
                        .name(FhirString.of("text"))
                        .build())
                .order(FhirPositiveInt.of(1))
                .network(FhirString.of("text"))
                .addCostToBeneficiary(Coverage.CostToBeneficiary.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .category(CodeableConcept.builder().build())
                        .network(CodeableConcept.builder().build())
                        .unit(CodeableConcept.builder().build())
                        .term(CodeableConcept.builder().build())
                        .value(Quantity.builder().build())
                        .addException(Coverage.CostToBeneficiary.Exemption.builder()
                                .type(CodeableConcept.builder().build())
                                .build())
                        .build())
                .subrogation(FhirBoolean.of(true))
                .addContract(Reference.builder().build())
                .insurancePlan(Reference.builder().build())
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
        assertNotNull(resource.kind());
        assertFalse(resource.paymentBy().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.policyHolder());
        assertNotNull(resource.subscriber());
        assertFalse(resource.subscriberId().isEmpty());
        assertNotNull(resource.beneficiary());
        assertNotNull(resource.dependent());
        assertNotNull(resource.relationship());
        assertNotNull(resource.period());
        assertNotNull(resource.insurer());
        assertFalse(resource.classValue().isEmpty());
        assertNotNull(resource.order());
        assertNotNull(resource.network());
        assertFalse(resource.costToBeneficiary().isEmpty());
        assertNotNull(resource.subrogation());
        assertFalse(resource.contract().isEmpty());
        assertNotNull(resource.insurancePlan());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Coverage.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<FinancialResourceStatusCodes>) null).build()).getMessage());
    }

    @Test
    void coverageEligibilityRequest() {
        CoverageEligibilityRequest resource = CoverageEligibilityRequest.builder()
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
                .priority(CodeableConcept.builder().build())
                .addPurpose(FhirEnum.of(EligibilityRequestPurpose.values()[0]))
                .patient(Reference.builder().build())
                .addEvent(CoverageEligibilityRequest.Event.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .when(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .serviced(FhirDate.parse("2024-01-01"))
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .enterer(Reference.builder().build())
                .provider(Reference.builder().build())
                .insurer(Reference.builder().build())
                .facility(Reference.builder().build())
                .addSupportingInfo(CoverageEligibilityRequest.SupportingInformation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .information(Reference.builder().build())
                        .appliesToAll(FhirBoolean.of(true))
                        .build())
                .addInsurance(CoverageEligibilityRequest.Insurance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .focal(FhirBoolean.of(true))
                        .coverage(Reference.builder().build())
                        .businessArrangement(FhirString.of("text"))
                        .build())
                .addItem(CoverageEligibilityRequest.Details.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addSupportingInfoSequence(FhirPositiveInt.of(1))
                        .category(CodeableConcept.builder().build())
                        .productOrService(CodeableConcept.builder().build())
                        .addModifier(CodeableConcept.builder().build())
                        .provider(Reference.builder().build())
                        .quantity(Quantity.builder().build())
                        .unitPrice(Money.builder().build())
                        .facility(Reference.builder().build())
                        .addDiagnosis(CoverageEligibilityRequest.Details.Diagnosis.builder().build())
                        .addDetail(Reference.builder().build())
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
        assertNotNull(resource.priority());
        assertFalse(resource.purpose().isEmpty());
        assertNotNull(resource.patient());
        assertFalse(resource.event().isEmpty());
        assertNotNull(resource.serviced());
        assertNotNull(resource.created());
        assertNotNull(resource.enterer());
        assertNotNull(resource.provider());
        assertNotNull(resource.insurer());
        assertNotNull(resource.facility());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.item().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CoverageEligibilityRequest.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<FinancialResourceStatusCodes>) null).build()).getMessage());
    }

    @Test
    void coverageEligibilityResponse() {
        CoverageEligibilityResponse resource = CoverageEligibilityResponse.builder()
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
                .addPurpose(FhirEnum.of(EligibilityResponsePurpose.values()[0]))
                .patient(Reference.builder().build())
                .addEvent(CoverageEligibilityResponse.Event.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .when(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .serviced(FhirDate.parse("2024-01-01"))
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requestor(Reference.builder().build())
                .request(Reference.builder().build())
                .outcome(FhirEnum.of(EligibilityOutcome.values()[0]))
                .disposition(FhirString.of("text"))
                .insurer(Reference.builder().build())
                .addInsurance(CoverageEligibilityResponse.Insurance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .coverage(Reference.builder().build())
                        .inforce(FhirBoolean.of(true))
                        .benefitPeriod(Period.builder().build())
                        .addItem(CoverageEligibilityResponse.Insurance.Items.builder().build())
                        .build())
                .preAuthRef(FhirString.of("text"))
                .form(CodeableConcept.builder().build())
                .addError(CoverageEligibilityResponse.Errors.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .addExpression(FhirString.of("text"))
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
        assertFalse(resource.purpose().isEmpty());
        assertNotNull(resource.patient());
        assertFalse(resource.event().isEmpty());
        assertNotNull(resource.serviced());
        assertNotNull(resource.created());
        assertNotNull(resource.requestor());
        assertNotNull(resource.request());
        assertNotNull(resource.outcome());
        assertNotNull(resource.disposition());
        assertNotNull(resource.insurer());
        assertFalse(resource.insurance().isEmpty());
        assertNotNull(resource.preAuthRef());
        assertNotNull(resource.form());
        assertFalse(resource.error().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CoverageEligibilityResponse.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<FinancialResourceStatusCodes>) null).build()).getMessage());
    }

    @Test
    void enrollmentRequest() {
        EnrollmentRequest resource = EnrollmentRequest.builder()
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
                .insurer(Reference.builder().build())
                .provider(Reference.builder().build())
                .candidate(Reference.builder().build())
                .coverage(Reference.builder().build())
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
        assertNotNull(resource.insurer());
        assertNotNull(resource.provider());
        assertNotNull(resource.candidate());
        assertNotNull(resource.coverage());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void enrollmentResponse() {
        EnrollmentResponse resource = EnrollmentResponse.builder()
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
                .request(Reference.builder().build())
                .outcome(FhirEnum.of(EnrollmentOutcome.values()[0]))
                .disposition(FhirString.of("text"))
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .organization(Reference.builder().build())
                .requestProvider(Reference.builder().build())
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
        assertNotNull(resource.request());
        assertNotNull(resource.outcome());
        assertNotNull(resource.disposition());
        assertNotNull(resource.created());
        assertNotNull(resource.organization());
        assertNotNull(resource.requestProvider());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
