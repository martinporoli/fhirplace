package se.poroli.fhirplace.r5.valuesets;

/**
 * The possible sort directions, ascending or descending.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/sort-direction">FHIR R5 SortDirection</a>
 */
public enum SortDirection implements CodedEnum {

    /** Sort by the value ascending, so that lower values appear first. */
    ASCENDING("ascending", "Ascending"),

    /** Sort by the value descending, so that lower values appear last. */
    DESCENDING("descending", "Descending");

    private final String code;
    private final String display;

    SortDirection(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/sort-direction";
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
    public static SortDirection fromCode(String code) {
        for (SortDirection value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SortDirection code: '" + code + "'");
    }
}
