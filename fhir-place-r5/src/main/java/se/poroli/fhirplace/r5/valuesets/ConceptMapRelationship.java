package se.poroli.fhirplace.r5.valuesets;

/**
 * The relationship between concepts.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/concept-map-relationship">FHIR R5 ConceptMapRelationship</a>
 */
public enum ConceptMapRelationship implements CodedEnum {

    /** The concepts are related to each other, but the exact relationship is not known. */
    RELATED_TO("related-to", "Related To"),

    /** The definitions of the concepts mean the same thing. */
    EQUIVALENT("equivalent", "Equivalent"),

    /** The source concept is narrower in meaning than the target concept. */
    SOURCE_IS_NARROWER_THAN_TARGET("source-is-narrower-than-target", "Source Is Narrower Than Target"),

    /** The source concept is broader in meaning than the target concept. */
    SOURCE_IS_BROADER_THAN_TARGET("source-is-broader-than-target", "Source Is Broader Than Target"),

    /** This is an explicit assertion that the target concept is not related to the source concept. */
    NOT_RELATED_TO("not-related-to", "Not Related To");

    private final String code;
    private final String display;

    ConceptMapRelationship(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/concept-map-relationship";
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
    public static ConceptMapRelationship fromCode(String code) {
        for (ConceptMapRelationship value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConceptMapRelationship code: '" + code + "'");
    }
}
