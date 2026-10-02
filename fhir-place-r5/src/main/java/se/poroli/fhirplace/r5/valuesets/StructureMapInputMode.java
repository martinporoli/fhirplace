package se.poroli.fhirplace.r5.valuesets;

/**
 * Mode for this instance of data.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/map-input-mode">FHIR R5 StructureMapInputMode</a>
 */
public enum StructureMapInputMode implements CodedEnum {

    /** Names an input instance used a source for mapping. */
    SOURCE("source", "Source Instance"),

    /** Names an instance that is being populated. */
    TARGET("target", "Target Instance");

    private final String code;
    private final String display;

    StructureMapInputMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/map-input-mode";
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
    public static StructureMapInputMode fromCode(String code) {
        for (StructureMapInputMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StructureMapInputMode code: '" + code + "'");
    }
}
