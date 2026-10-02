package se.poroli.fhirplace.r5.genomicstudy;

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
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
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

/** Builds a GenomicStudy with all elements and checks the builder and validation. */
class GenomicStudyTest {

    @Test
    void genomicStudy() {
        GenomicStudy resource = GenomicStudy.builder()
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
                .status(FhirEnum.of(GenomicStudyStatus.values()[0]))
                .addType(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .startDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addBasedOn(Reference.builder().build())
                .referrer(Reference.builder().build())
                .addInterpreter(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .instantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .instantiatesUri(FhirUri.of("http://example.org/uri"))
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .description(FhirMarkdown.of("text"))
                .addAnalysis(GenomicStudy.Analysis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .addMethodType(CodeableConcept.builder().build())
                        .addChangeType(CodeableConcept.builder().build())
                        .genomeBuild(CodeableConcept.builder().build())
                        .instantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                        .instantiatesUri(FhirUri.of("http://example.org/uri"))
                        .title(FhirString.of("text"))
                        .addFocus(Reference.builder().build())
                        .addSpecimen(Reference.builder().build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .protocolPerformed(Reference.builder().build())
                        .addRegionsStudied(Reference.builder().build())
                        .addRegionsCalled(Reference.builder().build())
                        .addInput(GenomicStudy.Analysis.Input.builder().build())
                        .addOutput(GenomicStudy.Analysis.Output.builder().build())
                        .addPerformer(GenomicStudy.Analysis.Performer.builder().build())
                        .addDevice(GenomicStudy.Analysis.Device.builder().build())
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
        assertFalse(resource.type().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.startDate());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.referrer());
        assertFalse(resource.interpreter().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.instantiatesCanonical());
        assertNotNull(resource.instantiatesUri());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.analysis().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("GenomicStudy.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<GenomicStudyStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(GenomicStudyStatus.values(), GenomicStudyStatus::fromCode);
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
