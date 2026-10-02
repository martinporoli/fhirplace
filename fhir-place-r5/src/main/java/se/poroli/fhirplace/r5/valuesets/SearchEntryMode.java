package se.poroli.fhirplace.r5.valuesets;

/**
 * Why an entry is in the result set - whether it's included as a match or because of an _include requirement, or to
 * convey information or warning information about the search process.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/search-entry-mode">FHIR R5 SearchEntryMode</a>
 */
public enum SearchEntryMode implements CodedEnum {

    /** This resource matched the search specification. */
    MATCH("match", "Match"),

    /** This resource is returned because it is referred to from another resource in the search set. */
    INCLUDE("include", "Include"),

    /** An OperationOutcome that provides additional information about the processing of a search. */
    OUTCOME("outcome", "Outcome");

    private final String code;
    private final String display;

    SearchEntryMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/search-entry-mode";
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
    public static SearchEntryMode fromCode(String code) {
        for (SearchEntryMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SearchEntryMode code: '" + code + "'");
    }
}
