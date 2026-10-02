package se.poroli.fhirplace.r5.valuesets;

/**
 * The status of the diagnostic report.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/diagnostic-report-status">FHIR R5 DiagnosticReportStatus</a>
 */
public enum DiagnosticReportStatus implements CodedEnum {

    /** The existence of the report is registered, but there is nothing yet available. */
    REGISTERED("registered", "Registered"),

    /**
     * This is a partial (e.g. initial, interim or preliminary) report: data in the report may be incomplete or
     * unverified.
     */
    PARTIAL("partial", "Partial"),

    /** Verified early results are available, but not all results are final. */
    PRELIMINARY("preliminary", "Preliminary"),

    /** Prior to being final, the report has been modified. */
    MODIFIED("modified", "Modified"),

    /** The report is complete and verified by an authorized person. */
    FINAL("final", "Final"),

    /** Subsequent to being final, the report has been modified. */
    AMENDED("amended", "Amended"),

    /**
     * Subsequent to being final, the report has been modified to correct an error in the report or referenced
     * results.
     */
    CORRECTED("corrected", "Corrected"),

    /** Subsequent to being final, the report has been modified by adding new content. */
    APPENDED("appended", "Appended"),

    /**
     * The report is unavailable because the measurement was not started or not completed (also sometimes called
     * "aborted").
     */
    CANCELLED("cancelled", "Cancelled"),

    /** The report has been withdrawn following a previous final release. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * The authoring/source system does not know which of the status values currently applies for this observation.
     */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    DiagnosticReportStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/diagnostic-report-status";
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
    public static DiagnosticReportStatus fromCode(String code) {
        for (DiagnosticReportStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DiagnosticReportStatus code: '" + code + "'");
    }
}
