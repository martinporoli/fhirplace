package se.poroli.fhirplace.r5.explanationofbenefit;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A code specifying the state of the resource instance.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/explanationofbenefit-status">FHIR R5 ExplanationOfBenefitStatus</a>
 */
public enum ExplanationOfBenefitStatus implements CodedEnum {

    /** The resource instance is currently in-force. */
    ACTIVE("active", "Active"),

    /** The resource instance is withdrawn, rescinded or reversed. */
    CANCELLED("cancelled", "Cancelled"),

    /** A new resource instance the contents of which is not complete. */
    DRAFT("draft", "Draft"),

    /** The resource instance was entered in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered In Error");

    private final String code;
    private final String display;

    ExplanationOfBenefitStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/explanationofbenefit-status";
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
    public static ExplanationOfBenefitStatus fromCode(String code) {
        for (ExplanationOfBenefitStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ExplanationOfBenefitStatus code: '" + code + "'");
    }
}
