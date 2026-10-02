package se.poroli.fhirplace.r5.nutritionproduct;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes identifying the lifecycle stage of a product.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/nutritionproduct-status">FHIR R5 NutritionProductStatus</a>
 */
public enum NutritionProductStatus implements CodedEnum {

    /** The product can be used. */
    ACTIVE("active", "Active"),

    /** The product is not expected or allowed to be used. */
    INACTIVE("inactive", "Inactive"),

    /**
     * This electronic record should never have existed, though it is possible that real-world decisions were based on
     * it.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    NutritionProductStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/nutritionproduct-status";
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
    public static NutritionProductStatus fromCode(String code) {
        for (NutritionProductStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown NutritionProductStatus code: '" + code + "'");
    }
}
