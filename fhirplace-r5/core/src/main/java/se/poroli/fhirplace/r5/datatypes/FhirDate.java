package se.poroli.fhirplace.r5.datatypes;

import java.time.temporal.Temporal;
import java.util.List;

/**
 * FHIR {@code date}: a date or partial date, such as {@code 2024}, {@code 2024-05} or {@code 2024-05-17}, with
 * no time or UTC offset.
 *
 * <p>The precision is the type of the value: a {@link java.time.Year}, {@link java.time.YearMonth} or {@link
 * java.time.LocalDate}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value a {@link java.time.Year}, {@link java.time.YearMonth} or {@link java.time.LocalDate}, or {@code null}
 *   when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#date">FHIR R5 date</a>
 */
public record FhirDate(String id, List<Extension> extension, Temporal value) implements PrimitiveType<Temporal> {

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a {@link
     *   java.time.Year}, {@link java.time.YearMonth} or {@link java.time.LocalDate} in the years 1 to 9999
     */
    public FhirDate {
        extension = Primitives.extensions(extension, value);
        if (value != null) {
            Primitives.checkPartialDate("date", value);
        }
    }

    /**
     * Creates a date with the given value and no id or extensions.
     *
     * @param value a {@link java.time.Year}, {@link java.time.YearMonth} or {@link java.time.LocalDate}
     * @return the date
     * @throws IllegalArgumentException if the value is {@code null} or of another type
     */
    public static FhirDate of(Temporal value) {
        return new FhirDate(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a date: {@code YYYY}, {@code YYYY-MM} or {@code YYYY-MM-DD}.
     *
     * @param value the lexical form
     * @return the date
     * @throws IllegalArgumentException if the value is not a valid date
     */
    public static FhirDate parse(String value) {
        return of(Primitives.parsePartialDate("date", value));
    }

    @Override
    public String valueAsString() {
        return value == null ? null : Primitives.formatPartialDate(value);
    }
}
