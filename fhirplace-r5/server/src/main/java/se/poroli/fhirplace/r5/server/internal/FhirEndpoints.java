package se.poroli.fhirplace.r5.server.internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.bundle.BundleType;
import se.poroli.fhirplace.r5.bundle.LinkRelationTypes;
import se.poroli.fhirplace.r5.bundle.SearchEntryMode;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.server.Saved;

/** Routes the FHIR RESTful API to the registered handlers. */
@Path("")
@ApplicationScoped
@Produces({FhirMediaTypes.FHIR_JSON, FhirMediaTypes.FHIR_XML, MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class FhirEndpoints {

    private static final String[] FHIR_BODY = {FhirMediaTypes.FHIR_JSON, FhirMediaTypes.FHIR_XML,
            MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML};

    private final HandlerRegistry registry;
    private final Capabilities capabilities;

    /**
     * Creates the endpoints.
     *
     * @param registry the handlers
     * @param capabilities the CapabilityStatement
     */
    @Inject
    public FhirEndpoints(HandlerRegistry registry, Capabilities capabilities) {
        this.registry = registry;
        this.capabilities = capabilities;
    }

    /** CDI proxy constructor. */
    protected FhirEndpoints() {
        this(null, null);
    }

    /**
     * The {@code capabilities} interaction.
     *
     * @param uriInfo the request URI
     * @return the CapabilityStatement
     */
    @GET
    @Path("metadata")
    public Response metadata(@Context UriInfo uriInfo) {
        return Response.ok().entity(capabilities.statement(), Responses.pretty(uriInfo)).build();
    }

    /**
     * The {@code read} interaction.
     *
     * @param type the resource type
     * @param id the logical id
     * @param uriInfo the request URI
     * @param headers the request headers
     * @param request the request, for date preconditions
     * @return the resource, 304 if not modified, or 404
     */
    @GET
    @Path("{type}/{id}")
    public Response read(@PathParam("type") String type, @PathParam("id") String id, @Context UriInfo uriInfo,
            @Context HttpHeaders headers, @Context Request request) {
        HandlerRegistry.Registered handler = registry.require(type);
        HandlerMethod read = handler.require(Interaction.READ);
        Resource resource = read(handler, read, type, requireId(id));
        String ifNoneMatch = headers.getHeaderString(HttpHeaders.IF_NONE_MATCH);
        if (ifNoneMatch != null && Responses.matches(ifNoneMatch, resource)) {
            return Responses.versionHeaders(Response.notModified(), resource).build();
        }
        Date lastModified = Responses.lastModified(resource);
        if (ifNoneMatch == null && lastModified != null) {
            Response.ResponseBuilder notModified = request.evaluatePreconditions(lastModified);
            if (notModified != null) {
                return Responses.versionHeaders(notModified, resource).build();
            }
        }
        return Responses.versionHeaders(Response.ok().entity(resource, Responses.pretty(uriInfo)), resource).build();
    }

    /**
     * The {@code vread} interaction.
     *
     * @param type the resource type
     * @param id the logical id
     * @param versionId the version id
     * @param uriInfo the request URI
     * @return the resource version, or 404
     */
    @GET
    @Path("{type}/{id}/_history/{vid}")
    public Response vread(@PathParam("type") String type, @PathParam("id") String id,
            @PathParam("vid") String versionId, @Context UriInfo uriInfo) {
        HandlerRegistry.Registered handler = registry.require(type);
        HandlerMethod vread = handler.require(Interaction.VREAD);
        requireId(id);
        if (!Responses.isValidId(versionId)) {
            throw FhirException.invalid("'" + versionId + "' is not a valid version id");
        }
        Object result = vread.invoke(handler.instance(), vread.arguments(binding -> switch (binding) {
            case Binding.Id ignored -> id;
            case Binding.VersionId ignored -> versionId;
            default -> throw new IllegalStateException();
        }));
        Resource resource = resource(result).orElseThrow(() ->
                new FhirException(404, IssueType.NOT_FOUND, type + "/" + id + "/_history/" + versionId
                        + " is not known"));
        return Responses.versionHeaders(Response.ok().entity(resource, Responses.pretty(uriInfo)), resource).build();
    }

    /**
     * The {@code search} interaction with parameters in the URL.
     *
     * @param type the resource type
     * @param uriInfo the request URI with the search parameters
     * @param headers the request headers
     * @return a searchset Bundle
     */
    @GET
    @Path("{type}")
    public Response search(@PathParam("type") String type, @Context UriInfo uriInfo, @Context HttpHeaders headers) {
        return search(type, uriInfo.getQueryParameters(), uriInfo, headers);
    }

    /**
     * The {@code search} interaction with parameters in a form body, and optionally the URL.
     *
     * @param type the resource type
     * @param form the form parameters
     * @param uriInfo the request URI
     * @param headers the request headers
     * @return a searchset Bundle
     */
    @POST
    @Path("{type}/_search")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response searchPost(@PathParam("type") String type, MultivaluedMap<String, String> form,
            @Context UriInfo uriInfo, @Context HttpHeaders headers) {
        MultivaluedMap<String, String> parameters = new MultivaluedHashMap<>(uriInfo.getQueryParameters());
        form.forEach(parameters::addAll);
        return search(type, parameters, uriInfo, headers);
    }

    /**
     * The {@code create} interaction.
     *
     * @param type the resource type
     * @param body the resource to create
     * @param uriInfo the request URI
     * @param headers the request headers
     * @return 201 with the created resource as the client prefers
     */
    @POST
    @Path("{type}")
    @Consumes({FhirMediaTypes.FHIR_JSON, FhirMediaTypes.FHIR_XML, MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response create(@PathParam("type") String type, Resource body, @Context UriInfo uriInfo,
            @Context HttpHeaders headers) {
        HandlerRegistry.Registered handler = registry.require(type);
        HandlerMethod create = handler.require(Interaction.CREATE);
        requireBody(handler, body);
        Resource created = (Resource) create.invoke(handler.instance(), create.arguments(binding -> body));
        if (created == null || !Responses.isValidId(created.id())) {
            throw new IllegalStateException(create.method() + " must return the stored resource with a valid id");
        }
        Response.ResponseBuilder response = Response.status(Response.Status.CREATED)
                .location(Responses.location(uriInfo, type, created));
        return withPreferredBody(Responses.versionHeaders(response, created), created, "Created " + type + "/"
                + created.id(), uriInfo, headers).build();
    }

    /**
     * The {@code update} interaction.
     *
     * @param type the resource type
     * @param id the logical id
     * @param body the new content
     * @param uriInfo the request URI
     * @param headers the request headers
     * @return 200, or 201 if the update created the resource
     */
    @PUT
    @Path("{type}/{id}")
    @Consumes({FhirMediaTypes.FHIR_JSON, FhirMediaTypes.FHIR_XML, MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response update(@PathParam("type") String type, @PathParam("id") String id, Resource body,
            @Context UriInfo uriInfo, @Context HttpHeaders headers) {
        HandlerRegistry.Registered handler = registry.require(type);
        HandlerMethod update = handler.require(Interaction.UPDATE);
        requireId(id);
        requireBody(handler, body);
        if (body.id() == null) {
            throw FhirException.invalid("The resource must have an id; it should be '" + id + "'");
        }
        if (!body.id().equals(id)) {
            throw FhirException.invalid("The resource id '" + body.id() + "' does not match the URL id '" + id
                    + "'");
        }
        checkIfMatch(handler, type, id, headers);
        Object result = update.invoke(handler.instance(), update.arguments(binding -> switch (binding) {
            case Binding.Id ignored -> id;
            case Binding.Body ignored -> body;
            default -> throw new IllegalStateException();
        }));
        boolean created = result instanceof Saved<?> saved && saved.created();
        Resource stored = result instanceof Saved<?> saved ? saved.resource() : (Resource) result;
        if (stored == null) {
            throw new IllegalStateException(update.method() + " must return the stored resource");
        }
        Response.ResponseBuilder response = created
                ? Response.status(Response.Status.CREATED).location(Responses.location(uriInfo, type, stored))
                : Response.ok();
        return withPreferredBody(Responses.versionHeaders(response, stored), stored,
                (created ? "Created " : "Updated ") + type + "/" + id, uriInfo, headers).build();
    }

    /**
     * The {@code delete} interaction.
     *
     * @param type the resource type
     * @param id the logical id
     * @param headers the request headers
     * @return 204
     */
    @DELETE
    @Path("{type}/{id}")
    public Response delete(@PathParam("type") String type, @PathParam("id") String id,
            @Context HttpHeaders headers) {
        HandlerRegistry.Registered handler = registry.require(type);
        HandlerMethod delete = handler.require(Interaction.DELETE);
        requireId(id);
        checkIfMatch(handler, type, id, headers);
        delete.invoke(handler.instance(), delete.arguments(binding -> id));
        return Response.noContent().build();
    }

    private Response search(String type, Map<String, List<String>> parameters, UriInfo uriInfo,
            HttpHeaders headers) {
        HandlerRegistry.Registered handler = registry.require(type);
        HandlerMethod search = handler.require(Interaction.SEARCH);
        boolean lenient = "lenient".equals(Responses.preferences(headers).get("handling"));
        SearchParameters.Bound bound = SearchParameters.bind(search, parameters, lenient);
        List<Resource> matches = results(search.invoke(handler.instance(), bound.arguments()));
        String self = uriInfo.getBaseUri() + type + (bound.used().isEmpty() ? "" : "?" + bound.query());
        Bundle.Builder bundle = Bundle.builder()
                .id(UUID.randomUUID().toString())
                .type(BundleType.SEARCHSET)
                .timestamp(FhirInstant.of(OffsetDateTime.now(ZoneOffset.UTC)))
                .total(FhirUnsignedInt.of(matches.size()))
                .addLink(Bundle.Link.builder().relation(LinkRelationTypes.SELF).url(FhirUri.of(self)).build());
        for (Resource match : matches) {
            bundle.addEntry(Bundle.Entry.builder()
                    .fullUrl(match.id() == null ? null : FhirUri.of(uriInfo.getBaseUri() + type + "/" + match.id()))
                    .resource(match)
                    .search(Bundle.Entry.Search.builder().mode(SearchEntryMode.MATCH).build())
                    .build());
        }
        return Response.ok().entity(bundle.build(), Responses.pretty(uriInfo)).build();
    }

    private static Resource read(HandlerRegistry.Registered handler, HandlerMethod read, String type, String id) {
        return resource(read.invoke(handler.instance(), read.arguments(binding -> id)))
                .orElseThrow(() -> FhirException.notFound(type, id));
    }

    /** Checks {@code If-Match} against the current version, which the handler's read method provides. */
    private static void checkIfMatch(HandlerRegistry.Registered handler, String type, String id,
            HttpHeaders headers) {
        String ifMatch = headers.getHeaderString(HttpHeaders.IF_MATCH);
        if (ifMatch == null) {
            return;
        }
        HandlerMethod read = handler.method(Interaction.READ).orElseThrow(() -> FhirException.invalid(
                "If-Match is not supported for " + type + " because it has no read interaction"));
        Resource current = resource(read.invoke(handler.instance(), read.arguments(binding -> id))).orElse(null);
        if (!Responses.matches(ifMatch, current)) {
            throw FhirException.preconditionFailed("If-Match " + ifMatch + " does not match the current version"
                    + (current == null ? "; " + type + "/" + id + " does not exist"
                            : " W/\"" + Responses.versionId(current) + "\""));
        }
    }

    private static Response.ResponseBuilder withPreferredBody(Response.ResponseBuilder response, Resource resource,
            String message, UriInfo uriInfo, HttpHeaders headers) {
        String preferred = Responses.preferences(headers).getOrDefault("return", "representation");
        return switch (preferred) {
            case "minimal" -> response;
            case "OperationOutcome", "operationoutcome" -> response.entity(OperationOutcome.builder()
                    .addIssue(OperationOutcome.Issue.builder()
                            .severity(IssueSeverity.INFORMATION)
                            .code(IssueType.INFORMATIONAL)
                            .diagnostics(FhirString.of(message))
                            .build())
                    .build(), Responses.pretty(uriInfo));
            default -> response.entity(resource, Responses.pretty(uriInfo));
        };
    }

    private static void requireBody(HandlerRegistry.Registered handler, Resource body) {
        if (body == null) {
            throw FhirException.invalid("A " + handler.handler().typeName() + " is required as request body");
        }
        if (!handler.handler().resourceType().isInstance(body)) {
            throw FhirException.invalid("Expected a " + handler.handler().typeName() + " but got a "
                    + body.getClass().getSimpleName());
        }
    }

    private static String requireId(String id) {
        if (!Responses.isValidId(id)) {
            throw FhirException.invalid("'" + id + "' is not a valid resource id");
        }
        return id;
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
