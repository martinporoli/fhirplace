package se.poroli.fhirplace.r5.coverageeligibilityresponse;

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
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.FinancialResourceStatusCodes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a CoverageEligibilityResponse with all elements and checks the builder and validation. */
class CoverageEligibilityResponseTest {

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
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(EligibilityOutcome.values(), EligibilityOutcome::fromCode);
        assertCodes(EligibilityResponsePurpose.values(), EligibilityResponsePurpose::fromCode);
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
