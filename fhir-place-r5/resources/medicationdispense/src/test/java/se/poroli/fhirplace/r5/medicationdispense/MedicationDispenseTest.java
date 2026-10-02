package se.poroli.fhirplace.r5.medicationdispense;

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
import se.poroli.fhirplace.r5.datatypes.Dosage;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
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

/** Builds a MedicationDispense with all elements and checks the builder and validation. */
class MedicationDispenseTest {

    @Test
    void medicationDispense() {
        MedicationDispense resource = MedicationDispense.builder()
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
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(MedicationDispenseStatusCodes.values()[0]))
                .notPerformedReason(CodeableReference.builder().build())
                .statusChanged(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addCategory(CodeableConcept.builder().build())
                .medication(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .addPerformer(MedicationDispense.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .location(Reference.builder().build())
                .addAuthorizingPrescription(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .quantity(Quantity.builder().build())
                .daysSupply(Quantity.builder().build())
                .recorded(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .whenPrepared(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .whenHandedOver(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .destination(Reference.builder().build())
                .addReceiver(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .renderedDosageInstruction(FhirMarkdown.of("text"))
                .addDosageInstruction(Dosage.builder().build())
                .substitution(MedicationDispense.Substitution.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .wasSubstituted(FhirBoolean.of(true))
                        .type(CodeableConcept.builder().build())
                        .addReason(CodeableConcept.builder().build())
                        .responsibleParty(Reference.builder().build())
                        .build())
                .addEventHistory(Reference.builder().build())
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
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.notPerformedReason());
        assertNotNull(resource.statusChanged());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.medication());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.authorizingPrescription().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.quantity());
        assertNotNull(resource.daysSupply());
        assertNotNull(resource.recorded());
        assertNotNull(resource.whenPrepared());
        assertNotNull(resource.whenHandedOver());
        assertNotNull(resource.destination());
        assertFalse(resource.receiver().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.renderedDosageInstruction());
        assertFalse(resource.dosageInstruction().isEmpty());
        assertNotNull(resource.substitution());
        assertFalse(resource.eventHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MedicationDispense.status is required", assertThrows(NullPointerException.class,
                (
                        ) -> resource.toBuilder().status((FhirEnum<MedicationDispenseStatusCodes>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(MedicationDispenseStatusCodes.values(), MedicationDispenseStatusCodes::fromCode);
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
