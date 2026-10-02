package se.poroli.fhirplace.r5.valuesets;

/**
 * Defines the types of relationships between actions.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-relationship-type">FHIR R5 ActionRelationshipType</a>
 */
public enum ActionRelationshipType implements CodedEnum {

    /** The action must be performed before the related action. */
    BEFORE("before", "Before"),

    /** The action must be performed before the start of the related action. */
    BEFORE_START("before-start", "Before Start"),

    /** The action must be performed before the end of the related action. */
    BEFORE_END("before-end", "Before End"),

    /** The action must be performed concurrent with the related action. */
    CONCURRENT("concurrent", "Concurrent"),

    /** The action must be performed concurrent with the start of the related action. */
    CONCURRENT_WITH_START("concurrent-with-start", "Concurrent With Start"),

    /** The action must be performed concurrent with the end of the related action. */
    CONCURRENT_WITH_END("concurrent-with-end", "Concurrent With End"),

    /** The action must be performed after the related action. */
    AFTER("after", "After"),

    /** The action must be performed after the start of the related action. */
    AFTER_START("after-start", "After Start"),

    /** The action must be performed after the end of the related action. */
    AFTER_END("after-end", "After End");

    private final String code;
    private final String display;

    ActionRelationshipType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-relationship-type";
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
    public static ActionRelationshipType fromCode(String code) {
        for (ActionRelationshipType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionRelationshipType code: '" + code + "'");
    }
}
