package se.poroli.fhirplace.r5;

import java.util.Objects;

/**
 * FHIR JSON or XML that cannot be read as a valid resource: malformed syntax, an unknown or misplaced element, or
 * content that breaks the FHIR specification's rules, such as a missing required element or an invalid date. The
 * {@link #problem() problem} tells which, and the {@link #expression() expression} where.
 */
public final class FhirFormatException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    /** What is wrong with the content. */
    public enum Problem {
        /** Not well-formed JSON or XML. */
        SYNTAX,
        /** Well-formed, but not the structure of the resource: an unknown element, a wrong type, and the like. */
        STRUCTURE,
        /** A required element is missing, or a list that must not be empty is. */
        REQUIRED,
        /** A value is invalid, such as a malformed date or a code outside a required value set. */
        VALUE
    }

    private final Problem problem;
    private final String expression;
    private final String detail;

    /**
     * Creates the exception.
     *
     * @param problem what is wrong
     * @param expression where, as a FHIRPath-style location such as {@code Patient.name[0].family}, or {@code null}
     * @param detail a description of the problem, without the location
     * @param cause the underlying exception, or {@code null}
     */
    public FhirFormatException(Problem problem, String expression, String detail, Throwable cause) {
        super(expression == null ? detail : expression + ": " + detail, cause);
        this.problem = Objects.requireNonNull(problem, "problem");
        this.expression = expression;
        this.detail = Objects.requireNonNull(detail, "detail");
    }

    /**
     * Returns what is wrong with the content.
     *
     * @return the problem
     */
    public Problem problem() {
        return problem;
    }

    /**
     * Returns where the problem is.
     *
     * @return a FHIRPath-style location such as {@code Patient.contact[1].name}, or {@code null} for syntax errors
     */
    public String expression() {
        return expression;
    }

    /**
     * Returns the description of the problem, without the location.
     *
     * @return the detail
     */
    public String detail() {
        return detail;
    }
}
