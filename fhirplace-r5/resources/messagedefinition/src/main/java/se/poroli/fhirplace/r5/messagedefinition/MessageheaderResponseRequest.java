package se.poroli.fhirplace.r5.messagedefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * HL7-defined table of codes which identify conditions under which acknowledgments are required to be returned in
 * response to a message.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/messageheader-response-request">FHIR R5 MessageheaderResponseRequest</a>
 */
public enum MessageheaderResponseRequest implements CodedEnum {

    /** initiator expects a response for this message. */
    ALWAYS("always", "Always"),

    /** initiator expects a response only if in error. */
    ON_ERROR("on-error", "Error/reject conditions only"),

    /** initiator does not expect a response. */
    NEVER("never", "Never"),

    /** initiator expects a response only if successful. */
    ON_SUCCESS("on-success", "Successful completion only");

    private final String code;
    private final String display;

    MessageheaderResponseRequest(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/messageheader-response-request";
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
    public static MessageheaderResponseRequest fromCode(String code) {
        for (MessageheaderResponseRequest value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MessageheaderResponseRequest code: '" + code + "'");
    }
}
