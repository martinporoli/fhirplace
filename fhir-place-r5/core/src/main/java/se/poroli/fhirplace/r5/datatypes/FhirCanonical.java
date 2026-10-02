package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code canonical}: a URI that refers to a resource by its canonical URL, optionally with {@code |version}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#canonical">FHIR R5 canonical</a>
 */
public record FhirCanonical(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern CANONICAL = Pattern.compile("\\S+");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid canonical
     */
    public FhirCanonical {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("canonical", value, CANONICAL);
    }

    /**
     * Creates a canonical with the given value and no id or extensions.
     *
     * @param value the value
     * @return the canonical
     * @throws IllegalArgumentException if the value is {@code null} or not a valid canonical
     */
    public static FhirCanonical of(String value) {
        return new FhirCanonical(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
