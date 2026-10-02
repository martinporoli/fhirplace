package se.poroli.fhirplace.r5.datatypes;

import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.List;

/**
 * FHIR {@code dateTime}: a date, partial date or date and time, such as {@code 2024}, {@code 2024-05-17} or
 * {@code 2024-05-17T13:28:17+02:00}. A time always has seconds and a UTC offset.
 *
 * <p>The precision is the type of the value: a {@link java.time.Year}, {@link java.time.YearMonth}, {@link
 * java.time.LocalDate} or {@link java.time.OffsetDateTime}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value a {@link java.time.Year}, {@link java.time.YearMonth}, {@link java.time.LocalDate} or {@link
 *   java.time.OffsetDateTime}, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#dateTime">FHIR R5 dateTime</a>
 */
public record FhirDateTime(String id, List<Extension> extension, Temporal value) implements PrimitiveType<Temporal> {

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a {@link
     *   java.time.Year}, {@link java.time.YearMonth}, {@link java.time.LocalDate} or {@link java.time.OffsetDateTime}
     *   in the years 1 to 9999
     */
    public FhirDateTime {
        extension = Primitives.extensions(extension, value);
        if (value instanceof OffsetDateTime dateTime) {
            Primitives.checkDateTime("dateTime", dateTime);
        } else if (value != null) {
            Primitives.checkPartialDate("dateTime", value);
        }
    }

    /**
     * Creates a dateTime with the given value and no id or extensions.
     *
     * @param value a {@link java.time.Year}, {@link java.time.YearMonth}, {@link java.time.LocalDate} or {@link
     *   java.time.OffsetDateTime}
     * @return the dateTime
     * @throws IllegalArgumentException if the value is {@code null} or of another type
     */
    public static FhirDateTime of(Temporal value) {
        return new FhirDateTime(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a dateTime: {@code YYYY}, {@code YYYY-MM}, {@code YYYY-MM-DD} or
     * {@code YYYY-MM-DDThh:mm:ss[.fraction](Z|+hh:mm|-hh:mm)}.
     *
     * @param value the lexical form
     * @return the dateTime
     * @throws IllegalArgumentException if the value is not a valid dateTime
     */
    public static FhirDateTime parse(String value) {
        if (value != null && Primitives.isPartialDate(value)) {
            return of(Primitives.parsePartialDate("dateTime", value));
        }
        return of(Primitives.parseDateTime("dateTime", value));
    }

    @Override
    public String valueAsString() {
        return switch (value) {
            case null -> null;
            case OffsetDateTime dateTime -> Primitives.formatDateTime(dateTime);
            default -> Primitives.formatPartialDate(value);
        };
    }
}
