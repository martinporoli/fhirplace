package se.poroli.fhirplace.r5.valuesets;

/**
 * SHALL applications comply with this constraint?.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/constraint-severity">FHIR R5 ConstraintSeverity</a>
 */
public enum ConstraintSeverity implements CodedEnum {

    /** If the constraint is violated, the resource is not conformant. */
    ERROR("error", "Error"),

    /**
     * If the constraint is violated, the resource is conformant, but it is not necessarily following best practice.
     */
    WARNING("warning", "Warning");

    private final String code;
    private final String display;

    ConstraintSeverity(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/constraint-severity";
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
    public static ConstraintSeverity fromCode(String code) {
        for (ConstraintSeverity value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConstraintSeverity code: '" + code + "'");
    }
}
