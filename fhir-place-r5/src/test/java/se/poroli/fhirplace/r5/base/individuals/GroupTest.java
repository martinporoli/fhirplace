package se.poroli.fhirplace.r5.base.individuals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.GroupMembershipBasis;
import se.poroli.fhirplace.r5.valuesets.GroupType;

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
}
