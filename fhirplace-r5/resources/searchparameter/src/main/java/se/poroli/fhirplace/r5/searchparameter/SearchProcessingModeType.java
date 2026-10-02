package se.poroli.fhirplace.r5.searchparameter;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * How a search parameter relates to the set of elements returned by evaluating its expression query.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/search-processingmode">FHIR R5 SearchProcessingModeType</a>
 */
public enum SearchProcessingModeType implements CodedEnum {

    /** The search parameter is derived directly from the selected nodes based on the type definitions. */
    NORMAL("normal", "Normal"),

    /** The search parameter is derived by a phonetic transform from the selected nodes. */
    PHONETIC("phonetic", "Phonetic"),

    /** The interpretation of the xpath statement is unknown (and can't be automated). */
    OTHER("other", "Other");

    private final String code;
    private final String display;

    SearchProcessingModeType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/search-processingmode";
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
    public static SearchProcessingModeType fromCode(String code) {
        for (SearchProcessingModeType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SearchProcessingModeType code: '" + code + "'");
    }
}
