package se.poroli.fhirplace.r5.inventoryreport;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The type of count.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/inventoryreport-counttype">FHIR R5 InventoryCountType</a>
 */
public enum InventoryCountType implements CodedEnum {

    /** The inventory report is a current absolute snapshot, i.e. it represents the quantities at hand. */
    SNAPSHOT("snapshot", "Snapshot"),

    /**
     * The inventory report is about the difference between a previous count and a current count, i.e. it represents
     * the items that have been added/subtracted from inventory.
     */
    DIFFERENCE("difference", "Difference");

    private final String code;
    private final String display;

    InventoryCountType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/inventoryreport-counttype";
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
    public static InventoryCountType fromCode(String code) {
        for (InventoryCountType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown InventoryCountType code: '" + code + "'");
    }
}
