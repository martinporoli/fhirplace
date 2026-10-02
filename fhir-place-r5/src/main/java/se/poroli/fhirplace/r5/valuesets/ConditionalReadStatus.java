package se.poroli.fhirplace.r5.valuesets;

/**
 * A code that indicates how the server supports conditional read.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/conditional-read-status">FHIR R5 ConditionalReadStatus</a>
 */
public enum ConditionalReadStatus implements CodedEnum {

    /** No support for conditional reads. */
    NOT_SUPPORTED("not-supported", "Not Supported"),

    /** Conditional reads are supported, but only with the If-Modified-Since HTTP Header. */
    MODIFIED_SINCE("modified-since", "If-Modified-Since"),

    /** Conditional reads are supported, but only with the If-None-Match HTTP Header. */
    NOT_MATCH("not-match", "If-None-Match"),

    /** Conditional reads are supported, with both If-Modified-Since and If-None-Match HTTP Headers. */
    FULL_SUPPORT("full-support", "Full Support");

    private final String code;
    private final String display;

    ConditionalReadStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/conditional-read-status";
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
    public static ConditionalReadStatus fromCode(String code) {
        for (ConditionalReadStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConditionalReadStatus code: '" + code + "'");
    }
}
