package se.poroli.fhirplace.r5.valuesets;

/**
 * BiologicallyDerivedProductDispense Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/biologicallyderivedproductdispense-status">FHIR R5 BiologicallyDerivedProductDispenseCodes</a>
 */
public enum BiologicallyDerivedProductDispenseCodes implements CodedEnum {

    /** The dispense process has started but not yet completed. */
    PREPARATION("preparation", "Preparation"),

    /** The dispense process is in progress. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** The requested product has been allocated and is ready for transport. */
    ALLOCATED("allocated", "Allocated"),

    /** The dispensed product has been picked up. */
    ISSUED("issued", "Issued"),

    /** The dispense could not be completed. */
    UNFULFILLED("unfulfilled", "Unfulfilled"),

    /** The dispensed product was returned. */
    RETURNED("returned", "Returned"),

    /** The dispense was entered in error and therefore nullified. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The authoring system does not know which of the status values applies for this dispense. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    BiologicallyDerivedProductDispenseCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
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
    public static BiologicallyDerivedProductDispenseCodes fromCode(String code) {
        for (BiologicallyDerivedProductDispenseCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown BiologicallyDerivedProductDispenseCodes code: '" + code + "'");
    }
}
