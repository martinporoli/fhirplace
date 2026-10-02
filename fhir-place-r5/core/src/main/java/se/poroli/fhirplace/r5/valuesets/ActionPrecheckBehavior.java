package se.poroli.fhirplace.r5.valuesets;

/**
 * Defines selection frequency behavior for an action or group.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-precheck-behavior">FHIR R5 ActionPrecheckBehavior</a>
 */
public enum ActionPrecheckBehavior implements CodedEnum {

    /**
     * An action with this behavior is one of the most frequent action that is, or should be, included by an end user,
     * for the particular context in which the action occurs.
     */
    YES("yes", "Yes"),

    /**
     * An action with this behavior is one of the less frequent actions included by the end user, for the particular
     * context in which the action occurs.
     */
    NO("no", "No");

    private final String code;
    private final String display;

    ActionPrecheckBehavior(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-precheck-behavior";
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
    public static ActionPrecheckBehavior fromCode(String code) {
        for (ActionPrecheckBehavior value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionPrecheckBehavior code: '" + code + "'");
    }
}
