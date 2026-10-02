package se.poroli.fhirplace.r5.valuesets;

/**
 * A supported modifier for a search parameter.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/search-modifier-code">FHIR R5 SearchModifierCode</a>
 */
public enum SearchModifierCode implements CodedEnum {

    /** The search parameter returns resources that have a value or not. */
    MISSING("missing", "Missing"),

    /**
     * The search parameter returns resources that have a value that exactly matches the supplied parameter (the whole
     * string, including casing and accents).
     */
    EXACT("exact", "Exact"),

    /**
     * The search parameter returns resources that include the supplied parameter value anywhere within the field
     * being searched.
     */
    CONTAINS("contains", "Contains"),

    /** The search parameter returns resources that do not contain a match. */
    NOT("not", "Not"),

    /**
     * The search parameter is processed as a string that searches text associated with the code/value - either
     * CodeableConcept.text, Coding.display, Identifier.type.text, or Reference.display.
     */
    TEXT("text", "Text"),

    /**
     * The search parameter is a URI (relative or absolute) that identifies a value set, and the search parameter
     * tests whether the coding is in the specified value set.
     */
    IN("in", "In"),

    /**
     * The search parameter is a URI (relative or absolute) that identifies a value set, and the search parameter
     * tests whether the coding is not in the specified value set.
     */
    NOT_IN("not-in", "Not In"),

    /**
     * The search parameter tests whether the value in a resource is subsumed by the specified value (is-a, or
     * hierarchical relationships).
     */
    BELOW("below", "Below"),

    /**
     * The search parameter tests whether the value in a resource subsumes the specified value (is-a, or hierarchical
     * relationships).
     */
    ABOVE("above", "Above"),

    /**
     * The search parameter only applies to the Resource Type specified as a modifier (e.g. the modifier is not
     * actually :type, but :Patient etc.).
     */
    TYPE("type", "Type"),

    /** The search parameter applies to the identifier on the resource, not the reference. */
    IDENTIFIER("identifier", "Identifier"),

    /**
     * The search parameter has the format system|code|value, where the system and code refer to an
     * Identifier.type.coding.system and .code, and match if any of the type codes match.
     */
    OF_TYPE("of-type", "Of Type"),

    /**
     * Tests whether the textual display value in a resource (e.g., CodeableConcept.text, Coding.display, or
     * Reference.display) matches the supplied parameter value.
     */
    CODE_TEXT("code-text", "Code Text"),

    /**
     * Tests whether the value in a resource matches the supplied parameter value using advanced text handling that
     * searches text associated with the code/value - e.g., CodeableConcept.text, Coding.display, or
     * Identifier.type.text.
     */
    TEXT_ADVANCED("text-advanced", "Text Advanced"),

    /**
     * The search parameter indicates an inclusion directive (_include, _revinclude) that is applied to an included
     * resource instead of the matching resource.
     */
    ITERATE("iterate", "Iterate");

    private final String code;
    private final String display;

    SearchModifierCode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/search-modifier-code";
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
    public static SearchModifierCode fromCode(String code) {
        for (SearchModifierCode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SearchModifierCode code: '" + code + "'");
    }
}
