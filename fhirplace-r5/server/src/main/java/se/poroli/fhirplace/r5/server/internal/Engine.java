package se.poroli.fhirplace.r5.server.internal;

import java.net.URI;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.UUID;
import java.util.stream.Stream;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.bundle.BundleType;
import se.poroli.fhirplace.r5.bundle.LinkRelationTypes;
import se.poroli.fhirplace.r5.bundle.SearchEntryMode;
import se.poroli.fhirplace.r5.capabilitystatement.CapabilityStatement;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirResponse;
import se.poroli.fhirplace.r5.server.Saved;

/** Implements the FHIR RESTful API on top of the validated handlers. Thread-safe. */
public final class Engine {

    private static final java.util.regex.Pattern ID = java.util.regex.Pattern.compile("[A-Za-z0-9\\-.]{1,64}");
    private static final DateTimeFormatter HTTP_DATE =
            DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US).withZone(ZoneOffset.UTC);

    private final Map<String, Registered> handlers;
    private final CapabilityStatement capabilities;

    private Engine(Map<String, Registered> handlers) {
        this.handlers = handlers;
        this.capabilities = Capabilities.of(handlers.values().stream().map(Registered::handler).toList());
    }

    /** A handler with the object to call it on. */
    private record Registered(Handler handler, Object instance) {

        HandlerMethod require(Interaction interaction) {
            return handler.method(interaction).orElseThrow(() -> new FhirException(405, IssueType.NOT_SUPPORTED,
                    "The " + interaction.code().code() + " interaction is not supported for "
                            + handler.typeName()));
        }

        Object call(HandlerMethod method, java.util.function.Function<Binding, Object> arguments) {
            return method.invoke(instance, method.arguments(arguments));
        }
    }

    /** A response before serialization. */
    private record Result(int status, Map<String, List<String>> headers, Resource body) {

        Result(int status, Resource body) {
            this(status, new LinkedHashMap<>(), body);
        }

        Result header(String name, String value) {
            if (value != null) {
                headers.put(name, List.of(value));
            }
            return this;
        }
    }

    /**
     * Validates the handlers and creates the engine.
     *
     * @param handlers objects whose class or a superclass is annotated with {@link FhirResource}
     * @return the engine
     * @throws IllegalStateException listing every problem
     */
    public static Engine create(List<Object> handlers) {
        List<String> problems = new ArrayList<>();
        Map<String, Registered> registered = new TreeMap<>();
        for (Object instance : handlers) {
            Class<?> type = instance.getClass();
            while (type != null && !type.isAnnotationPresent(FhirResource.class)) {
                type = type.getSuperclass();
            }
            if (type == null) {
                problems.add(instance.getClass().getName() + " is not annotated with @FhirResource");
                continue;
            }
            try {
                Handler handler = Handler.inspect(type);
                Registered previous = registered.putIfAbsent(handler.typeName(), new Registered(handler, instance));
                if (previous != null) {
                    problems.add("Both " + previous.handler().beanClass().getName() + " and " + type.getName()
                            + " handle " + handler.typeName());
                }
            } catch (IllegalStateException e) {
                problems.add(e.getMessage());
            }
        }
        if (!problems.isEmpty()) {
            throw new IllegalStateException(String.join("\n", problems));
        }
        return new Engine(java.util.Collections.unmodifiableMap(registered));
    }

    /**
     * Handles one request.
     *
     * @param fhirRequest the request
     * @return the serialized response
     */
    public FhirResponse handle(FhirRequest fhirRequest) {
        Request request = new Request(fhirRequest);
        Formats.Format format = Formats.Format.DEFAULT;
        Result result;
        try {
            format = Formats.negotiate(request);
            result = route(request);
        } catch (FhirException e) {
            result = new Result(e.status(), e.outcome());
        }
        Map<String, List<String>> headers = new LinkedHashMap<>(result.headers());
        byte[] body = new byte[0];
        if (result.body() != null) {
            body = Formats.write(result.body(), format);
            headers.put("Content-Type", List.of(format.mediaType() + ";charset=UTF-8"));
        }
        return new FhirResponse(result.status(), headers, body);
    }

    private Result route(Request request) {
        List<String> path = request.segments;
        String method = request.method;
        if (path.isEmpty()) {
            throw new FhirException(404, IssueType.NOT_SUPPORTED,
                    "System-level interactions (batch, transaction, system search) are not supported");
        }
        if (path.size() == 1 && path.getFirst().equals("metadata")) {
            requireMethod(method, "GET");
            return new Result(200, capabilities);
        }
        Registered handler = handler(path.getFirst());
        String type = path.getFirst();
        switch (path.size()) {
            case 1 -> {
                return switch (method) {
                    case "GET" -> search(request, handler, type, request.parameters);
                    case "POST" -> create(request, handler, type);
                    default -> throw notAllowed(method);
                };
            }
            case 2 -> {
                String id = path.get(1);
                if (id.equals("_search")) {
                    requireMethod(method, "POST");
                    return search(request, handler, type, formAndQuery(request));
                }
                requireId(id);
                return switch (method) {
                    case "GET" -> read(request, handler, type, id);
                    case "PUT" -> update(request, handler, type, id);
                    case "DELETE" -> delete(request, handler, type, id);
                    default -> throw notAllowed(method);
                };
            }
            case 4 -> {
                if (path.get(2).equals("_history")) {
                    requireMethod(method, "GET");
                    return vread(handler, type, requireId(path.get(1)), path.get(3));
                }
            }
            default -> {
                // fall through to not found
            }
        }
        throw new FhirException(404, IssueType.NOT_SUPPORTED, "Unknown or unsupported path '"
                + String.join("/", path) + "'");
    }

    private Registered handler(String type) {
        Registered handler = handlers.get(type);
        if (handler == null) {
            throw new FhirException(404, IssueType.NOT_SUPPORTED,
                    "Resource type '" + type + "' is not supported by this server");
        }
        return handler;
    }

    private Result read(Request request, Registered handler, String type, String id) {
        Resource resource = current(handler, handler.require(Interaction.READ), id)
                .orElseThrow(() -> FhirException.notFound(type, id));
        String ifNoneMatch = request.header("If-None-Match");
        String ifModifiedSince = request.header("If-Modified-Since");
        Instant lastModified = lastModified(resource);
        boolean notModified = ifNoneMatch != null
                ? matches(ifNoneMatch, resource)
                : ifModifiedSince != null && lastModified != null
                        && parseHttpDate(ifModifiedSince).map(since -> !lastModified.isAfter(since)).orElse(false);
        return versioned(new Result(notModified ? 304 : 200, notModified ? null : resource), resource);
    }

    private Result vread(Registered handler, String type, String id, String versionId) {
        HandlerMethod vread = handler.require(Interaction.VREAD);
        if (!ID.matcher(versionId).matches()) {
            throw FhirException.invalid("'" + versionId + "' is not a valid version id");
        }
        Resource resource = resource(handler.call(vread, binding -> binding instanceof Binding.Id ? id : versionId))
                .orElseThrow(() -> new FhirException(404, IssueType.NOT_FOUND,
                        type + "/" + id + "/_history/" + versionId + " is not known"));
        return versioned(new Result(200, resource), resource);
    }

    private Result create(Request request, Registered handler, String type) {
        HandlerMethod create = handler.require(Interaction.CREATE);
        Resource body = body(request, handler);
        Resource created = (Resource) handler.call(create, binding -> body);
        if (created == null || created.id() == null || !ID.matcher(created.id()).matches()) {
            throw new IllegalStateException(create.method() + " must return the stored resource with a valid id");
        }
        Result result = new Result(201, null).header("Location", location(request, type, created));
        return preferredBody(request, versioned(result, created), created, "Created " + type + "/" + created.id());
    }

    private Result update(Request request, Registered handler, String type, String id) {
        HandlerMethod update = handler.require(Interaction.UPDATE);
        Resource body = body(request, handler);
        if (body.id() == null) {
            throw FhirException.invalid("The resource must have an id; it should be '" + id + "'");
        }
        if (!body.id().equals(id)) {
            throw FhirException.invalid("The resource id '" + body.id() + "' does not match the URL id '" + id
                    + "'");
        }
        checkIfMatch(request, handler, type, id);
        Object result = handler.call(update, binding -> binding instanceof Binding.Id ? id : body);
        boolean created = result instanceof Saved<?> saved && saved.created();
        Resource stored = result instanceof Saved<?> saved ? saved.resource() : (Resource) result;
        if (stored == null) {
            throw new IllegalStateException(update.method() + " must return the stored resource");
        }
        Result response = new Result(created ? 201 : 200, null);
        if (created) {
            response.header("Location", location(request, type, stored));
        }
        return preferredBody(request, versioned(response, stored), stored,
                (created ? "Created " : "Updated ") + type + "/" + id);
    }

    private Result delete(Request request, Registered handler, String type, String id) {
        HandlerMethod delete = handler.require(Interaction.DELETE);
        checkIfMatch(request, handler, type, id);
        handler.call(delete, binding -> id);
        return new Result(204, null);
    }

    private Result search(Request request, Registered handler, String type, Map<String, List<String>> parameters) {
        HandlerMethod search = handler.require(Interaction.SEARCH);
        boolean lenient = "lenient".equals(request.preferences().get("handling"));
        SearchParameters.Bound bound = SearchParameters.bind(search, parameters, lenient);
        List<Resource> matches = results(search.invoke(handler.instance(), bound.arguments()));
        String self = request.base + type + (bound.used().isEmpty() ? "" : "?" + bound.query());
        Bundle.Builder bundle = Bundle.builder()
                .id(UUID.randomUUID().toString())
                .type(BundleType.SEARCHSET)
                .timestamp(FhirInstant.of(java.time.OffsetDateTime.now(ZoneOffset.UTC)))
                .total(FhirUnsignedInt.of(matches.size()))
                .addLink(Bundle.Link.builder().relation(LinkRelationTypes.SELF).url(FhirUri.of(self)).build());
        for (Resource match : matches) {
            bundle.addEntry(Bundle.Entry.builder()
                    .fullUrl(match.id() == null ? null : FhirUri.of(request.base + type + "/" + match.id()))
                    .resource(match)
                    .search(Bundle.Entry.Search.builder().mode(SearchEntryMode.MATCH).build())
                    .build());
        }
        return new Result(200, bundle.build());
    }

    /** The parameters of {@code POST [type]/_search}: the URL's and the form body's. */
    private static Map<String, List<String>> formAndQuery(Request request) {
        String contentType = request.header("Content-Type");
        if (request.body.length > 0 && (contentType == null
                || !contentType.toLowerCase(Locale.ROOT).startsWith("application/x-www-form-urlencoded"))) {
            throw new FhirException(415, IssueType.NOT_SUPPORTED,
                    "_search expects an application/x-www-form-urlencoded body");
        }
        Map<String, List<String>> parameters = new LinkedHashMap<>(request.parameters);
        Request.parse(new String(request.body, java.nio.charset.StandardCharsets.UTF_8)).forEach((name, values) ->
                parameters.computeIfAbsent(name, n -> new ArrayList<>()).addAll(values));
        return parameters;
    }

    private static Resource body(Request request, Registered handler) {
        Resource body = Formats.read(request.body, request.header("Content-Type"));
        if (!handler.handler().resourceType().isInstance(body)) {
            throw FhirException.invalid("Expected a " + handler.handler().typeName() + " but got a "
                    + body.getClass().getSimpleName());
        }
        return body;
    }

    /** Checks {@code If-Match} against the current version, which the handler's read method provides. */
    private static void checkIfMatch(Request request, Registered handler, String type, String id) {
        String ifMatch = request.header("If-Match");
        if (ifMatch == null) {
            return;
        }
        HandlerMethod read = handler.handler().method(Interaction.READ).orElseThrow(() -> FhirException.invalid(
                "If-Match is not supported for " + type + " because it has no read interaction"));
        Resource current = current(handler, read, id).orElse(null);
        if (!matches(ifMatch, current)) {
            throw FhirException.preconditionFailed("If-Match " + ifMatch + " does not match the current version"
                    + (current == null ? "; " + type + "/" + id + " does not exist"
                            : " W/\"" + versionId(current) + "\""));
        }
    }

    private static Optional<Resource> current(Registered handler, HandlerMethod read, String id) {
        return resource(handler.call(read, binding -> id));
    }

    private static Result preferredBody(Request request, Result result, Resource resource, String message) {
        String preferred = request.preferences().getOrDefault("return", "representation");
        Resource body = switch (preferred.toLowerCase(Locale.ROOT)) {
            case "minimal" -> null;
            case "operationoutcome" -> OperationOutcome.builder()
                    .addIssue(OperationOutcome.Issue.builder()
                            .severity(IssueSeverity.INFORMATION)
                            .code(IssueType.INFORMATIONAL)
                            .diagnostics(FhirString.of(message))
                            .build())
                    .build();
            default -> resource;
        };
        return new Result(result.status(), result.headers(), body);
    }

    /** Adds {@code ETag} and {@code Last-Modified} from the resource's meta. */
    private static Result versioned(Result result, Resource resource) {
        String version = versionId(resource);
        result.header("ETag", version == null ? null : "W/\"" + version + "\"");
        Instant lastModified = lastModified(resource);
        result.header("Last-Modified", lastModified == null ? null : HTTP_DATE.format(lastModified));
        return result;
    }

    private static String location(Request request, String type, Resource resource) {
        String version = versionId(resource);
        URI location = request.base.resolve(type + "/" + resource.id()
                + (version == null ? "" : "/_history/" + version));
        return location.toString();
    }

    private static String versionId(Resource resource) {
        Meta meta = resource.meta();
        return meta == null || meta.versionId() == null ? null : meta.versionId().value();
    }

    private static Instant lastModified(Resource resource) {
        Meta meta = resource.meta();
        return meta == null || meta.lastUpdated() == null || meta.lastUpdated().value() == null
                ? null : meta.lastUpdated().value().toInstant();
    }

    /** Returns whether one of the entity tags in an {@code If-Match} or {@code If-None-Match} header matches. */
    private static boolean matches(String header, Resource resource) {
        if (header.strip().equals("*")) {
            return resource != null;
        }
        String version = resource == null ? null : versionId(resource);
        if (version == null) {
            return false;
        }
        for (String tag : header.split(",")) {
            String value = tag.strip();
            if (value.startsWith("W/")) {
                value = value.substring(2);
            }
            if (value.length() >= 2 && value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
            if (value.equals(version)) {
                return true;
            }
        }
        return false;
    }

    private static Optional<Instant> parseHttpDate(String value) {
        for (DateTimeFormatter formatter : List.of(HTTP_DATE, DateTimeFormatter.RFC_1123_DATE_TIME)) {
            try {
                return Optional.of(ZonedDateTime.parse(value.strip(), formatter).toInstant());
            } catch (DateTimeParseException e) {
                // try the next format
            }
        }
        return Optional.empty();
    }

    private static String requireId(String id) {
        if (!ID.matcher(id).matches()) {
            throw FhirException.invalid("'" + id + "' is not a valid resource id");
        }
        return id;
    }

    private static void requireMethod(String method, String allowed) {
        if (!method.equals(allowed)) {
            throw notAllowed(method);
        }
    }

    private static FhirException notAllowed(String method) {
        return new FhirException(405, IssueType.NOT_SUPPORTED, "Method " + method + " is not allowed here");
    }

    private static Optional<Resource> resource(Object result) {
        return result instanceof Optional<?> optional ? optional.map(Resource.class::cast)
                : Optional.ofNullable((Resource) result);
    }

    private static List<Resource> results(Object result) {
        List<Resource> matches = new ArrayList<>();
        if (result instanceof Stream<?> stream) {
            try (stream) {
                stream.forEach(r -> matches.add((Resource) r));
            }
        } else if (result instanceof Iterable<?> iterable) {
            iterable.forEach(r -> matches.add((Resource) r));
        }
        return matches;
    }
}
