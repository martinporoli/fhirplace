package se.poroli.fhirplace.r5.valuesets;

/**
 * The use of a questionnaire.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/condition-questionnaire-purpose">FHIR R5 ConditionQuestionnairePurpose</a>
 */
public enum ConditionQuestionnairePurpose implements CodedEnum {

    /** A pre-admit questionnaire. */
    PREADMIT("preadmit", "Pre-admit"),

    /** A questionnaire that helps with diferential diagnosis. */
    DIFF_DIAGNOSIS("diff-diagnosis", "Diff Diagnosis"),

    /** A questionnaire to check on outcomes for the patient. */
    OUTCOME("outcome", "Outcome");

    private final String code;
    private final String display;

    ConditionQuestionnairePurpose(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/condition-questionnaire-purpose";
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
    public static ConditionQuestionnairePurpose fromCode(String code) {
        for (ConditionQuestionnairePurpose value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConditionQuestionnairePurpose code: '" + code + "'");
    }
}
