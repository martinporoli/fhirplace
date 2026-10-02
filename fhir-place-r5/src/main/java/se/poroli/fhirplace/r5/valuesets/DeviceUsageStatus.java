package se.poroli.fhirplace.r5.valuesets;

/**
 * A coded concept indicating the current status of the Device Usage.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/deviceusage-status">FHIR R5 DeviceUsageStatus</a>
 */
public enum DeviceUsageStatus implements CodedEnum {

    /** The device is still being used. */
    ACTIVE("active", "Active"),

    /** The device is no longer being used. */
    COMPLETED("completed", "Completed"),

    /** The device was not used. */
    NOT_DONE("not-done", "Not done"),

    /** The statement was recorded incorrectly. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The device may be used at some time in the future. */
    INTENDED("intended", "Intended"),

    /** Actions implied by the statement have been permanently halted, before all of them occurred. */
    STOPPED("stopped", "Stopped"),

    /** Actions implied by the statement have been temporarily halted, but are expected to continue later. */
    ON_HOLD("on-hold", "On Hold");

    private final String code;
    private final String display;

    DeviceUsageStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/deviceusage-status";
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
    public static DeviceUsageStatus fromCode(String code) {
        for (DeviceUsageStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceUsageStatus code: '" + code + "'");
    }
}
