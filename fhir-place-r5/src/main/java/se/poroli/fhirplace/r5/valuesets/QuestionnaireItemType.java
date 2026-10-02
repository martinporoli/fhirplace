package se.poroli.fhirplace.r5.valuesets;

/**
 * Distinguishes groups from questions and display text and indicates data type for questions.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/item-type">FHIR R5 QuestionnaireItemType</a>
 */
public enum QuestionnaireItemType implements CodedEnum {

    /** An item with no direct answer but should have at least one child item. */
    GROUP("group", "Group"),

    /** Text for display that will not capture an answer or have child items. */
    DISPLAY("display", "Display"),

    /** An item that defines a specific answer to be captured, and which may have child items. */
    QUESTION("question", "Question"),

    /** Question with a yes/no answer (valueBoolean). */
    BOOLEAN("boolean", "Boolean"),

    /** Question with is a real number answer (valueDecimal). */
    DECIMAL("decimal", "Decimal"),

    /** Question with an integer answer (valueInteger). */
    INTEGER("integer", "Integer"),

    /** Question with a date answer (valueDate). */
    DATE("date", "Date"),

    /** Question with a date and time answer (valueDateTime). */
    DATE_TIME("dateTime", "Date Time"),

    /** Question with a time (hour:minute:second) answer independent of date. */
    TIME("time", "Time"),

    /** Question with a short (few words to short sentence) free-text entry answer (valueString). */
    STRING("string", "String"),

    /** Question with a long (potentially multi-paragraph) free-text entry answer (valueString). */
    TEXT("text", "Text"),

    /** Question with a URL (website, FTP site, etc.) answer (valueUri). */
    URL("url", "Url"),

    /** Question with a Coding - generally drawn from a list of possible answers (valueCoding). */
    CODING("coding", "Coding"),

    /** Question with binary content such as an image, PDF, etc. as an answer (valueAttachment). */
    ATTACHMENT("attachment", "Attachment"),

    /**
     * Question with a reference to another resource (practitioner, organization, etc.) as an answer (valueReference).
     */
    REFERENCE("reference", "Reference"),

    /** Question with a combination of a numeric value and unit as an answer. */
    QUANTITY("quantity", "Quantity");

    private final String code;
    private final String display;

    QuestionnaireItemType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/item-type";
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
    public static QuestionnaireItemType fromCode(String code) {
        for (QuestionnaireItemType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown QuestionnaireItemType code: '" + code + "'");
    }
}
