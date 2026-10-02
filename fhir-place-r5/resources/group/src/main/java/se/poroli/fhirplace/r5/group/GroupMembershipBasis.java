package se.poroli.fhirplace.r5.group;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Basis for membership in a group.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/group-membership-basis">FHIR R5 GroupMembershipBasis</a>
 */
public enum GroupMembershipBasis implements CodedEnum {

    /** The Group.characteristics specified are both necessary and sufficient to determine membership. */
    DEFINITIONAL("definitional", "Definitional"),

    /** The Group.characteristics are necessary but not sufficient to determine membership. */
    ENUMERATED("enumerated", "Enumerated");

    private final String code;
    private final String display;

    GroupMembershipBasis(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/group-membership-basis";
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String display() {
        return display;
    }

    /**
     * Returns the constant for a code.
     *
     * @param code the code, which is case-sensitive
     * @return the constant
     * @throws IllegalArgumentException if the code system does not define the code
     */
    public static GroupMembershipBasis fromCode(String code) {
        for (GroupMembershipBasis value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown GroupMembershipBasis code: '" + code + "'");
    }
}
