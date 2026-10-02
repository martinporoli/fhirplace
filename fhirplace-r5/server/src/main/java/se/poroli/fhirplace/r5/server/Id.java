package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binds the logical id from the request URL to a {@code String} parameter of a {@link Read}, {@link VRead},
 * {@link Update} or {@link Delete} method. The server rejects ids that are not valid FHIR ids with 400.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Id {
}
