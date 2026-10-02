package se.poroli.fhirplace.r5.valuesets;

/**
 * Whether an operation parameter is an input or an output parameter.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/operation-parameter-use">FHIR R5 OperationParameterUse</a>
 */
public enum OperationParameterUse implements CodedEnum {

    /** This is an input parameter. */
    IN("in", "In"),

    /** This is an output parameter. */
    OUT("out", "Out");

    private final String code;
    private final String display;

    OperationParameterUse(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/operation-parameter-use";
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
    public static OperationParameterUse fromCode(String code) {
        for (OperationParameterUse value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown OperationParameterUse code: '" + code + "'");
    }
}
