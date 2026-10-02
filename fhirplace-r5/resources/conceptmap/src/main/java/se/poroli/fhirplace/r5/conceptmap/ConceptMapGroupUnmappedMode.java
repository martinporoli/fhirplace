package se.poroli.fhirplace.r5.conceptmap;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Defines which action to take if there is no match in the group.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/conceptmap-unmapped-mode">FHIR R5 ConceptMapGroupUnmappedMode</a>
 */
public enum ConceptMapGroupUnmappedMode implements CodedEnum {

    /**
     * Use the code as provided in the $translate request in one of the following input parameters: sourceCode,
     * sourceCoding, sourceCodeableConcept.
     */
    USE_SOURCE_CODE("use-source-code", "Use Provided Source Code"),

    /** Use the code(s) explicitly provided in the group.unmapped 'code' or 'valueSet' element. */
    FIXED("fixed", "Fixed Code"),

    /** Use the map identified by the canonical URL in the url element. */
    OTHER_MAP("other-map", "Other Map");

    private final String code;
    private final String display;

    ConceptMapGroupUnmappedMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/conceptmap-unmapped-mode";
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
    public static ConceptMapGroupUnmappedMode fromCode(String code) {
        for (ConceptMapGroupUnmappedMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConceptMapGroupUnmappedMode code: '" + code + "'");
    }
}
