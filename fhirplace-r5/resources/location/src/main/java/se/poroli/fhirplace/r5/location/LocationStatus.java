package se.poroli.fhirplace.r5.location;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Indicates whether the location is still in use.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/location-status">FHIR R5 LocationStatus</a>
 */
public enum LocationStatus implements CodedEnum {

    /** The location is operational. */
    ACTIVE("active", "Active"),

    /** The location is temporarily closed. */
    SUSPENDED("suspended", "Suspended"),

    /** The location is no longer used. */
    INACTIVE("inactive", "Inactive");

    private final String code;
    private final String display;

    LocationStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/location-status";
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
    public static LocationStatus fromCode(String code) {
        for (LocationStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown LocationStatus code: '" + code + "'");
    }
}
