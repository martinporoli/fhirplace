package se.poroli.fhirplace.r5.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Collects the issues of one {@link Validator.Builder#check check} for one element. */
public final class Report {

    private final List<Issue> issues = new ArrayList<>();

    Report() {
    }

    /**
     * Reports an issue.
     *
     * @param issue the issue; its expression is relative to the checked element
     */
    public void add(Issue issue) {
        issues.add(Objects.requireNonNull(issue, "issue"));
    }

    List<Issue> issues() {
        return issues;
    }
}
