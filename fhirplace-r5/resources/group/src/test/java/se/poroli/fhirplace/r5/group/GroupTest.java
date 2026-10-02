package se.poroli.fhirplace.r5.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

class GroupTest {

    private static final CodeableConcept AGE = CodeableConcept.builder().text("age").build();

    @Test
    void buildsGroupWithCharacteristicsAndMembers() {
        Group group = Group.builder()
                .type(GroupType.PERSON)
                .membership(GroupMembershipBasis.ENUMERATED)
                .name("Adults")
                .quantity(1)
                .addCharacteristic(Group.Characteristic.builder()
                        .code(AGE)
                        .value(Range.builder().low(Quantity.builder().value(BigDecimal.valueOf(18)).build())
                                .build())
                        .exclude(false)
                        .build())
                .addMember(Group.Member.builder().entity(Reference.builder().reference("Patient/1").build()).build())
                .build();

        assertEquals("person", group.type().valueAsString());
        assertEquals("enumerated", group.membership().valueAsString());
        assertEquals(1, group.quantity().value());
        assertEquals("18", ((Range) group.characteristic().getFirst().value()).low().value().valueAsString());
        assertEquals(group, group.toBuilder().build());
    }

    @Test
    void requiresTypeAndMembership() {
        NullPointerException e = assertThrows(NullPointerException.class,
                () -> Group.builder().membership(GroupMembershipBasis.DEFINITIONAL).build());

        assertEquals("Group.type is required", e.getMessage());
    }

    @Test
    void rejectsChoiceValueOfDisallowedType() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Group.Characteristic(null, List.of(), List.of(), AGE, FhirString.of("adult"),
                        FhirBoolean.of(false), null));

        assertEquals("Group.characteristic.value[x] does not allow FhirString", e.getMessage());
    }

    @Test
    void group() {
        Group resource = Group.builder()
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
                .active(FhirBoolean.of(true))
                .type(FhirEnum.of(GroupType.values()[0]))
                .membership(FhirEnum.of(GroupMembershipBasis.values()[0]))
                .code(CodeableConcept.builder().build())
                .name(FhirString.of("text"))
                .description(FhirMarkdown.of("text"))
                .quantity(FhirUnsignedInt.of(0))
                .managingEntity(Reference.builder().build())
                .addCharacteristic(Group.Characteristic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .value(CodeableConcept.builder().build())
                        .exclude(FhirBoolean.of(true))
                        .period(Period.builder().build())
                        .build())
                .addMember(Group.Member.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .entity(Reference.builder().build())
                        .period(Period.builder().build())
                        .inactive(FhirBoolean.of(true))
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
        assertNotNull(resource.active());
        assertNotNull(resource.type());
        assertNotNull(resource.membership());
        assertNotNull(resource.code());
        assertNotNull(resource.name());
        assertNotNull(resource.description());
        assertNotNull(resource.quantity());
        assertNotNull(resource.managingEntity());
        assertFalse(resource.characteristic().isEmpty());
        assertFalse(resource.member().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Group.type is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().type((FhirEnum<GroupType>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(GroupMembershipBasis.values(), GroupMembershipBasis::fromCode);
        assertCodes(GroupType.values(), GroupType::fromCode);
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
