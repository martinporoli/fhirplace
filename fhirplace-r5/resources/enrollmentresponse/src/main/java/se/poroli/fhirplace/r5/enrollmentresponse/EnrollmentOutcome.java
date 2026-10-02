package se.poroli.fhirplace.r5.enrollmentresponse;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The outcome of the processing.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/enrollment-outcome">FHIR R5 EnrollmentOutcome</a>
 */
public enum EnrollmentOutcome implements CodedEnum {

    /** The Claim/Pre-authorization/Pre-determination has been received but processing has not begun. */
    QUEUED("queued", "Queued"),

    /** The processing has completed without errors. */
    COMPLETE("complete", "Processing Complete"),

    /** One or more errors have been detected in the Claim. */
    ERROR("error", "Error"),

    /** No errors have been detected in the Claim and some of the adjudication has been performed. */
    PARTIAL("partial", "Partial Processing");

    private final String code;
    private final String display;

    EnrollmentOutcome(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/enrollment-outcome";
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
    public static EnrollmentOutcome fromCode(String code) {
        for (EnrollmentOutcome value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown EnrollmentOutcome code: '" + code + "'");
    }
}
