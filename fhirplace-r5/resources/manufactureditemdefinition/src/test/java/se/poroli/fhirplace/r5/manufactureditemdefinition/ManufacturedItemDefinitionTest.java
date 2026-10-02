package se.poroli.fhirplace.r5.manufactureditemdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.MarketingStatus;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/** Builds a ManufacturedItemDefinition with all elements and checks the builder and validation. */
class ManufacturedItemDefinitionTest {

    @Test
    void manufacturedItemDefinition() {
        ManufacturedItemDefinition resource = ManufacturedItemDefinition.builder()
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
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .name(FhirString.of("text"))
                .manufacturedDoseForm(CodeableConcept.builder().build())
                .unitOfPresentation(CodeableConcept.builder().build())
                .addManufacturer(Reference.builder().build())
                .addMarketingStatus(MarketingStatus.builder()
                        .status(CodeableConcept.builder().build())
                        .build())
                .addIngredient(CodeableConcept.builder().build())
                .addProperty(ManufacturedItemDefinition.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addComponent(ManufacturedItemDefinition.Component.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addFunction(CodeableConcept.builder().build())
                        .addAmount(Quantity.builder().build())
                        .addConstituent(ManufacturedItemDefinition.Component.Constituent.builder().build())
                        .addProperty(ManufacturedItemDefinition.Property.builder()
                                .type(CodeableConcept.builder().build())
                                .build())
                        .addComponent(ManufacturedItemDefinition.Component.builder()
                                .type(CodeableConcept.builder().build())
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
        assertNotNull(resource.name());
        assertNotNull(resource.manufacturedDoseForm());
        assertNotNull(resource.unitOfPresentation());
        assertFalse(resource.manufacturer().isEmpty());
        assertFalse(resource.marketingStatus().isEmpty());
        assertFalse(resource.ingredient().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertFalse(resource.component().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ManufacturedItemDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
