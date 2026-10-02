package se.poroli.fhirplace.r5.json;

import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;
import se.poroli.fhirplace.r5.Resource;

/**
 * Jakarta JSON Binding serializer that writes resources in the FHIR JSON format. It is attached to all resources with
 * {@code @JsonbTypeSerializer}, so {@code jsonb.toJson(resource)} needs no configuration.
 */
public final class ResourceJsonbSerializer implements JsonbSerializer<Resource> {

    /** Creates the serializer. */
    public ResourceJsonbSerializer() {
    }

    /**
     * Writes the resource as a FHIR JSON object.
     *
     * @param resource the resource
     * @param generator the generator, positioned where the object value goes
     * @param context the serialization context, unused
     */
    @Override
    public void serialize(Resource resource, JsonGenerator generator, SerializationContext context) {
        FhirJson.write(resource, generator);
    }
}
