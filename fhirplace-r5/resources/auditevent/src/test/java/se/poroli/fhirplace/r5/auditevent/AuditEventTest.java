package se.poroli.fhirplace.r5.auditevent;

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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBase64Binary;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a AuditEvent with all elements and checks the builder and validation. */
class AuditEventTest {

    @Test
    void auditEvent() {
        AuditEvent resource = AuditEvent.builder()
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
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .action(FhirEnum.of(AuditEventAction.values()[0]))
                .severity(FhirEnum.of(AuditEventSeverity.values()[0]))
                .occurred(Period.builder().build())
                .recorded(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .outcome(AuditEvent.Outcome.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(Coding.builder().build())
                        .addDetail(CodeableConcept.builder().build())
                        .build())
                .addAuthorization(CodeableConcept.builder().build())
                .addBasedOn(Reference.builder().build())
                .patient(Reference.builder().build())
                .encounter(Reference.builder().build())
                .addAgent(AuditEvent.Agent.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addRole(CodeableConcept.builder().build())
                        .who(Reference.builder().build())
                        .requestor(FhirBoolean.of(true))
                        .location(Reference.builder().build())
                        .addPolicy(FhirUri.of("http://example.org/uri"))
                        .network(Reference.builder().build())
                        .addAuthorization(CodeableConcept.builder().build())
                        .build())
                .source(AuditEvent.Source.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .site(Reference.builder().build())
                        .observer(Reference.builder().build())
                        .addType(CodeableConcept.builder().build())
                        .build())
                .addEntity(AuditEvent.Entity.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .what(Reference.builder().build())
                        .role(CodeableConcept.builder().build())
                        .addSecurityLabel(CodeableConcept.builder().build())
                        .query(FhirBase64Binary.of("aGk="))
                        .addDetail(AuditEvent.Entity.Detail.builder()
                                .type(CodeableConcept.builder().build())
                                .value(Quantity.builder().build())
                                .build())
                        .addAgent(AuditEvent.Agent.builder().who(Reference.builder().build()).build())
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
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.action());
        assertNotNull(resource.severity());
        assertNotNull(resource.occurred());
        assertNotNull(resource.recorded());
        assertNotNull(resource.outcome());
        assertFalse(resource.authorization().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.patient());
        assertNotNull(resource.encounter());
        assertFalse(resource.agent().isEmpty());
        assertNotNull(resource.source());
        assertFalse(resource.entity().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("AuditEvent.code is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().code((CodeableConcept) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(AuditEventAction.values(), AuditEventAction::fromCode);
        assertCodes(AuditEventSeverity.values(), AuditEventSeverity::fromCode);
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
