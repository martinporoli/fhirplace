package se.poroli.fhirplace.r5.server.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.server.DateParam;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirResult;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.ReferenceParam;
import se.poroli.fhirplace.r5.server.Saved;
import se.poroli.fhirplace.r5.server.SearchParam;
import se.poroli.fhirplace.r5.server.StringParam;
import se.poroli.fhirplace.r5.server.TokenParam;
import se.poroli.fhirplace.r5.server.VersionId;

/**
 * The validated handler of one resource type: its bean class and interaction methods.
 *
 * @param resourceType the handled resource class
 * @param beanClass the handler bean class
 * @param methods the interaction methods
 */
record Handler(Class<? extends Resource> resourceType, Class<?> beanClass, Map<Interaction, HandlerMethod> methods) {

    static final Set<Class<?>> SEARCH_PARAMETER_TYPES =
            Set.of(StringParam.class, TokenParam.class, DateParam.class, ReferenceParam.class);

    Handler {
        methods = Map.copyOf(methods);
    }

    String typeName() {
        return resourceType.getSimpleName();
    }

    Optional<HandlerMethod> method(Interaction interaction) {
        return Optional.ofNullable(methods.get(interaction));
    }

    /**
     * Inspects and validates a class annotated with {@link FhirResource}.
     *
     * @throws IllegalStateException describing every problem found
     */
    static Handler inspect(Class<?> beanClass) {
        FhirResource annotation = beanClass.getAnnotation(FhirResource.class);
        if (annotation == null) {
            throw new IllegalStateException(beanClass.getName() + " is not annotated with @FhirResource");
        }
        Class<? extends Resource> resourceType = annotation.value();
        List<String> problems = new ArrayList<>();
        Map<Interaction, HandlerMethod> methods = new EnumMap<>(Interaction.class);
        for (Method method : beanClass.getMethods()) {
            List<Interaction> interactions = Stream.of(Interaction.values())
                    .filter(i -> method.isAnnotationPresent(i.annotation()))
                    .toList();
            if (interactions.isEmpty()) {
                continue;
            }
            String where = beanClass.getName() + "." + method.getName();
            if (interactions.size() > 1) {
                problems.add(where + " has more than one interaction annotation " + interactions);
                continue;
            }
            Interaction interaction = interactions.getFirst();
            if (Modifier.isStatic(method.getModifiers())) {
                problems.add(where + " must not be static");
                continue;
            }
            if (methods.containsKey(interaction)) {
                problems.add(beanClass.getName() + " has more than one " + interaction.displayName() + " method");
                continue;
            }
            List<Binding> bindings = new ArrayList<>();
            for (Parameter parameter : method.getParameters()) {
                bindings.add(binding(parameter, interaction, resourceType, where, problems));
            }
            checkRequired(interaction, bindings, where, problems);
            checkReturnType(method, interaction, resourceType, where, problems);
            methods.put(interaction, new HandlerMethod(interaction, method, bindings));
        }
        if (methods.isEmpty()) {
            problems.add(beanClass.getName() + " has no interaction methods");
        }
        if (!problems.isEmpty()) {
            throw new IllegalStateException("Invalid FHIR handler " + beanClass.getName() + ":\n  - "
                    + String.join("\n  - ", problems));
        }
        return new Handler(resourceType, beanClass, methods);
    }

    private static Binding binding(Parameter parameter, Interaction interaction,
            Class<? extends Resource> resourceType, String where, List<String> problems) {
        String name = where + " parameter " + parameter.getName();
        if (parameter.getType() == FhirRequest.class) {
            return new Binding.Request();
        }
        if (parameter.isAnnotationPresent(Id.class)) {
            if (parameter.getType() != String.class) {
                problems.add(name + ": @Id must be a String");
            }
            if (!Set.of(Interaction.READ, Interaction.VREAD, Interaction.UPDATE, Interaction.DELETE)
                    .contains(interaction)) {
                problems.add(name + ": @Id is not available for " + interaction.displayName());
            }
            return new Binding.Id();
        }
        if (parameter.isAnnotationPresent(VersionId.class)) {
            if (parameter.getType() != String.class) {
                problems.add(name + ": @VersionId must be a String");
            }
            if (interaction != Interaction.VREAD) {
                problems.add(name + ": @VersionId is only available for @VRead");
            }
            return new Binding.VersionId();
        }
        SearchParam search = parameter.getAnnotation(SearchParam.class);
        if (search != null) {
            if (interaction != Interaction.SEARCH) {
                problems.add(name + ": @SearchParam is only available for @Search");
            }
            if (search.value().isBlank() || search.value().contains(":")) {
                problems.add(name + ": invalid search parameter name '" + search.value() + "'");
            }
            Class<?> type = parameter.getType();
            boolean repeating = type == List.class;
            if (repeating) {
                type = elementType(parameter.getParameterizedType());
            }
            if (type == null || !SEARCH_PARAMETER_TYPES.contains(type)) {
                problems.add(name + ": a @SearchParam must be StringParam, TokenParam, DateParam or "
                        + "ReferenceParam, or a List of one of them");
            }
            return new Binding.Search(search.value(), type, repeating);
        }
        if (interaction == Interaction.CREATE || interaction == Interaction.UPDATE) {
            if (parameter.getType() != resourceType && parameter.getType() != Resource.class) {
                problems.add(name + ": the request body parameter must be a " + resourceType.getSimpleName());
            }
            return new Binding.Body();
        }
        problems.add(name + ": unsupported parameter; annotate it with @Id, @VersionId or @SearchParam, or "
                + "declare it as FhirRequest");
        return new Binding.Body();
    }

