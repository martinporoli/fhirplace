package se.poroli.fhirplace.r5.structuredefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How a type relates to its baseDefinition.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/type-derivation-rule">FHIR R5 TypeDerivationRule</a>
 */
public enum TypeDerivationRule implements CodedEnum {

    /**
     * This definition defines a new type that adds additional elements and optionally additional rules to the base
     * type.
     */
    SPECIALIZATION("specialization", "Specialization"),

    /** This definition adds additional rules to an existing concrete type. */
    CONSTRAINT("constraint", "Constraint");

    private final String code;
    private final String display;

    TypeDerivationRule(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/type-derivation-rule";
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
    public static TypeDerivationRule fromCode(String code) {
        for (TypeDerivationRule value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TypeDerivationRule code: '" + code + "'");
    }
}
