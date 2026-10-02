package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the handler method for the FHIR {@code vread} interaction, {@code GET [base]/[type]/[id]/_history/[vid]}.
 *
 * <p>The method takes an {@link Id} and a {@link VersionId} parameter and returns the resource version, or an empty
 * {@code Optional} or {@code null} if there is none (404), or a {@link FhirResult}.
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html#vread">FHIR R5 vread</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface VRead {
}
