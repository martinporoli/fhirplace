package se.poroli.fhirplace.r5.valuesets;

/**
 * The status of a resource narrative.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/narrative-status">FHIR R5 NarrativeStatus</a>
 */
public enum NarrativeStatus implements CodedEnum {

    /** The contents of the narrative are entirely generated from the core elements in the content. */
    GENERATED("generated", "Generated"),

    /**
     * The contents of the narrative are entirely generated from the core elements in the content and some of the
     * content is generated from extensions.
     */
    EXTENSIONS("extensions", "Extensions"),

    /** The contents of the narrative may contain additional information not found in the structured data. */
    ADDITIONAL("additional", "Additional"),

    /** The contents of the narrative are some equivalent of "No human-readable text provided in this case". */
    EMPTY("empty", "Empty");

    private final String code;
    private final String display;

    NarrativeStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/narrative-status";
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
    public static NarrativeStatus fromCode(String code) {
        for (NarrativeStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown NarrativeStatus code: '" + code + "'");
    }
}
