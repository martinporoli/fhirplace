package se.poroli.fhirplace.r5.substancenucleicacid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a SubstanceNucleicAcid with all elements and checks the builder and validation. */
class SubstanceNucleicAcidTest {

    @Test
    void substanceNucleicAcid() {
        SubstanceNucleicAcid resource = SubstanceNucleicAcid.builder()
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
                .sequenceType(CodeableConcept.builder().build())
                .numberOfSubunits(FhirInteger.of(1))
                .areaOfHybridisation(FhirString.of("text"))
                .oligoNucleotideType(CodeableConcept.builder().build())
                .addSubunit(SubstanceNucleicAcid.Subunit.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .subunit(FhirInteger.of(1))
                        .sequence(FhirString.of("text"))
                        .length(FhirInteger.of(1))
                        .sequenceAttachment(Attachment.builder().build())
                        .fivePrime(CodeableConcept.builder().build())
                        .threePrime(CodeableConcept.builder().build())
                        .addLinkage(SubstanceNucleicAcid.Subunit.Linkage.builder().build())
                        .addSugar(SubstanceNucleicAcid.Subunit.Sugar.builder().build())
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
        assertNotNull(resource.sequenceType());
        assertNotNull(resource.numberOfSubunits());
        assertNotNull(resource.areaOfHybridisation());
        assertNotNull(resource.oligoNucleotideType());
        assertFalse(resource.subunit().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }
}
