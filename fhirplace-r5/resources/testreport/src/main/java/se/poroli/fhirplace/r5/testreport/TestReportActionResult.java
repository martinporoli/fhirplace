package se.poroli.fhirplace.r5.testreport;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The results of executing an action.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/report-action-result-codes">FHIR R5 TestReportActionResult</a>
 */
public enum TestReportActionResult implements CodedEnum {

    /** The action was successful. */
    PASS("pass", "Pass"),

    /** The action was skipped. */
    SKIP("skip", "Skip"),

    /** The action failed. */
    FAIL("fail", "Fail"),

    /** The action passed but with warnings. */
    WARNING("warning", "Warning"),

    /** The action encountered a fatal error and the engine was unable to process. */
    ERROR("error", "Error");

    private final String code;
    private final String display;

    TestReportActionResult(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/report-action-result-codes";
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
    public static TestReportActionResult fromCode(String code) {
        for (TestReportActionResult value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TestReportActionResult code: '" + code + "'");
    }
}
