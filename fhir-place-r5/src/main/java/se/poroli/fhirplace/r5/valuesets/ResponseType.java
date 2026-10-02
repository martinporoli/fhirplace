package se.poroli.fhirplace.r5.valuesets;

/**
 * The kind of response to a message.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/response-code">FHIR R5 ResponseType</a>
 */
public enum ResponseType implements CodedEnum {

    /** The message was accepted and processed without error. */
    OK("ok", "OK"),

    /** Some internal unexpected error occurred - wait and try again. */
    TRANSIENT_ERROR("transient-error", "Transient Error"),

    /** The message was rejected because of a problem with the content. */
    FATAL_ERROR("fatal-error", "Fatal Error");

    private final String code;
    private final String display;

    ResponseType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/response-code";
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
    public static ResponseType fromCode(String code) {
        for (ResponseType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ResponseType code: '" + code + "'");
    }
}
