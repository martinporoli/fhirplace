package se.poroli.fhirplace.r5.valuesets;

/**
 * Defines the kinds of conditions that can appear on actions.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-condition-kind">FHIR R5 ActionConditionKind</a>
 */
public enum ActionConditionKind implements CodedEnum {

    /** The condition describes whether or not a given action is applicable. */
    APPLICABILITY("applicability", "Applicability"),

    /** The condition is a starting condition for the action. */
    START("start", "Start"),

    /** The condition is a stop, or exit condition for the action. */
    STOP("stop", "Stop");

    private final String code;
    private final String display;

    ActionConditionKind(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-condition-kind";
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
    public static ActionConditionKind fromCode(String code) {
        for (ActionConditionKind value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionConditionKind code: '" + code + "'");
    }
}
