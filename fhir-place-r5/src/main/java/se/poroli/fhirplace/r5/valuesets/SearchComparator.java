package se.poroli.fhirplace.r5.valuesets;

/**
 * What Search Comparator Codes are supported in search.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/search-comparator">FHIR R5 SearchComparator</a>
 */
public enum SearchComparator implements CodedEnum {

    /** the value for the parameter in the resource is equal to the provided value. */
    EQ("eq", "Equals"),

    /** the value for the parameter in the resource is not equal to the provided value. */
    NE("ne", "Not Equals"),

    /** the value for the parameter in the resource is greater than the provided value. */
    GT("gt", "Greater Than"),

    /** the value for the parameter in the resource is less than the provided value. */
    LT("lt", "Less Than"),

    /** the value for the parameter in the resource is greater or equal to the provided value. */
    GE("ge", "Greater or Equals"),

    /** the value for the parameter in the resource is less or equal to the provided value. */
    LE("le", "Less of Equal"),

    /** the value for the parameter in the resource starts after the provided value. */
    SA("sa", "Starts After"),

    /** the value for the parameter in the resource ends before the provided value. */
    EB("eb", "Ends Before"),

    /** the value for the parameter in the resource is approximately the same to the provided value. */
    AP("ap", "Approximately");

    private final String code;
    private final String display;

    SearchComparator(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/search-comparator";
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
    public static SearchComparator fromCode(String code) {
        for (SearchComparator value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SearchComparator code: '" + code + "'");
    }
}
