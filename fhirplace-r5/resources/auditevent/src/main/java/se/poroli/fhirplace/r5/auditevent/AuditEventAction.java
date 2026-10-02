package se.poroli.fhirplace.r5.auditevent;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Indicator for type of action performed during the event that generated the event.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/audit-event-action">FHIR R5 AuditEventAction</a>
 */
public enum AuditEventAction implements CodedEnum {

    /** Create a new database object, such as placing an order. */
    C("C", "Create"),

    /** Read data, such as to print or display to a doctor. */
    R("R", "Read"),

    /** Update data, such as revise patient information. */
    U("U", "Update"),

    /** Delete items, such as a doctor master file record. */
    D("D", "Delete"),

    /**
     * Perform a system or application function such as log-on, program execution or use of an object's method, or
     * perform a query/search operation.
     */
    E("E", "Execute");

    private final String code;
    private final String display;

    AuditEventAction(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/audit-event-action";
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
    public static AuditEventAction fromCode(String code) {
        for (AuditEventAction value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AuditEventAction code: '" + code + "'");
    }
}
