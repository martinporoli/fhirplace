package se.poroli.fhirplace.r5.valuesets;

/**
 * The type of an address (physical / postal).
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/address-type">FHIR R5 AddressType</a>
 */
public enum AddressType implements CodedEnum {

    /** Mailing addresses - PO Boxes and care-of addresses. */
    POSTAL("postal", "Postal"),

    /** A physical address that can be visited. */
    PHYSICAL("physical", "Physical"),

    /** An address that is both physical and postal. */
    BOTH("both", "Postal & Physical");

    private final String code;
    private final String display;

    AddressType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/address-type";
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
    public static AddressType fromCode(String code) {
        for (AddressType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AddressType code: '" + code + "'");
    }
}
