package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes providing the combined status of a specimen.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/specimen-combined">FHIR R5 SpecimenCombined</a>
 */
public enum SpecimenCombined implements CodedEnum {

    /** The specimen is in a group. */
    GROUPED("grouped", "Grouped"),

    /** The specimen is pooled. */
    POOLED("pooled", "Pooled");

    private final String code;
    private final String display;

    SpecimenCombined(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/specimen-combined";
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
    public static SpecimenCombined fromCode(String code) {
        for (SpecimenCombined value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SpecimenCombined code: '" + code + "'");
    }
}
