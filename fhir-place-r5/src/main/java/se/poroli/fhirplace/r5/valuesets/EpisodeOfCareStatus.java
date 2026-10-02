package se.poroli.fhirplace.r5.valuesets;

/**
 * The status of the episode of care.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/episode-of-care-status">FHIR R5 EpisodeOfCareStatus</a>
 */
public enum EpisodeOfCareStatus implements CodedEnum {

    /** This episode of care is planned to start at the date specified in the period.start. */
    PLANNED("planned", "Planned"),

    /** This episode has been placed on a waitlist, pending the episode being made active (or cancelled). */
    WAITLIST("waitlist", "Waitlist"),

    /** This episode of care is current. */
    ACTIVE("active", "Active"),

    /**
     * This episode of care is on hold; the organization has limited responsibility for the patient (such as while on
     * respite).
     */
    ONHOLD("onhold", "On Hold"),

    /**
     * This episode of care is finished and the organization is not expecting to be providing further care to the
     * patient.
     */
    FINISHED("finished", "Finished"),

    /**
     * The episode of care was cancelled, or withdrawn from service, often selected during the planned stage as the
     * patient may have gone elsewhere, or the circumstances have changed and the organization is unable to provide
     * the care.
     */
    CANCELLED("cancelled", "Cancelled"),

    /** This instance should not have been part of this patient's medical record. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    EpisodeOfCareStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/episode-of-care-status";
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
    public static EpisodeOfCareStatus fromCode(String code) {
        for (EpisodeOfCareStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EpisodeOfCareStatus code: '" + code + "'");
    }
}
