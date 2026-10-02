package se.poroli.fhirplace.r5.observationdefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Permitted data type for observation value.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/permitted-data-type">FHIR R5 ObservationDataType</a>
 */
public enum ObservationDataType implements CodedEnum {

    /** A measured amount. */
    QUANTITY("Quantity", "Quantity"),

    /** A coded concept from a reference terminology and/or text. */
    CODEABLE_CONCEPT("CodeableConcept", "CodeableConcept"),

    /** A sequence of Unicode characters. */
    STRING("string", "string"),

    /** true or false. */
    BOOLEAN("boolean", "boolean"),

    /** A signed integer. */
    INTEGER("integer", "integer"),

    /** A set of values bounded by low and high. */
    RANGE("Range", "Range"),

    /** A ratio of two Quantity values - a numerator and a denominator. */
    RATIO("Ratio", "Ratio"),

    /** A series of measurements taken by a device. */
    SAMPLED_DATA("SampledData", "SampledData"),

    /** A time during the day, in the format hh:mm:ss. */
    TIME("time", "time"),

    /** A date, date-time or partial date (e.g. just year or year + month) as used in human communication. */
    DATE_TIME("dateTime", "dateTime"),

    /** A time range defined by start and end date/time. */
    PERIOD("Period", "Period");

    private final String code;
    private final String display;

    ObservationDataType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/permitted-data-type";
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
    public static ObservationDataType fromCode(String code) {
        for (ObservationDataType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ObservationDataType code: '" + code + "'");
    }
}
