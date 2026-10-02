package se.poroli.fhirplace.r5.transport;

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
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RequestPriority;

/** Builds a Transport with all elements and checks the builder and validation. */
class TransportTest {

    @Test
    void transport() {
        Transport resource = Transport.builder()
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
                .instantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .instantiatesUri(FhirUri.of("http://example.org/uri"))
                .addBasedOn(Reference.builder().build())
                .groupIdentifier(Identifier.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(TransportStatus.values()[0]))
                .statusReason(CodeableConcept.builder().build())
                .intent(FhirCode.of("code"))
                .priority(FhirEnum.of(RequestPriority.values()[0]))
                .code(CodeableConcept.builder().build())
                .description(FhirString.of("text"))
                .focus(Reference.builder().build())
                .forValue(Reference.builder().build())
                .encounter(Reference.builder().build())
                .completionTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .authoredOn(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .lastModified(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .requester(Reference.builder().build())
                .addPerformerType(CodeableConcept.builder().build())
                .owner(Reference.builder().build())
                .location(Reference.builder().build())
                .addInsurance(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addRelevantHistory(Reference.builder().build())
                .restriction(Transport.Restriction.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .repetitions(FhirPositiveInt.of(1))
                        .period(Period.builder().build())
                        .addRecipient(Reference.builder().build())
                        .build())
                .addInput(Transport.Parameter.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBase64Binary.of("aGk="))
                        .build())
                .addOutput(Transport.Output.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .value(FhirBase64Binary.of("aGk="))
                        .build())
                .requestedLocation(Reference.builder().build())
                .currentLocation(Reference.builder().build())
                .reason(CodeableReference.builder().build())
                .history(Reference.builder().build())
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
        assertNotNull(resource.instantiatesCanonical());
        assertNotNull(resource.instantiatesUri());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.groupIdentifier());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.statusReason());
        assertNotNull(resource.intent());
        assertNotNull(resource.priority());
        assertNotNull(resource.code());
        assertNotNull(resource.description());
        assertNotNull(resource.focus());
        assertNotNull(resource.forValue());
        assertNotNull(resource.encounter());
        assertNotNull(resource.completionTime());
        assertNotNull(resource.authoredOn());
        assertNotNull(resource.lastModified());
        assertNotNull(resource.requester());
        assertFalse(resource.performerType().isEmpty());
        assertNotNull(resource.owner());
        assertNotNull(resource.location());
        assertFalse(resource.insurance().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.relevantHistory().isEmpty());
        assertNotNull(resource.restriction());
        assertFalse(resource.input().isEmpty());
        assertFalse(resource.output().isEmpty());
        assertNotNull(resource.requestedLocation());
        assertNotNull(resource.currentLocation());
        assertNotNull(resource.reason());
        assertNotNull(resource.history());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Transport.intent is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().intent((FhirCode) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(TransportStatus.values(), TransportStatus::fromCode);
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
