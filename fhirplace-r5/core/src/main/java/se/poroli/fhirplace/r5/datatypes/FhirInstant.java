package se.poroli.fhirplace.r5.datatypes;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * FHIR {@code instant}: a point in time, known at least to the second and always with a UTC offset, such as
 * {@code 2024-05-17T13:28:17.239+02:00}.
 *
 * <p>The record keeps the exact lexical form, so a value read from FHIR JSON or XML is written back unchanged,
 * including its fraction digits and whether UTC is written {@code Z} or {@code +00:00}. Two instants are equal when
 * their lexical forms are; compare {@link #value()} to compare points in time.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param valueAsString the instant in its FHIR lexical form, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#instant">FHIR R5 instant</a>
 */
public record FhirInstant(String id, List<Extension> extension, String valueAsString)
        implements PrimitiveType<OffsetDateTime> {

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid instant in
     *   the years 1 to 9999 with an offset from -14:00 to +14:00
     */
    public FhirInstant {
        extension = Primitives.extensions(extension, valueAsString);
        if (valueAsString != null) {
            parseValue(valueAsString);
        }
    }

    /**
     * Creates an instant with the given value and no id or extensions.
     *
     * @param value the instant
     * @return the instant
     * @throws IllegalArgumentException if the value is {@code null} or out of range
     */
    public static FhirInstant of(OffsetDateTime value) {
        if (value == null) {
            throw Primitives.invalid("instant", null);
        }
        Primitives.checkDateTime("instant", value);
        return new FhirInstant(null, List.of(), Primitives.formatDateTime(value));
    }

    /**
     * Parses the FHIR lexical form of an instant: {@code YYYY-MM-DDThh:mm:ss[.fraction](Z|+hh:mm|-hh:mm)}. The lexical
     * form is kept as given.
     *
     * @param value the lexical form
     * @return the instant
     * @throws IllegalArgumentException if the value is not a valid instant
     */
    public static FhirInstant parse(String value) {
        if (value == null) {
            throw Primitives.invalid("instant", null);
        }
        return new FhirInstant(null, List.of(), value);
    }

    /**
     * Returns the instant, parsed from its lexical form.
     *
     * @return the instant, or {@code null} when only extensions are present
     */
    @Override
    public OffsetDateTime value() {
        return valueAsString == null ? null : parseValue(valueAsString);
    }

    private static OffsetDateTime parseValue(String value) {
        OffsetDateTime instant = Primitives.parseDateTime("instant", value);
        Primitives.checkDateTime("instant", instant);
        return instant;
    }
}
