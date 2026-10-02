package se.poroli.fhirplace.r5.json;

import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirPositiveInt;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.PrimitiveType;
import se.poroli.fhirplace.r5.internal.FhirTypes;
import se.poroli.fhirplace.r5.internal.ModelInfo;
import se.poroli.fhirplace.r5.internal.Property;

/** Writes model records to a JSON-P generator and reads them from JSON-P objects, following the FHIR JSON format. */
final class JsonCodec {

    private static final String RESOURCE_TYPE = "resourceType";

    private JsonCodec() {
    }

    // ---- writing ---------------------------------------------------------------------------------------------------

    static void writeResource(JsonGenerator g, String name, Resource resource) {
        if (name == null) {
            g.writeStartObject();
        } else {
            g.writeStartObject(name);
        }
        g.write(RESOURCE_TYPE, FhirTypes.resourceType(resource.getClass()));
        writeElements(g, resource);
        g.writeEnd();
    }

    private static void writeElements(JsonGenerator g, Object record) {
        for (Property property : ModelInfo.of(record.getClass()).properties()) {
            Object value = property.get(record);
            if (value == null) {
                continue;
            }
            if (property.repeating()) {
                List<?> values = (List<?>) value;
                if (!values.isEmpty()) {
                    writeList(g, property, values);
                }
            } else {
                writeSingle(g, property, value);
            }
        }
    }

    private static void writeSingle(JsonGenerator g, Property property, Object value) {
        String name = property.name();
        switch (property.kind()) {
            case STRING -> g.write(name, (String) value);
            case XHTML -> g.write(name, ((FhirXhtml) value).value());
            case PRIMITIVE -> writePrimitive(g, name, (PrimitiveType<?>) value);
            case COMPLEX -> writeComplex(g, name, value);
            case RESOURCE -> writeResource(g, name, (Resource) value);
            case CHOICE -> {
                String choiceName = name + FhirTypes.typeSuffix(value.getClass());
                if (value instanceof PrimitiveType<?> primitive) {
                    writePrimitive(g, choiceName, primitive);
                } else {
                    writeComplex(g, choiceName, value);
                }
            }
        }
    }

    private static void writeComplex(JsonGenerator g, String name, Object value) {
        if (name == null) {
            g.writeStartObject();
        } else {
            g.writeStartObject(name);
        }
        writeElements(g, value);
        g.writeEnd();
    }

    private static void writePrimitive(JsonGenerator g, String name, PrimitiveType<?> primitive) {
        if (primitive.value() != null) {
            g.writeKey(name);
            writePrimitiveValue(g, primitive);
        }
        if (hasIdOrExtensions(primitive)) {
            g.writeKey("_" + name);
            writePrimitiveElement(g, primitive);
        }
    }

    private static void writeList(JsonGenerator g, Property property, List<?> values) {
        String name = property.name();
        switch (property.kind()) {
            case PRIMITIVE -> {
                boolean anyValue = values.stream().anyMatch(v -> ((PrimitiveType<?>) v).value() != null);
                boolean anyElement = values.stream().anyMatch(v -> hasIdOrExtensions((PrimitiveType<?>) v));
                if (anyValue) {
                    g.writeStartArray(name);
                    for (Object value : values) {
                        PrimitiveType<?> primitive = (PrimitiveType<?>) value;
                        if (primitive.value() == null) {
                            g.writeNull();
                        } else {
                            writePrimitiveValue(g, primitive);
                        }
                    }
                    g.writeEnd();
                }
                if (anyElement) {
                    g.writeStartArray("_" + name);
                    for (Object value : values) {
                        PrimitiveType<?> primitive = (PrimitiveType<?>) value;
                        if (hasIdOrExtensions(primitive)) {
                            writePrimitiveElement(g, primitive);
                        } else {
                            g.writeNull();
                        }
                    }
                    g.writeEnd();
                }
            }
            case STRING -> {
                g.writeStartArray(name);
                values.forEach(v -> g.write((String) v));
                g.writeEnd();
            }
            case RESOURCE -> {
                g.writeStartArray(name);
                values.forEach(v -> writeResource(g, null, (Resource) v));
                g.writeEnd();
            }
            case COMPLEX -> {
                g.writeStartArray(name);
                values.forEach(v -> writeComplex(g, null, v));
                g.writeEnd();
            }
            default -> throw new IllegalStateException("Repeating " + property.kind() + " element " + name);
        }
    }

    private static boolean hasIdOrExtensions(PrimitiveType<?> primitive) {
        return primitive.id() != null || !primitive.extension().isEmpty();
    }

    private static void writePrimitiveValue(JsonGenerator g, PrimitiveType<?> primitive) {
        switch (primitive) {
            case FhirBoolean b -> g.write(b.value());
            case FhirInteger i -> g.write(i.value());
            case FhirPositiveInt i -> g.write(i.value());
            case FhirUnsignedInt i -> g.write(i.value());
            case FhirDecimal d -> g.write(d.value());
            default -> g.write(primitive.valueAsString());
        }
    }

    private static void writePrimitiveElement(JsonGenerator g, PrimitiveType<?> primitive) {
        g.writeStartObject();
        if (primitive.id() != null) {
            g.write("id", primitive.id());
        }
        if (!primitive.extension().isEmpty()) {
            g.writeStartArray("extension");
            primitive.extension().forEach(e -> writeComplex(g, null, e));
            g.writeEnd();
        }
        g.writeEnd();
    }

    // ---- reading ---------------------------------------------------------------------------------------------------

