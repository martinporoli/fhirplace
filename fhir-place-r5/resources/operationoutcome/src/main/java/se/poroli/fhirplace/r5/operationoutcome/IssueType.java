package se.poroli.fhirplace.r5.operationoutcome;

import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * A code that describes the type of issue.
 *
 * @see <a href="http://hl7.org/fhir/ValueSet/issue-type">FHIR R5 IssueType</a>
 */
public enum IssueType implements CodedEnum {

    /** Content invalid against the specification or a profile. */
    INVALID("invalid", "Invalid Content"),

    /**
     * A structural issue in the content such as wrong namespace, unable to parse the content completely, invalid
     * syntax, etc.
     */
    STRUCTURE("structure", "Structural Issue"),

    /** A required element is missing. */
    REQUIRED("required", "Required element missing"),

    /** An element or header value is invalid. */
    VALUE("value", "Element value invalid"),

    /** A content validation rule failed - e.g. a schematron rule. */
    INVARIANT("invariant", "Validation rule failed"),

    /** An authentication/authorization/permissions issue of some kind. */
    SECURITY("security", "Security Problem"),

    /** The client needs to initiate an authentication process. */
    LOGIN("login", "Login Required"),

    /**
     * The user or system was not able to be authenticated (either there is no process, or the proferred token is
     * unacceptable).
     */
    UNKNOWN("unknown", "Unknown User"),

    /** User session expired; a login may be required. */
    EXPIRED("expired", "Session Expired"),

    /** The user does not have the rights to perform this action. */
    FORBIDDEN("forbidden", "Forbidden"),

    /**
     * Some information was not or might not have been returned due to business rules, consent or privacy rules, or
     * access permission constraints.
     */
    SUPPRESSED("suppressed", "Information Suppressed"),

    /** Processing issues. */
    PROCESSING("processing", "Processing Failure"),

    /** The interaction, operation, resource or profile is not supported. */
    NOT_SUPPORTED("not-supported", "Content not supported"),

    /** An attempt was made to create a duplicate record. */
    DUPLICATE("duplicate", "Duplicate"),

    /** Multiple matching records were found when the operation required only one match. */
    MULTIPLE_MATCHES("multiple-matches", "Multiple Matches"),

    /** The reference provided was not found. */
    NOT_FOUND("not-found", "Not Found"),

    /** The reference pointed to content (usually a resource) that has been deleted. */
    DELETED("deleted", "Deleted"),

    /** Provided content is too long (typically, this is a denial of service protection type of error). */
    TOO_LONG("too-long", "Content Too Long"),

    /**
     * The code or system could not be understood, or it was not valid in the context of a particular ValueSet.code.
     */
    CODE_INVALID("code-invalid", "Invalid Code"),

    /**
     * An extension was found that was not acceptable, could not be resolved, or a modifierExtension was not
     * recognized.
     */
    EXTENSION("extension", "Unacceptable Extension"),

    /**
     * The operation was stopped to protect server resources; e.g. a request for a value set expansion on all of
     * SNOMED CT.
     */
    TOO_COSTLY("too-costly", "Operation Too Costly"),

    /** The content/operation failed to pass some business rule and so could not proceed. */
    BUSINESS_RULE("business-rule", "Business Rule Violation"),

    /** Content could not be accepted because of an edit conflict (i.e. version aware updates). */
    CONFLICT("conflict", "Edit Version Conflict"),

    /** Some search filters might not have applied on all results. */
    LIMITED_FILTER("limited-filter", "Limited Filter Application"),

    /** Transient processing issues. */
    TRANSIENT("transient", "Transient Issue"),

    /** A resource/record locking failure (usually in an underlying database). */
    LOCK_ERROR("lock-error", "Lock Error"),

    /**
     * The persistent store is unavailable; e.g. the database is down for maintenance or similar action, and the
     * interaction or operation cannot be processed.
     */
    NO_STORE("no-store", "No Store Available"),

    /** An unexpected internal error has occurred. */
    EXCEPTION("exception", "Exception"),

    /** An internal timeout has occurred. */
    TIMEOUT("timeout", "Timeout"),

    /**
     * Not all data sources typically accessed could be reached or responded in time, so the returned information
     * might not be complete (applies to search interactions and some operations).
     */
    INCOMPLETE("incomplete", "Incomplete Results"),

    /** The system is not prepared to handle this request due to load management. */
    THROTTLED("throttled", "Throttled"),

    /**
     * A message unrelated to the processing success of the completed operation (examples of the latter include things
     * like reminders of password expiry, system maintenance times, etc.).
     */
    INFORMATIONAL("informational", "Informational Note"),

    /** The operation completed successfully. */
    SUCCESS("success", "Operation Successful");

    private final String code;
    private final String display;

    IssueType(String code, String display) {
        this.code = code;
        this.display = display;
    }

    @Override
    public String system() {
        return "http://hl7.org/fhir/issue-type";
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
    public static IssueType fromCode(String code) {
        for (IssueType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown IssueType code: '" + code + "'");
    }
}
