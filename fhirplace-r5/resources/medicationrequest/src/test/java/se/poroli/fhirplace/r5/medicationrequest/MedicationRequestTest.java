package se.poroli.fhirplace.r5.medicationrequest;

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
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;

/** Builds a MedicationRequest with all elements and checks the builder and validation. */
class MedicationRequestTest {

    @Test
    void medicationRequest() {
        MedicationRequest resource = MedicationRequest.builder()
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
                .priorPrescription(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(MedicationrequestStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .statusChanged(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .intent(FhirEnum.of(MedicationRequestIntent.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .doNotPerform(FhirBoolean.of(true))
                .medication(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .addInformationSource(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addSupportingInformation(Reference.builder().build())
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .reported(FhirBoolean.of(true))
                .performerType(CodeableConcept.builder().build())
                .addPerformer(Reference.builder().build())
                .addDevice(CodeableReference.builder().build())
                .recorder(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .courseOfTherapyType(CodeableConcept.builder().build())
                .addInsurance(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .renderedDosageInstruction(FhirMarkdown.of("text"))
                .effectiveDosePeriod(Period.builder().build())
                .addDosageInstruction(Dosage.builder().build())
                .dispenseRequest(MedicationRequest.DispenseRequest.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .initialFill(MedicationRequest.DispenseRequest.InitialFill.builder().build())
                        .dispenseInterval(Duration.builder().build())
                        .validityPeriod(Period.builder().build())
                        .numberOfRepeatsAllowed(FhirUnsignedInt.of(0))
                        .quantity(Quantity.builder().build())
                        .expectedSupplyDuration(Duration.builder().build())
                        .dispenser(Reference.builder().build())
                        .addDispenserInstruction(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .doseAdministrationAid(CodeableConcept.builder().build())
                        .build())
                .substitution(MedicationRequest.Substitution.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .allowed(FhirBoolean.of(true))
                        .reason(CodeableConcept.builder().build())
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
        assertNotNull(resource.priorPrescription());
        assertNotNull(resource.groupIdentifier());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.statusChanged());
        assertNotNull(resource.intent());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.priority());
        assertNotNull(resource.doNotPerform());
        assertNotNull(resource.medication());
        assertNotNull(resource.subject());
        assertFalse(resource.informationSource().isEmpty());
        assertNotNull(resource.encounter());
        assertFalse(resource.supportingInformation().isEmpty());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.requester());
        assertNotNull(resource.reported());
        assertNotNull(resource.performerType());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.device().isEmpty());
        assertNotNull(resource.recorder());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.courseOfTherapyType());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.renderedDosageInstruction());
        assertNotNull(resource.effectiveDosePeriod());
        assertFalse(resource.dosageInstruction().isEmpty());
        assertNotNull(resource.dispenseRequest());
        assertNotNull(resource.substitution());
        assertFalse(resource.eventHistory().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MedicationRequest.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<MedicationrequestStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(MedicationRequestIntent.values(), MedicationRequestIntent::fromCode);
        assertCodes(MedicationrequestStatus.values(), MedicationrequestStatus::fromCode);
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
