package se.poroli.fhirplace.r5.json;

import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import se.poroli.fhirplace.r5.Resource;

/**
 * Jakarta JSON Binding deserializer that reads resources from the FHIR JSON format. It is attached to all resources
 * with {@code @JsonbTypeDeserializer}, so {@code jsonb.fromJson(json, Patient.class)} needs no configuration.
 */
public final class ResourceJsonbDeserializer implements JsonbDeserializer<Resource> {

    /** Creates the deserializer. */
    public ResourceJsonbDeserializer() {
    }

    /**
     * Reads a FHIR JSON object as a resource.
     *
     * @param parser the parser, positioned at the start of the object
     * @param context the deserialization context, unused
     * @param type the requested type, a resource class or {@code Resource}
     * @return the resource
     * @throws IllegalArgumentException if the object is not a valid resource of the requested type
     */
    @Override
    public Resource deserialize(JsonParser parser, DeserializationContext context, Type type) {
        Resource resource = FhirJson.read(parser.getObject());
        Class<?> expected = type instanceof ParameterizedType p ? (Class<?>) p.getRawType() : (Class<?>) type;
        return FhirJson.as(resource, expected.asSubclass(Resource.class));
    }
}
