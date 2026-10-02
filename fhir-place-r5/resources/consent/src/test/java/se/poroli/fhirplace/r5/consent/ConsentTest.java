package se.poroli.fhirplace.r5.consent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.ConsentDataMeaning;
import se.poroli.fhirplace.r5.valuesets.ConsentProvisionType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Consent with all elements and checks the builder and validation. */
class ConsentTest {

    @Test
    void consent() {
        Consent resource = Consent.builder()
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
                .status(FhirEnum.of(ConsentState.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .date(FhirDate.parse("2024-01-01"))
                .period(Period.builder().build())
                .addGrantor(Reference.builder().build())
                .addGrantee(Reference.builder().build())
                .addManager(Reference.builder().build())
                .addController(Reference.builder().build())
                .addSourceAttachment(Attachment.builder().build())
                .addSourceReference(Reference.builder().build())
                .addRegulatoryBasis(CodeableConcept.builder().build())
                .policyBasis(Consent.PolicyBasis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .reference(Reference.builder().build())
                        .url(FhirUrl.of("http://example.org/url"))
                        .build())
                .addPolicyText(Reference.builder().build())
                .addVerification(Consent.Verification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .verified(FhirBoolean.of(true))
                        .verificationType(CodeableConcept.builder().build())
                        .verifiedBy(Reference.builder().build())
                        .verifiedWith(Reference.builder().build())
                        .addVerificationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .decision(FhirEnum.of(ConsentProvisionType.values()[0]))
                .addProvision(Consent.provision.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .period(Period.builder().build())
                        .addActor(Consent.provision.provisionActor.builder().build())
                        .addAction(CodeableConcept.builder().build())
                        .addSecurityLabel(Coding.builder().build())
                        .addPurpose(Coding.builder().build())
                        .addDocumentType(Coding.builder().build())
                        .addResourceType(Coding.builder().build())
                        .addCode(CodeableConcept.builder().build())
                        .dataPeriod(Period.builder().build())
                        .addData(Consent.provision.provisionData.builder()
                                .meaning(FhirEnum.of(ConsentDataMeaning.values()[0]))
                                .reference(Reference.builder().build())
                                .build())
                        .expression(Expression.builder().build())
                        .addProvision(Consent.provision.builder().build())
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
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.period());
        assertFalse(resource.grantor().isEmpty());
        assertFalse(resource.grantee().isEmpty());
        assertFalse(resource.manager().isEmpty());
        assertFalse(resource.controller().isEmpty());
        assertFalse(resource.sourceAttachment().isEmpty());
        assertFalse(resource.sourceReference().isEmpty());
        assertFalse(resource.regulatoryBasis().isEmpty());
        assertNotNull(resource.policyBasis());
        assertFalse(resource.policyText().isEmpty());
        assertFalse(resource.verification().isEmpty());
        assertNotNull(resource.decision());
        assertFalse(resource.provision().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Consent.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ConsentState>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ConsentState.values(), ConsentState::fromCode);
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
