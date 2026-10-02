package se.poroli.fhirplace.r5.valuesets;

/**
 * The allowable request method or HTTP operation codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/http-operations">FHIR R5 TestScriptRequestMethodCode</a>
 */
public enum TestScriptRequestMethodCode implements CodedEnum {

    /** HTTP DELETE operation. */
    DELETE("delete", "DELETE"),

    /** HTTP GET operation. */
    GET("get", "GET"),

    /** HTTP OPTIONS operation. */
    OPTIONS("options", "OPTIONS"),

    /** HTTP PATCH operation. */
    PATCH("patch", "PATCH"),

    /** HTTP POST operation. */
    POST("post", "POST"),

    /** HTTP PUT operation. */
    PUT("put", "PUT"),

    /** HTTP HEAD operation. */
    HEAD("head", "HEAD");

    private final String code;
    private final String display;

    TestScriptRequestMethodCode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/http-operations";
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
    public static TestScriptRequestMethodCode fromCode(String code) {
        for (TestScriptRequestMethodCode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TestScriptRequestMethodCode code: '" + code + "'");
    }
}
