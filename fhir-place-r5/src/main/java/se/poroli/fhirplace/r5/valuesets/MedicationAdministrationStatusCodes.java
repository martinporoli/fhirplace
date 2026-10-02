package se.poroli.fhirplace.r5.valuesets;

/**
 * MedicationAdministration Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/medication-admin-status">FHIR R5 MedicationAdministrationStatusCodes</a>
 */
public enum MedicationAdministrationStatusCodes implements CodedEnum {

    /** The administration has started but has not yet completed. */
    IN_PROGRESS("in-progress", "In Progress"),

    /**
     * The administration was terminated prior to any impact on the subject (though preparatory actions may have been
     * taken).
     */
    NOT_DONE("not-done", "Not Done"),

    /** Actions implied by the administration have been temporarily halted, but are expected to continue later. */
    ON_HOLD("on-hold", "On Hold"),

    /** All actions that are implied by the administration have occurred. */
    COMPLETED("completed", "Completed"),

    /** The administration was entered in error and therefore nullified. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** Actions implied by the administration have been permanently halted, before all of them occurred. */
    STOPPED("stopped", "Stopped"),

    /** The authoring system does not know which of the status values currently applies for this request. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    MedicationAdministrationStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/medication-admin-status";
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
    public static MedicationAdministrationStatusCodes fromCode(String code) {
        for (MedicationAdministrationStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MedicationAdministrationStatusCodes code: '" + code + "'");
    }
}
