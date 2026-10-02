package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the handler method for the FHIR {@code create} interaction, {@code POST [base]/[type]}.
 *
 * <p>The method takes the resource to create as an unannotated parameter and returns the stored resource, which must
 * have an id. The server answers 201 with {@code Location}, {@code ETag} and {@code Last-Modified}, and a body
 * according to the client's {@code Prefer: return=} header.
 *
 * @see <a href="https://hl7.org/fhir/R5/http.html#create">FHIR R5 create</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Create {
}
