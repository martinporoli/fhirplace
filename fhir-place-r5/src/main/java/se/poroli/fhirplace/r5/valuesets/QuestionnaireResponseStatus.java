package se.poroli.fhirplace.r5.valuesets;

/**
 * Lifecycle status of the questionnaire response.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/questionnaire-answers-status">FHIR R5 QuestionnaireResponseStatus</a>
 */
public enum QuestionnaireResponseStatus implements CodedEnum {

    /**
     * This QuestionnaireResponse has been partially filled out with answers but changes or additions are still
     * expected to be made to it.
     */
    IN_PROGRESS("in-progress", "In Progress"),

    /**
     * This QuestionnaireResponse has been filled out with answers and the current content is regarded as definitive.
     */
    COMPLETED("completed", "Completed"),

    /**
     * This QuestionnaireResponse has been filled out with answers, then marked as complete, yet changes or additions
     * have been made to it afterwards.
     */
    AMENDED("amended", "Amended"),

    /** This QuestionnaireResponse was entered in error and voided. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** This QuestionnaireResponse has been partially filled out with answers but has been abandoned. */
    STOPPED("stopped", "Stopped");

    private final String code;
    private final String display;

    QuestionnaireResponseStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/questionnaire-answers-status";
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
    public static QuestionnaireResponseStatus fromCode(String code) {
        for (QuestionnaireResponseStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown QuestionnaireResponseStatus code: '" + code + "'");
    }
}
