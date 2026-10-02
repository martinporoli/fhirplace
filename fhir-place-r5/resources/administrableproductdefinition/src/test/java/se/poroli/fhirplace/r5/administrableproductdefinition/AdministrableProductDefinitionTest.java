package se.poroli.fhirplace.r5.administrableproductdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/** Builds a AdministrableProductDefinition with all elements and checks the builder and validation. */
class AdministrableProductDefinitionTest {

    @Test
    void administrableProductDefinition() {
        AdministrableProductDefinition resource = AdministrableProductDefinition.builder()
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
                .addFormOf(Reference.builder().build())
                .administrableDoseForm(CodeableConcept.builder().build())
                .unitOfPresentation(CodeableConcept.builder().build())
                .addProducedFrom(Reference.builder().build())
                .addIngredient(CodeableConcept.builder().build())
                .device(Reference.builder().build())
                .description(FhirMarkdown.of("text"))
                .addProperty(AdministrableProductDefinition.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .build())
                .addRouteOfAdministration(AdministrableProductDefinition.RouteOfAdministration.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .firstDose(Quantity.builder().build())
                        .maxSingleDose(Quantity.builder().build())
                        .maxDosePerDay(Quantity.builder().build())
                        .maxDosePerTreatmentPeriod(Ratio.builder().build())
                        .maxTreatmentPeriod(Duration.builder().build())
                        .addTargetSpecies(AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.builder()
                                .code(CodeableConcept.builder().build())
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
        assertFalse(resource.formOf().isEmpty());
        assertNotNull(resource.administrableDoseForm());
        assertNotNull(resource.unitOfPresentation());
        assertFalse(resource.producedFrom().isEmpty());
        assertFalse(resource.ingredient().isEmpty());
        assertNotNull(resource.device());
        assertNotNull(resource.description());
        assertFalse(resource.property().isEmpty());
        assertFalse(resource.routeOfAdministration().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("AdministrableProductDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
