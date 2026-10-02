package se.poroli.fhirplace.r5.messagedefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The impact of the content of a message.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/message-significance-category">FHIR R5 MessageSignificanceCategory</a>
 */
public enum MessageSignificanceCategory implements CodedEnum {

    /**
     * The message represents/requests a change that should not be processed more than once; e.g., making a booking
     * for an appointment.
     */
    CONSEQUENCE("consequence", "Consequence"),

    /** The message represents a response to query for current information. */
    CURRENCY("currency", "Currency"),

    /**
     * The content is not necessarily intended to be current, and it can be reprocessed, though there may be version
     * issues created by processing old notifications.
     */
    NOTIFICATION("notification", "Notification");

    private final String code;
    private final String display;

    MessageSignificanceCategory(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/message-significance-category";
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
    public static MessageSignificanceCategory fromCode(String code) {
        for (MessageSignificanceCategory value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MessageSignificanceCategory code: '" + code + "'");
    }
}
