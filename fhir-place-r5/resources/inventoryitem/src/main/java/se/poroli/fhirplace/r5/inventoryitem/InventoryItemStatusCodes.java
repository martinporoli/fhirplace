package se.poroli.fhirplace.r5.inventoryitem;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * InventoryItem Status Codes.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/inventoryitem-status">FHIR R5 InventoryItemStatusCodes</a>
 */
public enum InventoryItemStatusCodes implements CodedEnum {

    /** The item is active and can be referenced. */
    ACTIVE("active", "Active"),

    /** The item is presently inactive - there may be references to it but the item is not expected to be used. */
    INACTIVE("inactive", "Inactive"),

    /** The item record was entered in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The item status has not been determined. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    InventoryItemStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/inventoryitem-status";
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
    public static InventoryItemStatusCodes fromCode(String code) {
        for (InventoryItemStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown InventoryItemStatusCodes code: '" + code + "'");
    }
}
