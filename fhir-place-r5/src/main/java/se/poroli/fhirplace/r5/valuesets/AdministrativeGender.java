package se.poroli.fhirplace.r5.valuesets;

/**
 * The gender of a person used for administrative purposes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/administrative-gender">FHIR R5 AdministrativeGender</a>
 */
public enum AdministrativeGender implements CodedEnum {

    /** Male. */
    MALE("male", "Male"),

    /** Female. */
    FEMALE("female", "Female"),

    /** Other. */
    OTHER("other", "Other"),

    /** Unknown. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    AdministrativeGender(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/administrative-gender";
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
    public static AdministrativeGender fromCode(String code) {
        for (AdministrativeGender value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AdministrativeGender code: '" + code + "'");
    }
}
