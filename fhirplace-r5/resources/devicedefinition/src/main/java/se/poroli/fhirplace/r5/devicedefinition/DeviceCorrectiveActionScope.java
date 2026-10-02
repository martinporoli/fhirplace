package se.poroli.fhirplace.r5.devicedefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Device - Corrective action scope.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/device-correctiveactionscope">FHIR R5 DeviceCorrectiveActionScope</a>
 */
public enum DeviceCorrectiveActionScope implements CodedEnum {

    /** The corrective action was intended for all units of the same model. */
    MODEL("model", "Model"),

    /** The corrective action was intended for a specific batch of units identified by a lot number. */
    LOT_NUMBERS("lot-numbers", "Lot Numbers"),

    /**
     * The corrective action was intended for an individual unit (or a set of units) individually identified by serial
     * number.
     */
    SERIAL_NUMBERS("serial-numbers", "Serial Numbers");

    private final String code;
    private final String display;

    DeviceCorrectiveActionScope(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/device-correctiveactionscope";
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
    public static DeviceCorrectiveActionScope fromCode(String code) {
        for (DeviceCorrectiveActionScope value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceCorrectiveActionScope code: '" + code + "'");
    }
}
