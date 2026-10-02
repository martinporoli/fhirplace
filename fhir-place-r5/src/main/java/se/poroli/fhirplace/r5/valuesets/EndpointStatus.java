package se.poroli.fhirplace.r5.valuesets;

/**
 * The status of the endpoint.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/endpoint-status">FHIR R5 EndpointStatus</a>
 */
public enum EndpointStatus implements CodedEnum {

    /** This endpoint is expected to be active and can be used. */
    ACTIVE("active", "Active"),

    /** This endpoint is temporarily unavailable. */
    SUSPENDED("suspended", "Suspended"),

    /**
     * This endpoint has exceeded connectivity thresholds and is considered in an error state and should no longer be
     * attempted to connect to until corrective action is taken.
     */
    ERROR("error", "Error"),

    /** This endpoint is no longer to be used. */
    OFF("off", "Off"),

    /** This instance should not have been part of this patient's medical record. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in error");

    private final String code;
    private final String display;

    EndpointStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/endpoint-status";
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
    public static EndpointStatus fromCode(String code) {
        for (EndpointStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EndpointStatus code: '" + code + "'");
    }
}
