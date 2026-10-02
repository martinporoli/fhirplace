package se.poroli.fhirplace.r5.testscript;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of direction to use for assertion.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/assert-direction-codes">FHIR R5 AssertionDirectionType</a>
 */
public enum AssertionDirectionType implements CodedEnum {

    /** The assertion is evaluated on the response. */
    RESPONSE("response", "response"),

    /** The assertion is evaluated on the request. */
    REQUEST("request", "request");

    private final String code;
    private final String display;

    AssertionDirectionType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/assert-direction-codes";
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
    public static AssertionDirectionType fromCode(String code) {
        for (AssertionDirectionType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AssertionDirectionType code: '" + code + "'");
    }
}
