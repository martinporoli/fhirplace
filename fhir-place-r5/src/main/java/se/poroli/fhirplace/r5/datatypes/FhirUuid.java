package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code uuid}: a UUID represented as a URI, such as {@code urn:uuid:c757873d-ec9a-4326-a141-556f43239520}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#uuid">FHIR R5 uuid</a>
 */
public record FhirUuid(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern UUID = Pattern.compile(
            "urn:uuid:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid uuid
     */
    public FhirUuid {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("uuid", value, UUID);
    }

    /**
     * Creates a uuid with the given value and no id or extensions.
     *
     * @param value the value
     * @return the uuid
     * @throws IllegalArgumentException if the value is {@code null} or not a valid uuid
     */
    public static FhirUuid of(String value) {
        return new FhirUuid(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
