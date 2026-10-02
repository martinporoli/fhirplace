package se.poroli.fhirplace.r5.financial.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Address;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.ClaimProcessingCodes;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.InvoiceStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PriceComponentType;
import se.poroli.fhirplace.r5.valuesets.Use;

/** Builds every financial.billing resource with all elements and checks the builders and validation. */
class FinancialBillingResourcesTest {

    @Test
    void claim() {
        Claim resource = Claim.builder()
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
                .status(FhirEnum.of(FinancialResourceStatusCodes.values()[0]))
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
                .fundsReserve(CodeableConcept.builder().build())
                .addRelated(Claim.RelatedClaim.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .claim(Reference.builder().build())
                        .relationship(CodeableConcept.builder().build())
                        .reference(Identifier.builder().build())
                        .build())
                .prescription(Reference.builder().build())
                .originalPrescription(Reference.builder().build())
                .payee(Claim.Payee.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .party(Reference.builder().build())
                        .build())
                .referral(Reference.builder().build())
                .addEncounter(Reference.builder().build())
                .facility(Reference.builder().build())
                .diagnosisRelatedGroup(CodeableConcept.builder().build())
                .addEvent(Claim.Event.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .when(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .addCareTeam(Claim.CareTeam.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .provider(Reference.builder().build())
                        .responsible(FhirBoolean.of(true))
                        .role(CodeableConcept.builder().build())
                        .specialty(CodeableConcept.builder().build())
                        .build())
                .addSupportingInfo(Claim.SupportingInformation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .category(CodeableConcept.builder().build())
                        .code(CodeableConcept.builder().build())
                        .timing(FhirDate.parse("2024-01-01"))
                        .value(FhirBoolean.of(true))
                        .reason(CodeableConcept.builder().build())
                        .build())
                .addDiagnosis(Claim.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .diagnosis(CodeableConcept.builder().build())
                        .addType(CodeableConcept.builder().build())
                        .onAdmission(CodeableConcept.builder().build())
                        .build())
                .addProcedure(Claim.Procedure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .addType(CodeableConcept.builder().build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .procedure(CodeableConcept.builder().build())
                        .addUdi(Reference.builder().build())
                        .build())
                .addInsurance(Claim.Insurance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .focal(FhirBoolean.of(true))
                        .identifier(Identifier.builder().build())
                        .coverage(Reference.builder().build())
                        .businessArrangement(FhirString.of("text"))
                        .addPreAuthRef(FhirString.of("text"))
                        .claimResponse(Reference.builder().build())
                        .build())
                .accident(Claim.Accident.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .date(FhirDate.parse("2024-01-01"))
                        .type(CodeableConcept.builder().build())
                        .location(Address.builder().build())
                        .build())
                .patientPaid(Money.builder().build())
                .addItem(Claim.Item.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .addTraceNumber(Identifier.builder().build())
                        .addCareTeamSequence(FhirPositiveInt.of(1))
                        .addDiagnosisSequence(FhirPositiveInt.of(1))
                        .addProcedureSequence(FhirPositiveInt.of(1))
                        .addInformationSequence(FhirPositiveInt.of(1))
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
                        .addBodySite(Claim.Item.BodySite.builder()
                                .addSite(CodeableReference.builder().build())
                                .build())
                        .addEncounter(Reference.builder().build())
                        .addDetail(Claim.Item.Detail.builder().sequence(FhirPositiveInt.of(1)).build())
                        .build())
                .total(Money.builder().build())
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
        assertNotNull(resource.fundsReserve());
        assertFalse(resource.related().isEmpty());
        assertNotNull(resource.prescription());
        assertNotNull(resource.originalPrescription());
        assertNotNull(resource.payee());
        assertNotNull(resource.referral());
        assertFalse(resource.encounter().isEmpty());
        assertNotNull(resource.facility());
        assertNotNull(resource.diagnosisRelatedGroup());
        assertFalse(resource.event().isEmpty());
        assertFalse(resource.careTeam().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertFalse(resource.procedure().isEmpty());
        assertFalse(resource.insurance().isEmpty());
        assertNotNull(resource.accident());
        assertNotNull(resource.patientPaid());
        assertFalse(resource.item().isEmpty());
        assertNotNull(resource.total());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Claim.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<FinancialResourceStatusCodes>) null).build()).getMessage());
    }

