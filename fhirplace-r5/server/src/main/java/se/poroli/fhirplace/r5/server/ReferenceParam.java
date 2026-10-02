package se.poroli.fhirplace.r5.server;

import java.util.List;

/**
 * One occurrence of a FHIR {@code reference} search parameter, such as {@code subject=Patient/123} or
 * {@code subject:Patient=123}.
 *
 * @param modifier the modifier after the colon, often a resource type, or {@code null}
 * @param anyOf the comma-separated alternatives as given: an id, {@code Type/id} or an absolute URL; at least one
 * @see <a href="https://hl7.org/fhir/R5/search.html#reference">FHIR R5 reference search</a>
 */
public record ReferenceParam(String modifier, List<String> anyOf) {

    /**
     * Creates the parameter, copying the values.
     *
     * @throws IllegalArgumentException if there are no values
     */
    public ReferenceParam {
        anyOf = SearchValues.nonEmpty(anyOf);
    }
}
