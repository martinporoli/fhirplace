package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes identifying the lifecycle stage of a request.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/request-status">FHIR R5 RequestStatus</a>
 */
public enum RequestStatus implements CodedEnum {

    /** The request has been created but is not yet complete or ready for action. */
    DRAFT("draft", "Draft"),

    /** The request is in force and ready to be acted upon. */
    ACTIVE("active", "Active"),

    /**
     * The request (and any implicit authorization to act) has been temporarily withdrawn but is expected to resume in
     * the future.
     */
    ON_HOLD("on-hold", "On Hold"),

    /**
     * The request (and any implicit authorization to act) has been terminated prior to the known full completion of
     * the intended actions.
     */
    REVOKED("revoked", "Revoked"),

    /** The activity described by the request has been fully performed. */
    COMPLETED("completed", "Completed"),

    /** This request should never have existed and should be considered 'void'. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The authoring/source system does not know which of the status values currently applies for this request. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    RequestStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/request-status";
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
    public static RequestStatus fromCode(String code) {
        for (RequestStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown RequestStatus code: '" + code + "'");
    }
}
