package se.poroli.fhirplace.r5.valuesets;

/**
 * Current state of the encounter.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/encounter-status">FHIR R5 EncounterStatus</a>
 */
public enum EncounterStatus implements CodedEnum {

    /** The Encounter has not yet started. */
    PLANNED("planned", "Planned"),

    /** The Encounter has begun and the patient is present / the practitioner and the patient are meeting. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** The Encounter has begun, but is currently on hold, e.g. because the patient is temporarily on leave. */
    ON_HOLD("on-hold", "On Hold"),

    /**
     * The Encounter has been clinically completed, the patient has been discharged from the facility or the visit has
     * ended, and the patient may have departed (refer to subjectStatus).
     */
    DISCHARGED("discharged", "Discharged"),

    /** The Encounter has ended. */
    COMPLETED("completed", "Completed"),

    /** The Encounter has ended before it has begun. */
    CANCELLED("cancelled", "Cancelled"),

    /** The Encounter has started, but was not able to be completed. */
    DISCONTINUED("discontinued", "Discontinued"),

    /** This instance should not have been part of this patient's medical record. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The encounter status is unknown. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    EncounterStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/encounter-status";
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
    public static EncounterStatus fromCode(String code) {
        for (EncounterStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EncounterStatus code: '" + code + "'");
    }
}
