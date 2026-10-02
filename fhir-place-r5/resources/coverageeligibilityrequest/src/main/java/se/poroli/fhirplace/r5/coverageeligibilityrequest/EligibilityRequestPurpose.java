package se.poroli.fhirplace.r5.coverageeligibilityrequest;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A code specifying the types of information being requested.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/eligibilityrequest-purpose">FHIR R5 EligibilityRequestPurpose</a>
 */
public enum EligibilityRequestPurpose implements CodedEnum {

    /**
     * The prior authorization requirements for the listed, or discovered if specified, converages for the categories
     * of service and/or specifed biling codes are requested.
     */
    AUTH_REQUIREMENTS("auth-requirements", "Coverage auth-requirements"),

    /**
     * The plan benefits and optionally benefits consumed for the listed, or discovered if specified, converages are
     * requested.
     */
    BENEFITS("benefits", "Coverage benefits"),

    /** The insurer is requested to report on any coverages which they are aware of in addition to any specifed. */
    DISCOVERY("discovery", "Coverage Discovery"),

    /** A check that the specified coverages are in-force is requested. */
    VALIDATION("validation", "Coverage Validation");

    private final String code;
    private final String display;

    EligibilityRequestPurpose(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/eligibilityrequest-purpose";
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
    public static EligibilityRequestPurpose fromCode(String code) {
        for (EligibilityRequestPurpose value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EligibilityRequestPurpose code: '" + code + "'");
    }
}
