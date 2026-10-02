package se.poroli.fhirplace.r5.codesystem;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of a property value.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/concept-property-type">FHIR R5 PropertyType</a>
 */
public enum PropertyType implements CodedEnum {

    /** The property value is a code that identifies a concept defined in the code system. */
    CODE("code", "code (internal reference)"),

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
    DECIMAL("decimal", "decimal");

    private final String code;
    private final String display;

    PropertyType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/concept-property-type";
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
    public static PropertyType fromCode(String code) {
        for (PropertyType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown PropertyType code: '" + code + "'");
    }
}
