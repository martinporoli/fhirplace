package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the handler method for the FHIR {@code delete} interaction, {@code DELETE [base]/[type]/[id]}.
 *
 * <p>The method takes an {@link Id} parameter and returns nothing; the server answers 204. {@code If-Match} is checked
 * against the current version from the {@link Read} method.
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html#delete">FHIR R5 delete</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Delete {
}
