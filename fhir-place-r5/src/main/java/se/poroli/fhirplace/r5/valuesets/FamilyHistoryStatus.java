package se.poroli.fhirplace.r5.valuesets;

/**
 * A code that identifies the status of the family history record.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/history-status">FHIR R5 FamilyHistoryStatus</a>
 */
public enum FamilyHistoryStatus implements CodedEnum {

    /** Some health information is known and captured, but not complete - see notes for details. */
    PARTIAL("partial", "Partial"),

    /**
     * All available related health information is captured as of the date (and possibly time) when the family member
     * history was taken.
     */
    COMPLETED("completed", "Completed"),

    /** This instance should not have been part of this patient's medical record. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** Health information for this family member is unavailable/unknown. */
    HEALTH_UNKNOWN("health-unknown", "Health Unknown");

    private final String code;
    private final String display;

    FamilyHistoryStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/history-status";
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
    public static FamilyHistoryStatus fromCode(String code) {
        for (FamilyHistoryStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FamilyHistoryStatus code: '" + code + "'");
    }
}
