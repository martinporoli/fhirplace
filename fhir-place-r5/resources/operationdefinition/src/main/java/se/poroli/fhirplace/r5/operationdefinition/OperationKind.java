package se.poroli.fhirplace.r5.operationdefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Whether an operation is a normal operation or a query.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/operation-kind">FHIR R5 OperationKind</a>
 */
public enum OperationKind implements CodedEnum {

    /** This operation is invoked as an operation. */
    OPERATION("operation", "Operation"),

    /** This operation is a named query, invoked using the search mechanism. */
    QUERY("query", "Query");

    private final String code;
    private final String display;

    OperationKind(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/operation-kind";
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
    public static OperationKind fromCode(String code) {
        for (OperationKind value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown OperationKind code: '" + code + "'");
    }
}
