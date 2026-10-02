package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the handler method for the FHIR {@code update} interaction, {@code PUT [base]/[type]/[id]}.
 *
 * <p>The method takes an {@link Id} parameter and the new resource content as an unannotated parameter, and returns
 * the stored resource, a {@link Saved} to tell whether the resource was created (201) rather than updated (200), or
 * a {@link FhirResult}.
 * The server rejects content whose id differs from the URL with 400, and checks {@code If-Match} against the current
 * version from the {@link Read} method (412 on mismatch).
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html#update">FHIR R5 update</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Update {
}
