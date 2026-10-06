package se.poroli.fhirplace.r5.validation;

import java.util.Objects;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;

/**
 * A problem found by a validation rule. A rule declares the issue it reports; the validator fills in the rule id and
 * resolves the expression against the validated element.
 *
 * <pre>{@code
 * Issue.error(IssueType.REQUIRED, "Family name is required").at("name.family")
 * }</pre>
 *
 * @param ruleId the id of the rule that reported the issue, or {@code null} before the validator sets it
 * @param severity how serious the issue is
 * @param code the kind of issue
 * @param message the message for the client, or {@code null} (or empty) when the issue has none
 * @param expression where the issue is: relative to the validated element when declared, such as {@code family},
 *     and absolute in a {@link ValidationResult}, such as {@code Patient.name[0].family}; {@code null} (or empty)
 *     for the element itself
 */
public record Issue(String ruleId, IssueSeverity severity, IssueType code, String message, String expression) {

    /**
     * Creates the issue. The message and expression are optional; an empty one is stored as {@code null}.
     *
     * @throws NullPointerException if the severity or code is {@code null}
     */
    public Issue {
        Objects.requireNonNull(severity, "severity");
        Objects.requireNonNull(code, "code");
        message = message == null || message.isEmpty() ? null : message;
        expression = expression == null || expression.isEmpty() ? null : expression;
    }

    /**
     * Returns an error, which makes a result invalid.
     *
     * @param code the kind of issue
     * @param message the message for the client
     * @return the issue
     */
    public static Issue error(IssueType code, String message) {
        return new Issue(null, IssueSeverity.ERROR, code, message, null);
    }

    /**
     * Returns a fatal error, which makes a result invalid.
     *
     * @param code the kind of issue
     * @param message the message for the client
     * @return the issue
     */
    public static Issue fatal(IssueType code, String message) {
        return new Issue(null, IssueSeverity.FATAL, code, message, null);
    }

    /**
     * Returns a warning, which is reported but leaves a result valid.
     *
     * @param code the kind of issue
     * @param message the message for the client
     * @return the issue
     */
    public static Issue warning(IssueType code, String message) {
        return new Issue(null, IssueSeverity.WARNING, code, message, null);
    }

    /**
     * Returns information, which is reported but leaves a result valid.
     *
     * @param code the kind of issue
     * @param message the message for the client
     * @return the issue
     */
    public static Issue information(IssueType code, String message) {
        return new Issue(null, IssueSeverity.INFORMATION, code, message, null);
    }

    /**
     * Returns this issue located at an element below the validated one.
     *
     * @param relativePath the path from the validated element, such as {@code family} or {@code identifier[0].system}
     * @return the issue
     */
    public Issue at(String relativePath) {
        return new Issue(ruleId, severity, code, message, Objects.requireNonNull(relativePath, "relativePath"));
    }

    /**
     * Returns whether the issue makes a result invalid.
     *
     * @return {@code true} for errors and fatal errors
     */
    public boolean isError() {
        return severity == IssueSeverity.ERROR || severity == IssueSeverity.FATAL;
    }
}
