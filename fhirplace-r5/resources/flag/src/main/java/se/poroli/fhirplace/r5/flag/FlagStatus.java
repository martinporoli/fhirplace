package se.poroli.fhirplace.r5.flag;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Indicates whether this flag is active and needs to be displayed to a user, or whether it is no longer needed or was
 * entered in error.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/flag-status">FHIR R5 FlagStatus</a>
 */
public enum FlagStatus implements CodedEnum {

    /** A current flag that should be displayed to a user. */
    ACTIVE("active", "Active"),

    /** The flag no longer needs to be displayed. */
    INACTIVE("inactive", "Inactive"),

    /** The flag was added in error and should no longer be displayed. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    FlagStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/flag-status";
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
    public static FlagStatus fromCode(String code) {
        for (FlagStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown FlagStatus code: '" + code + "'");
    }
}
