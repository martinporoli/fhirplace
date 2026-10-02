package se.poroli.fhirplace.r5.datatypes;

/**
 * A primitive datatype: a single value with an optional id and extensions.
 *
 * <p>A primitive has a value, at least one extension, or both. Extensions are typically used to explain why a
 * value is absent.
 *
 * @param <T> the Java type of the value
 * @see <a href="https://hl7.org/fhir/R5/datatypes.html#primitive">FHIR R5 primitive types</a>
 */
public sealed interface PrimitiveType<T> extends DataType
        permits FhirBoolean, FhirInteger, FhirInteger64, FhirPositiveInt, FhirUnsignedInt, FhirDecimal, FhirString,
                FhirMarkdown, FhirCode, FhirId, FhirUri, FhirUrl, FhirCanonical, FhirOid, FhirUuid, FhirBase64Binary,
                FhirInstant, FhirDate, FhirDateTime, FhirTime, FhirEnum {

    /**
     * Returns the value.
     *
     * @return the value, or {@code null} if only extensions are present
     */
    T value();

    /**
     * Returns the value in its FHIR lexical form, as used in JSON and XML.
     *
     * @return the lexical form, or {@code null} if only extensions are present
     */
    String valueAsString();
}
