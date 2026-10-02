package se.poroli.fhirplace.r5.valuesets;

/**
 * The status of the document reference.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/document-reference-status">FHIR R5 DocumentReferenceStatus</a>
 */
public enum DocumentReferenceStatus implements CodedEnum {

    /** This is the current reference for this document. */
    CURRENT("current", "Current"),

    /** This reference has been superseded by another reference. */
    SUPERSEDED("superseded", "Superseded"),

    /** This reference was created in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    DocumentReferenceStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/document-reference-status";
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
    public static DocumentReferenceStatus fromCode(String code) {
        for (DocumentReferenceStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DocumentReferenceStatus code: '" + code + "'");
    }
}
