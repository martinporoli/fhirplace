package se.poroli.fhirplace.r5.careplan;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes indicating the degree of authority/intentionality associated with a care plan.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/care-plan-intent">FHIR R5 CarePlanIntent</a>
 */
public enum CarePlanIntent implements CodedEnum {

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

    /** The request represents a request/demand and authorization for action by the requestor. */
    ORDER("order", "Order"),

    /**
     * The request represents a component or option for a RequestOrchestration that establishes timing, conditionality
     * and/or other constraints among a set of requests.
     */
    OPTION("option", "Option"),

    /** The request represents a legally binding instruction authored by a Patient or RelatedPerson. */
    DIRECTIVE("directive", "Directive");

    private final String code;
    private final String display;

    CarePlanIntent(String code, String display) {
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
    public static CarePlanIntent fromCode(String code) {
        for (CarePlanIntent value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CarePlanIntent code: '" + code + "'");
    }
}
