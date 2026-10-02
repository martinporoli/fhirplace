package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes that reflect the current state of a goal and whether the goal is still being targeted.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/goal-status">FHIR R5 GoalLifecycleStatus</a>
 */
public enum GoalLifecycleStatus implements CodedEnum {

    /** A goal is proposed for this patient. */
    PROPOSED("proposed", "Proposed"),

    /** A goal is planned for this patient. */
    PLANNED("planned", "Planned"),

    /** A proposed goal was accepted or acknowledged. */
    ACCEPTED("accepted", "Accepted"),

    /** The goal is being sought actively. */
    ACTIVE("active", "Active"),

    /**
     * The goal remains a long term objective but is no longer being actively pursued for a temporary period of time.
     */
    ON_HOLD("on-hold", "On Hold"),

    /** The goal is no longer being sought. */
    COMPLETED("completed", "Completed"),

    /** The goal has been abandoned. */
    CANCELLED("cancelled", "Cancelled"),

    /** The goal was entered in error and voided. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** A proposed goal was rejected. */
    REJECTED("rejected", "Rejected");

    private final String code;
    private final String display;

    GoalLifecycleStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/goal-status";
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
    public static GoalLifecycleStatus fromCode(String code) {
        for (GoalLifecycleStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown GoalLifecycleStatus code: '" + code + "'");
    }
}