    static Resource readResource(JsonValue json, String path) {
        JsonObject object = object(json, path);
        JsonValue type = object.get(RESOURCE_TYPE);
        if (!(type instanceof JsonString typeName)) {
            throw new IllegalArgumentException(path + ": missing resourceType");
        }
        Class<? extends Resource> resourceClass = FhirTypes.resourceClass(typeName.getString());
        String resourcePath = path.isEmpty() ? typeName.getString() : path;
        return (Resource) readComplex(resourceClass, object, resourcePath, true);
    }

    private static Object readComplex(Class<?> type, JsonObject object, String path, boolean resource) {
        ModelInfo info = ModelInfo.of(type);
        Object[] values = new Object[info.properties().size()];
        Set<String> seen = new HashSet<>();
        for (String key : object.keySet()) {
            if (resource && key.equals(RESOURCE_TYPE)) {
                continue;
            }
            String name = key.startsWith("_") ? key.substring(1) : key;
            if (!seen.add(name)) {
                continue;
            }
            ModelInfo.Resolved resolved = info.resolve(name);
            if (resolved == null) {
                throw new IllegalArgumentException(path + ": unknown element '" + key + "'");
            }
            Property property = resolved.property();
            if (values[property.index()] != null) {
                throw new IllegalArgumentException(path + ": more than one value for " + property.name() + "[x]");
            }
            String elementPath = path + "." + name;
            JsonValue value = object.get(name);
            JsonValue element = object.get("_" + name);
            try {
                values[property.index()] = property.repeating()
                        ? readList(property, resolved.type(), value, element, elementPath)
                        : readSingle(property, resolved.type(), value, element, elementPath);
            } catch (ClassCastException e) {
                throw new IllegalArgumentException(elementPath + ": unexpected JSON " + describe(value), e);
            }
        }
        try {
            return info.create(values);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException(path + ": " + e.getMessage(), e);
        }
    }

    private static List<Object> readList(
            Property property, Class<?> type, JsonValue value, JsonValue element, String path) {
        JsonArray values = isNull(value) ? null : value.asJsonArray();
        JsonArray elements = isNull(element) ? null : element.asJsonArray();
        int size = Math.max(values == null ? 0 : values.size(), elements == null ? 0 : elements.size());
        if (values != null && elements != null && values.size() != elements.size()) {
            throw new IllegalArgumentException(path + ": value and _ arrays differ in length");
        }
        List<Object> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(readSingle(property, type,
                    values == null ? null : values.get(i), elements == null ? null : elements.get(i),
                    path + "[" + i + "]"));
        }
        return list;
    }

    private static Object readSingle(
            Property property, Class<?> type, JsonValue value, JsonValue element, String path) {
        Property.Kind kind = property.kind() == Property.Kind.CHOICE
                ? (PrimitiveType.class.isAssignableFrom(type) ? Property.Kind.PRIMITIVE : Property.Kind.COMPLEX)
                : property.kind();
        if (kind != Property.Kind.PRIMITIVE && element != null) {
            throw new IllegalArgumentException(path + ": unexpected _" + property.name());
        }
        return switch (kind) {
            case STRING -> ((JsonString) value).getString();
            case XHTML -> FhirXhtml.of(((JsonString) value).getString());
            case COMPLEX -> readComplex(type, object(value, path), path, false);
            case RESOURCE -> readResource(value, path);
            case PRIMITIVE -> readPrimitive(property, type, value, element, path);
            case CHOICE -> throw new IllegalStateException();
        };
    }

    private static Object readPrimitive(
            Property property, Class<?> type, JsonValue value, JsonValue element, String path) {
        String id = null;
        List<Extension> extensions = null;
        if (!isNull(element)) {
            JsonObject object = object(element, path);
            for (String key : object.keySet()) {
                if (!key.equals("id") && !key.equals("extension")) {
                    throw new IllegalArgumentException(path + ": unknown element '_" + key + "'");
                }
            }
            if (object.containsKey("id")) {
                id = object.getString("id");
            }
            if (object.containsKey("extension")) {
                JsonArray array = object.getJsonArray("extension");
                extensions = new ArrayList<>(array.size());
                for (int i = 0; i < array.size(); i++) {
                    String extensionPath = path + ".extension[" + i + "]";
                    extensions.add((Extension) readComplex(
                            Extension.class, object(array.get(i), extensionPath), extensionPath, false));
                }
            }
        }
        String lexical = isNull(value) ? null : lexical(value, path);
        try {
            return FhirTypes.primitive(type, property.enumType(), id, extensions, lexical);
        } catch (IllegalArgumentException | NullPointerException | java.time.DateTimeException e) {
            throw new IllegalArgumentException(path + ": " + e.getMessage(), e);
        }
    }

    private static String lexical(JsonValue value, String path) {
        return switch (value) {
            case JsonString s -> s.getString();
            case JsonNumber n -> n.bigDecimalValue().toString();
            default -> {
                if (value == JsonValue.TRUE) {
                    yield "true";
                }
                if (value == JsonValue.FALSE) {
                    yield "false";
                }
                throw new IllegalArgumentException(path + ": expected a primitive value but got " + describe(value));
            }
        };
    }

    private static JsonObject object(JsonValue value, String path) {
        if (!(value instanceof JsonObject object)) {
            throw new IllegalArgumentException(path + ": expected a JSON object but got " + describe(value));
        }
        return object;
    }

    private static boolean isNull(JsonValue value) {
        return value == null || value.getValueType() == JsonValue.ValueType.NULL;
    }

    private static String describe(JsonValue value) {
        return value == null ? "nothing" : value.getValueType().toString().toLowerCase(java.util.Locale.ROOT);
    }
}
