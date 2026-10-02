package se.poroli.fhirplace.r5.valuesets;

/**
 * Data types allowed to be used for search parameters.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/search-param-type">FHIR R5 SearchParamType</a>
 */
public enum SearchParamType implements CodedEnum {

    /** Search parameter SHALL be a number (a whole number, or a decimal). */
    NUMBER("number", "Number"),

    /** Search parameter is on a date/time. */
    DATE("date", "Date/DateTime"),

    /** Search parameter is a simple string, like a name part. */
    STRING("string", "String"),

    /** Search parameter on a coded element or identifier. */
    TOKEN("token", "Token"),

    /** A reference to another resource (Reference or canonical). */
    REFERENCE("reference", "Reference"),

    /** A composite search parameter that combines a search on two values together. */
    COMPOSITE("composite", "Composite"),

    /** A search parameter that searches on a quantity. */
    QUANTITY("quantity", "Quantity"),

    /** A search parameter that searches on a URI (RFC 3986). */
    URI("uri", "URI"),

    /** Special logic applies to this parameter per the description of the search parameter. */
    SPECIAL("special", "Special");

    private final String code;
    private final String display;

    SearchParamType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/search-param-type";
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
    public static SearchParamType fromCode(String code) {
        for (SearchParamType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SearchParamType code: '" + code + "'");
    }
}
