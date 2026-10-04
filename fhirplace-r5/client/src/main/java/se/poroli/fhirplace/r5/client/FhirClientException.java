package se.poroli.fhirplace.r5.client;

import java.util.List;
import java.util.Map;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;

/** A FHIR server answered with an error status; carries the status, headers and OperationOutcome it sent. */
public final class FhirClientException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /** The HTTP status the server answered with. */
    private final int status;
    private final transient OperationOutcome outcome;
    private final transient Map<String, List<String>> headers;

    /**
     * Creates the exception.
     *
     * @param status the HTTP status
     * @param outcome the OperationOutcome from the response body, or {@code null} if there was none
     * @param headers the response headers
     */
    public FhirClientException(int status, OperationOutcome outcome, Map<String, List<String>> headers) {
        super(message(status, outcome));
        this.status = status;
        this.outcome = outcome;
        this.headers = Map.copyOf(headers);
    }

    /**
     * Returns the HTTP status.
     *
     * @return the status, such as 404
     */
    public int status() {
        return status;
    }

    /**
     * Returns the OperationOutcome the server sent.
     *
     * @return the outcome, or {@code null} if the response had none
     */
    public OperationOutcome outcome() {
        return outcome;
    }

    /**
     * Returns the response headers.
     *
     * @return the headers by name
     */
    public Map<String, List<String>> headers() {
        return headers;
    }

    /**
     * Returns the first value of a response header.
     *
     * @param name the header name, matched case-insensitively
     * @return the value, or {@code null} if the header is absent
     */
    public String header(String name) {
        return headers.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(name) && !entry.getValue().isEmpty())
                .map(entry -> entry.getValue().getFirst())
                .findFirst()
                .orElse(null);
    }

    private static String message(int status, OperationOutcome outcome) {
        String detail = outcome == null ? null : outcome.issue().stream()
                .map(issue -> issue.diagnostics() != null ? issue.diagnostics().value()
                        : issue.details() != null && issue.details().text() != null
                                ? issue.details().text().value() : null)
                .filter(text -> text != null)
                .findFirst()
                .orElse(null);
        return "HTTP " + status + (detail == null ? "" : ": " + detail);
    }
}
