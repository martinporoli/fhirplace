package se.poroli.fhirplace.r5.careplan;

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
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
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
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RequestStatus;

/** Builds a CarePlan with all elements and checks the builder and validation. */
class CarePlanTest {

    @Test
    void carePlan() {
        CarePlan resource = CarePlan.builder()
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
                .addInstantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .addInstantiatesUri(FhirUri.of("http://example.org/uri"))
                .addBasedOn(Reference.builder().build())
                .addReplaces(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(RequestStatus.values()[0]))
                .intent(FhirEnum.of(CarePlanIntent.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .title(FhirString.of("text"))
                .description(FhirString.of("text"))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .period(Period.builder().build())
                .created(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .custodian(Reference.builder().build())
                .addContributor(Reference.builder().build())
                .addCareTeam(Reference.builder().build())
                .addAddresses(CodeableReference.builder().build())
                .addSupportingInfo(Reference.builder().build())
                .addGoal(Reference.builder().build())
                .addActivity(CarePlan.Activity.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addPerformedActivity(CodeableReference.builder().build())
                        .addProgress(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .plannedActivityReference(Reference.builder().build())
                        .build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
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
        assertFalse(resource.instantiatesCanonical().isEmpty());
        assertFalse(resource.instantiatesUri().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.replaces().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.intent());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.title());
        assertNotNull(resource.description());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.period());
        assertNotNull(resource.created());
        assertNotNull(resource.custodian());
        assertFalse(resource.contributor().isEmpty());
        assertFalse(resource.careTeam().isEmpty());
        assertFalse(resource.addresses().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.goal().isEmpty());
        assertFalse(resource.activity().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("CarePlan.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<RequestStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(CarePlanIntent.values(), CarePlanIntent::fromCode);
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
