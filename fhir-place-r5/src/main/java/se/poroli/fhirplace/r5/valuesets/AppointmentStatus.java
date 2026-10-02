package se.poroli.fhirplace.r5.valuesets;

/**
 * The free/busy status of an appointment.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/appointmentstatus">FHIR R5 AppointmentStatus</a>
 */
public enum AppointmentStatus implements CodedEnum {

    /**
     * None of the participant(s) have finalized their acceptance of the appointment request, and the start/end time
     * might not be set yet.
     */
    PROPOSED("proposed", "Proposed"),

    /** Some or all of the participant(s) have not finalized their acceptance of the appointment request. */
    PENDING("pending", "Pending"),

    /**
     * All participant(s) have been considered and the appointment is confirmed to go ahead at the date/times
     * specified.
     */
    BOOKED("booked", "Booked"),

    /** The patient/patients has/have arrived and is/are waiting to be seen. */
    ARRIVED("arrived", "Arrived"),

    /**
     * The planning stages of the appointment are now complete, the encounter resource will exist and will track
     * further status changes.
     */
    FULFILLED("fulfilled", "Fulfilled"),

    /** The appointment has been cancelled. */
    CANCELLED("cancelled", "Cancelled"),

    /** Some or all of the participant(s) have not/did not appear for the appointment (usually the patient). */
    NOSHOW("noshow", "No Show"),

    /** This instance should not have been part of this patient's medical record. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in error"),

    /** When checked in, all pre-encounter administrative work is complete, and the encounter may begin. */
    CHECKED_IN("checked-in", "Checked In"),

    /**
     * The appointment has been placed on a waitlist, to be scheduled/confirmed in the future when a slot/service is
     * available.
     */
    WAITLIST("waitlist", "Waitlisted");

    private final String code;
    private final String display;

    AppointmentStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/appointmentstatus";
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
    public static AppointmentStatus fromCode(String code) {
        for (AppointmentStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AppointmentStatus code: '" + code + "'");
    }
}
