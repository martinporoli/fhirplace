package se.poroli.fhirplace.r5.allergyintolerance;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Estimate of the potential clinical harm, or seriousness, of a reaction to an identified substance.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/allergy-intolerance-criticality">FHIR R5 AllergyIntoleranceCriticality</a>
 */
public enum AllergyIntoleranceCriticality implements CodedEnum {

    /**
     * Worst case result of a future exposure is not assessed to be life-threatening or having high potential for
     * organ system failure.
     */
    LOW("low", "Low Risk"),

    /**
     * Worst case result of a future exposure is assessed to be life-threatening or having high potential for organ
     * system failure.
     */
    HIGH("high", "High Risk"),

    /** Unable to assess the worst case result of a future exposure. */
    UNABLE_TO_ASSESS("unable-to-assess", "Unable to Assess Risk");

    private final String code;
    private final String display;

    AllergyIntoleranceCriticality(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/allergy-intolerance-criticality";
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
    public static AllergyIntoleranceCriticality fromCode(String code) {
        for (AllergyIntoleranceCriticality value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AllergyIntoleranceCriticality code: '" + code + "'");
    }
}
