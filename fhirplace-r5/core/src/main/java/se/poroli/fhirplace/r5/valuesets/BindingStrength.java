package se.poroli.fhirplace.r5.valuesets;

/**
 * Indication of the degree of conformance expectations associated with a binding.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/binding-strength">FHIR R5 BindingStrength</a>
 */
public enum BindingStrength implements CodedEnum {

    /** To be conformant, the concept in this element SHALL be from the specified value set. */
    REQUIRED("required", "Required"),

    /**
     * To be conformant, the concept in this element SHALL be from the specified value set if any of the codes within
     * the value set can apply to the concept being communicated.
     */
    EXTENSIBLE("extensible", "Extensible"),

    /**
     * Instances are encouraged to draw from the specified codes for interoperability purposes but are not required to
     * do so to be considered conformant.
     */
    PREFERRED("preferred", "Preferred"),

    /** Instances are not expected or even encouraged to draw from the specified value set. */
    EXAMPLE("example", "Example");

    private final String code;
    private final String display;

    BindingStrength(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/binding-strength";
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
    public static BindingStrength fromCode(String code) {
        for (BindingStrength value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown BindingStrength code: '" + code + "'");
    }
}
