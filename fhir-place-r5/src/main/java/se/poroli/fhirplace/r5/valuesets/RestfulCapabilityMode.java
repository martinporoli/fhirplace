package se.poroli.fhirplace.r5.valuesets;

/**
 * The mode of a RESTful capability statement.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/restful-capability-mode">FHIR R5 RestfulCapabilityMode</a>
 */
public enum RestfulCapabilityMode implements CodedEnum {

    /** The application acts as a client for this resource. */
    CLIENT("client", "Client"),

    /** The application acts as a server for this resource. */
    SERVER("server", "Server");

    private final String code;
    private final String display;

    RestfulCapabilityMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/restful-capability-mode";
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
    public static RestfulCapabilityMode fromCode(String code) {
        for (RestfulCapabilityMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown RestfulCapabilityMode code: '" + code + "'");
    }
}
