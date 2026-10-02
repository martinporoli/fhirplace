package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of name the device is referred by.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/device-nametype">FHIR R5 DeviceNameType</a>
 */
public enum DeviceNameType implements CodedEnum {

    /**
     * The term assigned to a medical device by the entity who registers or submits information about it to a
     * jurisdiction or its databases.
     */
    REGISTERED_NAME("registered-name", "Registered name"),

    /**
     * The term that generically describes the device by a name as assigned by the manufacturer that is recognized by
     * lay person.
     */
    USER_FRIENDLY_NAME("user-friendly-name", "User Friendly name"),

    /**
     * the term used by the patient associated with the device when describing the device, for example 'knee implant',
     * when documented as a self-reported device.
     */
    PATIENT_REPORTED_NAME("patient-reported-name", "Patient Reported name");

    private final String code;
    private final String display;

    DeviceNameType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/device-nametype";
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
    public static DeviceNameType fromCode(String code) {
        for (DeviceNameType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceNameType code: '" + code + "'");
    }
}
