package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of the measure report.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/measure-report-type">FHIR R5 MeasureReportType</a>
 */
public enum MeasureReportType implements CodedEnum {

    /**
     * An individual report that provides information on the performance for a given measure with respect to a single
     * subject.
     */
    INDIVIDUAL("individual", "Individual"),

    /**
     * A subject list report that includes a listing of subjects that satisfied each population criteria in the
     * measure.
     */
    SUBJECT_LIST("subject-list", "Subject List"),

    /** A summary report that returns the number of members in each population criteria for the measure. */
    SUMMARY("summary", "Summary"),

    /**
     * A data exchange report that contains data-of-interest for the measure (i.e. data that is needed to calculate
     * the measure).
     */
    DATA_EXCHANGE("data-exchange", "Data Exchange");

    private final String code;
    private final String display;

    MeasureReportType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/measure-report-type";
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
    public static MeasureReportType fromCode(String code) {
        for (MeasureReportType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MeasureReportType code: '" + code + "'");
    }
}
