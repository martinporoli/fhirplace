package se.poroli.fhirplace.r5.immunization;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The value set to instantiate this attribute should be drawn from a terminologically robust code system that
 * consists of or contains concepts to support describing the current status of the administered dose of vaccine.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/immunization-status">FHIR R5 ImmunizationStatusCodes</a>
 */
public enum ImmunizationStatusCodes implements CodedEnum {

    /** The event has now concluded. */
    COMPLETED("completed", "Completed"),

    /**
     * This electronic record should never have existed, though it is possible that real-world decisions were based on
     * it.
     */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /** The event was terminated prior to any activity beyond preparation. */
    NOT_DONE("not-done", "Not Done");

    private final String code;
    private final String display;

    ImmunizationStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/event-status";
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
    public static ImmunizationStatusCodes fromCode(String code) {
        for (ImmunizationStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ImmunizationStatusCodes code: '" + code + "'");
    }
}
