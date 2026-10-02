package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code integer}: a signed 32-bit integer.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#integer">FHIR R5 integer</a>
 */
public record FhirInteger(String id, List<Extension> extension, Integer value) implements PrimitiveType<Integer> {

    private static final Pattern LEXICAL = Pattern.compile("0|[-+]?[1-9][0-9]*");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent
     */
    public FhirInteger {
        extension = Primitives.extensions(extension, value);
    }

    /**
     * Creates a integer with the given value and no id or extensions.
     *
     * @param value the value
     * @return the integer
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static FhirInteger of(Integer value) {
        return new FhirInteger(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a integer, such as {@code "-5"}.
     *
     * @param value the lexical form
     * @return the integer
     * @throws IllegalArgumentException if the value is not a valid integer
     */
    public static FhirInteger parse(String value) {
        Primitives.requireMatch("integer", value, LEXICAL);
        try {
            return of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw Primitives.invalid("integer", value);
        }
    }

    @Override
    public String valueAsString() {
        return value == null ? null : value.toString();
    }
}
