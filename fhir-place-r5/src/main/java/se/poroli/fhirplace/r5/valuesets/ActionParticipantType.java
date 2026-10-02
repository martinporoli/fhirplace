package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of participant for the action.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/action-participant-type">FHIR R5 ActionParticipantType</a>
 */
public enum ActionParticipantType implements CodedEnum {

    /** The participant is a care team caring for the patient under evaluation. */
    CARETEAM("careteam", "CareTeam"),

    /** The participant is a system or device used in the care of the patient. */
    DEVICE("device", "Device"),

    /** The participant is a group of participants involved in the care of the patient. */
    GROUP("group", "Group"),

    /**
     * The participant is an institution that can provide the given healthcare service used in the care of the
     * patient.
     */
    HEALTHCARESERVICE("healthcareservice", "HealthcareService"),

    /** The participant is a location involved in the care of the patient. */
    LOCATION("location", "Location"),

    /** The participant is an organization involved in the care of the patient. */
    ORGANIZATION("organization", "Organization"),

    /** The participant is the patient under evaluation. */
    PATIENT("patient", "Patient"),

    /** The participant is a practitioner involved in the patient's care. */
    PRACTITIONER("practitioner", "Practitioner"),

    /** The participant is a particular practitioner role involved in the patient's care. */
    PRACTITIONERROLE("practitionerrole", "PractitionerRole"),

    /** The participant is a person related to the patient. */
    RELATEDPERSON("relatedperson", "RelatedPerson");

    private final String code;
    private final String display;

    ActionParticipantType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/action-participant-type";
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
    public static ActionParticipantType fromCode(String code) {
        for (ActionParticipantType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ActionParticipantType code: '" + code + "'");
    }
}
