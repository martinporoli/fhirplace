package se.poroli.fhirplace.r5.questionnaire;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The criteria by which a question is enabled.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/questionnaire-enable-operator">FHIR R5 QuestionnaireItemOperator</a>
 */
public enum QuestionnaireItemOperator implements CodedEnum {

    /**
     * True if the determination of 'whether an answer exists for the question' is equal to the enableWhen answer
     * (which must be a boolean).
     */
    EXISTS("exists", "Exists"),

    /** True if at least one answer has a value that is equal to the enableWhen answer. */
    EQUALS("=", "Equals"),

    /** True if no answer has a value that is equal to the enableWhen answer. */
    NOT_EQUALS("!=", "Not Equals"),

    /** True if at least one answer has a value that is greater than the enableWhen answer. */
    GREATER_THAN(">", "Greater Than"),

    /** True if at least one answer has a value that is less than the enableWhen answer. */
    LESS_THAN("<", "Less Than"),

    /** True if at least one answer has a value that is greater or equal to the enableWhen answer. */
    GREATER_OR_EQUAL(">=", "Greater or Equals"),

    /** True if at least one answer has a value that is less or equal to the enableWhen answer. */
    LESS_OR_EQUAL("<=", "Less or Equals");

    private final String code;
    private final String display;

    QuestionnaireItemOperator(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/questionnaire-enable-operator";
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
    public static QuestionnaireItemOperator fromCode(String code) {
        for (QuestionnaireItemOperator value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown QuestionnaireItemOperator code: '" + code + "'");
    }
}
