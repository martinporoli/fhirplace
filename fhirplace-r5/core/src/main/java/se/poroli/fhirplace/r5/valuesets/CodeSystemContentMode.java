package se.poroli.fhirplace.r5.valuesets;

/**
 * The extent of the content of the code system (the concepts and codes it defines) are represented in a code system
 * resource.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/codesystem-content-mode">FHIR R5 CodeSystemContentMode</a>
 */
public enum CodeSystemContentMode implements CodedEnum {

    /** None of the concepts defined by the code system are included in the code system resource. */
    NOT_PRESENT("not-present", "Not Present"),

    /** A subset of the valid externally defined concepts are included in the code system resource. */
    EXAMPLE("example", "Example"),

    /** A subset of the code system concepts are included in the code system resource. */
    FRAGMENT("fragment", "Fragment"),

    /** All the concepts defined by the code system are included in the code system resource. */
    COMPLETE("complete", "Complete"),

    /**
     * The resource doesn't define any new concepts; it just provides additional designations and properties to
     * another code system.
     */
    SUPPLEMENT("supplement", "Supplement");

    private final String code;
    private final String display;

    CodeSystemContentMode(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/codesystem-content-mode";
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
    public static CodeSystemContentMode fromCode(String code) {
        for (CodeSystemContentMode value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CodeSystemContentMode code: '" + code + "'");
    }
}
