package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import java.util.regex.Pattern;

/**
 * FHIR {@code oid}: an OID represented as a URI, such as {@code urn:oid:1.2.3.4.5}.
 *
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the value, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#oid">FHIR R5 oid</a>
 */
public record FhirOid(String id, List<Extension> extension, String value) implements PrimitiveType<String> {

    private static final Pattern OID = Pattern.compile("urn:oid:[0-2](\\.(0|[1-9][0-9]*))+");

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent, or the value is not a valid oid
     */
    public FhirOid {
        extension = Primitives.extensions(extension, value);
        Primitives.requireMatch("oid", value, OID);
    }

    /**
     * Creates a oid with the given value and no id or extensions.
     *
     * @param value the value
     * @return the oid
     * @throws IllegalArgumentException if the value is {@code null} or not a valid oid
     */
    public static FhirOid of(String value) {
        return new FhirOid(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value;
    }
}
