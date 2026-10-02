package se.poroli.fhirplace.r5.transport;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Status of the transport.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/transport-status">FHIR R5 TransportStatus</a>
 */
public enum TransportStatus implements CodedEnum {

    /** Transport has started but not completed. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** Transport has been completed. */
    COMPLETED("completed", "Completed"),

    /** Transport was started but not completed. */
    ABANDONED("abandoned", "Abandoned"),

    /** Transport was cancelled before started. */
    CANCELLED("cancelled", "Cancelled"),

    /** Planned transport that is not yet requested. */
    PLANNED("planned", "Planned"),

    /**
     * This electronic record should never have existed, though it is possible that real-world decisions were based on
     * it.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered In Error");

    private final String code;
    private final String display;

    TransportStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/transport-status";
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
    public static TransportStatus fromCode(String code) {
        for (TransportStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TransportStatus code: '" + code + "'");
    }
}
