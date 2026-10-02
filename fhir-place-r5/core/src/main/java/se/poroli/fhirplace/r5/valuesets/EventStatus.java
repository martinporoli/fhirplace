package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes identifying the lifecycle stage of an event.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/event-status">FHIR R5 EventStatus</a>
 */
public enum EventStatus implements CodedEnum {

    /**
     * The core event has not started yet, but some staging activities have begun (e.g. surgical suite preparation).
     */
    PREPARATION("preparation", "Preparation"),

    /** The event is currently occurring. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** The event was terminated prior to any activity beyond preparation. */
    NOT_DONE("not-done", "Not Done"),

    /** The event has been temporarily stopped but is expected to resume in the future. */
    ON_HOLD("on-hold", "On Hold"),

    /**
     * The event was terminated prior to the full completion of the intended activity but after at least some of the
     * 'main' activity (beyond preparation) has occurred.
     */
    STOPPED("stopped", "Stopped"),

    /** The event has now concluded. */
    COMPLETED("completed", "Completed"),

    /**
     * This electronic record should never have existed, though it is possible that real-world decisions were based on
     * it.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The authoring/source system does not know which of the status values currently applies for this event. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    EventStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/event-status";
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
    public static EventStatus fromCode(String code) {
        for (EventStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EventStatus code: '" + code + "'");
    }
}
