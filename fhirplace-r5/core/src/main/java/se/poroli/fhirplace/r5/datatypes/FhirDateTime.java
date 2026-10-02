package se.poroli.fhirplace.r5.datatypes;

import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.List;

/**
 * FHIR {@code dateTime}: a date, partial date or date and time, such as {@code 2024}, {@code 2024-05-17} or
 * {@code 2024-05-17T13:28:17+02:00}. A time always has seconds and a UTC offset.
 *
 * <p>The record keeps the exact lexical form, so a value read from FHIR JSON or XML is written back unchanged,
 * including its fraction digits and whether UTC is written {@code Z} or {@code +00:00}. Two dateTimes are equal when
 * their lexical forms are. {@link #value()} parses the lexical form; the precision is the type of the result: a {@link
 * java.time.Year}, {@link java.time.YearMonth}, {@link java.time.LocalDate} or {@link java.time.OffsetDateTime}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param valueAsString the value in its FHIR lexical form, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#dateTime">FHIR R5 dateTime</a>
 */
public record FhirDateTime(String id, List<Extension> extension, String valueAsString)
        implements PrimitiveType<Temporal> {

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid dateTime
     *   in the years 1 to 9999
     */
    public FhirDateTime {
        extension = Primitives.extensions(extension, valueAsString);
        if (valueAsString != null) {
            parseValue(valueAsString);
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
        if (value instanceof OffsetDateTime dateTime) {
            Primitives.checkDateTime("dateTime", dateTime);
            return new FhirDateTime(null, List.of(), Primitives.formatDateTime(dateTime));
        }
        Primitives.checkPartialDate("dateTime", value);
        return new FhirDateTime(null, List.of(), Primitives.formatPartialDate(value));
    }

    /**
     * Parses the FHIR lexical form of a dateTime: {@code YYYY}, {@code YYYY-MM}, {@code YYYY-MM-DD} or
     * {@code YYYY-MM-DDThh:mm:ss[.fraction](Z|+hh:mm|-hh:mm)}. The lexical form is kept as given.
     *
     * @param value the lexical form
     * @return the dateTime
     * @throws IllegalArgumentException if the value is not a valid dateTime
     */
    public static FhirDateTime parse(String value) {
        if (value == null) {
            throw Primitives.invalid("dateTime", null);
        }
        return new FhirDateTime(null, List.of(), value);
    }

    /**
     * Returns the value, parsed from its lexical form.
     *
     * @return a {@link java.time.Year}, {@link java.time.YearMonth}, {@link java.time.LocalDate} or {@link
     *   java.time.OffsetDateTime}, or {@code null} when only extensions are present
     */
    @Override
    public Temporal value() {
        return valueAsString == null ? null : parseValue(valueAsString);
    }

    private static Temporal parseValue(String value) {
        if (Primitives.isPartialDate(value)) {
            Temporal date = Primitives.parsePartialDate("dateTime", value);
            Primitives.checkPartialDate("dateTime", date);
            return date;
        }
        OffsetDateTime dateTime = Primitives.parseDateTime("dateTime", value);
        Primitives.checkDateTime("dateTime", dateTime);
        return dateTime;
    }
}
