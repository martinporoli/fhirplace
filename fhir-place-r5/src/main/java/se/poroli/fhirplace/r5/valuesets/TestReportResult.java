package se.poroli.fhirplace.r5.valuesets;

/**
 * The reported execution result.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/report-result-codes">FHIR R5 TestReportResult</a>
 */
public enum TestReportResult implements CodedEnum {

    /** All test operations successfully passed all asserts. */
    PASS("pass", "Pass"),

    /** One or more test operations failed one or more asserts. */
    FAIL("fail", "Fail"),

    /** One or more test operations is pending execution completion. */
    PENDING("pending", "Pending");

    private final String code;
    private final String display;

    TestReportResult(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/report-result-codes";
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
    public static TestReportResult fromCode(String code) {
        for (TestReportResult value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TestReportResult code: '" + code + "'");
    }
}
