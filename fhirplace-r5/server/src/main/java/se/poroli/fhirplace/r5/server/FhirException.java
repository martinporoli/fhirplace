package se.poroli.fhirplace.r5.server;

import java.util.Objects;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;

/**
 * A failed FHIR interaction: the server answers with the HTTP status and the {@code OperationOutcome} as body.
 * Handlers throw it to report errors, typically through the static factories.
 */
public final class FhirException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int status;
    private final transient OperationOutcome outcome;

    /**
     * Creates the exception.
     *
     * @param status the HTTP status, 400 to 599
     * @param outcome the outcome to return as body
     */
    public FhirException(int status, OperationOutcome outcome) {
        super(message(Objects.requireNonNull(outcome, "outcome")));
        if (status < 400 || status > 599) {
            throw new IllegalArgumentException("Not an error status: " + status);
        }
        this.status = status;
        this.outcome = outcome;
    }

    /**
     * Creates the exception with an outcome of one error issue.
     *
     * @param status the HTTP status, 400 to 599
     * @param type the issue type
     * @param diagnostics a description of the error for the client
     */
    public FhirException(int status, IssueType type, String diagnostics) {
        this(status, OperationOutcome.builder()
                .addIssue(OperationOutcome.Issue.builder()
                        .severity(IssueSeverity.ERROR)
                        .code(type)
                        .diagnostics(FhirString.of(diagnostics))
                        .build())
                .build());
    }

    /**
     * Returns 404 Not Found for a resource that does not exist.
     *
     * @param resourceType the resource type, such as {@code Patient}
     * @param id the requested id
     * @return the exception
     */
    public static FhirException notFound(String resourceType, String id) {
        return new FhirException(404, IssueType.NOT_FOUND, resourceType + "/" + id + " is not known");
    }

    /**
     * Returns 410 Gone for a resource that has been deleted.
     *
     * @param resourceType the resource type, such as {@code Patient}
     * @param id the requested id
     * @return the exception
     */
    public static FhirException gone(String resourceType, String id) {
        return new FhirException(410, IssueType.DELETED, resourceType + "/" + id + " has been deleted");
    }

    /**
     * Returns 400 Bad Request for a request the server cannot process.
     *
     * @param diagnostics what is wrong with the request
     * @return the exception
     */
    public static FhirException invalid(String diagnostics) {
        return new FhirException(400, IssueType.INVALID, diagnostics);
    }

    /**
     * Returns 409 Conflict, for example for a delete that would break referential integrity.
     *
     * @param diagnostics the conflict
     * @return the exception
     */
    public static FhirException conflict(String diagnostics) {
        return new FhirException(409, IssueType.CONFLICT, diagnostics);
    }

    /**
     * Returns 412 Precondition Failed, for example for an {@code If-Match} version mismatch.
     *
     * @param diagnostics the failed precondition
     * @return the exception
     */
    public static FhirException preconditionFailed(String diagnostics) {
        return new FhirException(412, IssueType.CONFLICT, diagnostics);
    }

    /**
     * Returns 422 Unprocessable Entity for content that is valid FHIR but breaks the server's business rules or
     * profiles.
     *
     * @param diagnostics the rule that was broken
     * @return the exception
     */
    public static FhirException unprocessable(String diagnostics) {
        return new FhirException(422, IssueType.BUSINESS_RULE, diagnostics);
    }

    /**
     * Returns the HTTP status.
     *
     * @return the status
     */
    public int status() {
        return status;
    }

    /**
     * Returns the outcome sent as response body.
     *
     * @return the outcome
     */
    public OperationOutcome outcome() {
        return outcome;
    }

    private static String message(OperationOutcome outcome) {
        return outcome.issue().stream()
                .map(issue -> issue.diagnostics() == null ? issue.code().valueAsString() : issue.diagnostics().value())
                .findFirst()
                .orElse("FHIR error");
    }
}
