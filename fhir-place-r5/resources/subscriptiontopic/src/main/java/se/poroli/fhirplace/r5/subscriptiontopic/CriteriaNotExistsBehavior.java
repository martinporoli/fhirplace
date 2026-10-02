package se.poroli.fhirplace.r5.subscriptiontopic;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Behavior a server can exhibit when a criteria state does not exist (e.g., state prior to a create or after a
 * delete).
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/subscriptiontopic-cr-behavior">FHIR R5 CriteriaNotExistsBehavior</a>
 */
public enum CriteriaNotExistsBehavior implements CodedEnum {

    /**
     * The requested conditional statement will pass if a matching state does not exist (e.g., previous state during
     * create).
     */
    TEST_PASSES("test-passes", "Test passes"),

    /**
     * The requested conditional statement will fail if a matching state does not exist (e.g., previous state during
     * create).
     */
    TEST_FAILS("test-fails", "Test fails");

    private final String code;
    private final String display;

    CriteriaNotExistsBehavior(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/subscriptiontopic-cr-behavior";
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
    public static CriteriaNotExistsBehavior fromCode(String code) {
        for (CriteriaNotExistsBehavior value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CriteriaNotExistsBehavior code: '" + code + "'");
    }
}
