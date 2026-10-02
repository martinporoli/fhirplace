package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of operator to use for assertion.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/assert-operator-codes">FHIR R5 AssertionOperatorType</a>
 */
public enum AssertionOperatorType implements CodedEnum {

    /** Default value. */
    EQUALS("equals", "equals"),

    /** Not equals comparison. */
    NOT_EQUALS("notEquals", "notEquals"),

    /** Compare value within a known set of values. */
    IN("in", "in"),

    /** Compare value not within a known set of values. */
    NOT_IN("notIn", "notIn"),

    /** Compare value to be greater than a known value. */
    GREATER_THAN("greaterThan", "greaterThan"),

    /** Compare value to be less than a known value. */
    LESS_THAN("lessThan", "lessThan"),

    /** Compare value is empty. */
    EMPTY("empty", "empty"),

    /** Compare value is not empty. */
    NOT_EMPTY("notEmpty", "notEmpty"),

    /** Compare value string contains a known value. */
    CONTAINS("contains", "contains"),

    /** Compare value string does not contain a known value. */
    NOT_CONTAINS("notContains", "notContains"),

    /** Evaluate the FHIRPath expression as a boolean condition. */
    EVAL("eval", "evaluate"),

    /** Manually evaluate the condition described by this assert. */
    MANUAL_EVAL("manualEval", "manualEvaluate");

    private final String code;
    private final String display;

    AssertionOperatorType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/assert-operator-codes";
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
    public static AssertionOperatorType fromCode(String code) {
        for (AssertionOperatorType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AssertionOperatorType code: '" + code + "'");
    }
}
