package se.poroli.fhirplace.r5.valuesets;

/**
 * Controls how multiple enableWhen values are interpreted - whether all or any must be true.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/questionnaire-enable-behavior">FHIR R5 EnableWhenBehavior</a>
 */
public enum EnableWhenBehavior implements CodedEnum {

    /** Enable the question when all the enableWhen criteria are satisfied. */
    ALL("all", "All"),

    /** Enable the question when any of the enableWhen criteria are satisfied. */
    ANY("any", "Any");

    private final String code;
    private final String display;

    EnableWhenBehavior(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/questionnaire-enable-behavior";
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
    public static EnableWhenBehavior fromCode(String code) {
        for (EnableWhenBehavior value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EnableWhenBehavior code: '" + code + "'");
    }
}
