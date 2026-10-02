package se.poroli.fhirplace.r5.valuesets;

/**
 * The free/busy status of the slot.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/slotstatus">FHIR R5 SlotStatus</a>
 */
public enum SlotStatus implements CodedEnum {

    /** Indicates that the time interval is busy because one or more events have been scheduled for that interval. */
    BUSY("busy", "Busy"),

    /** Indicates that the time interval is free for scheduling. */
    FREE("free", "Free"),

    /** Indicates that the time interval is busy and that the interval cannot be scheduled. */
    BUSY_UNAVAILABLE("busy-unavailable", "Busy (Unavailable)"),

    /**
     * Indicates that the time interval is busy because one or more events have been tentatively scheduled for that
     * interval.
     */
    BUSY_TENTATIVE("busy-tentative", "Busy (Tentative)"),

    /** This instance should not have been part of this patient's medical record. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in error");

    private final String code;
    private final String display;

    SlotStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/slotstatus";
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
    public static SlotStatus fromCode(String code) {
        for (SlotStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SlotStatus code: '" + code + "'");
    }
}
