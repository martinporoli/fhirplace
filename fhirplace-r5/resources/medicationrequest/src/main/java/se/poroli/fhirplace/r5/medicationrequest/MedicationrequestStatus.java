package se.poroli.fhirplace.r5.medicationrequest;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * MedicationRequest Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/medicationrequest-status">FHIR R5 MedicationrequestStatus</a>
 */
public enum MedicationrequestStatus implements CodedEnum {

    /** The request is 'actionable', but not all actions that are implied by it have occurred yet. */
    ACTIVE("active", "Active"),

    /** Actions implied by the request are to be temporarily halted. */
    ON_HOLD("on-hold", "On Hold"),

    /** The request is no longer active and the subject should no longer be taking the medication. */
    ENDED("ended", "Ended"),

    /** Actions implied by the request are to be permanently halted, before all of the administrations occurred. */
    STOPPED("stopped", "Stopped"),

    /** All actions that are implied by the request have occurred. */
    COMPLETED("completed", "Completed"),

    /** The request has been withdrawn before any administrations have occurred. */
    CANCELLED("cancelled", "Cancelled"),

    /**
     * The request was recorded against the wrong patient or for some reason should not have been recorded (e.g. wrong
     * medication, wrong dose, etc.).
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * The request is not yet 'actionable', e.g. it is a work in progress, requires sign-off, verification or needs to
     * be run through decision support process.
     */
    DRAFT("draft", "Draft"),

    /** The authoring/source system does not know which of the status values currently applies for this request. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    MedicationrequestStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/medicationrequest-status";
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
    public static MedicationrequestStatus fromCode(String code) {
        for (MedicationrequestStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MedicationrequestStatus code: '" + code + "'");
    }
}
