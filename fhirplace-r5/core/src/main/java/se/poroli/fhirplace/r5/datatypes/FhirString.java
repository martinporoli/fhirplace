package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code string}: a sequence of Unicode characters, at most 1,048,576 characters long.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#string">FHIR R5 string</a>
 */
public record FhirString(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern STRING = Pattern.compile("[\\s\\S]{1,1048576}");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid string
     */
    public FhirString {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("string", value, STRING);
    }

    /**
     * Creates a string with the given value and no id or extensions.
     *
     * @param value the value
     * @return the string
     * @throws IllegalArgumentException if the value is {@code null} or not a valid string
     */
    public static FhirString of(String value) {
        return new FhirString(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
