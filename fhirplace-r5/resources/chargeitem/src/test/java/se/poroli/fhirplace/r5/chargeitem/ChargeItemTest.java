package se.poroli.fhirplace.r5.chargeitem;

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
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.MonetaryComponent;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PriceComponentType;

/** Builds a ChargeItem with all elements and checks the builder and validation. */
class ChargeItemTest {

    @Test
    void chargeItem() {
        ChargeItem resource = ChargeItem.builder()
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
                .addDefinitionUri(FhirUri.of("http://example.org/uri"))
                .addDefinitionCanonical(FhirCanonical.of("http://example.org/canonical"))
                .status(FhirEnum.of(ChargeItemStatus.values()[0]))
                .addPartOf(Reference.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .occurrence(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addPerformer(ChargeItem.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .performingOrganization(Reference.builder().build())
                .requestingOrganization(Reference.builder().build())
                .costCenter(Reference.builder().build())
                .quantity(Quantity.builder().build())
                .addBodysite(CodeableConcept.builder().build())
                .unitPriceComponent(MonetaryComponent.builder()
                        .type(FhirEnum.of(PriceComponentType.values()[0]))
                        .build())
                .totalPriceComponent(MonetaryComponent.builder()
                        .type(FhirEnum.of(PriceComponentType.values()[0]))
                        .build())
                .overrideReason(CodeableConcept.builder().build())
                .enterer(Reference.builder().build())
                .enteredDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addReason(CodeableConcept.builder().build())
                .addService(CodeableReference.builder().build())
                .addProduct(CodeableReference.builder().build())
                .addAccount(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addSupportingInformation(Reference.builder().build())
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
        assertFalse(resource.definitionUri().isEmpty());
        assertFalse(resource.definitionCanonical().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.occurrence());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.performingOrganization());
        assertNotNull(resource.requestingOrganization());
        assertNotNull(resource.costCenter());
        assertNotNull(resource.quantity());
        assertFalse(resource.bodysite().isEmpty());
        assertNotNull(resource.unitPriceComponent());
        assertNotNull(resource.totalPriceComponent());
        assertNotNull(resource.overrideReason());
        assertNotNull(resource.enterer());
        assertNotNull(resource.enteredDate());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.service().isEmpty());
        assertFalse(resource.product().isEmpty());
        assertFalse(resource.account().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.supportingInformation().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ChargeItem.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ChargeItemStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ChargeItemStatus.values(), ChargeItemStatus::fromCode);
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
