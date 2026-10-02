package se.poroli.fhirplace.r5.structuredefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Defines the type of structure that a definition is describing.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/structure-definition-kind">FHIR R5 StructureDefinitionKind</a>
 */
public enum StructureDefinitionKind implements CodedEnum {

    /** A primitive type that has a value and an extension. */
    PRIMITIVE_TYPE("primitive-type", "Primitive Data Type"),

    /** A complex structure that defines a set of data elements that is suitable for use in 'resources'. */
    COMPLEX_TYPE("complex-type", "Complex Data Type"),

    /**
     * A 'resource' - a directed acyclic graph of elements that aggregrates other types into an identifiable entity.
     */
    RESOURCE("resource", "Resource"),

    /** A pattern or a template that is not intended to be a real resource or complex type. */
    LOGICAL("logical", "Logical");

    private final String code;
    private final String display;

    StructureDefinitionKind(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/structure-definition-kind";
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
    public static StructureDefinitionKind fromCode(String code) {
        for (StructureDefinitionKind value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StructureDefinitionKind code: '" + code + "'");
    }
}
