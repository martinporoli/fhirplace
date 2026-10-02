package se.poroli.fhirplace.r5.devicemetric;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Describes the type of a metric calibration.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/metric-calibration-type">FHIR R5 DeviceMetricCalibrationType</a>
 */
public enum DeviceMetricCalibrationType implements CodedEnum {

    /** Metric calibration method has not been identified. */
    UNSPECIFIED("unspecified", "Unspecified"),

    /** Offset metric calibration method. */
    OFFSET("offset", "Offset"),

    /** Gain metric calibration method. */
    GAIN("gain", "Gain"),

    /** Two-point metric calibration method. */
    TWO_POINT("two-point", "Two Point");

    private final String code;
    private final String display;

    DeviceMetricCalibrationType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/metric-calibration-type";
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
    public static DeviceMetricCalibrationType fromCode(String code) {
        for (DeviceMetricCalibrationType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceMetricCalibrationType code: '" + code + "'");
    }
}
