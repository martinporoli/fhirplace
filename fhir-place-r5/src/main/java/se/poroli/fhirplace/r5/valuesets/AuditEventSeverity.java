package se.poroli.fhirplace.r5.valuesets;

/**
 * The severity of the audit entry.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/audit-event-severity">FHIR R5 AuditEventSeverity</a>
 */
public enum AuditEventSeverity implements CodedEnum {

    /** System is unusable. */
    EMERGENCY("emergency", "Emergency"),

    /** Notification should be sent to trigger action be taken. */
    ALERT("alert", "Alert"),

    /** Critical conditions. */
    CRITICAL("critical", "Critical"),

    /** Error conditions. */
    ERROR("error", "Error"),

    /** Warning conditions. */
    WARNING("warning", "Warning"),

    /** Notice messages. */
    NOTICE("notice", "Notice"),

    /** Normal operational messages that require no action. */
    INFORMATIONAL("informational", "Informational"),

    /** Debug-level messages. */
    DEBUG("debug", "Debug");

    private final String code;
    private final String display;

    AuditEventSeverity(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/audit-event-severity";
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
    public static AuditEventSeverity fromCode(String code) {
        for (AuditEventSeverity value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AuditEventSeverity code: '" + code + "'");
    }
}
