package se.poroli.fhirplace.r5.permission;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Codes identifying the lifecycle stage of a product.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/permission-status">FHIR R5 PermissionStatus</a>
 */
public enum PermissionStatus implements CodedEnum {

    /** Permission is given. */
    ACTIVE("active", "Active"),

    /** Permission was entered in error and is not active. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** Permission is being defined. */
    DRAFT("draft", "Draft"),

    /** Permission not granted. */
    REJECTED("rejected", "Rejected");

    private final String code;
    private final String display;

    PermissionStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/permission-status";
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
    public static PermissionStatus fromCode(String code) {
        for (PermissionStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown PermissionStatus code: '" + code + "'");
    }
}
