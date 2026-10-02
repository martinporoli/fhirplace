package se.poroli.fhirplace.r5.immunizationevaluation;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The value set to instantiate this attribute should be drawn from a terminologically robust code system that
 * consists of or contains concepts to support describing the current status of the evaluation for vaccine
 * administration event.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/immunization-evaluation-status">FHIR R5 ImmunizationEvaluationStatusCodes</a>
 */
public enum ImmunizationEvaluationStatusCodes implements CodedEnum {

    /** All actions that are implied by the administration have occurred. */
    COMPLETED("completed", "Completed"),

    /** The administration was entered in error and therefore nullified. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    ImmunizationEvaluationStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/medication-admin-status";
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
    public static ImmunizationEvaluationStatusCodes fromCode(String code) {
        for (ImmunizationEvaluationStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ImmunizationEvaluationStatusCodes code: '" + code + "'");
    }
}
