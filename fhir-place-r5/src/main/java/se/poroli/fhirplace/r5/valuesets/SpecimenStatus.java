package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes providing the status/availability of a specimen.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/specimen-status">FHIR R5 SpecimenStatus</a>
 */
public enum SpecimenStatus implements CodedEnum {

    /** The physical specimen is present and in good condition. */
    AVAILABLE("available", "Available"),

    /** There is no physical specimen because it is either lost, destroyed or consumed. */
    UNAVAILABLE("unavailable", "Unavailable"),

    /**
     * The specimen cannot be used because of a quality issue such as a broken container, contamination, or too old.
     */
    UNSATISFACTORY("unsatisfactory", "Unsatisfactory"),

    /** The specimen was entered in error and therefore nullified. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    SpecimenStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/specimen-status";
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
    public static SpecimenStatus fromCode(String code) {
        for (SpecimenStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SpecimenStatus code: '" + code + "'");
    }
}
