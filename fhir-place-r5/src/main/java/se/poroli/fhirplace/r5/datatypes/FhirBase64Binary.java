package se.poroli.fhirplace.r5.datatypes;

import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code base64Binary}: a stream of bytes, base64 encoded.
 *
 * <p>The value is kept in its encoded form; use {@link #decode()} to obtain the bytes.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the base64 encoded bytes, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#base64Binary">FHIR R5 base64Binary</a>
 */
public record FhirBase64Binary(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern BASE64 =
            Pattern.compile("(?:[A-Za-z0-9+/]{4})+(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?"
                    + "|[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not valid base64
     */
    public FhirBase64Binary {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("base64Binary", value, BASE64);
    }

    /**
     * Creates a base64Binary from its encoded form, with no id or extensions.
     *
     * @param value the base64 encoded bytes
     * @return the base64Binary
     * @throws IllegalArgumentException if the value is {@code null} or not valid base64
     */
    public static FhirBase64Binary of(String value) {
        return new FhirBase64Binary(null, List.of(), value);
    }

    /**
     * Creates a base64Binary by encoding the given bytes, with no id or extensions.
     *
     * @param bytes the bytes to encode; must not be empty
     * @return the base64Binary
     * @throws IllegalArgumentException if {@code bytes} is empty
     */
    public static FhirBase64Binary of(byte[] bytes) {
        return of(Base64.getEncoder().encodeToString(bytes));
    }

    /**
     * Decodes the value.
     *
     * @return the decoded bytes, or {@code null} if there is no value
     */
    public byte[] decode() {
        return value == null ? null : Base64.getDecoder().decode(value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
