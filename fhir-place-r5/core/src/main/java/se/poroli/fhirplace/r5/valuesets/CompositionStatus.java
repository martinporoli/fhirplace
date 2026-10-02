package se.poroli.fhirplace.r5.valuesets;

/**
 * The workflow/clinical status of the composition.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/composition-status">FHIR R5 CompositionStatus</a>
 */
public enum CompositionStatus implements CodedEnum {

    /** The existence of the composition is registered, but there is nothing yet available. */
    REGISTERED("registered", "Registered"),

    /**
     * This is a partial (e.g. initial, interim or preliminary) composition: data in the composition may be incomplete
     * or unverified.
     */
    PARTIAL("partial", "Partial"),

    /** Verified early results are available, but not all results are final. */
    PRELIMINARY("preliminary", "Preliminary"),

    /**
     * This version of the composition is complete and verified by an appropriate person and no further work is
     * planned.
     */
    FINAL("final", "Final"),

    /**
     * The composition content or the referenced resources have been modified (edited or added to) subsequent to being
     * released as "final" and the composition is complete and verified by an authorized person.
     */
    AMENDED("amended", "Amended"),

    /**
     * Subsequent to being final, the composition content has been modified to correct an error in the composition or
     * referenced results.
     */
    CORRECTED("corrected", "Corrected"),

    /** Subsequent to being final, the composition content has been modified by adding new content. */
    APPENDED("appended", "Appended"),

    /**
     * The composition is unavailable because the measurement was not started or not completed (also sometimes called
     * "aborted").
     */
    CANCELLED("cancelled", "Cancelled"),

    /**
     * The composition or document was originally created/issued in error, and this is an amendment that marks that
     * the entire series should not be considered as valid.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** This composition has been withdrawn or superseded and should no longer be used. */
    DEPRECATED("deprecated", "Deprecated"),

    /**
     * The authoring/source system does not know which of the status values currently applies for this observation.
     */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    CompositionStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/composition-status";
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
    public static CompositionStatus fromCode(String code) {
        for (CompositionStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CompositionStatus code: '" + code + "'");
    }
}
