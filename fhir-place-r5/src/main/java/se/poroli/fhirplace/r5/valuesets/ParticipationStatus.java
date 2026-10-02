package se.poroli.fhirplace.r5.valuesets;

/**
 * The Participation status of an appointment.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/participationstatus">FHIR R5 ParticipationStatus</a>
 */
public enum ParticipationStatus implements CodedEnum {

    /** The participant has accepted the appointment. */
    ACCEPTED("accepted", "Accepted"),

    /** The participant has declined the appointment and will not participate in the appointment. */
    DECLINED("declined", "Declined"),

    /** The participant has tentatively accepted the appointment. */
    TENTATIVE("tentative", "Tentative"),

    /**
     * The participant needs to indicate if they accept the appointment by changing this status to one of the other
     * statuses.
     */
    NEEDS_ACTION("needs-action", "Needs Action");

    private final String code;
    private final String display;

    ParticipationStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/participationstatus";
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
    public static ParticipationStatus fromCode(String code) {
        for (ParticipationStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ParticipationStatus code: '" + code + "'");
    }
}
