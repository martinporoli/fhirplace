package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes that guide the display of disabled questionnaire items.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/questionnaire-disabled-display">FHIR R5 QuestionnaireItemDisabledDisplay</a>
 */
public enum QuestionnaireItemDisabledDisplay implements CodedEnum {

    /** The item (and its children) should not be visible to the user at all. */
    HIDDEN("hidden", "Hidden"),

    /**
     * The item (and possibly its children) should not be selectable or editable but should still be visible - to
     * allow the user to see what questions *could* have been completed had other answers caused the item to be
     * enabled.
     */
    PROTECTED("protected", "Protected");

    private final String code;
    private final String display;

    QuestionnaireItemDisabledDisplay(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/questionnaire-disabled-display";
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
    public static QuestionnaireItemDisabledDisplay fromCode(String code) {
        for (QuestionnaireItemDisabledDisplay value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown QuestionnaireItemDisabledDisplay code: '" + code + "'");
    }
}
