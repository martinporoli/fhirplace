package se.poroli.fhirplace.r5.valuesets;

/**
 * The purpose of the Claim: predetermination, preauthorization, claim.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/claim-use">FHIR R5 Use</a>
 */
public enum Use implements CodedEnum {

    /** The treatment is complete and this represents a Claim for the services. */
    CLAIM("claim", "Claim"),

    /** The treatment is proposed and this represents a Pre-authorization for the services. */
    PREAUTHORIZATION("preauthorization", "Preauthorization"),

    /** The treatment is proposed and this represents a Pre-determination for the services. */
    PREDETERMINATION("predetermination", "Predetermination");

    private final String code;
    private final String display;

    Use(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/claim-use";
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
    public static Use fromCode(String code) {
        for (Use value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown Use code: '" + code + "'");
    }
}
