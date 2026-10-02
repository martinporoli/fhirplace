package se.poroli.fhirplace.r5.substancepolymer;

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

/** Builds a SubstancePolymer with all elements and checks the builder and validation. */
class SubstancePolymerTest {

    @Test
    void substancePolymer() {
        SubstancePolymer resource = SubstancePolymer.builder()
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
                .identifier(Identifier.builder().build())
                .classValue(CodeableConcept.builder().build())
                .geometry(CodeableConcept.builder().build())
                .addCopolymerConnectivity(CodeableConcept.builder().build())
                .modification(FhirString.of("text"))
                .addMonomerSet(SubstancePolymer.MonomerSet.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .ratioType(CodeableConcept.builder().build())
                        .addStartingMaterial(SubstancePolymer.MonomerSet.StartingMaterial.builder().build())
                        .build())
                .addRepeat(SubstancePolymer.Repeat.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .averageMolecularFormula(FhirString.of("text"))
                        .repeatUnitAmountType(CodeableConcept.builder().build())
                        .addRepeatUnit(SubstancePolymer.Repeat.RepeatUnit.builder().build())
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
        assertNotNull(resource.identifier());
        assertNotNull(resource.classValue());
        assertNotNull(resource.geometry());
        assertFalse(resource.copolymerConnectivity().isEmpty());
        assertNotNull(resource.modification());
        assertFalse(resource.monomerSet().isEmpty());
        assertFalse(resource.repeat().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
