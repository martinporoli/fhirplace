package se.poroli.fhirplace.r5.requirements;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Description Needed Here.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/conformance-expectation">FHIR R5 ConformanceExpectation</a>
 */
public enum ConformanceExpectation implements CodedEnum {

    /** Support for the specified capability is required to be considered conformant. */
    SHALL("SHALL", "SHALL"),

    /**
     * Support for the specified capability is strongly encouraged, and failure to support it should only occur after
     * careful consideration.
     */
    SHOULD("SHOULD", "SHOULD"),

    /**
     * Support for the specified capability is not necessary to be considered conformant, and the requirement should
     * be considered strictly optional.
     */
    MAY("MAY", "MAY"),

    /**
     * Support for the specified capability is strongly discouraged and should occur only after careful consideration.
     */
    SHOULD_NOT("SHOULD-NOT", "SHOULD-NOT");

    private final String code;
    private final String display;

    ConformanceExpectation(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/conformance-expectation";
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
    public static ConformanceExpectation fromCode(String code) {
        for (ConformanceExpectation value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConformanceExpectation code: '" + code + "'");
    }
}
