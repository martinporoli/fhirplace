package se.poroli.fhirplace.r5.datatypes;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * FHIR {@code instant}: a point in time, known at least to the second and always with a UTC offset, such as
 * {@code 2024-05-17T13:28:17.239+02:00}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the instant, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#instant">FHIR R5 instant</a>
 */
public record FhirInstant(String id, List<Extension> extension, OffsetDateTime value)
        implements PrimitiveType<OffsetDateTime> {

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is outside the years 1
     *   to 9999 or the offsets -14:00 to +14:00
     */
    public FhirInstant {
        extension = Primitives.extensions(extension, value);
        if (value != null) {
            Primitives.checkDateTime("instant", value);
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
        return new FhirInstant(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of an instant: {@code YYYY-MM-DDThh:mm:ss[.fraction](Z|+hh:mm|-hh:mm)}.
     *
     * @param value the lexical form
     * @return the instant
     * @throws IllegalArgumentException if the value is not a valid instant
     */
    public static FhirInstant parse(String value) {
        return of(Primitives.parseDateTime("instant", value));
    }

    @Override
    public String valueAsString() {
        return value == null ? null : Primitives.formatDateTime(value);
    }
}
