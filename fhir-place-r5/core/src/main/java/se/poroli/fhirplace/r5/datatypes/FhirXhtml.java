package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.Objects;

/**
 * FHIR {@code xhtml}: an XHTML fragment, used for the {@code div} of a {@link Narrative}.
 *
 * <p>Unlike other primitives, xhtml cannot have extensions, so {@link #extension()} is always empty.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param value the XHTML, normally a single {@code <div>} element
 * @see <a href="https://hl7.org/fhir/R5/narrative.html#xhtml">FHIR R5 xhtml</a>
 */
public record FhirXhtml(String id, String value) implements Element {

    /**
     * Creates the xhtml.
     *
     * @throws NullPointerException if the value is {@code null}
     * @throws IllegalArgumentException if the value is empty
     */
    public FhirXhtml {
        Objects.requireNonNull(value, "value");
        if (value.isEmpty()) {
            throw new IllegalArgumentException("xhtml must not be empty");
        }
    }

    /**
     * Creates an xhtml with the given value and no id.
     *
     * @param value the XHTML
     * @return the xhtml
     * @throws NullPointerException if the value is {@code null}
     * @throws IllegalArgumentException if the value is empty
     */
    public static FhirXhtml of(String value) {
        return new FhirXhtml(null, value);
    }

    /**
     * Returns no extensions, since xhtml cannot be extended.
     *
     * @return an empty list
     */
    @Override
    public List<Extension> extension() {
        return List.of();
    }
}
