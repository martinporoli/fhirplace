package se.poroli.fhirplace.r5.valuesets;

/**
 * Category of an identified substance associated with allergies or intolerances.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/allergy-intolerance-category">FHIR R5 AllergyIntoleranceCategory</a>
 */
public enum AllergyIntoleranceCategory implements CodedEnum {

    /** Any substance consumed to provide nutritional support for the body. */
    FOOD("food", "Food"),

    /** Substances administered to achieve a physiological effect. */
    MEDICATION("medication", "Medication"),

    /**
     * Any substances that are encountered in the environment, including any substance not already classified as food,
     * medication, or biologic.
     */
    ENVIRONMENT("environment", "Environment"),

    /**
     * A preparation that is synthesized from living organisms or their products, especially a human or animal
     * protein, such as a hormone or antitoxin, that is used as a diagnostic, preventive, or therapeutic agent.
     */
    BIOLOGIC("biologic", "Biologic");

    private final String code;
    private final String display;

    AllergyIntoleranceCategory(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/allergy-intolerance-category";
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
    public static AllergyIntoleranceCategory fromCode(String code) {
        for (AllergyIntoleranceCategory value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AllergyIntoleranceCategory code: '" + code + "'");
    }
}
