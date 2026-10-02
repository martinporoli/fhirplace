package se.poroli.fhirplace.r5.questionnaire;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes that describe the types of constraints possible on a question item that has a list of permitted answers.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/questionnaire-answer-constraint">FHIR R5 QuestionnaireAnswerConstraint</a>
 */
public enum QuestionnaireAnswerConstraint implements CodedEnum {

    /** Only values listed as answerOption or in the expansion of the answerValueSet are permitted. */
    OPTIONS_ONLY("optionsOnly", "Options only"),

    /**
     * In addition to the values listed as answerOption or in the expansion of the answerValueSet, any other values
     * that correspond to the specified item.type are permitted.
     */
    OPTIONS_OR_TYPE("optionsOrType", "Options or 'type'"),

    /**
     * In addition to the values listed as answerOption or in the expansion of the answerValueSet, free-text strings
     * are permitted.
     */
    OPTIONS_OR_STRING("optionsOrString", "Options or string");

    private final String code;
    private final String display;

    QuestionnaireAnswerConstraint(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/questionnaire-answer-constraint";
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
    public static QuestionnaireAnswerConstraint fromCode(String code) {
        for (QuestionnaireAnswerConstraint value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown QuestionnaireAnswerConstraint code: '" + code + "'");
    }
}
