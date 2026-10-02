package se.poroli.fhirplace.r5.valuesets;

/**
 * Whether a reference needs to be version specific or version independent, or whether either can be used.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/reference-version-rules">FHIR R5 ReferenceVersionRules</a>
 */
public enum ReferenceVersionRules implements CodedEnum {

    /** The reference may be either version independent or version specific. */
    EITHER("either", "Either Specific or independent"),

    /** The reference must be version independent. */
    INDEPENDENT("independent", "Version independent"),

    /** The reference must be version specific. */
    SPECIFIC("specific", "Version Specific");

    private final String code;
    private final String display;

    ReferenceVersionRules(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/reference-version-rules";
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
    public static ReferenceVersionRules fromCode(String code) {
        for (ReferenceVersionRules value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ReferenceVersionRules code: '" + code + "'");
    }
}
