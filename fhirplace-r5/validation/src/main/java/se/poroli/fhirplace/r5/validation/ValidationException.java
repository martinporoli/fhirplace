package se.poroli.fhirplace.r5.validation;

import java.util.Objects;

/**
 * A value failed validation. A fhirplace server answers with the {@link #status()} and the result's OperationOutcome.
 */
public final class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient ValidationResult result;
    /** The HTTP status to answer with. */
    private final int status;

    /**
     * Creates the exception.
     *
     * @param result the result with the errors
     * @param status the HTTP status for the response, 400 to 599
     */
    public ValidationException(ValidationResult result, int status) {
        super(message(Objects.requireNonNull(result, "result")));
        if (status < 400 || status > 599) {
            throw new IllegalArgumentException("Not an error status: " + status);
        }
        this.result = result;
        this.status = status;
    }

    /**
     * Returns the validation result.
     *
     * @return the result
     */
    public ValidationResult result() {
        return result;
    }

    /**
     * Returns the HTTP status for the response.
     *
     * @return the status, such as 422
     */
    public int status() {
        return status;
    }

    private static String message(ValidationResult result) {
        return result.errors().stream()
                .map(issue -> (issue.expression() == null ? "" : issue.expression() + ": ") + issue.message())
                .findFirst()
                .orElse("Validation failed");
    }
}
