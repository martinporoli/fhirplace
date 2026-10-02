package se.poroli.fhirplace.r5.valuesets;

/**
 * The status of the InventoryReport.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/inventoryreport-status">FHIR R5 InventoryReportStatus</a>
 */
public enum InventoryReportStatus implements CodedEnum {

    /**
     * The existence of the report is registered, but it is still without content or only some preliminary content.
     */
    DRAFT("draft", "Draft"),

    /** The inventory report has been requested but there is no data available. */
    REQUESTED("requested", "Requested"),

    /** This report is submitted as current. */
    ACTIVE("active", "Active"),

    /** The report has been withdrawn following a previous final release. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    InventoryReportStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/inventoryreport-status";
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
    public static InventoryReportStatus fromCode(String code) {
        for (InventoryReportStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown InventoryReportStatus code: '" + code + "'");
    }
}
