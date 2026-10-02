package se.poroli.fhirplace.r5.valuesets;

/**
 * State values for FHIR Subscriptions.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/subscription-status">FHIR R5 SubscriptionStatusCodes</a>
 */
public enum SubscriptionStatusCodes implements CodedEnum {

    /** The client has requested the subscription, and the server has not yet set it up. */
    REQUESTED("requested", "Requested"),

    /** The subscription is active. */
    ACTIVE("active", "Active"),

    /** The server has an error executing the notification. */
    ERROR("error", "Error"),

    /** Too many errors have occurred or the subscription has expired. */
    OFF("off", "Off"),

    /** This subscription has been flagged as incorrect. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    SubscriptionStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/subscription-status";
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
    public static SubscriptionStatusCodes fromCode(String code) {
        for (SubscriptionStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SubscriptionStatusCodes code: '" + code + "'");
    }
}
