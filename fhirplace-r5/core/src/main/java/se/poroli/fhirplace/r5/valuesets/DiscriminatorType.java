package se.poroli.fhirplace.r5.valuesets;

/**
 * How an element value is interpreted when discrimination is evaluated.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/discriminator-type">FHIR R5 DiscriminatorType</a>
 */
public enum DiscriminatorType implements CodedEnum {

    /**
     * The slices have different values in the nominated element, as determined by the applicable fixed value,
     * pattern, or required ValueSet binding.
     */
    VALUE("value", "Value"),

    /** The slices are differentiated by the presence or absence of the nominated element. */
    EXISTS("exists", "Exists"),

    /**
     * The slices have different values in the nominated element, as determined by the applicable fixed value,
     * pattern, or required ValueSet binding.
     */
    PATTERN("pattern", "Pattern"),

    /** The slices are differentiated by type of the nominated element. */
    TYPE("type", "Type"),

    /** The slices are differentiated by conformance of the nominated element to a specified profile. */
    PROFILE("profile", "Profile"),

    /** The slices are differentiated by their index. */
    POSITION("position", "Position");

    private final String code;
    private final String display;

    DiscriminatorType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/discriminator-type";
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
    public static DiscriminatorType fromCode(String code) {
        for (DiscriminatorType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DiscriminatorType code: '" + code + "'");
    }
}
