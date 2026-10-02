package se.poroli.fhirplace.r5.valuesets;

/**
 * How the Quantity should be understood and represented.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/quantity-comparator">FHIR R5 QuantityComparator</a>
 */
public enum QuantityComparator implements CodedEnum {

    /** The actual value is less than the given value. */
    LESS_THAN("<", "Less than"),

    /** The actual value is less than or equal to the given value. */
    LESS_OR_EQUAL("<=", "Less or Equal to"),

    /** The actual value is greater than or equal to the given value. */
    GREATER_OR_EQUAL(">=", "Greater or Equal to"),

    /** The actual value is greater than the given value. */
    GREATER_THAN(">", "Greater than"),

    /** The actual value is sufficient for the total quantity to equal the given value. */
    AD("ad", "Sufficient to achieve this total quantity");

    private final String code;
    private final String display;

    QuantityComparator(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/quantity-comparator";
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
    public static QuantityComparator fromCode(String code) {
        for (QuantityComparator value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown QuantityComparator code: '" + code + "'");
    }
}
