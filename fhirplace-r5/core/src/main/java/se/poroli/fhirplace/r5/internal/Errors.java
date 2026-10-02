package se.poroli.fhirplace.r5.internal;

import se.poroli.fhirplace.r5.FhirFormatException;
import se.poroli.fhirplace.r5.FhirFormatException.Problem;

/** Creates {@link FhirFormatException}s for the JSON and XML readers. Internal; not exported. */
public final class Errors {

    private Errors() {
    }

    /**
     * Returns a syntax error.
     *
     * @param detail the parser's message
     * @param cause the parser's exception
     * @return the exception
     */
    public static FhirFormatException syntax(String detail, Throwable cause) {
        return new FhirFormatException(Problem.SYNTAX, null, detail, cause);
    }

    /**
     * Returns a structure error.
     *
     * @param path the location, empty or {@code null} for the document
     * @param detail what is wrong
     * @return the exception
     */
    public static FhirFormatException structure(String path, String detail) {
        return new FhirFormatException(Problem.STRUCTURE, expression(path), detail, null);
    }

    /**
     * Classifies an exception from a model record's constructor or a primitive's parser: a missing required element
     * or empty required list, a choice value of a disallowed type, or an invalid value.
     *
     * @param path the location of the object being built
     * @param e the exception
     * @return the exception to throw
     */
    public static FhirFormatException fromModel(String path, RuntimeException e) {
        if (e instanceof FhirFormatException format) {
            return format;
        }
        String message = e.getMessage() == null ? e.getClass().getSimpleName() : e.getMessage();
        Problem problem;
        if (e instanceof NullPointerException || message.contains("requires at least one value")) {
            problem = Problem.REQUIRED;
        } else if (message.contains("must be one of")) {
            problem = Problem.STRUCTURE;
        } else {
            problem = Problem.VALUE;
        }
        return new FhirFormatException(problem, expression(path), message, e);
    }

    private static String expression(String path) {
        return path == null || path.isEmpty() ? null : path;
    }
}
