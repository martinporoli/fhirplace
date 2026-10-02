package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code id}: a logical id of 1 to 64 letters, digits, {@code -} and {@code .}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#id">FHIR R5 id</a>
 */
public record FhirId(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern ID = Pattern.compile("[A-Za-z0-9\\-.]{1,64}");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid id
     */
    public FhirId {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("id", value, ID);
    }

    /**
     * Creates a id with the given value and no id or extensions.
     *
     * @param value the value
     * @return the id
     * @throws IllegalArgumentException if the value is {@code null} or not a valid id
     */
    public static FhirId of(String value) {
        return new FhirId(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
