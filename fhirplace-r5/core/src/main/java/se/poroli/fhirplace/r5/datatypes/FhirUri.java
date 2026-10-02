package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code uri}: a Uniform Resource Identifier.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#uri">FHIR R5 uri</a>
 */
public record FhirUri(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern URI = Pattern.compile("\\S+");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid uri
     */
    public FhirUri {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("uri", value, URI);
    }

    /**
     * Creates a uri with the given value and no id or extensions.
     *
     * @param value the value
     * @return the uri
     * @throws IllegalArgumentException if the value is {@code null} or not a valid uri
     */
    public static FhirUri of(String value) {
        return new FhirUri(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
