package se.poroli.fhirplace.r5.supplyrequest;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Status of the supply request.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/supplyrequest-status">FHIR R5 SupplyRequestStatus</a>
 */
public enum SupplyRequestStatus implements CodedEnum {

    /** The request has been created but is not yet complete or ready for action. */
    DRAFT("draft", "Draft"),

    /** The request is ready to be acted upon. */
    ACTIVE("active", "Active"),

    /** The authorization/request to act has been temporarily withdrawn but is expected to resume in the future. */
    SUSPENDED("suspended", "Suspended"),

    /** The authorization/request to act has been terminated prior to the full completion of the intended actions. */
    CANCELLED("cancelled", "Cancelled"),

    /** Activity against the request has been sufficiently completed to the satisfaction of the requester. */
    COMPLETED("completed", "Completed"),

    /**
     * This electronic record should never have existed, though it is possible that real-world decisions were based on
     * it.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * The authoring/source system does not know which of the status values currently applies for this observation.
     */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    SupplyRequestStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/supplyrequest-status";
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
    public static SupplyRequestStatus fromCode(String code) {
        for (SupplyRequestStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SupplyRequestStatus code: '" + code + "'");
    }
}
