package se.poroli.fhirplace.r5.valuesets;

/**
 * Codes providing the type of triggeredBy observation.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/observation-triggeredbytype">FHIR R5 TriggeredBytype</a>
 */
public enum TriggeredBytype implements CodedEnum {

    /** Performance of one or more other tests depending on the results of the initial test. */
    REFLEX("reflex", "Reflex"),

    /** Performance of the same test again with the same parameters/settings/solution. */
    REPEAT("repeat", "Repeat (per policy)"),

    /** Performance of the same test but with different parameters/settings/solution. */
    RE_RUN("re-run", "Re-run (per policy)");

    private final String code;
    private final String display;

    TriggeredBytype(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/observation-triggeredbytype";
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
    public static TriggeredBytype fromCode(String code) {
        for (TriggeredBytype value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TriggeredBytype code: '" + code + "'");
    }
}
