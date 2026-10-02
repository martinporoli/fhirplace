package se.poroli.fhirplace.r5.observationdefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes identifying the category of observation range.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/observation-range-category">FHIR R5 ObservationRangeCategory</a>
 */
public enum ObservationRangeCategory implements CodedEnum {

    /** Reference (Normal) Range for Ordinal and Continuous Observations. */
    REFERENCE("reference", "reference range"),

    /** Critical Range for Ordinal and Continuous Observations. */
    CRITICAL("critical", "critical range"),

    /** Absolute Range for Ordinal and Continuous Observations. */
    ABSOLUTE("absolute", "absolute range");

    private final String code;
    private final String display;

    ObservationRangeCategory(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/observation-range-category";
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
    public static ObservationRangeCategory fromCode(String code) {
        for (ObservationRangeCategory value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ObservationRangeCategory code: '" + code + "'");
    }
}
