package se.poroli.fhirplace.r5.validation;

import java.util.Objects;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.FhirString;
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
 * @param details coded or textual details for the client, or {@code null} when absent
 * @param diagnostics additional diagnostic information, or {@code null} when absent
 * @param expression where the issue is: relative to the validated element when declared, such as {@code family},
 *     and absolute in a {@link ValidationResult}, such as {@code Patient.name[0].family}; {@code null} (or empty)
 *     for the validated element itself; an expression remains absent when used directly in a {@link ValidationResult}
 */
public record Issue(String ruleId, IssueSeverity severity, IssueType code, CodeableConcept details,
        FhirString diagnostics, String expression) {

    /**
     * Creates the issue. Details, diagnostics and expression are optional; an empty expression is stored as
     * {@code null}.
     *
     * @throws NullPointerException if the severity or code is {@code null}
     */
    public Issue {
        Objects.requireNonNull(severity, "severity");
        Objects.requireNonNull(code, "code");
        expression = expression == null || expression.isEmpty() ? null : expression;
    }

    /**
     * Returns an error, which makes a result invalid.
     *
     * @param code the kind of issue
     * @param message the text of the details, or {@code null} or empty for no details
     * @return the issue
     */
    public static Issue error(IssueType code, String message) {
        return error(code, textDetails(message));
    }

    /**
     * Returns an error with coded or textual details, which makes a result invalid.
     *
     * @param code the kind of issue
     * @param details the details, or {@code null} when absent
     * @return the issue
     */
    public static Issue error(IssueType code, CodeableConcept details) {
        return new Issue(null, IssueSeverity.ERROR, code, details, null, null);
    }

    /**
     * Returns a fatal error, which makes a result invalid.
     *
     * @param code the kind of issue
     * @param message the text of the details, or {@code null} or empty for no details
     * @return the issue
     */
    public static Issue fatal(IssueType code, String message) {
        return fatal(code, textDetails(message));
    }

    /**
     * Returns a fatal error with coded or textual details, which makes a result invalid.
     *
     * @param code the kind of issue
     * @param details the details, or {@code null} when absent
     * @return the issue
     */
    public static Issue fatal(IssueType code, CodeableConcept details) {
        return new Issue(null, IssueSeverity.FATAL, code, details, null, null);
    }

    /**
     * Returns a warning, which is reported but leaves a result valid.
     *
     * @param code the kind of issue
     * @param message the text of the details, or {@code null} or empty for no details
     * @return the issue
     */
    public static Issue warning(IssueType code, String message) {
        return warning(code, textDetails(message));
    }

    /**
     * Returns a warning with coded or textual details, which is reported but leaves a result valid.
     *
     * @param code the kind of issue
     * @param details the details, or {@code null} when absent
     * @return the issue
     */
    public static Issue warning(IssueType code, CodeableConcept details) {
        return new Issue(null, IssueSeverity.WARNING, code, details, null, null);
    }

    /**
     * Returns information, which is reported but leaves a result valid.
     *
     * @param code the kind of issue
     * @param message the text of the details, or {@code null} or empty for no details
     * @return the issue
     */
    public static Issue information(IssueType code, String message) {
        return information(code, textDetails(message));
    }

    /**
     * Returns information with coded or textual details, which is reported but leaves a result valid.
     *
     * @param code the kind of issue
     * @param details the details, or {@code null} when absent
     * @return the issue
     */
    public static Issue information(IssueType code, CodeableConcept details) {
        return new Issue(null, IssueSeverity.INFORMATION, code, details, null, null);
    }

    private static CodeableConcept textDetails(String message) {
        return message == null || message.isEmpty() ? null : CodeableConcept.builder().text(message).build();
    }

    /**
     * Returns this issue located at an element below the validated one.
     *
     * @param relativePath the path from the validated element, such as {@code family} or {@code identifier[0].system};
     *     empty to clear the expression
     * @return the issue
     */
    public Issue at(String relativePath) {
        return new Issue(ruleId, severity, code, details, diagnostics,
                Objects.requireNonNull(relativePath, "relativePath"));
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
