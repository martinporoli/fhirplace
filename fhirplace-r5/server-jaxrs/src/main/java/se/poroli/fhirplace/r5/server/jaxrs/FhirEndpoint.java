package se.poroli.fhirplace.r5.server.jaxrs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResponse;

/**
 * Passes every request under the application's Jakarta REST path to the {@link se.poroli.fhirplace.r5.server.FhirServer}.
 * Other resource classes with literal paths take precedence, so applications can serve non-FHIR endpoints too.
 */
@Path("")
@ApplicationScoped
public class FhirEndpoint {

    @Inject
    FhirServerBean server;

    /** Creates the endpoint; the container creates it and injects the server. */
    public FhirEndpoint() {
    }

    /**
     * Handles {@code GET}.
     *
     * @param uriInfo the request URI
     * @param headers the request headers
     * @param request the request
     * @return the FHIR response
     */
    @GET
    @Path("{path: .*}")
    public Response get(@Context UriInfo uriInfo, @Context HttpHeaders headers, @Context Request request) {
        return handle(request.getMethod(), uriInfo, headers, new byte[0]);
    }

    /**
     * Handles {@code POST}.
     *
     * @param uriInfo the request URI
     * @param headers the request headers
     * @param body the request body
     * @return the FHIR response
     */
    @POST
    @Path("{path: .*}")
    public Response post(@Context UriInfo uriInfo, @Context HttpHeaders headers, byte[] body) {
        return handle("POST", uriInfo, headers, body);
    }

    /**
     * Handles {@code PUT}.
     *
     * @param uriInfo the request URI
     * @param headers the request headers
     * @param body the request body
     * @return the FHIR response
     */
    @PUT
    @Path("{path: .*}")
    public Response put(@Context UriInfo uriInfo, @Context HttpHeaders headers, byte[] body) {
        return handle("PUT", uriInfo, headers, body);
    }

    /**
     * Handles {@code PATCH}.
     *
     * @param uriInfo the request URI
     * @param headers the request headers
     * @param body the request body
     * @return the FHIR response
     */
    @PATCH
    @Path("{path: .*}")
    public Response patch(@Context UriInfo uriInfo, @Context HttpHeaders headers, byte[] body) {
        return handle("PATCH", uriInfo, headers, body);
    }

    /**
     * Handles {@code DELETE}.
     *
     * @param uriInfo the request URI
     * @param headers the request headers
     * @return the FHIR response
     */
    @DELETE
    @Path("{path: .*}")
    public Response delete(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
        return handle("DELETE", uriInfo, headers, new byte[0]);
    }

    private Response handle(String method, UriInfo uriInfo, HttpHeaders headers, byte[] body) {
        FhirResponse response = server.server().handle(new FhirRequest(method, rawPath(uriInfo),
                uriInfo.getRequestUri().getRawQuery(), headers.getRequestHeaders(), body == null ? new byte[0] : body,
                uriInfo.getBaseUri()));
        Response.ResponseBuilder builder = Response.status(response.status());
        response.headers().forEach((name, values) -> values.forEach(value -> builder.header(name, value)));
        if (response.body().length > 0) {
            builder.entity(response.body());
        }
        return builder.build();
    }

    /** The still-encoded path below the base; derived from the URIs because not every runtime offers it directly. */
    private static String rawPath(UriInfo uriInfo) {
        java.net.URI relative = uriInfo.getBaseUri().relativize(uriInfo.getRequestUri());
        return relative.isAbsolute() || relative.getRawPath() == null ? "" : relative.getRawPath();
    }
}
