package se.poroli.fhirplace.r5.account;

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
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
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
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Account with all elements and checks the builder and validation. */
class AccountTest {

    @Test
    void account() {
        Account resource = Account.builder()
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
                .status(FhirEnum.of(AccountStatus.values()[0]))
                .billingStatus(CodeableConcept.builder().build())
                .type(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .addSubject(Reference.builder().build())
                .servicePeriod(Period.builder().build())
                .addCoverage(Account.Coverage.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .coverage(Reference.builder().build())
                        .priority(FhirPositiveInt.of(1))
                        .build())
                .owner(Reference.builder().build())
                .description(FhirMarkdown.of("text"))
                .addGuarantor(Account.Guarantor.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .party(Reference.builder().build())
                        .onHold(FhirBoolean.of(true))
                        .period(Period.builder().build())
                        .build())
                .addDiagnosis(Account.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .condition(CodeableReference.builder().build())
                        .dateOfDiagnosis(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addType(CodeableConcept.builder().build())
                        .onAdmission(FhirBoolean.of(true))
                        .addPackageCode(CodeableConcept.builder().build())
                        .build())
                .addProcedure(Account.Procedure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirPositiveInt.of(1))
                        .code(CodeableReference.builder().build())
                        .dateOfService(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addType(CodeableConcept.builder().build())
                        .addPackageCode(CodeableConcept.builder().build())
                        .addDevice(Reference.builder().build())
                        .build())
                .addRelatedAccount(Account.RelatedAccount.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .relationship(CodeableConcept.builder().build())
                        .account(Reference.builder().build())
                        .build())
                .currency(CodeableConcept.builder().build())
                .addBalance(Account.Balance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .aggregate(CodeableConcept.builder().build())
                        .term(CodeableConcept.builder().build())
                        .estimate(FhirBoolean.of(true))
                        .amount(Money.builder().build())
                        .build())
                .calculatedAt(FhirInstant.parse("2024-01-01T00:00:00Z"))
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
        assertNotNull(resource.billingStatus());
        assertNotNull(resource.type());
        assertNotNull(resource.name());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.servicePeriod());
        assertFalse(resource.coverage().isEmpty());
        assertNotNull(resource.owner());
        assertNotNull(resource.description());
        assertFalse(resource.guarantor().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertFalse(resource.procedure().isEmpty());
        assertFalse(resource.relatedAccount().isEmpty());
        assertNotNull(resource.currency());
        assertFalse(resource.balance().isEmpty());
        assertNotNull(resource.calculatedAt());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Account.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<AccountStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(AccountStatus.values(), AccountStatus::fromCode);
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
