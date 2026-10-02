package se.poroli.fhirplace.r5.valuesets;

/**
 * Additional Binding Purpose.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/additional-binding-purpose">FHIR R5 AdditionalBindingPurposeVS</a>
 */
public enum AdditionalBindingPurposeVS implements CodedEnum {

    /** A required binding, for use when the binding strength is 'extensible' or 'preferred'. */
    MAXIMUM("maximum", "Maximum Binding"),

    /** The minimum allowable value set - any conformant system SHALL support all these codes. */
    MINIMUM("minimum", "Minimum Binding"),

    /**
     * This value set is used as a required binding (in addition to the base binding (not a replacement), usually in a
     * particular usage context).
     */
    REQUIRED("required", "Required Binding"),

    /**
     * This value set is used as an extensible binding (in addition to the base binding (not a replacement), usually
     * in a particular usage context).
     */
    EXTENSIBLE("extensible", "Conformance Binding"),

    /**
     * This value set is a candidate to substitute for the overall conformance value set in some situations; usually
     * these are defined in the documentation.
     */
    CANDIDATE("candidate", "Candidate Binding"),

    /** New records are required to use this value set, but legacy records may use other codes. */
    CURRENT("current", "Current Binding"),

    /** This is the value set that is preferred in a given context (documentation should explain why). */
    PREFERRED("preferred", "Preferred Binding"),

    /** This value set is provided for user look up in a given context. */
    UI("ui", "UI Suggested Binding"),

    /** This value set is a good set of codes to start with when designing your system. */
    STARTER("starter", "Starter Binding"),

    /** This value set is a component of the base value set. */
    COMPONENT("component", "Component Binding");

    private final String code;
    private final String display;

    AdditionalBindingPurposeVS(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/additional-binding-purpose";
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
    public static AdditionalBindingPurposeVS fromCode(String code) {
        for (AdditionalBindingPurposeVS value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AdditionalBindingPurposeVS code: '" + code + "'");
    }
}
