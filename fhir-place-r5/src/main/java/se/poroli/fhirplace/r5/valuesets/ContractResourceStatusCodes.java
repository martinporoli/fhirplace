package se.poroli.fhirplace.r5.valuesets;

/**
 * This value set contract specific codes for status.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/contract-status">FHIR R5 ContractResourceStatusCodes</a>
 */
public enum ContractResourceStatusCodes implements CodedEnum {

    /**
     * Contract is augmented with additional information to correct errors in a predecessor or to updated values in a
     * predecessor.
     */
    AMENDED("amended", "Amended"),

    /** Contract is augmented with additional information that was missing from a predecessor Contract. */
    APPENDED("appended", "Appended"),

    /**
     * Contract is terminated due to failure of the Grantor and/or the Grantee to fulfil one or more contract
     * provisions.
     */
    CANCELLED("cancelled", "Cancelled"),

    /** Contract is pended to rectify failure of the Grantor or the Grantee to fulfil contract provision(s). */
    DISPUTED("disputed", "Disputed"),

    /** Contract was created in error. */
    ENTERED_IN_ERROR("entered-in-error", "Entered in Error"),

    /**
     * Contract execution pending; may be executed when either the Grantor or the Grantee accepts the contract
     * provisions by signing.
     */
    EXECUTABLE("executable", "Executable"),

    /** Contract is activated for period stipulated when both the Grantor and Grantee have signed it. */
    EXECUTED("executed", "Executed"),

    /**
     * Contract execution is suspended while either or both the Grantor and Grantee propose and consider new or
     * revised contract provisions.
     */
    NEGOTIABLE("negotiable", "Negotiable"),

    /** Contract is a proposal by either the Grantor or the Grantee. */
    OFFERED("offered", "Offered"),

    /** Contract template is available as the basis for an application or offer by the Grantor or Grantee. */
    POLICY("policy", "Policy"),

    /**
     * Execution of the Contract is not completed because either or both the Grantor and Grantee decline to accept
     * some or all of the contract provisions.
     */
    REJECTED("rejected", "Rejected"),

    /** Beginning of a successor Contract at the termination of predecessor Contract lifecycle. */
    RENEWED("renewed", "Renewed"),

    /** A Contract that is rescinded. */
    REVOKED("revoked", "Revoked"),

    /** Contract is reactivated after being pended because of faulty execution. */
    RESOLVED("resolved", "Resolved"),

    /** Contract reaches its expiry date. */
    TERMINATED("terminated", "Terminated");

    private final String code;
    private final String display;

    ContractResourceStatusCodes(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/contract-status";
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
    public static ContractResourceStatusCodes fromCode(String code) {
        for (ContractResourceStatusCodes value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown ContractResourceStatusCodes code: '" + code + "'");
    }
}
