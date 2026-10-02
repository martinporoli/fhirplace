package se.poroli.fhirplace.r5.medication;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Medication Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/medication-status">FHIR R5 MedicationStatusCodes</a>
 */
public enum MedicationStatusCodes implements CodedEnum {

    /** The medication record is current and is appropriate for reference in new instances. */
    ACTIVE("active", "Active"),

    /** The medication record is not current and is not is appropriate for reference in new instances. */
    INACTIVE("inactive", "Inactive"),

    /** The medication record was created erroneously and is not appropriated for reference in new instances. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    MedicationStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/medication-status";
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
    public static MedicationStatusCodes fromCode(String code) {
        for (MedicationStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MedicationStatusCodes code: '" + code + "'");
    }
}
