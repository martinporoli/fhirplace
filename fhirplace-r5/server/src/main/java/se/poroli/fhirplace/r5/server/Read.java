package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the handler method for the FHIR {@code read} interaction, {@code GET [base]/[type]/[id]}.
 *
 * <p>The method takes an {@link Id} parameter and returns the resource, or an empty {@code Optional} or {@code null}
 * if there is none, which the server answers with 404 and an {@code OperationOutcome}. The server derives
 * {@code ETag} and {@code Last-Modified} from the resource's {@code meta} and answers conditional reads
 * ({@code If-None-Match}, {@code If-Modified-Since}) with 304. It also uses this method to check {@code If-Match} on
 * update and delete.
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html#read">FHIR R5 read</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Read {
}
