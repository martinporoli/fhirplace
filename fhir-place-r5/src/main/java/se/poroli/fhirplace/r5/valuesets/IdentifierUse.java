package se.poroli.fhirplace.r5.valuesets;

/**
 * Identifies the purpose for this identifier, if known.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/identifier-use">FHIR R5 IdentifierUse</a>
 */
public enum IdentifierUse implements CodedEnum {

    /**
     * The identifier recommended for display and use in real-world interactions which should be used when such
     * identifier is different from the "official" identifier.
     */
    USUAL("usual", "Usual"),

    /** The identifier considered to be most trusted for the identification of this item. */
    OFFICIAL("official", "Official"),

    /** A temporary identifier. */
    TEMP("temp", "Temp"),

    /**
     * An identifier that was assigned in secondary use - it serves to identify the object in a relative context, but
     * cannot be consistently assigned to the same object again in a different context.
     */
    SECONDARY("secondary", "Secondary"),

    /** The identifier id no longer considered valid, but may be relevant for search purposes. */
    OLD("old", "Old");

    private final String code;
    private final String display;

    IdentifierUse(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/identifier-use";
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
    public static IdentifierUse fromCode(String code) {
        for (IdentifierUse value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown IdentifierUse code: '" + code + "'");
    }
}
