package se.poroli.fhirplace.r5.diagnosticreport;

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
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a DiagnosticReport with all elements and checks the builder and validation. */
class DiagnosticReportTest {

    @Test
    void diagnosticReport() {
        DiagnosticReport resource = DiagnosticReport.builder()
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
                .addBasedOn(Reference.builder().build())
                .status(FhirEnum.of(DiagnosticReportStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .effective(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .issued(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPerformer(Reference.builder().build())
                .addResultsInterpreter(Reference.builder().build())
                .addSpecimen(Reference.builder().build())
                .addResult(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addStudy(Reference.builder().build())
                .addSupportingInfo(DiagnosticReport.SupportingInfo.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .reference(Reference.builder().build())
                        .build())
                .addMedia(DiagnosticReport.Media.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .comment(FhirString.of("text"))
                        .link(Reference.builder().build())
                        .build())
                .composition(Reference.builder().build())
                .conclusion(FhirMarkdown.of("text"))
                .addConclusionCode(CodeableConcept.builder().build())
                .addPresentedForm(Attachment.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.effective());
        assertNotNull(resource.issued());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.resultsInterpreter().isEmpty());
        assertFalse(resource.specimen().isEmpty());
        assertFalse(resource.result().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.study().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.media().isEmpty());
        assertNotNull(resource.composition());
        assertNotNull(resource.conclusion());
        assertFalse(resource.conclusionCode().isEmpty());
        assertFalse(resource.presentedForm().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DiagnosticReport.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<DiagnosticReportStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(DiagnosticReportStatus.values(), DiagnosticReportStatus::fromCode);
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
