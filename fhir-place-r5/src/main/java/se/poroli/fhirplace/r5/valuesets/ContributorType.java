package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of contributor.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/contributor-type">FHIR R5 ContributorType</a>
 */
public enum ContributorType implements CodedEnum {

    /** An author of the content of the module. */
    AUTHOR("author", "Author"),

    /** An editor of the content of the module. */
    EDITOR("editor", "Editor"),

    /** A reviewer of the content of the module. */
    REVIEWER("reviewer", "Reviewer"),

    /** An endorser of the content of the module. */
    ENDORSER("endorser", "Endorser");

    private final String code;
    private final String display;

    ContributorType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/contributor-type";
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
    public static ContributorType fromCode(String code) {
        for (ContributorType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ContributorType code: '" + code + "'");
    }
}
