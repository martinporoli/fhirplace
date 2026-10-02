package se.poroli.fhirplace.r5.allergyintolerance;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Clinical assessment of the severity of a reaction event as a whole, potentially considering multiple different
 * manifestations.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/reaction-event-severity">FHIR R5 AllergyIntoleranceSeverity</a>
 */
public enum AllergyIntoleranceSeverity implements CodedEnum {

    /** Causes mild physiological effects. */
    MILD("mild", "Mild"),

    /** Causes moderate physiological effects. */
    MODERATE("moderate", "Moderate"),

    /** Causes severe physiological effects. */
    SEVERE("severe", "Severe");

    private final String code;
    private final String display;

    AllergyIntoleranceSeverity(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/reaction-event-severity";
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
    public static AllergyIntoleranceSeverity fromCode(String code) {
        for (AllergyIntoleranceSeverity value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AllergyIntoleranceSeverity code: '" + code + "'");
    }
}
