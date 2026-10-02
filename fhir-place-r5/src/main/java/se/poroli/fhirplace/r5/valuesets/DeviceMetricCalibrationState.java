package se.poroli.fhirplace.r5.valuesets;

/**
 * Describes the state of a metric calibration.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/metric-calibration-state">FHIR R5 DeviceMetricCalibrationState</a>
 */
public enum DeviceMetricCalibrationState implements CodedEnum {

    /** The metric has not been calibrated. */
    NOT_CALIBRATED("not-calibrated", "Not Calibrated"),

    /** The metric needs to be calibrated. */
    CALIBRATION_REQUIRED("calibration-required", "Calibration Required"),

    /** The metric has been calibrated. */
    CALIBRATED("calibrated", "Calibrated"),

    /** The state of calibration of this metric is unspecified. */
    UNSPECIFIED("unspecified", "Unspecified");

    private final String code;
    private final String display;

    DeviceMetricCalibrationState(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/metric-calibration-state";
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
    public static DeviceMetricCalibrationState fromCode(String code) {
        for (DeviceMetricCalibrationState value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceMetricCalibrationState code: '" + code + "'");
    }
}
