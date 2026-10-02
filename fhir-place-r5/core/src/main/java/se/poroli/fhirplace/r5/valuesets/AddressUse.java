package se.poroli.fhirplace.r5.valuesets;

/**
 * The use of an address.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/address-use">FHIR R5 AddressUse</a>
 */
public enum AddressUse implements CodedEnum {

    /** A communication address at a home. */
    HOME("home", "Home"),

    /** An office address. */
    WORK("work", "Work"),

    /** A temporary address. */
    TEMP("temp", "Temporary"),

    /** This address is no longer in use (or was never correct but retained for records). */
    OLD("old", "Old / Incorrect"),

    /** An address to be used to send bills, invoices, receipts etc. */
    BILLING("billing", "Billing");

    private final String code;
    private final String display;

    AddressUse(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/address-use";
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
    public static AddressUse fromCode(String code) {
        for (AddressUse value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AddressUse code: '" + code + "'");
    }
}
