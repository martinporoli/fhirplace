package se.poroli.fhirplace.r5.valuesets;

/**
 * The way in which this manufacturer is associated with the ingredient.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/ingredient-manufacturer-role">FHIR R5 IngredientManufacturerRole</a>
 */
public enum IngredientManufacturerRole implements CodedEnum {

    /** Manufacturer is specifically allowed for this ingredient. */
    ALLOWED("allowed", "Manufacturer is specifically allowed for this ingredient"),

    /** Manufacturer is known to make this ingredient in general. */
    POSSIBLE("possible", "Manufacturer is known to make this ingredient in general"),

    /** Manufacturer actually makes this particular ingredient. */
    ACTUAL("actual", "Manufacturer actually makes this particular ingredient");

    private final String code;
    private final String display;

    IngredientManufacturerRole(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/ingredient-manufacturer-role";
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
    public static IngredientManufacturerRole fromCode(String code) {
        for (IngredientManufacturerRole value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown IngredientManufacturerRole code: '" + code + "'");
    }
}
