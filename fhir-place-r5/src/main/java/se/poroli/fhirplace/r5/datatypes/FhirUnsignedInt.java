package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code unsignedInt}: a non-negative 32-bit integer ({@code >= 0}).
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#unsignedInt">FHIR R5 unsignedInt</a>
 */
public record FhirUnsignedInt(String id, List<Extension> extension, Integer value) implements PrimitiveType<Integer> {

    private static final Pattern LEXICAL = Pattern.compile("0|[1-9][0-9]*");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is less than 0
     */
    public FhirUnsignedInt {
        extension = Primitives.extensions(extension, value);
        if (value != null && value < 0) {
            throw Primitives.invalid("unsignedInt", value);
        }
    }

    /**
     * Creates a unsignedInt with the given value and no id or extensions.
     *
     * @param value the value
     * @return the unsignedInt
     * @throws IllegalArgumentException if the value is {@code null} or less than 0
     */
    public static FhirUnsignedInt of(Integer value) {
        return new FhirUnsignedInt(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a unsignedInt, such as {@code "5"}.
     *
     * @param value the lexical form
     * @return the unsignedInt
     * @throws IllegalArgumentException if the value is not a valid unsignedInt
     */
    public static FhirUnsignedInt parse(String value) {
        Primitives.requireMatch("unsignedInt", value, LEXICAL);
        try {
            return of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw Primitives.invalid("unsignedInt", value);
        }
    }

    @Override
    public String valueAsString() {
        return value == null ? null : value.toString();
    }
}
