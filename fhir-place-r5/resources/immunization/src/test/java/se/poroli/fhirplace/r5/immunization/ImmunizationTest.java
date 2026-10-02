package se.poroli.fhirplace.r5.immunization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
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
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a Immunization with all elements and checks the builder and validation. */
class ImmunizationTest {

    @Test
    void immunization() {
        Immunization resource = Immunization.builder()
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
                .addBasedOn(Reference.builder().build())
                .status(FhirEnum.of(ImmunizationStatusCodes.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .vaccineCode(CodeableConcept.builder().build())
                .administeredProduct(CodeableReference.builder().build())
                .manufacturer(CodeableReference.builder().build())
                .lotNumber(FhirString.of("text"))
                .expirationDate(FhirDate.parse("2024-01-01"))
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .primarySource(FhirBoolean.of(true))
                .informationSource(CodeableReference.builder().build())
                .location(Reference.builder().build())
                .site(CodeableConcept.builder().build())
                .route(CodeableConcept.builder().build())
                .doseQuantity(Quantity.builder().build())
                .addPerformer(Immunization.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addReason(CodeableReference.builder().build())
                .isSubpotent(FhirBoolean.of(true))
                .addSubpotentReason(CodeableConcept.builder().build())
                .addProgramEligibility(Immunization.ProgramEligibility.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .program(CodeableConcept.builder().build())
                        .programStatus(CodeableConcept.builder().build())
                        .build())
                .fundingSource(CodeableConcept.builder().build())
                .addReaction(Immunization.Reaction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .manifestation(CodeableReference.builder().build())
                        .reported(FhirBoolean.of(true))
                        .build())
                .addProtocolApplied(Immunization.ProtocolApplied.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .series(FhirString.of("text"))
                        .authority(Reference.builder().build())
                        .addTargetDisease(CodeableConcept.builder().build())
                        .doseNumber(FhirString.of("text"))
                        .seriesDoses(FhirString.of("text"))
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
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.vaccineCode());
        assertNotNull(resource.administeredProduct());
        assertNotNull(resource.manufacturer());
        assertNotNull(resource.lotNumber());
        assertNotNull(resource.expirationDate());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertNotNull(resource.occurrence());
        assertNotNull(resource.primarySource());
        assertNotNull(resource.informationSource());
        assertNotNull(resource.location());
        assertNotNull(resource.site());
        assertNotNull(resource.route());
        assertNotNull(resource.doseQuantity());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.isSubpotent());
        assertFalse(resource.subpotentReason().isEmpty());
        assertFalse(resource.programEligibility().isEmpty());
        assertNotNull(resource.fundingSource());
        assertFalse(resource.reaction().isEmpty());
        assertFalse(resource.protocolApplied().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Immunization.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ImmunizationStatusCodes>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ImmunizationStatusCodes.values(), ImmunizationStatusCodes::fromCode);
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
