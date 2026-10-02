package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code markdown}: a string that may contain GitHub Flavored Markdown.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#markdown">FHIR R5 markdown</a>
 */
public record FhirMarkdown(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern MARKDOWN = Pattern.compile("[\\s\\S]+");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid markdown
     */
    public FhirMarkdown {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("markdown", value, MARKDOWN);
    }

    /**
     * Creates a markdown with the given value and no id or extensions.
     *
     * @param value the value
     * @return the markdown
     * @throws IllegalArgumentException if the value is {@code null} or not a valid markdown
     */
    public static FhirMarkdown of(String value) {
        return new FhirMarkdown(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
