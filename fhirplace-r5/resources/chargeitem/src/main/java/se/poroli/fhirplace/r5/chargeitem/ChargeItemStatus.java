package se.poroli.fhirplace.r5.chargeitem;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes identifying the lifecycle stage of a ChargeItem.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/chargeitem-status">FHIR R5 ChargeItemStatus</a>
 */
public enum ChargeItemStatus implements CodedEnum {

    /**
     * The charge item has been entered, but the charged service is not yet complete, so it shall not be billed yet
     * but might be used in the context of pre-authorization.
     */
    PLANNED("planned", "Planned"),

    /** The charge item is ready for billing. */
    BILLABLE("billable", "Billable"),

    /**
     * The charge item has been determined to be not billable (e.g. due to rules associated with the billing code).
     */
    NOT_BILLABLE("not-billable", "Not billable"),

    /** The processing of the charge was aborted. */
    ABORTED("aborted", "Aborted"),

    /**
     * The charge item has been billed (e.g. a billing engine has generated financial transactions by applying the
     * associated ruled for the charge item to the context of the Encounter, and placed them into Claims/Invoices.
     */
    BILLED("billed", "Billed"),

    /** The charge item has been entered in error and should not be processed for billing. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * The authoring system does not know which of the status values currently applies for this charge item Note: This
     * concept is not to be used for "other" - one of the listed statuses is presumed to apply, it's just not known
     * which one.
     */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    ChargeItemStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/chargeitem-status";
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
    public static ChargeItemStatus fromCode(String code) {
        for (ChargeItemStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ChargeItemStatus code: '" + code + "'");
    }
}
