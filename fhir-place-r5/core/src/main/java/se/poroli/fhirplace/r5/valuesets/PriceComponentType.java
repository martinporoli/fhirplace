package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes indicating the kind of the price component.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/price-component-type">FHIR R5 PriceComponentType</a>
 */
public enum PriceComponentType implements CodedEnum {

    /**
     * the amount is the base price used for calculating the total price before applying surcharges, discount or
     * taxes.
     */
    BASE("base", "base price"),

    /** the amount is a surcharge applied on the base price. */
    SURCHARGE("surcharge", "surcharge"),

    /** the amount is a deduction applied on the base price. */
    DEDUCTION("deduction", "deduction"),

    /** the amount is a discount applied on the base price. */
    DISCOUNT("discount", "discount"),

    /** the amount is the tax component of the total price. */
    TAX("tax", "tax"),

    /** the amount is of informational character, it has not been applied in the calculation of the total price. */
    INFORMATIONAL("informational", "informational");

    private final String code;
    private final String display;

    PriceComponentType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/price-component-type";
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
    public static PriceComponentType fromCode(String code) {
        for (PriceComponentType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown PriceComponentType code: '" + code + "'");
    }
}
