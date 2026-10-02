package se.poroli.fhirplace.r5;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.json.ResourceJsonbDeserializer;
import se.poroli.fhirplace.r5.json.ResourceJsonbSerializer;

/**
 * This is the base resource type for everything.
 *
 * <p>Implemented by the resource records in the per-resource modules. Jakarta JSON Binding reads and writes resources
 * as FHIR JSON; see {@link se.poroli.fhirplace.r5.json.FhirJson} and {@link se.poroli.fhirplace.r5.xml.FhirXml}.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Resource">FHIR R5 Resource</a>
 */
@JsonbTypeSerializer(ResourceJsonbSerializer.class)
@JsonbTypeDeserializer(ResourceJsonbDeserializer.class)
public interface Resource {

    /**
     * Logical id of this artifact.
     *
     * @return the id, or {@code null} if absent
     */
    String id();

    /**
     * Metadata about the resource.
     *
     * @return the meta, or {@code null} if absent
     */
    Meta meta();

    /**
     * A set of rules under which this content was created. Modifier element.
     *
     * @return the implicitRules, or {@code null} if absent
     */
    FhirUri implicitRules();

    /**
     * Language of the resource content.
     *
     * @return the language, or {@code null} if absent
     */
    FhirCode language();
}
