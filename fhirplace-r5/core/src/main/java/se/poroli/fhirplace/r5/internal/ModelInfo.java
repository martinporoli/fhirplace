package se.poroli.fhirplace.r5.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.PrimitiveType;

/**
 * The FHIR elements of a model record and how to construct it, derived from its record components. Internal; not
 * exported.
 */
public final class ModelInfo {

    /** Java keywords that are FHIR element names; the model names these components {@code <keyword>Value}. */
    private static final Set<String> KEYWORDS =
            Set.of("abstract", "assert", "case", "class", "const", "extends", "for", "import", "short");

    private static final ClassValue<ModelInfo> CACHE = new ClassValue<>() {
        @Override
        protected ModelInfo computeValue(Class<?> type) {
            return new ModelInfo(type);
        }
    };

    private final Class<?> type;
    private final boolean resource;
    private final Constructor<?> constructor;
    private final List<Property> properties;
    private final Map<String, Property> byName;

    private ModelInfo(Class<?> type) {
        if (!type.isRecord()) {
            throw new IllegalArgumentException(type.getName() + " is not a FHIR model record");
        }
        this.type = type;
        this.resource = Resource.class.isAssignableFrom(type);
        RecordComponent[] components = type.getRecordComponents();
        Class<?>[] parameterTypes = new Class<?>[components.length];
        List<Property> props = new ArrayList<>(components.length);
        Map<String, Property> names = new HashMap<>();
        for (int i = 0; i < components.length; i++) {
            RecordComponent component = components[i];
            parameterTypes[i] = component.getType();
            Property property = property(component, i);
            props.add(property);
            names.put(property.name(), property);
        }
        try {
            this.constructor = type.getDeclaredConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
        this.properties = List.copyOf(props);
        this.byName = Map.copyOf(names);
    }

    /**
     * Returns the description of a model record.
     *
     * @param type a resource, datatype or backbone element record
     * @return the description, cached per class
     * @throws IllegalArgumentException if the type is not a record
     */
    public static ModelInfo of(Class<?> type) {
        return CACHE.get(type);
    }

    /**
     * Returns the described record class.
     *
     * @return the class
     */
    public Class<?> type() {
        return type;
    }

    /**
     * Returns whether the record is a resource.
     *
     * @return {@code true} for resources
     */
    public boolean isResource() {
        return resource;
    }

    /**
     * Returns the FHIR elements in specification order.
     *
     * @return the properties
     */
    public List<Property> properties() {
        return properties;
    }

    /**
     * Returns the element with the given FHIR name, not resolving choice suffixes.
     *
     * @param name the FHIR element name
     * @return the property, or {@code null} if there is none
     */
    public Property property(String name) {
        return byName.get(name);
    }

    /**
     * Resolves a FHIR element name, including choice elements written with their type suffix.
     *
     * @param name the element name as it appears in JSON or XML, such as {@code valueQuantity}
     * @return the property and the concrete value type, or {@code null} if the name is unknown
     */
    public Resolved resolve(String name) {
        Property exact = byName.get(name);
        if (exact != null) {
            return exact.kind() == Property.Kind.CHOICE ? null : new Resolved(exact, exact.type());
        }
        for (Property property : properties) {
            if (property.kind() == Property.Kind.CHOICE
                    && name.length() > property.name().length()
                    && name.startsWith(property.name())
                    && Character.isUpperCase(name.charAt(property.name().length()))) {
                Class<?> dataType = FhirTypes.dataType(name.substring(property.name().length()));
                if (dataType != null) {
                    return new Resolved(property, dataType);
                }
            }
        }
        return null;
    }

    /**
     * An element name resolved to its property and concrete value type.
     *
     * @param property the property
     * @param type the class of the value; for choices the datatype named by the suffix
     */
    public record Resolved(Property property, Class<?> type) {
    }

    /**
     * Creates an instance from element values in property order.
     *
     * @param values the values; lists for repeating elements, {@code null} for absent elements
     * @return the record
     * @throws RuntimeException whatever the record's validation throws, such as for missing required elements
     */
    public Object create(Object[] values) {
        try {
            return constructor.newInstance(values);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw unwrap(e);
        }
    }

    static RuntimeException unwrap(InvocationTargetException e) {
        Throwable cause = e.getCause();
        if (cause instanceof RuntimeException runtime) {
            return runtime;
        }
        if (cause instanceof Error error) {
            throw error;
        }
        return new IllegalStateException(cause);
    }

    private static Property property(RecordComponent component, int index) {
        String name = component.getName();
        if (name.endsWith("Value") && KEYWORDS.contains(name.substring(0, name.length() - "Value".length()))) {
            name = name.substring(0, name.length() - "Value".length());
        }
        boolean repeating = component.getType() == List.class;
        Type generic = component.getGenericType();
        if (repeating) {
            generic = ((ParameterizedType) generic).getActualTypeArguments()[0];
        }
        Class<?> valueType = raw(generic);
        Class<?> enumType = null;
        Property.Kind kind;
        if (valueType == String.class) {
            kind = Property.Kind.STRING;
        } else if (valueType == FhirXhtml.class) {
            kind = Property.Kind.XHTML;
        } else if (valueType == Resource.class) {
            kind = Property.Kind.RESOURCE;
        } else if (valueType == DataType.class) {
            kind = Property.Kind.CHOICE;
        } else if (PrimitiveType.class.isAssignableFrom(valueType)) {
            kind = Property.Kind.PRIMITIVE;
            if (valueType == FhirEnum.class) {
                enumType = raw(((ParameterizedType) generic).getActualTypeArguments()[0]);
            }
        } else if (valueType.isRecord()) {
            kind = Property.Kind.COMPLEX;
        } else {
            throw new IllegalStateException("Unsupported element type " + generic + " of "
                    + component.getDeclaringRecord().getName() + "." + component.getName());
        }
        return new Property(name, kind, valueType, enumType, repeating, index, component.getAccessor());
    }

    private static Class<?> raw(Type type) {
        if (type instanceof Class<?> c) {
            return c;
        }
        if (type instanceof ParameterizedType p) {
            return (Class<?>) p.getRawType();
        }
        throw new IllegalStateException("Unsupported element type " + type);
    }
}
