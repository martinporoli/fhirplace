package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes to represent how much resource content to send in the notification payload.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/subscription-payload-content">FHIR R5 SubscriptionPayloadContent</a>
 */
public enum SubscriptionPayloadContent implements CodedEnum {

    /** No resource content is transacted in the notification payload. */
    EMPTY("empty", "Empty"),

    /** Only the resource id is transacted in the notification payload. */
    ID_ONLY("id-only", "Id-only"),

    /** The entire resource is transacted in the notification payload. */
    FULL_RESOURCE("full-resource", "Full-resource");

    private final String code;
    private final String display;

    SubscriptionPayloadContent(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/subscription-payload-content";
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
    public static SubscriptionPayloadContent fromCode(String code) {
        for (SubscriptionPayloadContent value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SubscriptionPayloadContent code: '" + code + "'");
    }
}
