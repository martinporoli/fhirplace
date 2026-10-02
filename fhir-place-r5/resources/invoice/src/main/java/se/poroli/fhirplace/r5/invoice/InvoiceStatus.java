package se.poroli.fhirplace.r5.invoice;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes identifying the lifecycle stage of an Invoice.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/invoice-status">FHIR R5 InvoiceStatus</a>
 */
public enum InvoiceStatus implements CodedEnum {

    /** the invoice has been prepared but not yet finalized. */
    DRAFT("draft", "draft"),

    /** the invoice has been finalized and sent to the recipient. */
    ISSUED("issued", "issued"),

    /** the invoice has been balaced / completely paid. */
    BALANCED("balanced", "balanced"),

    /** the invoice was cancelled. */
    CANCELLED("cancelled", "cancelled"),

    /** the invoice was determined as entered in error before it was issued. */
    ENTERED_IN_ERROR("entered-in-error", "entered in error");

    private final String code;
    private final String display;

    InvoiceStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/invoice-status";
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
    public static InvoiceStatus fromCode(String code) {
        for (InvoiceStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown InvoiceStatus code: '" + code + "'");
    }
}
