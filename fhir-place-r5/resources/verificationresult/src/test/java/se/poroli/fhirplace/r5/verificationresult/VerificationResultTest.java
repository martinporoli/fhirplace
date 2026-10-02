package se.poroli.fhirplace.r5.verificationresult;

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
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.Signature;
import se.poroli.fhirplace.r5.datatypes.Timing;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a VerificationResult with all elements and checks the builder and validation. */
class VerificationResultTest {

    @Test
    void verificationResult() {
        VerificationResult resource = VerificationResult.builder()
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
                .addTarget(Reference.builder().build())
                .addTargetLocation(FhirString.of("text"))
                .need(CodeableConcept.builder().build())
                .status(FhirEnum.of(VerificationResultStatus.values()[0]))
                .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .validationType(CodeableConcept.builder().build())
                .addValidationProcess(CodeableConcept.builder().build())
                .frequency(Timing.builder().build())
                .lastPerformed(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .nextScheduled(FhirDate.parse("2024-01-01"))
                .failureAction(CodeableConcept.builder().build())
                .addPrimarySource(VerificationResult.PrimarySource.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .who(Reference.builder().build())
                        .addType(CodeableConcept.builder().build())
                        .addCommunicationMethod(CodeableConcept.builder().build())
                        .validationStatus(CodeableConcept.builder().build())
                        .validationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .canPushUpdates(CodeableConcept.builder().build())
                        .addPushTypeAvailable(CodeableConcept.builder().build())
                        .build())
                .attestation(VerificationResult.Attestation.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .who(Reference.builder().build())
                        .onBehalfOf(Reference.builder().build())
                        .communicationMethod(CodeableConcept.builder().build())
                        .date(FhirDate.parse("2024-01-01"))
                        .sourceIdentityCertificate(FhirString.of("text"))
                        .proxyIdentityCertificate(FhirString.of("text"))
                        .proxySignature(Signature.builder().build())
                        .sourceSignature(Signature.builder().build())
                        .build())
                .addValidator(VerificationResult.Validator.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .organization(Reference.builder().build())
                        .identityCertificate(FhirString.of("text"))
                        .attestationSignature(Signature.builder().build())
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
        assertFalse(resource.target().isEmpty());
        assertFalse(resource.targetLocation().isEmpty());
        assertNotNull(resource.need());
        assertNotNull(resource.status());
        assertNotNull(resource.statusDate());
        assertNotNull(resource.validationType());
        assertFalse(resource.validationProcess().isEmpty());
        assertNotNull(resource.frequency());
        assertNotNull(resource.lastPerformed());
        assertNotNull(resource.nextScheduled());
        assertNotNull(resource.failureAction());
        assertFalse(resource.primarySource().isEmpty());
        assertNotNull(resource.attestation());
        assertFalse(resource.validator().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("VerificationResult.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<VerificationResultStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(VerificationResultStatus.values(), VerificationResultStatus::fromCode);
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
