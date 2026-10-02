package se.poroli.fhirplace.r5.datatypes;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code decimal}: a rational number with implicit precision.
 *
 * <p>The precision of the value is significant, so {@code 1.5} and {@code 1.50} are different values. The
 * {@link BigDecimal} scale preserves it.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#decimal">FHIR R5 decimal</a>
 */
public record FhirDecimal(String id, List<Extension> extension, BigDecimal value)
        implements PrimitiveType<BigDecimal> {

    private static final Pattern LEXICAL =
            Pattern.compile("-?(0|[1-9][0-9]{0,17})(\\.[0-9]{1,17})?([eE][+-]?[0-9]{1,9})?");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent
     */
    public FhirDecimal {
        extension = Primitives.extensions(extension, value);
    }

    /**
     * Creates a decimal with the given value and no id or extensions.
     *
     * @param value the value, whose scale is its precision
     * @return the decimal
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static FhirDecimal of(BigDecimal value) {
        return new FhirDecimal(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a decimal, such as {@code "1.50"} or {@code "1e3"}, keeping its precision.
     *
     * @param value the lexical form
     * @return the decimal
     * @throws IllegalArgumentException if the value is not a valid decimal
     */
    public static FhirDecimal parse(String value) {
        Primitives.requireMatch("decimal", value, LEXICAL);
        return of(new BigDecimal(value));
    }

    @Override
    public String valueAsString() {
        if (value == null) {
            return null;
        }
        return value.scale() < 0 ? value.toString() : value.toPlainString();
    }
}
