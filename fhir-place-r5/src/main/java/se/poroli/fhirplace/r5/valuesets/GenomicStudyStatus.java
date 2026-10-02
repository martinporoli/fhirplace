package se.poroli.fhirplace.r5.valuesets;

/**
 * The status of the GenomicStudy.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/genomicstudy-status">FHIR R5 GenomicStudyStatus</a>
 */
public enum GenomicStudyStatus implements CodedEnum {

    /** The existence of the genomic study is registered, but there is nothing yet available. */
    REGISTERED("registered", "Registered"),

    /** At least one instance has been associated with this genomic study. */
    AVAILABLE("available", "Available"),

    /**
     * The genomic study is unavailable because the genomic study was not started or not completed (also sometimes
     * called "aborted").
     */
    CANCELLED("cancelled", "Cancelled"),

    /** The genomic study has been withdrawn following a previous final release. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The system does not know which of the status values currently applies for this request. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    GenomicStudyStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/genomicstudy-status";
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
    public static GenomicStudyStatus fromCode(String code) {
        for (GenomicStudyStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown GenomicStudyStatus code: '" + code + "'");
    }
}
