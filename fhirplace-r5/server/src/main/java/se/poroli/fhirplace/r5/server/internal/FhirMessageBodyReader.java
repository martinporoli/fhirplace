package se.poroli.fhirplace.r5.server.internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Reads request bodies in FHIR JSON or XML as resources. */
@Provider
@ApplicationScoped
@Consumes({FhirMediaTypes.FHIR_JSON, FhirMediaTypes.FHIR_XML, MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class FhirMessageBodyReader implements MessageBodyReader<Resource> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Resource.class.isAssignableFrom(type)
                && (FhirMediaTypes.isJson(mediaType) || FhirMediaTypes.isXml(mediaType));
    }

    @Override
    public Resource readFrom(Class<Resource> type, Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream) {
        Reader reader = new InputStreamReader(entityStream, charset(mediaType));
        Resource resource;
        try {
            resource = FhirMediaTypes.isXml(mediaType) ? FhirXml.read(reader) : FhirJson.read(reader);
        } catch (IllegalArgumentException e) {
            throw FhirException.invalid("Invalid FHIR content: " + e.getMessage());
        }
        if (!type.isInstance(resource)) {
            throw FhirException.invalid("Expected a " + type.getSimpleName() + " but got a "
                    + resource.getClass().getSimpleName());
        }
        return resource;
    }

    private static Charset charset(MediaType mediaType) {
        String charset = mediaType.getParameters().get(MediaType.CHARSET_PARAMETER);
        return charset == null ? StandardCharsets.UTF_8 : Charset.forName(charset);
    }
}
