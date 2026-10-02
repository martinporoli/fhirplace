package se.poroli.fhirplace.r5.valuesets;

/**
 * How the issue affects the success of the action.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/issue-severity">FHIR R5 IssueSeverity</a>
 */
public enum IssueSeverity implements CodedEnum {

    /** The issue caused the action to fail and no further checking could be performed. */
    FATAL("fatal", "Fatal"),

    /** The issue is sufficiently important to cause the action to fail. */
    ERROR("error", "Error"),

    /**
     * The issue is not important enough to cause the action to fail but may cause it to be performed suboptimally or
     * in a way that is not as desired.
     */
    WARNING("warning", "Warning"),

    /** The issue has no relation to the degree of success of the action. */
    INFORMATION("information", "Information"),

    /** The operation completed successfully. */
    SUCCESS("success", "Operation Successful");

    private final String code;
    private final String display;

    IssueSeverity(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/issue-severity";
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
    public static IssueSeverity fromCode(String code) {
        for (IssueSeverity value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown IssueSeverity code: '" + code + "'");
    }
}
