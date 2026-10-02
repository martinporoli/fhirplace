package se.poroli.fhirplace.r5.valuesets;

/**
 * Identifies the purpose of the naming system.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/namingsystem-type">FHIR R5 NamingSystemType</a>
 */
public enum NamingSystemType implements CodedEnum {

    /**
     * The naming system is used to define concepts and symbols to represent those concepts; e.g. UCUM, LOINC, NDC
     * code, local lab codes, etc.
     */
    CODESYSTEM("codesystem", "Code System"),

    /** The naming system is used to manage identifiers (e.g. license numbers, order numbers, etc.). */
    IDENTIFIER("identifier", "Identifier"),

    /** The naming system is used as the root for other identifiers and naming systems. */
    ROOT("root", "Root");

    private final String code;
    private final String display;

    NamingSystemType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/namingsystem-type";
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
    public static NamingSystemType fromCode(String code) {
        for (NamingSystemType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown NamingSystemType code: '" + code + "'");
    }
}
