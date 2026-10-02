package se.poroli.fhirplace.r5.person;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The level of confidence that this link represents the same actual person, based on NIST Authentication Levels.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/identity-assuranceLevel">FHIR R5 IdentityAssuranceLevel</a>
 */
public enum IdentityAssuranceLevel implements CodedEnum {

    /** Little or no confidence in the asserted identity's accuracy. */
    LEVEL1("level1", "Level 1"),

    /** Some confidence in the asserted identity's accuracy. */
    LEVEL2("level2", "Level 2"),

    /** High confidence in the asserted identity's accuracy. */
    LEVEL3("level3", "Level 3"),

    /** Very high confidence in the asserted identity's accuracy. */
    LEVEL4("level4", "Level 4");

    private final String code;
    private final String display;

    IdentityAssuranceLevel(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/identity-assuranceLevel";
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
    public static IdentityAssuranceLevel fromCode(String code) {
        for (IdentityAssuranceLevel value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown IdentityAssuranceLevel code: '" + code + "'");
    }
}
