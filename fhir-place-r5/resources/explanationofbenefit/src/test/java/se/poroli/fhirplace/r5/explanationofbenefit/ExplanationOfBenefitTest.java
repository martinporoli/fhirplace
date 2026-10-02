package se.poroli.fhirplace.r5.explanationofbenefit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
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
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.ClaimProcessingCodes;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.Use;

/** Builds a ExplanationOfBenefit with all elements and checks the builder and validation. */
class ExplanationOfBenefitTest {

    @Test
    void explanationOfBenefit() {
        ExplanationOfBenefit resource = ExplanationOfBenefit.builder()
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
                .addTraceNumber(Identifier.builder().build())
                .status(FhirEnum.of(ExplanationOfBenefitStatus.values()[0]))
                .type(CodeableConcept.builder().build())
                .subType(CodeableConcept.builder().build())
                .use(FhirEnum.of(Use.values()[0]))
                .patient(Reference.builder().build())
                .billablePeriod(Period.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .enterer(Reference.builder().build())
                .insurer(Reference.builder().build())
                .provider(Reference.builder().build())
                .priority(CodeableConcept.builder().build())
                .fundsReserveRequested(CodeableConcept.builder().build())
                .fundsReserve(CodeableConcept.builder().build())
                .addRelated(ExplanationOfBenefit.RelatedClaim.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .claim(Reference.builder().build())
                        .relationship(CodeableConcept.builder().build())
                        .reference(Identifier.builder().build())
                        .build())
                .prescription(Reference.builder().build())
                .originalPrescription(Reference.builder().build())
                .addEvent(ExplanationOfBenefit.Event.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .when(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .payee(ExplanationOfBenefit.Payee.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .party(Reference.builder().build())
                        .build())
                .referral(Reference.builder().build())
                .addEncounter(Reference.builder().build())
                .facility(Reference.builder().build())
                .claim(Reference.builder().build())
                .claimResponse(Reference.builder().build())
                .outcome(FhirEnum.of(ClaimProcessingCodes.values()[0]))
                .decision(CodeableConcept.builder().build())
                .disposition(FhirString.of("text"))
                .addPreAuthRef(FhirString.of("text"))
                .addPreAuthRefPeriod(Period.builder().build())
                .diagnosisRelatedGroup(CodeableConcept.builder().build())
                .addCareTeam(ExplanationOfBenefit.CareTeam.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .provider(Reference.builder().build())
                        .responsible(FhirBoolean.of(true))
                        .role(CodeableConcept.builder().build())
                        .specialty(CodeableConcept.builder().build())
                        .build())
                .addSupportingInfo(ExplanationOfBenefit.SupportingInformation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .category(CodeableConcept.builder().build())
                        .code(CodeableConcept.builder().build())
                        .timing(FhirDate.parse("2024-01-01"))
                        .value(FhirBoolean.of(true))
                        .reason(Coding.builder().build())
                        .build())
                .addDiagnosis(ExplanationOfBenefit.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .diagnosis(CodeableConcept.builder().build())
                        .addType(CodeableConcept.builder().build())
                        .onAdmission(CodeableConcept.builder().build())
                        .build())
                .addProcedure(ExplanationOfBenefit.Procedure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .addType(CodeableConcept.builder().build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .procedure(CodeableConcept.builder().build())
                        .addUdi(Reference.builder().build())
                        .build())
                .precedence(FhirPositiveInt.of(1))
                .addInsurance(ExplanationOfBenefit.Insurance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .focal(FhirBoolean.of(true))
                        .coverage(Reference.builder().build())
                        .addPreAuthRef(FhirString.of("text"))
                        .build())
                .accident(ExplanationOfBenefit.Accident.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .date(FhirDate.parse("2024-01-01"))
                        .type(CodeableConcept.builder().build())
                        .location(Address.builder().build())
                        .build())
                .patientPaid(Money.builder().build())
                .addItem(ExplanationOfBenefit.Item.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .addCareTeamSequence(FhirPositiveInt.of(1))
                        .addDiagnosisSequence(FhirPositiveInt.of(1))
                        .addProcedureSequence(FhirPositiveInt.of(1))
                        .addInformationSequence(FhirPositiveInt.of(1))
                        .addTraceNumber(Identifier.builder().build())
                        .revenue(CodeableConcept.builder().build())
                        .category(CodeableConcept.builder().build())
                        .productOrService(CodeableConcept.builder().build())
                        .productOrServiceEnd(CodeableConcept.builder().build())
                        .addRequest(Reference.builder().build())
                        .addModifier(CodeableConcept.builder().build())
                        .addProgramCode(CodeableConcept.builder().build())
                        .serviced(FhirDate.parse("2024-01-01"))
                        .location(CodeableConcept.builder().build())
                        .patientPaid(Money.builder().build())
                        .quantity(Quantity.builder().build())
                        .unitPrice(Money.builder().build())
                        .factor(FhirDecimal.parse("1.0"))
                        .tax(Money.builder().build())
                        .net(Money.builder().build())
                        .addUdi(Reference.builder().build())
                        .addBodySite(ExplanationOfBenefit.Item.ItemBodySite.builder()
                                .addSite(CodeableReference.builder().build())
                                .build())
                        .addEncounter(Reference.builder().build())
                        .addNoteNumber(FhirPositiveInt.of(1))
                        .reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome.builder().build())
                        .addAdjudication(ExplanationOfBenefit.Item.Adjudication.builder()
                                .category(CodeableConcept.builder().build())
                                .build())
                        .addDetail(ExplanationOfBenefit.Item.Detail.builder()
                                .sequence(FhirPositiveInt.of(1))
                                .build())
                        .build())
                .addAddItem(ExplanationOfBenefit.AddedItem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addItemSequence(FhirPositiveInt.of(1))
                        .addDetailSequence(FhirPositiveInt.of(1))
                        .addSubDetailSequence(FhirPositiveInt.of(1))
                        .addTraceNumber(Identifier.builder().build())
                        .addProvider(Reference.builder().build())
                        .revenue(CodeableConcept.builder().build())
                        .productOrService(CodeableConcept.builder().build())
                        .productOrServiceEnd(CodeableConcept.builder().build())
                        .addRequest(Reference.builder().build())
                        .addModifier(CodeableConcept.builder().build())
                        .addProgramCode(CodeableConcept.builder().build())
                        .serviced(FhirDate.parse("2024-01-01"))
                        .location(CodeableConcept.builder().build())
                        .patientPaid(Money.builder().build())
                        .quantity(Quantity.builder().build())
                        .unitPrice(Money.builder().build())
                        .factor(FhirDecimal.parse("1.0"))
                        .tax(Money.builder().build())
                        .net(Money.builder().build())
                        .addBodySite(ExplanationOfBenefit.AddedItem.AddedItemBodySite.builder()
                                .addSite(CodeableReference.builder().build())
                                .build())
                        .addNoteNumber(FhirPositiveInt.of(1))
                        .reviewOutcome(ExplanationOfBenefit.Item.ReviewOutcome.builder().build())
                        .addAdjudication(ExplanationOfBenefit.Item.Adjudication.builder()
                                .category(CodeableConcept.builder().build())
                                .build())
                        .addDetail(ExplanationOfBenefit.AddedItem.AddedItemDetail.builder().build())
                        .build())
                .addAdjudication(ExplanationOfBenefit.Item.Adjudication.builder()
                        .category(CodeableConcept.builder().build())
                        .build())
                .addTotal(ExplanationOfBenefit.Total.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .amount(Money.builder().build())
                        .build())
                .payment(ExplanationOfBenefit.Payment.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .adjustment(Money.builder().build())
                        .adjustmentReason(CodeableConcept.builder().build())
                        .date(FhirDate.parse("2024-01-01"))
                        .amount(Money.builder().build())
                        .identifier(Identifier.builder().build())
                        .build())
                .formCode(CodeableConcept.builder().build())
                .form(Attachment.builder().build())
                .addProcessNote(ExplanationOfBenefit.Note.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .number(FhirPositiveInt.of(1))
                        .type(CodeableConcept.builder().build())
                        .text(FhirString.of("text"))
                        .language(CodeableConcept.builder().build())
                        .build())
                .benefitPeriod(Period.builder().build())
                .addBenefitBalance(ExplanationOfBenefit.BenefitBalance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .excluded(FhirBoolean.of(true))
                        .name(FhirString.of("text"))
                        .description(FhirString.of("text"))
                        .network(CodeableConcept.builder().build())
                        .unit(CodeableConcept.builder().build())
                        .term(CodeableConcept.builder().build())
                        .addFinancial(ExplanationOfBenefit.BenefitBalance.Benefit.builder()
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
        assertFalse(resource.traceNumber().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.type());
        assertNotNull(resource.subType());
        assertNotNull(resource.use());
        assertNotNull(resource.patient());
        assertNotNull(resource.billablePeriod());
        assertNotNull(resource.created());
        assertNotNull(resource.enterer());
        assertNotNull(resource.insurer());
        assertNotNull(resource.provider());
        assertNotNull(resource.priority());
        assertNotNull(resource.fundsReserveRequested());
        assertNotNull(resource.fundsReserve());
        assertFalse(resource.related().isEmpty());
        assertNotNull(resource.prescription());
        assertNotNull(resource.originalPrescription());
        assertFalse(resource.event().isEmpty());
        assertNotNull(resource.payee());
        assertNotNull(resource.referral());
        assertFalse(resource.encounter().isEmpty());
        assertNotNull(resource.facility());
        assertNotNull(resource.claim());
        assertNotNull(resource.claimResponse());
        assertNotNull(resource.outcome());
        assertNotNull(resource.decision());
        assertNotNull(resource.disposition());
        assertFalse(resource.preAuthRef().isEmpty());
        assertFalse(resource.preAuthRefPeriod().isEmpty());
        assertNotNull(resource.diagnosisRelatedGroup());
        assertFalse(resource.careTeam().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertFalse(resource.procedure().isEmpty());
        assertNotNull(resource.precedence());
        assertFalse(resource.insurance().isEmpty());
        assertNotNull(resource.accident());
        assertNotNull(resource.patientPaid());
        assertFalse(resource.item().isEmpty());
        assertFalse(resource.addItem().isEmpty());
        assertFalse(resource.adjudication().isEmpty());
        assertFalse(resource.total().isEmpty());
        assertNotNull(resource.payment());
        assertNotNull(resource.formCode());
        assertNotNull(resource.form());
        assertFalse(resource.processNote().isEmpty());
        assertNotNull(resource.benefitPeriod());
        assertFalse(resource.benefitBalance().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ExplanationOfBenefit.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ExplanationOfBenefitStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ExplanationOfBenefitStatus.values(), ExplanationOfBenefitStatus::fromCode);
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
