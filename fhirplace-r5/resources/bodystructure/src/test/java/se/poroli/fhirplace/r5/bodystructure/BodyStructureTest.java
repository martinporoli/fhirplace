package se.poroli.fhirplace.r5.bodystructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a BodyStructure with all elements and checks the builder and validation. */
class BodyStructureTest {

    @Test
    void bodyStructure() {
        BodyStructure resource = BodyStructure.builder()
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
                .active(FhirBoolean.of(true))
                .morphology(CodeableConcept.builder().build())
                .addIncludedStructure(BodyStructure.IncludedStructure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .structure(CodeableConcept.builder().build())
                        .laterality(CodeableConcept.builder().build())
                        .addBodyLandmarkOrientation(BodyStructure.IncludedStructure.BodyLandmarkOrientation.builder()
                                
                                .build())
                        .addSpatialReference(Reference.builder().build())
                        .addQualifier(CodeableConcept.builder().build())
                        .build())
                .addExcludedStructure(BodyStructure.IncludedStructure.builder()
                        .structure(CodeableConcept.builder().build())
                        .build())
                .description(FhirMarkdown.of("text"))
                .addImage(Attachment.builder().build())
                .patient(Reference.builder().build())
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
        assertNotNull(resource.active());
        assertNotNull(resource.morphology());
        assertFalse(resource.includedStructure().isEmpty());
        assertFalse(resource.excludedStructure().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.image().isEmpty());
        assertNotNull(resource.patient());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("BodyStructure.includedStructure requires at least one value", assertThrows(
                IllegalArgumentException.class,
                (
                        ) -> resource.toBuilder().includedStructure((java.util.List<BodyStructure.IncludedStructure>) null).build()).getMessage());
    }
}
