package se.poroli.fhirplace.r5.account;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Indicates whether the account is available to be used.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/account-status">FHIR R5 AccountStatus</a>
 */
public enum AccountStatus implements CodedEnum {

    /** This account is active and may be used. */
    ACTIVE("active", "Active"),

    /** This account is inactive and should not be used to track financial information. */
    INACTIVE("inactive", "Inactive"),

    /** This instance should not have been part of this patient's medical record. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in error"),

    /** This account is on hold. */
    ON_HOLD("on-hold", "On Hold"),

    /** The account status is unknown. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    AccountStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/account-status";
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
    public static AccountStatus fromCode(String code) {
        for (AccountStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AccountStatus code: '" + code + "'");
    }
}
