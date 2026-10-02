package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code code}: a code from a set of codes, with no leading, trailing or repeated whitespace.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#code">FHIR R5 code</a>
 */
public record FhirCode(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern CODE = Pattern.compile("[^\\s]+( [^\\s]+)*");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid code
     */
    public FhirCode {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("code", value, CODE);
    }

    /**
     * Creates a code with the given value and no id or extensions.
     *
     * @param value the value
     * @return the code
     * @throws IllegalArgumentException if the value is {@code null} or not a valid code
     */
    public static FhirCode of(String value) {
        return new FhirCode(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
