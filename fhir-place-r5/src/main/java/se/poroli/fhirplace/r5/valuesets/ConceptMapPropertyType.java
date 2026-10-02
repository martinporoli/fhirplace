package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of a ConceptMap mapping property value.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/conceptmap-property-type">FHIR R5 ConceptMapPropertyType</a>
 */
public enum ConceptMapPropertyType implements CodedEnum {

    /** The property value is a code defined in an external code system. */
    CODING("Coding", "Coding (external reference)"),

    /** The property value is a string. */
    STRING("string", "string"),

    /**
     * The property value is an integer (often used to assign ranking values to concepts for supporting score
     * assessments).
     */
    INTEGER("integer", "integer"),

    /** The property value is a boolean true | false. */
    BOOLEAN("boolean", "boolean"),

    /** The property is a date or a date + time. */
    DATE_TIME("dateTime", "dateTime"),

    /** The property value is a decimal number. */
    DECIMAL("decimal", "decimal"),

    /** The property value is a code as defined in the CodeSystem in ConceptMap.property.system. */
    CODE("code", "code");

    private final String code;
    private final String display;

    ConceptMapPropertyType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/conceptmap-property-type";
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
    public static ConceptMapPropertyType fromCode(String code) {
        for (ConceptMapPropertyType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConceptMapPropertyType code: '" + code + "'");
    }
}
