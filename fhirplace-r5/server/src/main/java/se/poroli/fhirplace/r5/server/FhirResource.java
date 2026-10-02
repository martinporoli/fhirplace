package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import se.poroli.fhirplace.r5.Resource;

/**
 * Marks a CDI bean as the handler of one FHIR resource type. Its public methods annotated with {@link Read},
 * {@link VRead}, {@link Search}, {@link Create}, {@link Update} or {@link Delete} implement those interactions, and
 * the server serves them and lists them in its {@code CapabilityStatement} at {@code [base]/metadata}.
 *
 * <p>Any interaction method may also declare a {@link FhirRequest} parameter to read the request's headers or base
 * URL.
 *
 * <p>The bean also needs a scope, normally {@code @ApplicationScoped}. Each resource type may have one handler, and
 * each interaction one method; the server checks the handlers at startup and fails deployment if one is invalid.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FhirResource {

    /**
     * The resource type this bean handles.
     *
     * @return the resource class, such as {@code Patient.class}
     */
    Class<? extends Resource> value();
}
