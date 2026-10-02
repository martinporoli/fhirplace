package se.poroli.fhirplace.r5.guidanceresponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a GuidanceResponse with all elements and checks the builder and validation. */
class GuidanceResponseTest {

    @Test
    void guidanceResponse() {
        GuidanceResponse resource = GuidanceResponse.builder()
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
                .requestIdentifier(Identifier.builder().build())
                .addIdentifier(Identifier.builder().build())
                .module(FhirUri.of("http://example.org/uri"))
                .status(FhirEnum.of(GuidanceResponseStatus.values()[0]))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrenceDateTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .performer(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .evaluationMessage(Reference.builder().build())
                .outputParameters(Reference.builder().build())
                .addResult(Reference.builder().build())
                .addDataRequirement(DataRequirement.builder()
                        .type(FhirEnum.of(FHIRTypes.values()[0]))
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
        assertNotNull(resource.requestIdentifier());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.module());
        assertNotNull(resource.status());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrenceDateTime());
        assertNotNull(resource.performer());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.evaluationMessage());
        assertNotNull(resource.outputParameters());
        assertFalse(resource.result().isEmpty());
        assertFalse(resource.dataRequirement().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("GuidanceResponse.module is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().module((FhirUri) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(GuidanceResponseStatus.values(), GuidanceResponseStatus::fromCode);
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
