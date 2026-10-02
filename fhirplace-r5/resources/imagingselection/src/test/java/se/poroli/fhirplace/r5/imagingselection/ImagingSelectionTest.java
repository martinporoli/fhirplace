package se.poroli.fhirplace.r5.imagingselection;

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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
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

/** Builds a ImagingSelection with all elements and checks the builder and validation. */
class ImagingSelectionTest {

    @Test
    void imagingSelection() {
        ImagingSelection resource = ImagingSelection.builder()
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
                .status(FhirEnum.of(ImagingSelectionStatus.values()[0]))
                .subject(Reference.builder().build())
                .issued(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPerformer(ImagingSelection.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addBasedOn(Reference.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .studyUid(FhirId.of("id1"))
                .addDerivedFrom(Reference.builder().build())
                .addEndpoint(Reference.builder().build())
                .seriesUid(FhirId.of("id1"))
                .seriesNumber(FhirUnsignedInt.of(0))
                .frameOfReferenceUid(FhirId.of("id1"))
                .bodySite(CodeableReference.builder().build())
                .addFocus(Reference.builder().build())
                .addInstance(ImagingSelection.Instance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .uid(FhirId.of("id1"))
                        .number(FhirUnsignedInt.of(0))
                        .sopClass(Coding.builder().build())
                        .addSubset(FhirString.of("text"))
                        .addImageRegion2D(ImagingSelection.Instance.ImageRegion2D.builder()
                                .regionType(FhirEnum.of(ImagingSelection2DGraphicType.values()[0]))
                                .addCoordinate(FhirDecimal.parse("1.0"))
                                .build())
                        .addImageRegion3D(ImagingSelection.Instance.ImageRegion3D.builder()
                                .regionType(FhirEnum.of(ImagingSelection3DGraphicType.values()[0]))
                                .addCoordinate(FhirDecimal.parse("1.0"))
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
        assertNotNull(resource.subject());
        assertNotNull(resource.issued());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.studyUid());
        assertFalse(resource.derivedFrom().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertNotNull(resource.seriesUid());
        assertNotNull(resource.seriesNumber());
        assertNotNull(resource.frameOfReferenceUid());
        assertNotNull(resource.bodySite());
        assertFalse(resource.focus().isEmpty());
        assertFalse(resource.instance().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImagingSelection.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ImagingSelectionStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ImagingSelection2DGraphicType.values(), ImagingSelection2DGraphicType::fromCode);
        assertCodes(ImagingSelection3DGraphicType.values(), ImagingSelection3DGraphicType::fromCode);
        assertCodes(ImagingSelectionStatus.values(), ImagingSelectionStatus::fromCode);
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
