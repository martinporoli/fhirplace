package se.poroli.fhirplace.r5.bundle;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * HTTP verbs (in the HTTP command line).
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/http-verb">FHIR R5 HTTPVerb</a>
 */
public enum HTTPVerb implements CodedEnum {

    /** HTTP GET Command. */
    GET("GET", "GET"),

    /** HTTP HEAD Command. */
    HEAD("HEAD", "HEAD"),

    /** HTTP POST Command. */
    POST("POST", "POST"),

    /** HTTP PUT Command. */
    PUT("PUT", "PUT"),

    /** HTTP DELETE Command. */
    DELETE("DELETE", "DELETE"),

    /** HTTP PATCH Command. */
    PATCH("PATCH", "PATCH");

    private final String code;
    private final String display;

    HTTPVerb(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/http-verb";
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
    public static HTTPVerb fromCode(String code) {
        for (HTTPVerb value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown HTTPVerb code: '" + code + "'");
    }
}
