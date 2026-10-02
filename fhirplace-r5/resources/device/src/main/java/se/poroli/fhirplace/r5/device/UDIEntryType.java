package se.poroli.fhirplace.r5.device;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes to identify how UDI data was entered.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/udi-entry-type">FHIR R5 UDIEntryType</a>
 */
public enum UDIEntryType implements CodedEnum {

    /** a barcodescanner captured the data from the device label. */
    BARCODE("barcode", "Barcode"),

    /** An RFID chip reader captured the data from the device label. */
    RFID("rfid", "RFID"),

    /** The data was read from the label by a person and manually entered. */
    MANUAL("manual", "Manual"),

    /** The data originated from a patient's implant card and was read by an operator. */
    CARD("card", "Card"),

    /** The data originated from a patient source and was not directly scanned or read from a label or card. */
    SELF_REPORTED("self-reported", "Self Reported"),

    /**
     * The UDI information was received electronically from the device through a communication protocol, such as the
     * IEEE 11073 20601 version 4 exchange protocol over Bluetooth or USB.
     */
    ELECTRONIC_TRANSMISSION("electronic-transmission", "Electronic Transmission"),

    /** The method of data capture has not been determined. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    UDIEntryType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/udi-entry-type";
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
    public static UDIEntryType fromCode(String code) {
        for (UDIEntryType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown UDIEntryType code: '" + code + "'");
    }
}
