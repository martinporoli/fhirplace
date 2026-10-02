package se.poroli.fhirplace.r5.capabilitystatement;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A set of flags that defines how references are supported.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/reference-handling-policy">FHIR R5 ReferenceHandlingPolicy</a>
 */
public enum ReferenceHandlingPolicy implements CodedEnum {

    /**
     * The server supports and populates Literal references (i.e. using Reference.reference) where they are known
     * (this code does not guarantee that all references are literal; see 'enforced').
     */
    LITERAL("literal", "Literal References"),

    /** The server allows logical references (i.e. using Reference.identifier). */
    LOGICAL("logical", "Logical References"),

    /**
     * The server will attempt to resolve logical references to literal references - i.e. converting
     * Reference.identifier to Reference.reference (if resolution fails, the server may still accept resources; see
     * logical).
     */
    RESOLVES("resolves", "Resolves References"),

    /**
     * The server enforces that references have integrity - e.g. it ensures that references can always be resolved.
     */
    ENFORCED("enforced", "Reference Integrity Enforced"),

    /** The server does not support references that point to other servers. */
    LOCAL("local", "Local References Only");

    private final String code;
    private final String display;

    ReferenceHandlingPolicy(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/reference-handling-policy";
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
    public static ReferenceHandlingPolicy fromCode(String code) {
        for (ReferenceHandlingPolicy value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ReferenceHandlingPolicy code: '" + code + "'");
    }
}
