package se.poroli.fhirplace.r5.datatypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code time}: a time of day with seconds and no date or UTC offset, such as {@code 13:28:17}.
 *
 * <p>The record keeps the exact lexical form, so fraction digits read from FHIR JSON or XML are written back
 * unchanged. Two times are equal when their lexical forms are.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param valueAsString the time in its FHIR lexical form, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#time">FHIR R5 time</a>
 */
public record FhirTime(String id, List<Extension> extension, String valueAsString)
        implements PrimitiveType<LocalTime> {

    private static final Pattern LEXICAL =
            Pattern.compile("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]{1,9})?");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid time
     */
    public FhirTime {
        extension = Primitives.extensions(extension, valueAsString);
        if (valueAsString != null) {
            parseValue(valueAsString);
        }
    }

    /**
     * Creates a time with the given value and no id or extensions.
     *
     * @param value the time
     * @return the time
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static FhirTime of(LocalTime value) {
        if (value == null) {
            throw Primitives.invalid("time", null);
        }
        return new FhirTime(null, List.of(), DateTimeFormatter.ISO_LOCAL_TIME.format(value));
    }

    /**
     * Parses the FHIR lexical form of a time: {@code hh:mm:ss[.fraction]}. The lexical form is kept as given.
     *
     * @param value the lexical form
     * @return the time
     * @throws IllegalArgumentException if the value is not a valid time
     */
    public static FhirTime parse(String value) {
        if (value == null) {
            throw Primitives.invalid("time", null);
        }
        return new FhirTime(null, List.of(), value);
    }

    /**
     * Returns the time, parsed from its lexical form.
     *
     * @return the time, or {@code null} when only extensions are present
     */
    @Override
    public LocalTime value() {
        return valueAsString == null ? null : parseValue(valueAsString);
    }

    private static LocalTime parseValue(String value) {
        Primitives.requireMatch("time", value, LEXICAL);
        try {
            return LocalTime.parse(value, DateTimeFormatter.ISO_LOCAL_TIME);
        } catch (DateTimeParseException e) {
            throw Primitives.invalid("time", value);
        }
    }
}
