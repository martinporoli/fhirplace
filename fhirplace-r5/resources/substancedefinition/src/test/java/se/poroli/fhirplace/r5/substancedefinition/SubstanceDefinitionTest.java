package se.poroli.fhirplace.r5.substancedefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
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
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Ratio;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a SubstanceDefinition with all elements and checks the builder and validation. */
class SubstanceDefinitionTest {

    @Test
    void substanceDefinition() {
        SubstanceDefinition resource = SubstanceDefinition.builder()
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
                .version(FhirString.of("text"))
                .status(CodeableConcept.builder().build())
                .addClassification(CodeableConcept.builder().build())
                .domain(CodeableConcept.builder().build())
                .addGrade(CodeableConcept.builder().build())
                .description(FhirMarkdown.of("text"))
                .addInformationSource(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addManufacturer(Reference.builder().build())
                .addSupplier(Reference.builder().build())
                .addMoiety(SubstanceDefinition.Moiety.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .role(CodeableConcept.builder().build())
                        .identifier(Identifier.builder().build())
                        .name(FhirString.of("text"))
                        .stereochemistry(CodeableConcept.builder().build())
                        .opticalActivity(CodeableConcept.builder().build())
                        .molecularFormula(FhirString.of("text"))
                        .amount(Quantity.builder().build())
                        .measurementType(CodeableConcept.builder().build())
                        .build())
                .addCharacterization(SubstanceDefinition.Characterization.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .technique(CodeableConcept.builder().build())
                        .form(CodeableConcept.builder().build())
                        .description(FhirMarkdown.of("text"))
                        .addFile(Attachment.builder().build())
                        .build())
                .addProperty(SubstanceDefinition.Property.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .referenceInformation(Reference.builder().build())
                .addMolecularWeight(SubstanceDefinition.MolecularWeight.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .method(CodeableConcept.builder().build())
                        .type(CodeableConcept.builder().build())
                        .amount(Quantity.builder().build())
                        .build())
                .structure(SubstanceDefinition.Structure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .stereochemistry(CodeableConcept.builder().build())
                        .opticalActivity(CodeableConcept.builder().build())
                        .molecularFormula(FhirString.of("text"))
                        .molecularFormulaByMoiety(FhirString.of("text"))
                        .molecularWeight(SubstanceDefinition.MolecularWeight.builder()
                                .amount(Quantity.builder().build())
                                .build())
                        .addTechnique(CodeableConcept.builder().build())
                        .addSourceDocument(Reference.builder().build())
                        .addRepresentation(SubstanceDefinition.Structure.Representation.builder().build())
                        .build())
                .addCode(SubstanceDefinition.Code.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .statusDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .addSource(Reference.builder().build())
                        .build())
                .addName(SubstanceDefinition.Name.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .type(CodeableConcept.builder().build())
                        .status(CodeableConcept.builder().build())
                        .preferred(FhirBoolean.of(true))
                        .addLanguage(CodeableConcept.builder().build())
                        .addDomain(CodeableConcept.builder().build())
                        .addJurisdiction(CodeableConcept.builder().build())
                        .addSynonym(SubstanceDefinition.Name.builder().name(FhirString.of("text")).build())
                        .addTranslation(SubstanceDefinition.Name.builder().name(FhirString.of("text")).build())
                        .addOfficial(SubstanceDefinition.Name.Official.builder().build())
                        .addSource(Reference.builder().build())
                        .build())
                .addRelationship(SubstanceDefinition.Relationship.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .substanceDefinition(Reference.builder().build())
                        .type(CodeableConcept.builder().build())
                        .isDefining(FhirBoolean.of(true))
                        .amount(Quantity.builder().build())
                        .ratioHighLimitAmount(Ratio.builder().build())
                        .comparator(CodeableConcept.builder().build())
                        .addSource(Reference.builder().build())
                        .build())
                .nucleicAcid(Reference.builder().build())
                .polymer(Reference.builder().build())
                .protein(Reference.builder().build())
                .sourceMaterial(SubstanceDefinition.SourceMaterial.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .genus(CodeableConcept.builder().build())
                        .species(CodeableConcept.builder().build())
                        .part(CodeableConcept.builder().build())
                        .addCountryOfOrigin(CodeableConcept.builder().build())
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
        assertNotNull(resource.version());
        assertNotNull(resource.status());
        assertFalse(resource.classification().isEmpty());
        assertNotNull(resource.domain());
        assertFalse(resource.grade().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.informationSource().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.manufacturer().isEmpty());
        assertFalse(resource.supplier().isEmpty());
        assertFalse(resource.moiety().isEmpty());
        assertFalse(resource.characterization().isEmpty());
        assertFalse(resource.property().isEmpty());
        assertNotNull(resource.referenceInformation());
        assertFalse(resource.molecularWeight().isEmpty());
        assertNotNull(resource.structure());
        assertFalse(resource.code().isEmpty());
        assertFalse(resource.name().isEmpty());
        assertFalse(resource.relationship().isEmpty());
        assertNotNull(resource.nucleicAcid());
        assertNotNull(resource.polymer());
        assertNotNull(resource.protein());
        assertNotNull(resource.sourceMaterial());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
