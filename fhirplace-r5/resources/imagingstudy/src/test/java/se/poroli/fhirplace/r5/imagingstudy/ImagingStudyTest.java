package se.poroli.fhirplace.r5.imagingstudy;

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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a ImagingStudy with all elements and checks the builder and validation. */
class ImagingStudyTest {

    @Test
    void imagingStudy() {
        ImagingStudy resource = ImagingStudy.builder()
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
                .status(FhirEnum.of(ImagingStudyStatus.values()[0]))
                .addModality(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .started(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addBasedOn(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .referrer(Reference.builder().build())
                .addEndpoint(Reference.builder().build())
                .numberOfSeries(FhirUnsignedInt.of(0))
                .numberOfInstances(FhirUnsignedInt.of(0))
                .addProcedure(CodeableReference.builder().build())
                .location(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .description(FhirString.of("text"))
                .addSeries(ImagingStudy.Series.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .uid(FhirId.of("id1"))
                        .number(FhirUnsignedInt.of(0))
                        .modality(CodeableConcept.builder().build())
                        .description(FhirString.of("text"))
                        .numberOfInstances(FhirUnsignedInt.of(0))
                        .addEndpoint(Reference.builder().build())
                        .bodySite(CodeableReference.builder().build())
                        .laterality(CodeableConcept.builder().build())
                        .addSpecimen(Reference.builder().build())
                        .started(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addPerformer(ImagingStudy.Series.Performer.builder()
                                .actor(Reference.builder().build())
                                .build())
                        .addInstance(ImagingStudy.Series.Instance.builder()
                                .uid(FhirId.of("id1"))
                                .sopClass(Coding.builder().build())
                                .build())
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
        assertFalse(resource.modality().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.started());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.referrer());
        assertFalse(resource.endpoint().isEmpty());
        assertNotNull(resource.numberOfSeries());
        assertNotNull(resource.numberOfInstances());
        assertFalse(resource.procedure().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.series().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImagingStudy.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ImagingStudyStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ImagingStudyStatus.values(), ImagingStudyStatus::fromCode);
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
