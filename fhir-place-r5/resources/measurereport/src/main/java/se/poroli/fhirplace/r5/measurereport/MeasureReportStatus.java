package se.poroli.fhirplace.r5.measurereport;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The status of the measure report.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/measure-report-status">FHIR R5 MeasureReportStatus</a>
 */
public enum MeasureReportStatus implements CodedEnum {

    /** The report is complete and ready for use. */
    COMPLETE("complete", "Complete"),

    /** The report is currently being generated. */
    PENDING("pending", "Pending"),

    /** An error occurred attempting to generate the report. */
    ERROR("error", "Error");

    private final String code;
    private final String display;

    MeasureReportStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/measure-report-status";
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
    public static MeasureReportStatus fromCode(String code) {
        for (MeasureReportStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MeasureReportStatus code: '" + code + "'");
    }
}
