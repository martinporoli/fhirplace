package se.poroli.fhirplace.r5.clinicalusedefinition;

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
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a ClinicalUseDefinition with all elements and checks the builder and validation. */
class ClinicalUseDefinitionTest {

    @Test
    void clinicalUseDefinition() {
        ClinicalUseDefinition resource = ClinicalUseDefinition.builder()
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
                .type(FhirEnum.of(ClinicalUseDefinitionType.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .addSubject(Reference.builder().build())
                .status(CodeableConcept.builder().build())
                .contraindication(ClinicalUseDefinition.Contraindication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .diseaseSymptomProcedure(CodeableReference.builder().build())
                        .diseaseStatus(CodeableReference.builder().build())
                        .addComorbidity(CodeableReference.builder().build())
                        .addIndication(Reference.builder().build())
                        .applicability(Expression.builder().build())
                        .addOtherTherapy(ClinicalUseDefinition.Contraindication.OtherTherapy.builder()
                                .relationshipType(CodeableConcept.builder().build())
                                .treatment(CodeableReference.builder().build())
                                .build())
                        .build())
                .indication(ClinicalUseDefinition.Indication.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .diseaseSymptomProcedure(CodeableReference.builder().build())
                        .diseaseStatus(CodeableReference.builder().build())
                        .addComorbidity(CodeableReference.builder().build())
                        .intendedEffect(CodeableReference.builder().build())
                        .duration(Range.builder().build())
                        .addUndesirableEffect(Reference.builder().build())
                        .applicability(Expression.builder().build())
                        .addOtherTherapy(ClinicalUseDefinition.Contraindication.OtherTherapy.builder()
                                .relationshipType(CodeableConcept.builder().build())
                                .treatment(CodeableReference.builder().build())
                                .build())
                        .build())
                .interaction(ClinicalUseDefinition.Interaction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addInteractant(ClinicalUseDefinition.Interaction.Interactant.builder()
                                .item(Reference.builder().build())
                                .build())
                        .type(CodeableConcept.builder().build())
                        .effect(CodeableReference.builder().build())
                        .incidence(CodeableConcept.builder().build())
                        .addManagement(CodeableConcept.builder().build())
                        .build())
                .addPopulation(Reference.builder().build())
                .addLibrary(FhirCanonical.of("http://example.org/canonical"))
                .undesirableEffect(ClinicalUseDefinition.UndesirableEffect.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .symptomConditionEffect(CodeableReference.builder().build())
                        .classification(CodeableConcept.builder().build())
                        .frequencyOfOccurrence(CodeableConcept.builder().build())
                        .build())
                .warning(ClinicalUseDefinition.Warning.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .code(CodeableConcept.builder().build())
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
        assertNotNull(resource.type());
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.contraindication());
        assertNotNull(resource.indication());
        assertNotNull(resource.interaction());
        assertFalse(resource.population().isEmpty());
        assertFalse(resource.library().isEmpty());
        assertNotNull(resource.undesirableEffect());
        assertNotNull(resource.warning());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ClinicalUseDefinition.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((FhirEnum<ClinicalUseDefinitionType>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ClinicalUseDefinitionType.values(), ClinicalUseDefinitionType::fromCode);
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
