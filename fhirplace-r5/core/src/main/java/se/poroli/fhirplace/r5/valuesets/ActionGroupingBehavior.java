package se.poroli.fhirplace.r5.valuesets;

/**
 * Defines organization behavior of a group.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-grouping-behavior">FHIR R5 ActionGroupingBehavior</a>
 */
public enum ActionGroupingBehavior implements CodedEnum {

    /** Any group marked with this behavior should be displayed as a visual group to the end user. */
    VISUAL_GROUP("visual-group", "Visual Group"),

    /**
     * A group with this behavior logically groups its sub-elements, and may be shown as a visual group to the end
     * user, but it is not required to do so.
     */
    LOGICAL_GROUP("logical-group", "Logical Group"),

    /**
     * A group of related alternative actions is a sentence group if the target referenced by the action is the same
     * in all the actions and each action simply constitutes a different variation on how to specify the details for
     * the target.
     */
    SENTENCE_GROUP("sentence-group", "Sentence Group");

    private final String code;
    private final String display;

    ActionGroupingBehavior(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-grouping-behavior";
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
    public static ActionGroupingBehavior fromCode(String code) {
        for (ActionGroupingBehavior value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionGroupingBehavior code: '" + code + "'");
    }
}
