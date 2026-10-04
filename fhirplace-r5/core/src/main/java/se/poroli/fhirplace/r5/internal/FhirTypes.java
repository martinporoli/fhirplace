package se.poroli.fhirplace.r5.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.DataType;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.PrimitiveType;

/**
 * Maps between FHIR type names and model classes, and creates primitives from their lexical form. Internal; not
 * exported.
 */
public final class FhirTypes {

    private static final Pattern TYPE_NAME = Pattern.compile("[A-Z][A-Za-z0-9]*");
    private static final String MODEL_PACKAGE = "se.poroli.fhirplace.r5.";
    private static final String DATATYPES_PACKAGE = MODEL_PACKAGE + "datatypes.";

    /**
     * Datatypes found by {@link #dataType}. Only hits are kept: suffixes come from the content being read, so caching
     * misses would let that content grow the map without bound.
     */
    private static final Map<String, Class<?>> DATA_TYPES = new ConcurrentHashMap<>();

    private static final ClassValue<Constructor<?>> PRIMITIVE_CONSTRUCTORS = new ClassValue<>() {
        @Override
        protected Constructor<?> computeValue(Class<?> type) {
            try {
                return type.getDeclaredConstructor(String.class, List.class, type.getRecordComponents()[2].getType());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    private static final ClassValue<Method> LEXICAL_PARSERS = new ClassValue<>() {
        @Override
        protected Method computeValue(Class<?> type) {
            for (String name : List.of("parse", "fromCode", "of")) {
                try {
                    return type.getMethod(name, String.class);
                } catch (NoSuchMethodException e) {
                    // try the next factory name
                }
            }
            throw new IllegalStateException("No lexical factory on " + type.getName());
        }
    };

    private FhirTypes() {
    }

    /**
     * Finds the resource class for a FHIR resource type name. Resource {@code X} is the class {@code X} in package and
     * module {@code se.poroli.fhirplace.r5.<x>}, which must be present at run time.
     *
     * @param resourceType the resource type, such as {@code Patient}
     * @return the resource class
     * @throws IllegalArgumentException if the name is not a resource type or its module is absent
     */
    public static Class<? extends Resource> resourceClass(String resourceType) {
        if (resourceType == null || !TYPE_NAME.matcher(resourceType).matches()) {
            throw new IllegalArgumentException("Invalid resource type: " + resourceType);
        }
        String packageName = MODEL_PACKAGE + resourceType.toLowerCase(Locale.ROOT);
        String className = packageName + "." + resourceType;
        Class<?> type = Optional.ofNullable(FhirTypes.class.getModule().getLayer())
                .flatMap(layer -> layer.findModule(packageName))
                .or(() -> ModuleLayer.boot().findModule(packageName))
                .<Class<?>>map(module -> Class.forName(module, className))
                .orElseGet(() -> load(className));
        if (type == null || !Resource.class.isAssignableFrom(type) || !type.getSimpleName().equals(resourceType)) {
            throw new IllegalArgumentException("Unknown resource type " + resourceType
                    + "; is the module " + packageName + " on the class or module path?");
        }
        return type.asSubclass(Resource.class);
    }

    /**
     * Returns the FHIR resource type name of a resource class.
     *
     * @param type the resource class
     * @return the name, such as {@code Patient}
     */
    public static String resourceType(Class<?> type) {
        return type.getSimpleName();
    }

    /**
     * Returns the datatype class for a FHIR type name as used in choice element suffixes.
     *
     * @param typeName the type name with an upper-case first letter, such as {@code DateTime} or {@code Quantity}
     * @return the datatype class, or {@code null} if there is none
     */
    public static Class<?> dataType(String typeName) {
        Class<?> cached = DATA_TYPES.get(typeName);
        if (cached != null || !TYPE_NAME.matcher(typeName).matches()) {
            return cached;
        }
        for (String name : List.of(DATATYPES_PACKAGE + "Fhir" + typeName, DATATYPES_PACKAGE + typeName)) {
            Class<?> type = loadDataType(name);
            if (type != null && DataType.class.isAssignableFrom(type) && type.isRecord() && type != FhirEnum.class) {
                DATA_TYPES.putIfAbsent(typeName, type);
                return type;
            }
        }
        return null;
    }

    /**
     * Returns the FHIR type name of a datatype class, as used in choice element suffixes.
     *
     * @param type the datatype class
     * @return the type name with an upper-case first letter, such as {@code DateTime}
     */
    public static String typeSuffix(Class<?> type) {
        if (type == FhirEnum.class) {
            return "Code";
        }
        String name = type.getSimpleName();
        return name.startsWith("Fhir") ? name.substring("Fhir".length()) : name;
    }

    /**
     * Creates a primitive from its lexical form, id and extensions.
     *
     * @param type the primitive class
     * @param enumType the enum of a {@code FhirEnum}, otherwise {@code null}
     * @param id the element id, or {@code null}
     * @param extensions the extensions, or {@code null}
     * @param lexical the value in its FHIR lexical form, or {@code null} if the element has only extensions
     * @return the primitive
     * @throws IllegalArgumentException if the lexical form is invalid for the type
     */
    public static PrimitiveType<?> primitive(
            Class<?> type, Class<?> enumType, String id, List<Extension> extensions, String lexical) {
        Constructor<?> constructor = PRIMITIVE_CONSTRUCTORS.get(type);
        Object value = null;
        if (lexical != null) {
            if (type == FhirEnum.class) {
                value = invoke(LEXICAL_PARSERS.get(enumType), lexical);
            } else if (constructor.getParameterTypes()[2] == String.class) {
                value = lexical;
            } else {
                value = parse(type, lexical);
            }
        }
        try {
            return (PrimitiveType<?>) constructor.newInstance(id, extensions, value);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw ModelInfo.unwrap(e);
        }
    }

    private static Object parse(Class<?> type, String lexical) {
        Object parsed = invoke(LEXICAL_PARSERS.get(type), lexical);
        return parsed instanceof PrimitiveType<?> primitive ? primitive.value() : parsed;
    }

    private static Object invoke(Method method, String argument) {
        try {
            return method.invoke(null, argument);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw ModelInfo.unwrap(e);
        }
    }

    /** Loads a class of core's datatypes package, which lives in core itself, with core's own class loader. */
    private static Class<?> loadDataType(String className) {
        try {
            return Class.forName(className, false, FhirTypes.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static Class<?> load(String className) {
        for (ClassLoader loader : new ClassLoader[] {
                Thread.currentThread().getContextClassLoader(), FhirTypes.class.getClassLoader()}) {
            if (loader == null) {
                continue;
            }
            try {
                return Class.forName(className, false, loader);
            } catch (ClassNotFoundException e) {
                // try the next loader
            }
        }
        return null;
    }
}
