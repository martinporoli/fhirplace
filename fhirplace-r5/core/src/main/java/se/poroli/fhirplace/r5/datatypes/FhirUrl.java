package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code url}: a Uniform Resource Locator, i.e. a URI that is a literal reference.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#url">FHIR R5 url</a>
 */
public record FhirUrl(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern URL = Pattern.compile("\\S+");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid url
     */
    public FhirUrl {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("url", value, URL);
    }

    /**
     * Creates a url with the given value and no id or extensions.
     *
     * @param value the value
     * @return the url
     * @throws IllegalArgumentException if the value is {@code null} or not a valid url
     */
    public static FhirUrl of(String value) {
        return new FhirUrl(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
