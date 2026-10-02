package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of a ConceptMap mapping attribute value.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/conceptmap-attribute-type">FHIR R5 ConceptMapAttributeType</a>
 */
public enum ConceptMapAttributeType implements CodedEnum {

    /** The attribute value is a code defined in the code system in context. */
    CODE("code", "code"),

    /** The attribute value is a code defined in a code system. */
    CODING("Coding", "Coding"),

    /** The attribute value is a string. */
    STRING("string", "string"),

    /** The attribute value is a boolean true | false. */
    BOOLEAN("boolean", "boolean"),

    /** The attribute is a Quantity (may represent an integer or a decimal with no units). */
    QUANTITY("Quantity", "Quantity");

    private final String code;
    private final String display;

    ConceptMapAttributeType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/conceptmap-attribute-type";
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
    public static ConceptMapAttributeType fromCode(String code) {
        for (ConceptMapAttributeType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConceptMapAttributeType code: '" + code + "'");
    }
}
