package se.poroli.fhirplace.r5.capabilitystatement;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A code that indicates how the server supports conditional delete.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/conditional-delete-status">FHIR R5 ConditionalDeleteStatus</a>
 */
public enum ConditionalDeleteStatus implements CodedEnum {

    /** No support for conditional deletes. */
    NOT_SUPPORTED("not-supported", "Not Supported"),

    /** Conditional deletes are supported, but only single resources at a time. */
    SINGLE("single", "Single Deletes Supported"),

    /** Conditional deletes are supported, and multiple resources can be deleted in a single interaction. */
    MULTIPLE("multiple", "Multiple Deletes Supported");

    private final String code;
    private final String display;

    ConditionalDeleteStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/conditional-delete-status";
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
    public static ConditionalDeleteStatus fromCode(String code) {
        for (ConditionalDeleteStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConditionalDeleteStatus code: '" + code + "'");
    }
}
