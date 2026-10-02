package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code integer64}: a signed 64-bit integer.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#integer64">FHIR R5 integer64</a>
 */
public record FhirInteger64(String id, List<Extension> extension, Long value) implements PrimitiveType<Long> {

    private static final Pattern LEXICAL = Pattern.compile("0|[-+]?[1-9][0-9]*");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent
     */
    public FhirInteger64 {
        extension = Primitives.extensions(extension, value);
    }

    /**
     * Creates a integer64 with the given value and no id or extensions.
     *
     * @param value the value
     * @return the integer64
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static FhirInteger64 of(Long value) {
        return new FhirInteger64(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a integer64, such as {@code "-5"}.
     *
     * @param value the lexical form
     * @return the integer64
     * @throws IllegalArgumentException if the value is not a valid integer64
     */
    public static FhirInteger64 parse(String value) {
        Primitives.requireMatch("integer64", value, LEXICAL);
        try {
            return of(Long.parseLong(value));
        } catch (NumberFormatException e) {
            throw Primitives.invalid("integer64", value);
        }
    }

    @Override
    public String valueAsString() {
        return value == null ? null : value.toString();
    }
}
