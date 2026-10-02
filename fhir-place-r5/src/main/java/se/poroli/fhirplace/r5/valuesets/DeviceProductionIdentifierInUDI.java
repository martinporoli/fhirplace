package se.poroli.fhirplace.r5.valuesets;

/**
 * Device Production Identifier in UDI.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/device-productidentifierinudi">FHIR R5 DeviceProductionIdentifierInUDI</a>
 */
public enum DeviceProductionIdentifierInUDI implements CodedEnum {

    /** The label includes the lot number. */
    LOT_NUMBER("lot-number", "Lot Number"),

    /** The label includes the manufacture date. */
    MANUFACTURED_DATE("manufactured-date", "Manufactured date"),

    /** The label includes the serial number. */
    SERIAL_NUMBER("serial-number", "Serial Number"),

    /** The label includes the expiration date. */
    EXPIRATION_DATE("expiration-date", "Expiration date"),

    /** The label includes the biological source identifier. */
    BIOLOGICAL_SOURCE("biological-source", "Biological source"),

    /** The label includes the software version. */
    SOFTWARE_VERSION("software-version", "Software Version");

    private final String code;
    private final String display;

    DeviceProductionIdentifierInUDI(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/device-productidentifierinudi";
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
    public static DeviceProductionIdentifierInUDI fromCode(String code) {
        for (DeviceProductionIdentifierInUDI value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown DeviceProductionIdentifierInUDI code: '" + code + "'");
    }
}
