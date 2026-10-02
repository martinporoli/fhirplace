package se.poroli.fhirplace.r5.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binds a FHIR search parameter to a parameter of a {@link Search} method.
 *
 * <p>The parameter type is {@link StringParam}, {@link TokenParam}, {@link DateParam} or {@link ReferenceParam} for a
 * parameter that may appear at most once, or a {@code List} of one of them for a parameter that may be repeated, where
 * all occurrences must match (AND). Within one occurrence, comma-separated values are alternatives (OR). An absent
 * parameter is {@code null}, or an empty list. The parameter's type also determines its type in the
 * {@code CapabilityStatement}.
 *
 * @see <a href="https://hl7.org/fhir/R5/search.html">FHIR R5 search</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface SearchParam {

    /**
     * The search parameter name as used in the URL, without modifier.
     *
     * @return the name, such as {@code family} or {@code general-practitioner}
     */
    String value();
}
