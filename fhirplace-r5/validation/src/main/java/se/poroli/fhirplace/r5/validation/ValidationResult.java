package se.poroli.fhirplace.r5.validation;

import java.util.List;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;

/**
 * The issues a {@link Validator} found, independent of HTTP or any other transport.
 *
 * @param issues the issues in the order the rules ran, located from the validated type
 */
public record ValidationResult(List<Issue> issues) {

    /** Creates the result, copying the issues. */
    public ValidationResult {
        issues = List.copyOf(issues);
    }

    /**
     * Returns whether there are no errors; warnings and information are allowed.
     *
     * @return {@code true} if no issue is an error or fatal error
     */
    public boolean isValid() {
        return issues.stream().noneMatch(Issue::isError);
    }

    /**
     * Returns the errors and fatal errors.
     *
     * @return the errors
     */
    public List<Issue> errors() {
        return issues.stream().filter(Issue::isError).toList();
    }

    /**
     * Returns the warnings.
     *
     * @return the warnings
     */
    public List<Issue> warnings() {
        return issues.stream().filter(issue -> issue.severity() == IssueSeverity.WARNING).toList();
    }

    /**
     * Returns the issues as an OperationOutcome: one issue each, with severity, code, details and diagnostics copied
     * verbatim, and the expression when present. Without issues, it has one informational issue saying so, as an
     * OperationOutcome needs one.
     *
     * @return the OperationOutcome
     */
    public OperationOutcome toOperationOutcome() {
        OperationOutcome.Builder outcome = OperationOutcome.builder();
        for (Issue issue : issues) {
            OperationOutcome.Issue.Builder entry = OperationOutcome.Issue.builder()
                    .severity(issue.severity())
                    .code(issue.code())
                    .details(issue.details())
                    .diagnostics(issue.diagnostics());
            if (issue.expression() != null) {
                entry.addExpression(FhirString.of(issue.expression()));
            }
            outcome.addIssue(entry.build());
        }
        if (issues.isEmpty()) {
            outcome.addIssue(OperationOutcome.Issue.builder()
                    .severity(IssueSeverity.INFORMATION)
                    .code(IssueType.INFORMATIONAL)
                    .diagnostics(FhirString.of("No issues found"))
                    .build());
        }
        return outcome.build();
    }
}
