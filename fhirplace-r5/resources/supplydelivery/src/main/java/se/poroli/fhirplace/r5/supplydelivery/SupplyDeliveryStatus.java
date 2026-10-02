package se.poroli.fhirplace.r5.supplydelivery;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Status of the supply delivery.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/supplydelivery-status">FHIR R5 SupplyDeliveryStatus</a>
 */
public enum SupplyDeliveryStatus implements CodedEnum {

    /** Supply has been requested, but not delivered. */
    IN_PROGRESS("in-progress", "In Progress"),

    /** Supply has been delivered ("completed"). */
    COMPLETED("completed", "Delivered"),

    /** Delivery was not completed. */
    ABANDONED("abandoned", "Abandoned"),

    /**
     * This electronic record should never have existed, though it is possible that real-world decisions were based on
     * it.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered In Error");

    private final String code;
    private final String display;

    SupplyDeliveryStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/supplydelivery-status";
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
    public static SupplyDeliveryStatus fromCode(String code) {
        for (SupplyDeliveryStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SupplyDeliveryStatus code: '" + code + "'");
    }
}
