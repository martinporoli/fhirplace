package se.poroli.fhirplace.r5.subscriptionstatus;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of notification represented by the status message.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/subscription-notification-type">FHIR R5 SubscriptionNotificationType</a>
 */
public enum SubscriptionNotificationType implements CodedEnum {

    /** The status was generated as part of the setup or verification of a communications channel. */
    HANDSHAKE("handshake", "Handshake"),

    /** The status was generated to perform a heartbeat notification to the subscriber. */
    HEARTBEAT("heartbeat", "Heartbeat"),

    /** The status was generated for an event to the subscriber. */
    EVENT_NOTIFICATION("event-notification", "Event Notification"),

    /** The status was generated in response to a status query/request. */
    QUERY_STATUS("query-status", "Query Status"),

    /** The status was generated in response to an event query/request. */
    QUERY_EVENT("query-event", "Query Event");

    private final String code;
    private final String display;

    SubscriptionNotificationType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/subscription-notification-type";
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
    public static SubscriptionNotificationType fromCode(String code) {
        for (SubscriptionNotificationType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SubscriptionNotificationType code: '" + code + "'");
    }
}
