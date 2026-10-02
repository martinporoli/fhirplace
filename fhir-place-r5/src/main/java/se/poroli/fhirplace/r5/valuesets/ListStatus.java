package se.poroli.fhirplace.r5.valuesets;

/**
 * The current state of the list.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/list-status">FHIR R5 ListStatus</a>
 */
public enum ListStatus implements CodedEnum {

    /** The list is considered to be an active part of the patient's record. */
    CURRENT("current", "Current"),

    /** The list is "old" and should no longer be considered accurate or relevant. */
    RETIRED("retired", "Retired"),

    /** The list was never accurate. */
    ENTERED_IN_ERROR("entered-in-error", "Entered In Error");

    private final String code;
    private final String display;

    ListStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/list-status";
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
    public static ListStatus fromCode(String code) {
        for (ListStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ListStatus code: '" + code + "'");
    }
}
