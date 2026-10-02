package se.poroli.fhirplace.r5.medicationknowledge;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * MedicationKnowledge Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/medicationknowledge-status">FHIR R5 MedicationKnowledgeStatusCodes</a>
 */
public enum MedicationKnowledgeStatusCodes implements CodedEnum {

    /**
     * The medication referred to by this MedicationKnowledge is in active use within the drug database or inventory
     * system.
     */
    ACTIVE("active", "Active"),

    /**
     * The medication referred to by this MedicationKnowledge was entered in error within the drug database or
     * inventory system.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * The medication referred to by this MedicationKnowledge is not in active use within the drug database or
     * inventory system.
     */
    INACTIVE("inactive", "Inactive");

    private final String code;
    private final String display;

    MedicationKnowledgeStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/medicationknowledge-status";
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
    public static MedicationKnowledgeStatusCodes fromCode(String code) {
        for (MedicationKnowledgeStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MedicationKnowledgeStatusCodes code: '" + code + "'");
    }
}
