package se.poroli.fhirplace.r5.server;

import java.util.List;

/**
 * One occurrence of a FHIR {@code string} search parameter, such as {@code family=smith,jones} or
 * {@code family:exact=Smith}.
 *
 * @param modifier the modifier after the colon, such as {@code exact} or {@code contains}, or {@code null}
 * @param anyOf the comma-separated alternatives, unescaped; at least one
 * @see <a href="https://hl7.org/fhir/R5/search.html#string">FHIR R5 string search</a>
 */
public record StringParam(String modifier, List<String> anyOf) {

    /**
     * Creates the parameter, copying the values.
     *
     * @throws IllegalArgumentException if there are no values
     */
    public StringParam {
        anyOf = SearchValues.nonEmpty(anyOf);
    }
}
