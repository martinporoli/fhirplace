package se.poroli.fhirplace.r5.valuesets;

/**
 * How a resource reference is interpreted when testing consent restrictions.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/consent-data-meaning">FHIR R5 ConsentDataMeaning</a>
 */
public enum ConsentDataMeaning implements CodedEnum {

    /** The consent applies directly to the instance of the resource. */
    INSTANCE("instance", "Instance"),

    /** The consent applies directly to the instance of the resource and instances it refers to. */
    RELATED("related", "Related"),

    /** The consent applies directly to the instance of the resource and instances that refer to it. */
    DEPENDENTS("dependents", "Dependents"),

    /** The consent applies to instances of resources that are authored by. */
    AUTHOREDBY("authoredby", "AuthoredBy");

    private final String code;
    private final String display;

    ConsentDataMeaning(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/consent-data-meaning";
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
    public static ConsentDataMeaning fromCode(String code) {
        for (ConsentDataMeaning value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConsentDataMeaning code: '" + code + "'");
    }
}