    private static void checkRequired(Interaction interaction, List<Binding> bindings, String where,
            List<String> problems) {
        long ids = bindings.stream().filter(b -> b instanceof Binding.Id).count();
        long versions = bindings.stream().filter(b -> b instanceof Binding.VersionId).count();
        long bodies = bindings.stream().filter(b -> b instanceof Binding.Body).count();
        boolean needsId = Set.of(Interaction.READ, Interaction.VREAD, Interaction.UPDATE, Interaction.DELETE)
                .contains(interaction);
        if (ids != (needsId ? 1 : 0)) {
            problems.add(where + ": " + interaction.displayName() + " needs " + (needsId ? "exactly one" : "no")
                    + " @Id parameter");
        }
        if (versions != (interaction == Interaction.VREAD ? 1 : 0)) {
            problems.add(where + ": " + interaction.displayName() + " needs "
                    + (interaction == Interaction.VREAD ? "exactly one" : "no") + " @VersionId parameter");
        }
        boolean needsBody = interaction == Interaction.CREATE || interaction == Interaction.UPDATE;
        if (bodies != (needsBody ? 1 : 0)) {
            problems.add(where + ": " + interaction.displayName() + " needs " + (needsBody ? "exactly one" : "no")
                    + " resource parameter");
        }
        List<String> names = bindings.stream()
                .filter(b -> b instanceof Binding.Search)
                .map(b -> ((Binding.Search) b).name())
                .toList();
        if (names.size() != Set.copyOf(names).size()) {
            problems.add(where + ": a search parameter name is bound more than once");
        }
    }

    private static void checkReturnType(Method method, Interaction interaction,
            Class<? extends Resource> resourceType, String where, List<String> problems) {
        Class<?> raw = method.getReturnType();
        Type generic = method.getGenericReturnType();
        boolean result = raw == FhirResult.class && isResource(elementType(generic), resourceType);
        boolean ok = switch (interaction) {
            case READ, VREAD -> resourceType.isAssignableFrom(raw) || result
                    || (raw == Optional.class && isResource(elementType(generic), resourceType));
            case SEARCH -> (raw == List.class || raw == Collection.class || raw == Iterable.class
                    || raw == Stream.class) && isResource(elementType(generic), resourceType);
            case CREATE -> resourceType.isAssignableFrom(raw) || result;
            case UPDATE -> resourceType.isAssignableFrom(raw) || result
                    || (raw == Saved.class && isResource(elementType(generic), resourceType));
            case DELETE -> raw == void.class
                    || (raw == FhirResult.class && isResource(elementType(generic), Resource.class));
        };
        if (!ok) {
            String expected = switch (interaction) {
                case READ, VREAD -> "T, Optional<T> or FhirResult<T>";
                case SEARCH -> "List<T>, Collection<T>, Iterable<T> or Stream<T>";
                case CREATE -> "T or FhirResult<T>";
                case UPDATE -> "T, Saved<T> or FhirResult<T>";
                case DELETE -> "void or FhirResult<R> with R any resource type";
            };
            problems.add(where + ": " + interaction.displayName() + " must return " + expected + " with T = "
                    + resourceType.getSimpleName() + ", not " + generic.getTypeName());
        }
    }

    private static boolean isResource(Class<?> type, Class<? extends Resource> resourceType) {
        return type != null && resourceType.isAssignableFrom(type);
    }

    private static Class<?> elementType(Type type) {
        if (type instanceof ParameterizedType parameterized
                && parameterized.getActualTypeArguments()[0] instanceof Class<?> element) {
            return element;
        }
        if (type instanceof ParameterizedType parameterized
                && parameterized.getActualTypeArguments()[0] instanceof java.lang.reflect.WildcardType wildcard
                && wildcard.getUpperBounds()[0] instanceof Class<?> bound) {
            return bound;
        }
        return null;
    }
}
