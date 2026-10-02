package se.poroli.fhirplace.r5.medicationstatement;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * MedicationStatement Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/medication-statement-status">FHIR R5 MedicationStatementStatusCodes</a>
 */
public enum MedicationStatementStatusCodes implements CodedEnum {

    /** The action of recording the medication statement is finished. */
    RECORDED("recorded", "Recorded"),

    /** Some of the actions that are implied by the medication usage may have occurred. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The medication usage is draft or preliminary. */
    DRAFT("draft", "Draft");

    private final String code;
    private final String display;

    MedicationStatementStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/medication-statement-status";
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
    public static MedicationStatementStatusCodes fromCode(String code) {
        for (MedicationStatementStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MedicationStatementStatusCodes code: '" + code + "'");
    }
}
