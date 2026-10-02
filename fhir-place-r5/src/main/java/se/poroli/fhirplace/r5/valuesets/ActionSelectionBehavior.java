package se.poroli.fhirplace.r5.valuesets;

/**
 * Defines selection behavior of a group.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-selection-behavior">FHIR R5 ActionSelectionBehavior</a>
 */
public enum ActionSelectionBehavior implements CodedEnum {

    /** Any number of the actions in the group may be chosen, from zero to all. */
    ANY("any", "Any"),

    /** All the actions in the group must be selected as a single unit. */
    ALL("all", "All"),

    /**
     * All the actions in the group are meant to be chosen as a single unit: either all must be selected by the end
     * user, or none may be selected.
     */
    ALL_OR_NONE("all-or-none", "All Or None"),

    /** The end user must choose one and only one of the selectable actions in the group. */
    EXACTLY_ONE("exactly-one", "Exactly One"),

    /** The end user may choose zero or at most one of the actions in the group. */
    AT_MOST_ONE("at-most-one", "At Most One"),

    /** The end user must choose a minimum of one, and as many additional as desired. */
    ONE_OR_MORE("one-or-more", "One Or More");

    private final String code;
    private final String display;

    ActionSelectionBehavior(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-selection-behavior";
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
    public static ActionSelectionBehavior fromCode(String code) {
        for (ActionSelectionBehavior value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionSelectionBehavior code: '" + code + "'");
    }
}
