package se.poroli.fhirplace.r5.valuesets;

/**
 * Type for orientation.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/orientation-type">FHIR R5 OrientationType</a>
 */
public enum OrientationType implements CodedEnum {

    /** Sense orientation of reference sequence. */
    SENSE("sense", "Sense orientation of referenceSeq"),

    /** Antisense orientation of reference sequence. */
    ANTISENSE("antisense", "Antisense orientation of referenceSeq");

    private final String code;
    private final String display;

    OrientationType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/orientation-type";
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
    public static OrientationType fromCode(String code) {
        for (OrientationType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown OrientationType code: '" + code + "'");
    }
}
