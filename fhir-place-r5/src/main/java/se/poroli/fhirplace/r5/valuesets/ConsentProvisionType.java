package se.poroli.fhirplace.r5.valuesets;

/**
 * How a rule statement is applied, such as adding additional consent or removing consent.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/consent-provision-type">FHIR R5 ConsentProvisionType</a>
 */
public enum ConsentProvisionType implements CodedEnum {

    /** Consent is denied for actions meeting these rules. */
    DENY("deny", "Deny"),

    /** Consent is provided for actions meeting these rules. */
    PERMIT("permit", "Permit");

    private final String code;
    private final String display;

    ConsentProvisionType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/consent-provision-type";
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
    public static ConsentProvisionType fromCode(String code) {
        for (ConsentProvisionType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConsentProvisionType code: '" + code + "'");
    }
}
