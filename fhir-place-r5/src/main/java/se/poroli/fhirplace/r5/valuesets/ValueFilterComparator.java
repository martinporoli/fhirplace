package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of comparator operator to use.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/value-filter-comparator">FHIR R5 ValueFilterComparator</a>
 */
public enum ValueFilterComparator implements CodedEnum {

    /** the value for the parameter in the resource is equal to the provided value. */
    EQ("eq", "Equals"),

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
    EB("eb", "Ends Before");

    private final String code;
    private final String display;

    ValueFilterComparator(String code, String display) {
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
    public static ValueFilterComparator fromCode(String code) {
        for (ValueFilterComparator value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ValueFilterComparator code: '" + code + "'");
    }
}
