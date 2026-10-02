package se.poroli.fhirplace.r5.adverseevent;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes identifying the lifecycle stage of an adverse event.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/adverse-event-status">FHIR R5 AdverseEventStatus</a>
 */
public enum AdverseEventStatus implements CodedEnum {

    /** The event is currently occurring. */
    IN_PROGRESS("in-progress", "In Progress"),

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

    AdverseEventStatus(String code, String display) {
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
    public static AdverseEventStatus fromCode(String code) {
        for (AdverseEventStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AdverseEventStatus code: '" + code + "'");
    }
}
