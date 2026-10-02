package se.poroli.fhirplace.r5.episodeofcare;

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
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a EpisodeOfCare with all elements and checks the builder and validation. */
class EpisodeOfCareTest {

    @Test
    void episodeOfCare() {
        EpisodeOfCare resource = EpisodeOfCare.builder()
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
                .status(FhirEnum.of(EpisodeOfCareStatus.values()[0]))
                .addStatusHistory(EpisodeOfCare.StatusHistory.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .status(FhirEnum.of(EpisodeOfCareStatus.values()[0]))
                        .period(Period.builder().build())
                        .build())
                .addType(CodeableConcept.builder().build())
                .addReason(EpisodeOfCare.Reason.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .use(CodeableConcept.builder().build())
                        .addValue(CodeableReference.builder().build())
                        .build())
                .addDiagnosis(EpisodeOfCare.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addCondition(CodeableReference.builder().build())
                        .use(CodeableConcept.builder().build())
                        .build())
                .patient(Reference.builder().build())
                .managingOrganization(Reference.builder().build())
                .period(Period.builder().build())
                .addReferralRequest(Reference.builder().build())
                .careManager(Reference.builder().build())
                .addCareTeam(Reference.builder().build())
                .addAccount(Reference.builder().build())
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
        assertFalse(resource.statusHistory().isEmpty());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertNotNull(resource.patient());
        assertNotNull(resource.managingOrganization());
        assertNotNull(resource.period());
        assertFalse(resource.referralRequest().isEmpty());
        assertNotNull(resource.careManager());
        assertFalse(resource.careTeam().isEmpty());
        assertFalse(resource.account().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("EpisodeOfCare.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EpisodeOfCareStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(EpisodeOfCareStatus.values(), EpisodeOfCareStatus::fromCode);
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
