package se.poroli.fhirplace.r5.device;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The status of the Device record.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/device-status">FHIR R5 FHIRDeviceStatus</a>
 */
public enum FHIRDeviceStatus implements CodedEnum {

    /** The device record is current and is appropriate for reference in new instances. */
    ACTIVE("active", "Active"),

    /** The device record is not current and is not appropriate for reference in new instances. */
    INACTIVE("inactive", "Inactive"),

    /** The device record is not current and is not appropriate for reference in new instances. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    FHIRDeviceStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/device-status";
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
    public static FHIRDeviceStatus fromCode(String code) {
        for (FHIRDeviceStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FHIRDeviceStatus code: '" + code + "'");
    }
}