    @Test
    void claimResponse() {
        ClaimResponse resource = ClaimResponse.builder()
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
                .status(FhirEnum.of(FinancialResourceStatusCodes.values()[0]))
                .type(CodeableConcept.builder().build())
                .subType(CodeableConcept.builder().build())
                .use(FhirEnum.of(Use.values()[0]))
                .patient(Reference.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .insurer(Reference.builder().build())
                .requestor(Reference.builder().build())
                .request(Reference.builder().build())
                .outcome(FhirEnum.of(ClaimProcessingCodes.values()[0]))
                .decision(CodeableConcept.builder().build())
                .disposition(FhirString.of("text"))
                .preAuthRef(FhirString.of("text"))
                .preAuthPeriod(Period.builder().build())
                .addEvent(ClaimResponse.Event.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .when(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .payeeType(CodeableConcept.builder().build())
                .addEncounter(Reference.builder().build())
                .diagnosisRelatedGroup(CodeableConcept.builder().build())
                .addItem(ClaimResponse.Item.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .itemSequence(FhirPositiveInt.of(1))
                        .addTraceNumber(Identifier.builder().build())
                        .addNoteNumber(FhirPositiveInt.of(1))
                        .reviewOutcome(ClaimResponse.Item.ReviewOutcome.builder().build())
                        .addAdjudication(ClaimResponse.Item.Adjudication.builder()
                                .category(CodeableConcept.builder().build())
                                .build())
                        .addDetail(ClaimResponse.Item.ItemDetail.builder()
                                .detailSequence(FhirPositiveInt.of(1))
                                .build())
                        .build())
                .addAddItem(ClaimResponse.AddedItem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addItemSequence(FhirPositiveInt.of(1))
                        .addDetailSequence(FhirPositiveInt.of(1))
                        .addSubdetailSequence(FhirPositiveInt.of(1))
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
                        .quantity(Quantity.builder().build())
                        .unitPrice(Money.builder().build())
                        .factor(FhirDecimal.parse("1.0"))
                        .tax(Money.builder().build())
                        .net(Money.builder().build())
                        .addBodySite(ClaimResponse.AddedItem.BodySite.builder()
                                .addSite(CodeableReference.builder().build())
                                .build())
                        .addNoteNumber(FhirPositiveInt.of(1))
                        .reviewOutcome(ClaimResponse.Item.ReviewOutcome.builder().build())
                        .addAdjudication(ClaimResponse.Item.Adjudication.builder()
                                .category(CodeableConcept.builder().build())
                                .build())
                        .addDetail(ClaimResponse.AddedItem.AddedItemDetail.builder().build())
                        .build())
                .addAdjudication(ClaimResponse.Item.Adjudication.builder()
                        .category(CodeableConcept.builder().build())
                        .build())
                .addTotal(ClaimResponse.Total.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .category(CodeableConcept.builder().build())
                        .amount(Money.builder().build())
                        .build())
                .payment(ClaimResponse.Payment.builder()
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
                .fundsReserve(CodeableConcept.builder().build())
                .formCode(CodeableConcept.builder().build())
                .form(Attachment.builder().build())
                .addProcessNote(ClaimResponse.Note.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .number(FhirPositiveInt.of(1))
                        .type(CodeableConcept.builder().build())
                        .text(FhirString.of("text"))
                        .language(CodeableConcept.builder().build())
                        .build())
                .addCommunicationRequest(Reference.builder().build())
                .addInsurance(ClaimResponse.Insurance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .focal(FhirBoolean.of(true))
                        .coverage(Reference.builder().build())
                        .businessArrangement(FhirString.of("text"))
                        .claimResponse(Reference.builder().build())
                        .build())
                .addError(ClaimResponse.ClaimResponseError.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .itemSequence(FhirPositiveInt.of(1))
                        .detailSequence(FhirPositiveInt.of(1))
                        .subDetailSequence(FhirPositiveInt.of(1))
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
        assertFalse(resource.traceNumber().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.type());
        assertNotNull(resource.subType());
        assertNotNull(resource.use());
        assertNotNull(resource.patient());
        assertNotNull(resource.created());
        assertNotNull(resource.insurer());
        assertNotNull(resource.requestor());
        assertNotNull(resource.request());
        assertNotNull(resource.outcome());
        assertNotNull(resource.decision());
        assertNotNull(resource.disposition());
        assertNotNull(resource.preAuthRef());
        assertNotNull(resource.preAuthPeriod());
        assertFalse(resource.event().isEmpty());
        assertNotNull(resource.payeeType());
        assertFalse(resource.encounter().isEmpty());
        assertNotNull(resource.diagnosisRelatedGroup());
        assertFalse(resource.item().isEmpty());
        assertFalse(resource.addItem().isEmpty());
        assertFalse(resource.adjudication().isEmpty());
        assertFalse(resource.total().isEmpty());
        assertNotNull(resource.payment());
        assertNotNull(resource.fundsReserve());
        assertNotNull(resource.formCode());
        assertNotNull(resource.form());
        assertFalse(resource.processNote().isEmpty());
        assertFalse(resource.communicationRequest().isEmpty());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.error().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ClaimResponse.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<FinancialResourceStatusCodes>) null).build()).getMessage());
    }

    @Test
    void invoice() {
        Invoice resource = Invoice.builder()
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
                .status(FhirEnum.of(InvoiceStatus.values()[0]))
                .cancelledReason(FhirString.of("text"))
                .type(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .recipient(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .creation(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .period(FhirDate.parse("2024-01-01"))
                .addParticipant(Invoice.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .issuer(Reference.builder().build())
                .account(Reference.builder().build())
                .addLineItem(Invoice.LineItem.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .serviced(FhirDate.parse("2024-01-01"))
                        .chargeItem(Reference.builder().build())
                        .addPriceComponent(MonetaryComponent.builder()
                                .type(FhirEnum.of(PriceComponentType.values()[0]))
                                .build())
                        .build())
                .addTotalPriceComponent(MonetaryComponent.builder()
                        .type(FhirEnum.of(PriceComponentType.values()[0]))
                        .build())
                .totalNet(Money.builder().build())
                .totalGross(Money.builder().build())
                .paymentTerms(FhirMarkdown.of("text"))
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
        assertNotNull(resource.cancelledReason());
        assertNotNull(resource.type());
        assertNotNull(resource.subject());
        assertNotNull(resource.recipient());
        assertNotNull(resource.date());
        assertNotNull(resource.creation());
        assertNotNull(resource.period());
        assertFalse(resource.participant().isEmpty());
        assertNotNull(resource.issuer());
        assertNotNull(resource.account());
        assertFalse(resource.lineItem().isEmpty());
        assertFalse(resource.totalPriceComponent().isEmpty());
        assertNotNull(resource.totalNet());
        assertNotNull(resource.totalGross());
        assertNotNull(resource.paymentTerms());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Invoice.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<InvoiceStatus>) null).build()).getMessage());
    }
}
