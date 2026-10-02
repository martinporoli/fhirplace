package se.poroli.fhirplace.r5.valuesets;

/**
 * Identifies the style of unique identifier used to identify a namespace.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/namingsystem-identifier-type">FHIR R5 NamingSystemIdentifierType</a>
 */
public enum NamingSystemIdentifierType implements CodedEnum {

    /** An ISO object identifier; e.g. 1.2.3.4.5. */
    OID("oid", "OID"),

    /** A universally unique identifier of the form a5afddf4-e880-459b-876e-e4591b0acc11. */
    UUID("uuid", "UUID"),

    /** A uniform resource identifier (ideally a URL - uniform resource locator); e.g. http://unitsofmeasure.org. */
    URI("uri", "URI"),

    /** An IRI string that can be prepended to the code to obtain a concept IRI for RDF applications. */
    IRI_STEM("iri-stem", "IRI stem"),

    /**
     * A short string published by HL7 for use in the V2 family of standsrds to idenfify a code system in the V12
     * coded data types CWE, CNE, and CF.
     */
    V2CSMNEMONIC("v2csmnemonic", "V2CSMNemonic"),

    /** Some other type of unique identifier; e.g. HL7-assigned reserved string such as LN for LOINC. */
    OTHER("other", "Other");

    private final String code;
    private final String display;

    NamingSystemIdentifierType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/namingsystem-identifier-type";
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
    public static NamingSystemIdentifierType fromCode(String code) {
        for (NamingSystemIdentifierType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown NamingSystemIdentifierType code: '" + code + "'");
    }
}
