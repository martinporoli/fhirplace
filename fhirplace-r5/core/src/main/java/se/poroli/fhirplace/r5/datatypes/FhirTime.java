package se.poroli.fhirplace.r5.datatypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code time}: a time of day with seconds and no date or UTC offset, such as {@code 13:28:17}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the time, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#time">FHIR R5 time</a>
 */
public record FhirTime(String id, List<Extension> extension, LocalTime value) implements PrimitiveType<LocalTime> {

    private static final Pattern LEXICAL =
            Pattern.compile("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]{1,9})?");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent
     */
    public FhirTime {
        extension = Primitives.extensions(extension, value);
    }

    /**
     * Creates a time with the given value and no id or extensions.
     *
     * @param value the time
     * @return the time
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static FhirTime of(LocalTime value) {
        return new FhirTime(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a time: {@code hh:mm:ss[.fraction]}.
     *
     * @param value the lexical form
     * @return the time
     * @throws IllegalArgumentException if the value is not a valid time
     */
    public static FhirTime parse(String value) {
        Primitives.requireMatch("time", value, LEXICAL);
        try {
            return of(LocalTime.parse(value, DateTimeFormatter.ISO_LOCAL_TIME));
        } catch (DateTimeParseException e) {
            throw Primitives.invalid("time", value);
        }
    }

    @Override
    public String valueAsString() {
        return value == null ? null : DateTimeFormatter.ISO_LOCAL_TIME.format(value);
    }
}
