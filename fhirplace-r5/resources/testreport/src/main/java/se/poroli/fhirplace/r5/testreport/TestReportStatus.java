package se.poroli.fhirplace.r5.testreport;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The current status of the test report.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/report-status-codes">FHIR R5 TestReportStatus</a>
 */
public enum TestReportStatus implements CodedEnum {

    /** All test operations have completed. */
    COMPLETED("completed", "Completed"),

    /** A test operations is currently executing. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** A test operation is waiting for an external client request. */
    WAITING("waiting", "Waiting"),

    /** The test script execution was manually stopped. */
    STOPPED("stopped", "Stopped"),

    /** This test report was entered or created in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered In Error");

    private final String code;
    private final String display;

    TestReportStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/report-status-codes";
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
    public static TestReportStatus fromCode(String code) {
        for (TestReportStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TestReportStatus code: '" + code + "'");
    }
}
