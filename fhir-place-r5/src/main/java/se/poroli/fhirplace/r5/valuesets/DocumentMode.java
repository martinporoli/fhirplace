package se.poroli.fhirplace.r5.valuesets;

/**
 * Whether the application produces or consumes documents.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/document-mode">FHIR R5 DocumentMode</a>
 */
public enum DocumentMode implements CodedEnum {

    /** The application produces documents of the specified type. */
    PRODUCER("producer", "Producer"),

    /** The application consumes documents of the specified type. */
    CONSUMER("consumer", "Consumer");

    private final String code;
    private final String display;

    DocumentMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/document-mode";
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
    public static DocumentMode fromCode(String code) {
        for (DocumentMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DocumentMode code: '" + code + "'");
    }
}
