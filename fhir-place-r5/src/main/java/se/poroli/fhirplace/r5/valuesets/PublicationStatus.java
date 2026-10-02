package se.poroli.fhirplace.r5.valuesets;

/**
 * The lifecycle status of an artifact.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/publication-status">FHIR R5 PublicationStatus</a>
 */
public enum PublicationStatus implements CodedEnum {

    /** This resource is still under development and is not yet considered to be ready for normal use. */
    DRAFT("draft", "Draft"),

    /** This resource is ready for normal use. */
    ACTIVE("active", "Active"),

    /** This resource has been withdrawn or superseded and should no longer be used. */
    RETIRED("retired", "Retired"),

    /** The authoring system does not know which of the status values currently applies for this resource. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    PublicationStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/publication-status";
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
    public static PublicationStatus fromCode(String code) {
        for (PublicationStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown PublicationStatus code: '" + code + "'");
    }
}
