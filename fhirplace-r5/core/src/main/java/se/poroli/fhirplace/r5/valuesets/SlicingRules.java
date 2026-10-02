package se.poroli.fhirplace.r5.valuesets;

/**
 * How slices are interpreted when evaluating an instance.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/resource-slicing-rules">FHIR R5 SlicingRules</a>
 */
public enum SlicingRules implements CodedEnum {

    /** No additional content is allowed other than that described by the slices in this profile. */
    CLOSED("closed", "Closed"),

    /** Additional content is allowed anywhere in the list. */
    OPEN("open", "Open"),

    /** Additional content is allowed, but only at the end of the list. */
    OPEN_AT_END("openAtEnd", "Open at End");

    private final String code;
    private final String display;

    SlicingRules(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/resource-slicing-rules";
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
    public static SlicingRules fromCode(String code) {
        for (SlicingRules value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SlicingRules code: '" + code + "'");
    }
}
