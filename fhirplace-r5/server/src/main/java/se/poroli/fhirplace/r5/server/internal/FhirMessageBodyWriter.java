package se.poroli.fhirplace.r5.server.internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonGeneratorFactory;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Writes resources as FHIR JSON or XML, indented when the entity carries {@link Pretty}. */
@Provider
@ApplicationScoped
@Produces({FhirMediaTypes.FHIR_JSON, FhirMediaTypes.FHIR_XML, MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class FhirMessageBodyWriter implements MessageBodyWriter<Resource> {

    private static final JsonGeneratorFactory PRETTY_JSON =
            Json.createGeneratorFactory(Map.of(JsonGenerator.PRETTY_PRINTING, true));

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Resource.class.isAssignableFrom(type)
                && (FhirMediaTypes.isJson(mediaType) || FhirMediaTypes.isXml(mediaType));
    }

    @Override
    public void writeTo(Resource resource, Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException {
        httpHeaders.putSingle(HttpHeaders.CONTENT_TYPE, mediaType.withCharset(StandardCharsets.UTF_8.name()));
        Writer writer = new OutputStreamWriter(entityStream, StandardCharsets.UTF_8);
        if (FhirMediaTypes.isXml(mediaType)) {
            FhirXml.write(resource, writer);
        } else if (isPretty(annotations)) {
            // Flushed, not closed: closing the generator would close the container's output stream.
            JsonGenerator generator = PRETTY_JSON.createGenerator(writer);
            FhirJson.write(resource, generator);
            generator.flush();
        } else {
            FhirJson.write(resource, writer);
        }
        writer.flush();
    }

    private static boolean isPretty(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Pretty.class) {
                return true;
            }
        }
        return false;
    }
}
