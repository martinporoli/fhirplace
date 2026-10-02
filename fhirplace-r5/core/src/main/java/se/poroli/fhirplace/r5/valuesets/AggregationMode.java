package se.poroli.fhirplace.r5.valuesets;

/**
 * How resource references can be aggregated.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/resource-aggregation-mode">FHIR R5 AggregationMode</a>
 */
public enum AggregationMode implements CodedEnum {

    /** The reference is a local reference to a contained resource. */
    CONTAINED("contained", "Contained"),

    /** The reference to a resource that has to be resolved externally to the resource that includes the reference. */
    REFERENCED("referenced", "Referenced"),

    /**
     * When the resource is in a Bundle, the resource the reference points to will be found in the same bundle as the
     * resource that includes the reference.
     */
    BUNDLED("bundled", "Bundled");

    private final String code;
    private final String display;

    AggregationMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/resource-aggregation-mode";
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
    public static AggregationMode fromCode(String code) {
        for (AggregationMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AggregationMode code: '" + code + "'");
    }
}
