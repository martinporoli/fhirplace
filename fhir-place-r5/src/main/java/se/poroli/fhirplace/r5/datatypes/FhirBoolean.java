package se.poroli.fhirplace.r5.datatypes;

import java.util.List;

/**
 * FHIR {@code boolean}: {@code true} or {@code false}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#boolean">FHIR R5 boolean</a>
 */
public record FhirBoolean(String id, List<Extension> extension, Boolean value) implements PrimitiveType<Boolean> {

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent
     */
    public FhirBoolean {
        extension = Primitives.extensions(extension, value);
    }

    /**
     * Creates a boolean with the given value and no id or extensions.
     *
     * @param value the value
     * @return the boolean
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static FhirBoolean of(Boolean value) {
        return new FhirBoolean(null, List.of(), value);
    }

    /**
     * Parses the FHIR lexical form of a boolean, which is exactly {@code "true"} or {@code "false"}.
     *
     * @param value the lexical form
     * @return the boolean
     * @throws IllegalArgumentException if the value is neither {@code "true"} nor {@code "false"}
     */
    public static FhirBoolean parse(String value) {
        return switch (value) {
            case "true" -> of(true);
            case "false" -> of(false);
            case null, default -> throw Primitives.invalid("boolean", value);
        };
    }

    @Override
    public String valueAsString() {
        return value == null ? null : value.toString();
    }
}
