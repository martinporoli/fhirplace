package se.poroli.fhirplace.r5.valuesets;

/**
 * Indicates whether a resource instance represents a specific location or a class of locations.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/location-mode">FHIR R5 LocationMode</a>
 */
public enum LocationMode implements CodedEnum {

    /** The Location resource represents a specific instance of a location (e.g. Operating Theatre 1A). */
    INSTANCE("instance", "Instance"),

    /**
     * The Location represents a class of locations (e.g. Any Operating Theatre) although this class of locations
     * could be constrained within a specific boundary (such as organization, or parent location, address etc.).
     */
    KIND("kind", "Kind");

    private final String code;
    private final String display;

    LocationMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/location-mode";
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
    public static LocationMode fromCode(String code) {
        for (LocationMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown LocationMode code: '" + code + "'");
    }
}
