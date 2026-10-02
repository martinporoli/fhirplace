package se.poroli.fhirplace.r5.claim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Address;
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
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.Use;

/** Builds a Claim with all elements and checks the builder and validation. */
class ClaimTest {

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
}
