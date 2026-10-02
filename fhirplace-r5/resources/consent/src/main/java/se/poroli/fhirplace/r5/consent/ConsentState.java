package se.poroli.fhirplace.r5.consent;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * Indicates the state of the consent.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/consent-state-codes">FHIR R5 ConsentState</a>
 */
public enum ConsentState implements CodedEnum {

    /** The consent is in development or awaiting use but is not yet intended to be acted upon. */
    DRAFT("draft", "Pending"),

    /** The consent is to be followed and enforced. */
    ACTIVE("active", "Active"),

    /** The consent is terminated or replaced. */
    INACTIVE("inactive", "Inactive"),

    /** The consent development has been terminated prior to completion. */
    NOT_DONE("not-done", "Abandoned"),

    /** The consent was created wrongly (e.g. wrong patient) and should be ignored. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The resource is in an indeterminate state. */
    UNKNOWN("unknown", "Unknown");

    private final String code;
    private final String display;

    ConsentState(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/consent-state-codes";
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
    public static ConsentState fromCode(String code) {
        for (ConsentState value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ConsentState code: '" + code + "'");
    }
}
