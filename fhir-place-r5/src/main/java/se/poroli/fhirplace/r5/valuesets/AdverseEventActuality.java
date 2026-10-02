package se.poroli.fhirplace.r5.valuesets;

/**
 * Overall nature of the adverse event, e.g. real or potential.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/adverse-event-actuality">FHIR R5 AdverseEventActuality</a>
 */
public enum AdverseEventActuality implements CodedEnum {

    /** The adverse event actually happened regardless of whether anyone was affected or harmed. */
    ACTUAL("actual", "Adverse Event"),

    /** A potential adverse event. */
    POTENTIAL("potential", "Potential Adverse Event");

    private final String code;
    private final String display;

    AdverseEventActuality(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/adverse-event-actuality";
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
    public static AdverseEventActuality fromCode(String code) {
        for (AdverseEventActuality value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AdverseEventActuality code: '" + code + "'");
    }
}
