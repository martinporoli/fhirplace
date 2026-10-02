package se.poroli.fhirplace.r5.valuesets;

/**
 * Type for strand.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/strand-type">FHIR R5 StrandType</a>
 */
public enum StrandType implements CodedEnum {

    /** Watson strand of starting sequence. */
    WATSON("watson", "Watson strand of starting sequence"),

    /** Crick strand of starting sequence. */
    CRICK("crick", "Crick strand of starting sequence");

    private final String code;
    private final String display;

    StrandType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/strand-type";
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
    public static StrandType fromCode(String code) {
        for (StrandType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StrandType code: '" + code + "'");
    }
}
