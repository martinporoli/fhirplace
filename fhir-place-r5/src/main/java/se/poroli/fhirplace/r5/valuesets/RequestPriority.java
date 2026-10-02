package se.poroli.fhirplace.r5.valuesets;

/**
 * Identifies the level of importance to be assigned to actioning the request.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/request-priority">FHIR R5 RequestPriority</a>
 */
public enum RequestPriority implements CodedEnum {

    /** The request has normal priority. */
    ROUTINE("routine", "Routine"),

    /** The request should be actioned promptly - higher priority than routine. */
    URGENT("urgent", "Urgent"),

    /** The request should be actioned as soon as possible - higher priority than urgent. */
    ASAP("asap", "ASAP"),

    /** The request should be actioned immediately - highest possible priority. */
    STAT("stat", "STAT");

    private final String code;
    private final String display;

    RequestPriority(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/request-priority";
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
    public static RequestPriority fromCode(String code) {
        for (RequestPriority value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown RequestPriority code: '" + code + "'");
    }
}
