package se.poroli.fhirplace.r5.testscript;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of manual completion to use for assertion.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/assert-manual-completion-codes">FHIR R5 AssertionManualCompletionType</a>
 */
public enum AssertionManualCompletionType implements CodedEnum {

    /**
     * Mark the currently waiting test failed and proceed with the next assert if the stopTestOnFail is false or the
     * next test in the TestScript if the stopTestOnFail is true.
     */
    FAIL("fail", "Fail"),

    /**
     * Mark the currently waiting test passed (if the test is not failed already) and proceed with the next action in
     * the TestScript.
     */
    PASS("pass", "Pass"),

    /** Mark this assert as skipped and proceed with the next action in the TestScript. */
    SKIP("skip", "Skip"),

    /** Stop execution of this TestScript. */
    STOP("stop", "Stop");

    private final String code;
    private final String display;

    AssertionManualCompletionType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/assert-manual-completion-codes";
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
    public static AssertionManualCompletionType fromCode(String code) {
        for (AssertionManualCompletionType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AssertionManualCompletionType code: '" + code + "'");
    }
}
