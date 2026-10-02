package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes providing the status of an observation.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/observation-status">FHIR R5 ObservationStatus</a>
 */
public enum ObservationStatus implements CodedEnum {

    /** The existence of the observation is registered, but there is no result yet available. */
    REGISTERED("registered", "Registered"),

    /** This is an initial or interim observation: data may be incomplete or unverified. */
    PRELIMINARY("preliminary", "Preliminary"),

    /** The observation is complete and there are no further actions needed. */
    FINAL("final", "Final"),

    /** Subsequent to being Final, the observation has been modified subsequent. */
    AMENDED("amended", "Amended"),

    /** Subsequent to being Final, the observation has been modified to correct an error in the test result. */
    CORRECTED("corrected", "Corrected"),

    /**
     * The observation is unavailable because the measurement was not started or not completed (also sometimes called
     * "aborted").
     */
    CANCELLED("cancelled", "Cancelled"),

    /** The observation has been withdrawn following previous final release. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * The authoring/source system does not know which of the status values currently applies for this observation.
     */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    ObservationStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/observation-status";
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
    public static ObservationStatus fromCode(String code) {
        for (ObservationStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ObservationStatus code: '" + code + "'");
    }
}
