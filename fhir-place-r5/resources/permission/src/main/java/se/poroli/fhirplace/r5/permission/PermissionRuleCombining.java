package se.poroli.fhirplace.r5.permission;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes identifying rule combining algorithm.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/permission-rule-combining">FHIR R5 PermissionRuleCombining</a>
 */
public enum PermissionRuleCombining implements CodedEnum {

    /**
     * The deny overrides combining algorithm is intended for those cases where a deny decision should have priority
     * over a permit decision.
     */
    DENY_OVERRIDES("deny-overrides", "Deny-overrides"),

    /**
     * The permit overrides combining algorithm is intended for those cases where a permit decision should have
     * priority over a deny decision.
     */
    PERMIT_OVERRIDES("permit-overrides", "Permit-overrides"),

    /**
     * The behavior of this algorithm is identical to that of the “Deny-overrides” rule-combining algorithm with one
     * exception.
     */
    ORDERED_DENY_OVERRIDES("ordered-deny-overrides", "Ordered-deny-overrides"),

    /**
     * The behavior of this algorithm is identical to that of the “Permit-overrides” rule-combining algorithm with one
     * exception.
     */
    ORDERED_PERMIT_OVERRIDES("ordered-permit-overrides", "Ordered-permit-overrides"),

    /**
     * The “Deny-unless-permit” combining algorithm is intended for those cases where a permit decision should have
     * priority over a deny decision, and an “Indeterminate” or “NotApplicable” must never be the result.
     */
    DENY_UNLESS_PERMIT("deny-unless-permit", "Deny-unless-permit"),

    /**
     * The “Permit-unless-deny” combining algorithm is intended for those cases where a deny decision should have
     * priority over a permit decision, and an “Indeterminate” or “NotApplicable” must never be the result.
     */
    PERMIT_UNLESS_DENY("permit-unless-deny", "Permit-unless-deny");

    private final String code;
    private final String display;

    PermissionRuleCombining(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/permission-rule-combining";
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
    public static PermissionRuleCombining fromCode(String code) {
        for (PermissionRuleCombining value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown PermissionRuleCombining code: '" + code + "'");
    }
}
