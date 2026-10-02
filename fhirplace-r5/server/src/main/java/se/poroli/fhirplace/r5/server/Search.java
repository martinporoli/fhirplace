package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the handler method for the FHIR {@code search} interaction on a type, {@code GET [base]/[type]?params} and
 * {@code POST [base]/[type]/_search}.
 *
 * <p>The method takes {@link SearchParam} parameters and returns the matches as a {@code List}, {@code Collection},
 * {@code Iterable} or {@code Stream}; the server wraps them in a {@code searchset} Bundle. Search parameters that the
 * method does not declare are rejected with 400, unless the client sends {@code Prefer: handling=lenient}.
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html#search">FHIR R5 search</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Search {
}
