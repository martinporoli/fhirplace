package se.poroli.fhirplace.r5.valuesets;

/**
 * The current status of the task.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/task-status">FHIR R5 TaskStatus</a>
 */
public enum TaskStatus implements CodedEnum {

    /** The task is not yet ready to be acted upon. */
    DRAFT("draft", "Draft"),

    /** The task is ready to be acted upon and action is sought. */
    REQUESTED("requested", "Requested"),

    /** A potential performer has claimed ownership of the task and is evaluating whether to perform it. */
    RECEIVED("received", "Received"),

    /** The potential performer has agreed to execute the task but has not yet started work. */
    ACCEPTED("accepted", "Accepted"),

    /**
     * The potential performer who claimed ownership of the task has decided not to execute it prior to performing any
     * action.
     */
    REJECTED("rejected", "Rejected"),

    /** The task is ready to be performed, but no action has yet been taken. */
    READY("ready", "Ready"),

    /** The task was not completed. */
    CANCELLED("cancelled", "Cancelled"),

    /** The task has been started but is not yet complete. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** The task has been started but work has been paused. */
    ON_HOLD("on-hold", "On Hold"),

    /** The task was attempted but could not be completed due to some error. */
    FAILED("failed", "Failed"),

    /** The task has been completed. */
    COMPLETED("completed", "Completed"),

    /** The task should never have existed and is retained only because of the possibility it may have used. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    TaskStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/task-status";
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
    public static TaskStatus fromCode(String code) {
        for (TaskStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TaskStatus code: '" + code + "'");
    }
}
