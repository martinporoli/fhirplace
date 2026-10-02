package se.poroli.fhirplace.r5.subscriptiontopic;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * FHIR RESTful interaction codes used for SubscriptionTopic trigger.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/interaction-trigger">FHIR R5 InteractionTrigger</a>
 */
public enum InteractionTrigger implements CodedEnum {

    /** Create a new resource with a server assigned id. */
    CREATE("create", "create"),

    /** Update an existing resource by its id (or create it if it is new). */
    UPDATE("update", "update"),

    /** Delete a resource. */
    DELETE("delete", "delete");

    private final String code;
    private final String display;

    InteractionTrigger(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/restful-interaction";
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
    public static InteractionTrigger fromCode(String code) {
        for (InteractionTrigger value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown InteractionTrigger code: '" + code + "'");
    }
}
