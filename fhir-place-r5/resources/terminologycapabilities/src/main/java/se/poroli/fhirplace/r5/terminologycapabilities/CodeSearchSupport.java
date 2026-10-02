package se.poroli.fhirplace.r5.terminologycapabilities;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The degree to which the server supports the code search parameter on ValueSet, if it is supported.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/code-search-support">FHIR R5 CodeSearchSupport</a>
 */
public enum CodeSearchSupport implements CodedEnum {

    /**
     * The search for code on ValueSet returns ValueSet resources where the code is included in the extensional
     * definition of the ValueSet.
     */
    IN_COMPOSE("in-compose", "In Compose"),

    /**
     * The search for code on ValueSet returns ValueSet resources where the code is contained in the ValueSet
     * expansion.
     */
    IN_EXPANSION("in-expansion", "In Expansion"),

    /**
     * The search for code on ValueSet returns ValueSet resources where the code is included in the extensional
     * definition or contained in the ValueSet expansion.
     */
    IN_COMPOSE_OR_EXPANSION("in-compose-or-expansion", "In Compose Or Expansion");

    private final String code;
    private final String display;

    CodeSearchSupport(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/code-search-support";
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
    public static CodeSearchSupport fromCode(String code) {
        for (CodeSearchSupport value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CodeSearchSupport code: '" + code + "'");
    }
}
