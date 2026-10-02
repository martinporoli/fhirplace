package se.poroli.fhirplace.r5.valuesets;

/**
 * Defines expectations around whether an action or action group is required.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-required-behavior">FHIR R5 ActionRequiredBehavior</a>
 */
public enum ActionRequiredBehavior implements CodedEnum {

    /**
     * An action with this behavior must be included in the actions processed by the end user; the end user SHALL NOT
     * choose not to include this action.
     */
    MUST("must", "Must"),

    /** An action with this behavior may be included in the set of actions processed by the end user. */
    COULD("could", "Could"),

    /**
     * An action with this behavior must be included in the set of actions processed by the end user, unless the end
     * user provides documentation as to why the action was not included.
     */
    MUST_UNLESS_DOCUMENTED("must-unless-documented", "Must Unless Documented");

    private final String code;
    private final String display;

    ActionRequiredBehavior(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-required-behavior";
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
    public static ActionRequiredBehavior fromCode(String code) {
        for (ActionRequiredBehavior value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionRequiredBehavior code: '" + code + "'");
    }
}
