package se.poroli.fhirplace.r5.claimresponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
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
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.Use;

/** Builds a ClaimResponse with all elements and checks the builder and validation. */
class ClaimResponseTest {

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
}
