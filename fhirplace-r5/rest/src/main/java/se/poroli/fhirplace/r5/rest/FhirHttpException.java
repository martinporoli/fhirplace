package se.poroli.fhirplace.r5.rest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;

/**
 * A failed FHIR HTTP interaction: its error status, optional OperationOutcome and response headers. Server handlers
 * throw it to choose an error response; clients throw it for an error response they received. Its message is
 * {@code HTTP <status>}, followed by the first issue's diagnostics, details text or code when available.
 */
public final class FhirHttpException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /** The HTTP error status, whether received from a server or chosen by a handler. */
    private final int status;
    private final transient OperationOutcome outcome;
    private final transient Map<String, List<String>> headers;

    /**
     * Creates an HTTP error without extra headers.
     *
     * @param status the HTTP error status, 400 to 599
     * @param outcome the outcome, or {@code null} when the response has none
     * @throws IllegalArgumentException if the status is not an error status
     */
    public FhirHttpException(int status, OperationOutcome outcome) {
        this(status, outcome, Map.of());
    }

    /**
     * Creates an HTTP error, copying the headers and their value lists.
     *
     * @param status the HTTP error status, 400 to 599
     * @param outcome the outcome, or {@code null} when the response has none
     * @param headers response headers, such as {@code Retry-After} or {@code WWW-Authenticate}
     * @throws IllegalArgumentException if the status is not an error status
     */
    public FhirHttpException(int status, OperationOutcome outcome, Map<String, List<String>> headers) {
        super(message(status, outcome));
        if (status < 400 || status > 599) {
            throw new IllegalArgumentException("Not an error status: " + status);
        }
        this.status = status;
        this.outcome = outcome;
        Map<String, List<String>> copy = new LinkedHashMap<>();
        Objects.requireNonNull(headers, "headers").forEach((name, values) ->
                copy.put(Objects.requireNonNull(name, "header name"), List.copyOf(values)));
        this.headers = Collections.unmodifiableMap(copy);
    }

    /**
     * Creates an HTTP error with one error issue.
     *
     * @param status the HTTP error status, 400 to 599
     * @param type the issue type
     * @param diagnostics diagnostic text, or {@code null} or empty for none
     */
    public FhirHttpException(int status, IssueType type, String diagnostics) {
        this(status, OperationOutcome.builder()
                .addIssue(OperationOutcome.Issue.builder()
                        .severity(IssueSeverity.ERROR)
                        .code(type)
                        .diagnostics(diagnostics == null || diagnostics.isEmpty() ? null : FhirString.of(diagnostics))
                        .build())
                .build());
    }

    /**
     * Returns 404 Not Found for a resource that does not exist.
     *
     * @param resourceType the resource type, such as {@code Patient}
     * @param id the resource id
     * @return the HTTP error
     */
    public static FhirHttpException notFound(String resourceType, String id) {
        return new FhirHttpException(404, IssueType.NOT_FOUND, resourceType + "/" + id + " is not known");
    }

    /**
     * Returns 410 Gone for a deleted resource.
     *
     * @param resourceType the resource type, such as {@code Patient}
     * @param id the resource id
     * @return the HTTP error
     */
    public static FhirHttpException gone(String resourceType, String id) {
        return new FhirHttpException(410, IssueType.DELETED, resourceType + "/" + id + " has been deleted");
    }

    /**
     * Returns 400 Bad Request for an invalid request.
     *
     * @param diagnostics what is wrong with the request
     * @return the HTTP error
     */
    public static FhirHttpException invalid(String diagnostics) {
        return new FhirHttpException(400, IssueType.INVALID, diagnostics);
    }

    /**
     * Returns 409 Conflict, such as a delete that would break referential integrity.
     *
     * @param diagnostics the conflict
     * @return the HTTP error
     */
    public static FhirHttpException conflict(String diagnostics) {
        return new FhirHttpException(409, IssueType.CONFLICT, diagnostics);
    }

    /**
     * Returns 412 Precondition Failed, such as an {@code If-Match} version mismatch.
     *
     * @param diagnostics the failed precondition
     * @return the HTTP error
     */
    public static FhirHttpException preconditionFailed(String diagnostics) {
        return new FhirHttpException(412, IssueType.CONFLICT, diagnostics);
    }

    /**
     * Returns 422 Unprocessable Entity for content that violates a business rule or profile.
     *
     * @param diagnostics the rule that was broken
     * @return the HTTP error
     */
    public static FhirHttpException unprocessable(String diagnostics) {
        return new FhirHttpException(422, IssueType.BUSINESS_RULE, diagnostics);
    }

    /**
     * Returns 422 Unprocessable Entity with the supplied outcome, preserving all issues.
     *
     * @param outcome the outcome describing the validation or business-rule failure
     * @return the HTTP error
     */
    public static FhirHttpException unprocessable(OperationOutcome outcome) {
        return new FhirHttpException(422, Objects.requireNonNull(outcome, "outcome"));
    }

    /**
     * Returns the HTTP error status.
     *
     * @return the status, such as 404 or 422
     */
    public int status() {
        return status;
    }

    /**
     * Returns the error outcome.
     *
     * @return the outcome, or {@code null} if the response has none
     */
    public OperationOutcome outcome() {
        return outcome;
    }

    /**
     * Returns the immutable response headers.
     *
     * @return the headers by name, with immutable value lists
     */
    public Map<String, List<String>> headers() {
        return headers;
    }

    /**
     * Returns the first value of a response header, matched case-insensitively.
     *
     * @param name the header name
     * @return the value, or {@code null} when absent
     */
    public String header(String name) {
        Objects.requireNonNull(name, "name");
        return headers.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(name) && !entry.getValue().isEmpty())
                .map(entry -> entry.getValue().getFirst())
                .findFirst()
                .orElse(null);
    }

    private static String message(int status, OperationOutcome outcome) {
        String detail = null;
        if (outcome != null && !outcome.issue().isEmpty()) {
            OperationOutcome.Issue issue = outcome.issue().getFirst();
            if (issue.diagnostics() != null && issue.diagnostics().value() != null) {
                detail = issue.diagnostics().value();
            } else if (issue.details() != null && issue.details().text() != null
                    && issue.details().text().value() != null) {
                detail = issue.details().text().value();
            } else {
                detail = issue.code().valueAsString();
            }
        }
        return "HTTP " + status + (detail == null ? "" : ": " + detail);
    }
}
