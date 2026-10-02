package se.poroli.fhirplace.r5.valuesets;

/**
 * How a capability statement is intended to be used.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/capability-statement-kind">FHIR R5 CapabilityStatementKind</a>
 */
public enum CapabilityStatementKind implements CodedEnum {

    /** The CapabilityStatement instance represents the present capabilities of a specific system instance. */
    INSTANCE("instance", "Instance"),

    /**
     * The CapabilityStatement instance represents the capabilities of a system or piece of software, independent of a
     * particular installation.
     */
    CAPABILITY("capability", "Capability"),

    /**
     * The CapabilityStatement instance represents a set of requirements for other systems to meet; e.g. as part of an
     * implementation guide or 'request for proposal'.
     */
    REQUIREMENTS("requirements", "Requirements");

    private final String code;
    private final String display;

    CapabilityStatementKind(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/capability-statement-kind";
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
    public static CapabilityStatementKind fromCode(String code) {
        for (CapabilityStatementKind value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CapabilityStatementKind code: '" + code + "'");
    }
}
