package se.poroli.fhirplace.r5.valuesets;

/**
 * Indicates that a parameter applies when the operation is being invoked at the specified level.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/operation-parameter-scope">FHIR R5 OperationParameterScope</a>
 */
public enum OperationParameterScope implements CodedEnum {

    /** This is a parameter that can be used at the instance level. */
    INSTANCE("instance", "Instance"),

    /** This is a parameter that can be used at the type level. */
    TYPE("type", "Type"),

    /** This is a parameter that can be used at the system level. */
    SYSTEM("system", "System");

    private final String code;
    private final String display;

    OperationParameterScope(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/operation-parameter-scope";
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
    public static OperationParameterScope fromCode(String code) {
        for (OperationParameterScope value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown OperationParameterScope code: '" + code + "'");
    }
}
