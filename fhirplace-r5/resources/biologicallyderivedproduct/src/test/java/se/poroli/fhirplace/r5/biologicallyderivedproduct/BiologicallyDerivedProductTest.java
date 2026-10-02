package se.poroli.fhirplace.r5.biologicallyderivedproduct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a BiologicallyDerivedProduct with all elements and checks the builder and validation. */
class BiologicallyDerivedProductTest {

    @Test
    void biologicallyDerivedProduct() {
        BiologicallyDerivedProduct resource = BiologicallyDerivedProduct.builder()
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
                .productCategory(Coding.builder().build())
                .productCode(CodeableConcept.builder().build())
                .addParent(Reference.builder().build())
                .addRequest(Reference.builder().build())
                .addIdentifier(Identifier.builder().build())
                .biologicalSourceEvent(Identifier.builder().build())
                .addProcessingFacility(Reference.builder().build())
                .division(FhirString.of("text"))
                .productStatus(Coding.builder().build())
                .expirationDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .collection(BiologicallyDerivedProduct.Collection.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .collector(Reference.builder().build())
                        .source(Reference.builder().build())
                        .collected(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .storageTempRequirements(Range.builder().build())
                .addProperty(BiologicallyDerivedProduct.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBoolean.of(true))
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
        assertNotNull(resource.productCategory());
        assertNotNull(resource.productCode());
        assertFalse(resource.parent().isEmpty());
        assertFalse(resource.request().isEmpty());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.biologicalSourceEvent());
        assertFalse(resource.processingFacility().isEmpty());
        assertNotNull(resource.division());
        assertNotNull(resource.productStatus());
        assertNotNull(resource.expirationDate());
        assertNotNull(resource.collection());
        assertNotNull(resource.storageTempRequirements());
        assertFalse(resource.property().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
