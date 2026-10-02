package se.poroli.fhirplace.r5.valuesets;

/**
 * Indicates the status of the care team.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/care-team-status">FHIR R5 CareTeamStatus</a>
 */
public enum CareTeamStatus implements CodedEnum {

    /**
     * The care team has been drafted and proposed, but not yet participating in the coordination and delivery of
     * patient care.
     */
    PROPOSED("proposed", "Proposed"),

    /** The care team is currently participating in the coordination and delivery of care. */
    ACTIVE("active", "Active"),

    /**
     * The care team is temporarily on hold or suspended and not participating in the coordination and delivery of
     * care.
     */
    SUSPENDED("suspended", "Suspended"),

    /** The care team was, but is no longer, participating in the coordination and delivery of care. */
    INACTIVE("inactive", "Inactive"),

    /** The care team should have never existed. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    CareTeamStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/care-team-status";
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
    public static CareTeamStatus fromCode(String code) {
        for (CareTeamStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CareTeamStatus code: '" + code + "'");
    }
}
