package se.poroli.fhirplace.r5.devicemetric;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Describes the operational status of the DeviceMetric.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/metric-operational-status">FHIR R5 DeviceMetricOperationalStatus</a>
 */
public enum DeviceMetricOperationalStatus implements CodedEnum {

    /** The DeviceMetric is operating and will generate Observations. */
    ON("on", "On"),

    /** The DeviceMetric is not operating. */
    OFF("off", "Off"),

    /** The DeviceMetric is operating, but will not generate any Observations. */
    STANDBY("standby", "Standby"),

    /** The DeviceMetric was entered in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered In Error");

    private final String code;
    private final String display;

    DeviceMetricOperationalStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/metric-operational-status";
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
    public static DeviceMetricOperationalStatus fromCode(String code) {
        for (DeviceMetricOperationalStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceMetricOperationalStatus code: '" + code + "'");
    }
}
