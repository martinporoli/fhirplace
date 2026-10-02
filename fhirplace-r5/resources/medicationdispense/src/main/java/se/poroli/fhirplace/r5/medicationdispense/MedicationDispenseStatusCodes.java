package se.poroli.fhirplace.r5.medicationdispense;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * MedicationDispense Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/medicationdispense-status">FHIR R5 MedicationDispenseStatusCodes</a>
 */
public enum MedicationDispenseStatusCodes implements CodedEnum {

    /**
     * The core event has not started yet, but some staging activities have begun (e.g. initial compounding or
     * packaging of medication).
     */
    PREPARATION("preparation", "Preparation"),

    /** The dispensed product is ready for pickup. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** The dispensed product was not and will never be picked up by the patient. */
    CANCELLED("cancelled", "Cancelled"),

    /** The dispense process is paused while waiting for an external event to reactivate the dispense. */
    ON_HOLD("on-hold", "On Hold"),

    /** The dispensed product has been picked up. */
    COMPLETED("completed", "Completed"),

    /** The dispense was entered in error and therefore nullified. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** Actions implied by the dispense have been permanently halted, before all of them occurred. */
    STOPPED("stopped", "Stopped"),

    /** The dispense was declined and not performed. */
    DECLINED("declined", "Declined"),

    /** The authoring system does not know which of the status values applies for this medication dispense. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    MedicationDispenseStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/medicationdispense-status";
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
    public static MedicationDispenseStatusCodes fromCode(String code) {
        for (MedicationDispenseStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MedicationDispenseStatusCodes code: '" + code + "'");
    }
}
