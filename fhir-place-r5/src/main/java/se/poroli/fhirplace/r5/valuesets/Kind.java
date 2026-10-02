package se.poroli.fhirplace.r5.valuesets;

/**
 * The kind of coverage: insurance, selfpay or other.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/coverage-kind">FHIR R5 Kind</a>
 */
public enum Kind implements CodedEnum {

    /** The Coverage provides the identifiers and card-level details of an insurance policy. */
    INSURANCE("insurance", "Insurance"),

    /** One or more persons and/or organizations are paying for the services rendered. */
    SELF_PAY("self-pay", "Self-pay"),

    /** Some other organization is paying for the service. */
    OTHER("other", "Other");

    private final String code;
    private final String display;

    Kind(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/coverage-kind";
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
    public static Kind fromCode(String code) {
        for (Kind value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown Kind code: '" + code + "'");
    }
}
