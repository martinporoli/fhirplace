package se.poroli.fhirplace.r5.structuredefinition;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How an extension context is interpreted.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/extension-context-type">FHIR R5 ExtensionContextType</a>
 */
public enum ExtensionContextType implements CodedEnum {

    /** The context is all elements that match the FHIRPath query found in the expression. */
    FHIRPATH("fhirpath", "FHIRPath"),

    /** The context is any element that has an ElementDefinition.id that matches that found in the expression. */
    ELEMENT("element", "Element ID"),

    /**
     * The context is a particular extension from a particular StructureDefinition, and the expression is just a uri
     * that identifies the extension.
     */
    EXTENSION("extension", "Extension URL");

    private final String code;
    private final String display;

    ExtensionContextType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/extension-context-type";
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
    public static ExtensionContextType fromCode(String code) {
        for (ExtensionContextType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ExtensionContextType code: '" + code + "'");
    }
}
