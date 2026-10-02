package se.poroli.fhirplace.r5.valuesets;

/**
 * Defines behavior for an action or a group for how many times that item may be repeated.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-cardinality-behavior">FHIR R5 ActionCardinalityBehavior</a>
 */
public enum ActionCardinalityBehavior implements CodedEnum {

    /** The action may only be selected one time. */
    SINGLE("single", "Single"),

    /** The action may be selected multiple times. */
    MULTIPLE("multiple", "Multiple");

    private final String code;
    private final String display;

    ActionCardinalityBehavior(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-cardinality-behavior";
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
    public static ActionCardinalityBehavior fromCode(String code) {
        for (ActionCardinalityBehavior value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionCardinalityBehavior code: '" + code + "'");
    }
}
