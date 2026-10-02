package se.poroli.fhirplace.r5.json;

import jakarta.json.Json;
import jakarta.json.JsonException;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.stream.JsonGenerator;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.internal.Errors;

/**
 * Reads and writes resources in the FHIR JSON format using Jakarta JSON Processing.
 *
 * <p>Resource types are resolved from {@code resourceType}: resource {@code X} must be available as module
 * {@code se.poroli.fhirplace.r5.<x>}, for example by depending on {@code fhirplace-r5-patient} for {@code Patient}.
 * Reading rejects malformed JSON, elements the model does not know and values that violate the model's constraints
 * with a {@link se.poroli.fhirplace.r5.FhirFormatException} that tells what is wrong and where.
 *
 * @see <a href="https://hl7.org/fhir/R5/json.html">FHIR R5 JSON representation</a>
 */
public final class FhirJson {

    private FhirJson() {
    }

    /**
     * Writes a resource as FHIR JSON.
     *
     * @param resource the resource
     * @return the compact JSON text
     */
    public static String write(Resource resource) {
        StringWriter writer = new StringWriter();
        write(resource, writer);
        return writer.toString();
    }

    /**
     * Writes a resource as FHIR JSON to a character stream. The writer is flushed but not closed.
     *
     * @param resource the resource
     * @param writer the destination
     */
    public static void write(Resource resource, Writer writer) {
        Objects.requireNonNull(resource, "resource");
        try (JsonGenerator generator = Json.createGenerator(new NonClosingWriter(writer))) {
            write(resource, generator);
        }
    }

    /**
     * Writes a resource as a FHIR JSON object to a generator, as a top-level value or array element. To write it as
     * the value of a property, call {@link JsonGenerator#writeKey(String)} first.
     *
     * @param resource the resource
     * @param generator the generator
     */
    public static void write(Resource resource, JsonGenerator generator) {
        JsonCodec.writeResource(generator, null, Objects.requireNonNull(resource, "resource"));
    }

    /**
     * Reads a resource from FHIR JSON.
     *
     * @param json the JSON text of one resource
     * @return the resource, of the class named by its {@code resourceType}
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the text is not a valid FHIR resource for this model
     */
    public static Resource read(String json) {
        return read(new StringReader(Objects.requireNonNull(json, "json")));
    }

    /**
     * Reads a resource of an expected type from FHIR JSON.
     *
     * @param json the JSON text of one resource
     * @param type the expected resource class
     * @param <T> the resource type
     * @return the resource
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the text is not a valid FHIR resource of that type
     */
    public static <T extends Resource> T read(String json, Class<T> type) {
        return as(read(json), type);
    }

    /**
     * Reads a resource from a character stream of FHIR JSON. The reader is not closed.
     *
     * @param reader the source of one resource
     * @return the resource, of the class named by its {@code resourceType}
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the content is not a valid FHIR resource for this model
     */
    public static Resource read(Reader reader) {
        JsonObject object;
        try (JsonReader json = Json.createReader(new NonClosingReader(reader))) {
            object = json.readObject();
        } catch (JsonException e) {
            throw Errors.syntax("Invalid JSON: " + e.getMessage(), e);
        }
        return read(object);
    }

    /**
     * Reads a resource from a parsed JSON object.
     *
     * @param object the JSON object of one resource
     * @return the resource, of the class named by its {@code resourceType}
     * @throws se.poroli.fhirplace.r5.FhirFormatException if the object is not a valid FHIR resource for this model
     */
    public static Resource read(JsonObject object) {
        return JsonCodec.readResource(Objects.requireNonNull(object, "object"), "");
    }

    static <T extends Resource> T as(Resource resource, Class<T> type) {
        if (!type.isInstance(resource)) {
            throw Errors.structure(resource.getClass().getSimpleName(), "expected a " + type.getSimpleName()
                    + " but got a " + resource.getClass().getSimpleName());
        }
        return type.cast(resource);
    }

    private static final class NonClosingWriter extends java.io.FilterWriter {
        NonClosingWriter(Writer out) {
            super(Objects.requireNonNull(out, "writer"));
        }

        @Override
        public void close() throws java.io.IOException {
            flush();
        }
    }

    private static final class NonClosingReader extends java.io.FilterReader {
        NonClosingReader(Reader in) {
            super(Objects.requireNonNull(in, "reader"));
        }

        @Override
        public void close() {
        }
    }
}
