package se.poroli.fhirplace.r5.devicemetric;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Describes the category of the metric.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/metric-category">FHIR R5 DeviceMetricCategory</a>
 */
public enum DeviceMetricCategory implements CodedEnum {

    /** Observations generated for this DeviceMetric are measured. */
    MEASUREMENT("measurement", "Measurement"),

    /** Observations generated for this DeviceMetric is a setting that will influence the behavior of the Device. */
    SETTING("setting", "Setting"),

    /** Observations generated for this DeviceMetric are calculated. */
    CALCULATION("calculation", "Calculation"),

    /** The category of this DeviceMetric is unspecified. */
    UNSPECIFIED("unspecified", "Unspecified");

    private final String code;
    private final String display;

    DeviceMetricCategory(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/metric-category";
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
    public static DeviceMetricCategory fromCode(String code) {
        for (DeviceMetricCategory value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceMetricCategory code: '" + code + "'");
    }
}
