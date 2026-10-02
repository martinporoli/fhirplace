package se.poroli.fhirplace.r5.valuesets;

/**
 * This value set includes Status codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/fm-status">FHIR R5 FinancialResourceStatusCodes</a>
 */
public enum FinancialResourceStatusCodes implements CodedEnum {

    /** The instance is currently in-force. */
    ACTIVE("active", "Active"),

    /** The instance is withdrawn, rescinded or reversed. */
    CANCELLED("cancelled", "Cancelled"),

    /** A new instance the contents of which is not complete. */
    DRAFT("draft", "Draft"),

    /** The instance was entered in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    FinancialResourceStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/fm-status";
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
    public static FinancialResourceStatusCodes fromCode(String code) {
        for (FinancialResourceStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FinancialResourceStatusCodes code: '" + code + "'");
    }
}
