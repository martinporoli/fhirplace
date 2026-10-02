package se.poroli.fhirplace.r5.datatypes;

import java.util.List;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;

/**
 * FHIR {@code code} whose value is bound to a fixed set of codes, represented by an enum.
 *
 * <p>Used for elements with a required binding to a value set whose codes are fully enumerated, such as
 * {@code Patient.gender}. Other codes use {@link FhirCode}.
 *
 * @param <E> the enum holding the allowed codes
 * @param id unique id for inter-element referencing, or {@code null}
 * @param extension additional content defined by implementations; never {@code null}
 * @param value the code, or {@code null} when only extensions are present
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#code">FHIR R5 code</a>
 */
public record FhirEnum<E extends Enum<E> & CodedEnum>(String id, List<Extension> extension, E value)
        implements PrimitiveType<E> {

    /**
     * Creates the primitive, copying the extensions.
     *
     * @throws IllegalArgumentException if both value and extensions are absent
     */
    public FhirEnum {
        extension = Primitives.extensions(extension, value);
    }

    /**
     * Creates a code with the given value and no id or extensions.
     *
     * @param <E> the enum holding the allowed codes
     * @param value the code
     * @return the code
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static <E extends Enum<E> & CodedEnum> FhirEnum<E> of(E value) {
        return new FhirEnum<>(null, List.of(), value);
    }

    @Override
    public String valueAsString() {
        return value == null ? null : value.code();
    }
}
