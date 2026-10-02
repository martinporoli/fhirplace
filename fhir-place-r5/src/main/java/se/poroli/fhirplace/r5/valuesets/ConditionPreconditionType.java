package se.poroli.fhirplace.r5.valuesets;

/**
 * Kind of precondition for the condition.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/condition-precondition-type">FHIR R5 ConditionPreconditionType</a>
 */
public enum ConditionPreconditionType implements CodedEnum {

    /** The observation is very sensitive for the condition, but may also indicate other conditions. */
    SENSITIVE("sensitive", "Sensitive"),

    /** The observation is very specific for this condition, but not particularly sensitive. */
    SPECIFIC("specific", "Specific");

    private final String code;
    private final String display;

    ConditionPreconditionType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/condition-precondition-type";
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
    public static ConditionPreconditionType fromCode(String code) {
        for (ConditionPreconditionType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConditionPreconditionType code: '" + code + "'");
    }
}
