package se.poroli.fhirplace.r5.substancesourcematerial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a SubstanceSourceMaterial with all elements and checks the builder and validation. */
class SubstanceSourceMaterialTest {

    @Test
    void substanceSourceMaterial() {
        SubstanceSourceMaterial resource = SubstanceSourceMaterial.builder()
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
                .sourceMaterialClass(CodeableConcept.builder().build())
                .sourceMaterialType(CodeableConcept.builder().build())
                .sourceMaterialState(CodeableConcept.builder().build())
                .organismId(Identifier.builder().build())
                .organismName(FhirString.of("text"))
                .addParentSubstanceId(Identifier.builder().build())
                .addParentSubstanceName(FhirString.of("text"))
                .addCountryOfOrigin(CodeableConcept.builder().build())
                .addGeographicalLocation(FhirString.of("text"))
                .developmentStage(CodeableConcept.builder().build())
                .addFractionDescription(SubstanceSourceMaterial.FractionDescription.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .fraction(FhirString.of("text"))
                        .materialType(CodeableConcept.builder().build())
                        .build())
                .organism(SubstanceSourceMaterial.Organism.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .family(CodeableConcept.builder().build())
                        .genus(CodeableConcept.builder().build())
                        .species(CodeableConcept.builder().build())
                        .intraspecificType(CodeableConcept.builder().build())
                        .intraspecificDescription(FhirString.of("text"))
                        .addAuthor(SubstanceSourceMaterial.Organism.Author.builder().build())
                        .hybrid(SubstanceSourceMaterial.Organism.Hybrid.builder().build())
                        .organismGeneral(SubstanceSourceMaterial.Organism.OrganismGeneral.builder().build())
                        .build())
                .addPartDescription(SubstanceSourceMaterial.PartDescription.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .part(CodeableConcept.builder().build())
                        .partLocation(CodeableConcept.builder().build())
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
        assertNotNull(resource.sourceMaterialClass());
        assertNotNull(resource.sourceMaterialType());
        assertNotNull(resource.sourceMaterialState());
        assertNotNull(resource.organismId());
        assertNotNull(resource.organismName());
        assertFalse(resource.parentSubstanceId().isEmpty());
        assertFalse(resource.parentSubstanceName().isEmpty());
        assertFalse(resource.countryOfOrigin().isEmpty());
        assertFalse(resource.geographicalLocation().isEmpty());
        assertNotNull(resource.developmentStage());
        assertFalse(resource.fractionDescription().isEmpty());
        assertNotNull(resource.organism());
        assertFalse(resource.partDescription().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
