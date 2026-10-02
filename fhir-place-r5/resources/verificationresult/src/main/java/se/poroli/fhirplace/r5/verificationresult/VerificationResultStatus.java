package se.poroli.fhirplace.r5.verificationresult;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * The validation status of the target.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/verificationresult-status">FHIR R5 VerificationResultStatus</a>
 */
public enum VerificationResultStatus implements CodedEnum {

    /** ***TODO***. */
    ATTESTED("attested", "Attested"),

    /** ***TODO***. */
    VALIDATED("validated", "Validated"),

    /** ***TODO***. */
    IN_PROCESS("in-process", "In process"),

    /** ***TODO***. */
    REQ_REVALID("req-revalid", "Requires revalidation"),

    /** ***TODO***. */
    VAL_FAIL("val-fail", "Validation failed"),

    /** ***TODO***. */
    REVAL_FAIL("reval-fail", "Re-Validation failed"),

    /** The VerificationResult record was created erroneously and is not appropriated for use. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error");

    private final String code;
    private final String display;

    VerificationResultStatus(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/CodeSystem/verificationresult-status";
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
    public static VerificationResultStatus fromCode(String code) {
        for (VerificationResultStatus value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown VerificationResultStatus code: '" + code + "'");
    }
}
