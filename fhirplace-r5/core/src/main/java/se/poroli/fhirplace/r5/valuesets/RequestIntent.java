package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes indicating the degree of authority/intentionality associated with a request.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/request-intent">FHIR R5 RequestIntent</a>
 */
public enum RequestIntent implements CodedEnum {

    /**
     * The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and
     * without providing an authorization to act.
     */
    PROPOSAL("proposal", "Proposal"),

    /**
     * The request represents an intention to ensure something occurs without providing an authorization for others to
     * act.
     */
    PLAN("plan", "Plan"),

    /** The request represents a legally binding instruction authored by a Patient or RelatedPerson. */
    DIRECTIVE("directive", "Directive"),

    /** The request represents a request/demand and authorization for action by the requestor. */
    ORDER("order", "Order"),

    /** The request represents an original authorization for action. */
    ORIGINAL_ORDER("original-order", "Original Order"),

    /**
     * The request represents an automatically generated supplemental authorization for action based on a parent
     * authorization together with initial results of the action taken against that parent authorization.
     */
    REFLEX_ORDER("reflex-order", "Reflex Order"),

    /**
     * The request represents the view of an authorization instantiated by a fulfilling system representing the
     * details of the fulfiller's intention to act upon a submitted order.
     */
    FILLER_ORDER("filler-order", "Filler Order"),

    /**
     * An order created in fulfillment of a broader order that represents the authorization for a single activity
     * occurrence.
     */
    INSTANCE_ORDER("instance-order", "Instance Order"),

    /**
     * The request represents a component or option for a RequestOrchestration that establishes timing, conditionality
     * and/or other constraints among a set of requests.
     */
    OPTION("option", "Option");

    private final String code;
    private final String display;

    RequestIntent(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/request-intent";
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
    public static RequestIntent fromCode(String code) {
        for (RequestIntent value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown RequestIntent code: '" + code + "'");
    }
}
