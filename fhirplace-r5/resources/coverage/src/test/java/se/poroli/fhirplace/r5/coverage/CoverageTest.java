package se.poroli.fhirplace.r5.coverage;

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
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Coverage with all elements and checks the builder and validation. */
class CoverageTest {

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
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(Kind.values(), Kind::fromCode);
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
