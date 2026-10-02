package se.poroli.fhirplace.r5.paymentreconciliation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Money;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a PaymentReconciliation with all elements and checks the builder and validation. */
class PaymentReconciliationTest {

    @Test
    void paymentReconciliation() {
        PaymentReconciliation resource = PaymentReconciliation.builder()
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
                .type(CodeableConcept.builder().build())
                .status(FhirEnum.of(FinancialResourceStatusCodes.values()[0]))
                .kind(CodeableConcept.builder().build())
                .period(Period.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .enterer(Reference.builder().build())
                .issuerType(CodeableConcept.builder().build())
                .paymentIssuer(Reference.builder().build())
                .request(Reference.builder().build())
                .requestor(Reference.builder().build())
                .outcome(FhirEnum.of(PaymentOutcome.values()[0]))
                .disposition(FhirString.of("text"))
                .date(FhirDate.parse("2024-01-01"))
                .location(Reference.builder().build())
                .method(CodeableConcept.builder().build())
                .cardBrand(FhirString.of("text"))
                .accountNumber(FhirString.of("text"))
                .expirationDate(FhirDate.parse("2024-01-01"))
                .processor(FhirString.of("text"))
                .referenceNumber(FhirString.of("text"))
                .authorization(FhirString.of("text"))
                .tenderedAmount(Money.builder().build())
                .returnedAmount(Money.builder().build())
                .amount(Money.builder().build())
                .paymentIdentifier(Identifier.builder().build())
                .addAllocation(PaymentReconciliation.Allocation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .identifier(Identifier.builder().build())
                        .predecessor(Identifier.builder().build())
                        .target(Reference.builder().build())
                        .targetItem(FhirString.of("text"))
                        .encounter(Reference.builder().build())
                        .account(Reference.builder().build())
                        .type(CodeableConcept.builder().build())
                        .submitter(Reference.builder().build())
                        .response(Reference.builder().build())
                        .date(FhirDate.parse("2024-01-01"))
                        .responsible(Reference.builder().build())
                        .payee(Reference.builder().build())
                        .amount(Money.builder().build())
                        .build())
                .formCode(CodeableConcept.builder().build())
                .addProcessNote(PaymentReconciliation.Notes.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(NoteType.values()[0]))
                        .text(FhirString.of("text"))
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
        assertNotNull(resource.type());
        assertNotNull(resource.status());
        assertNotNull(resource.kind());
        assertNotNull(resource.period());
        assertNotNull(resource.created());
        assertNotNull(resource.enterer());
        assertNotNull(resource.issuerType());
        assertNotNull(resource.paymentIssuer());
        assertNotNull(resource.request());
        assertNotNull(resource.requestor());
        assertNotNull(resource.outcome());
        assertNotNull(resource.disposition());
        assertNotNull(resource.date());
        assertNotNull(resource.location());
        assertNotNull(resource.method());
        assertNotNull(resource.cardBrand());
        assertNotNull(resource.accountNumber());
        assertNotNull(resource.expirationDate());
        assertNotNull(resource.processor());
        assertNotNull(resource.referenceNumber());
        assertNotNull(resource.authorization());
        assertNotNull(resource.tenderedAmount());
        assertNotNull(resource.returnedAmount());
        assertNotNull(resource.amount());
        assertNotNull(resource.paymentIdentifier());
        assertFalse(resource.allocation().isEmpty());
        assertNotNull(resource.formCode());
        assertFalse(resource.processNote().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("PaymentReconciliation.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((CodeableConcept) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(NoteType.values(), NoteType::fromCode);
        assertCodes(PaymentOutcome.values(), PaymentOutcome::fromCode);
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
