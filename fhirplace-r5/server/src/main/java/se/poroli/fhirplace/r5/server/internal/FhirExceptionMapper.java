package se.poroli.fhirplace.r5.server.internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import se.poroli.fhirplace.r5.server.FhirException;

/** Answers a {@link FhirException} with its status and {@code OperationOutcome}. */
@Provider
@ApplicationScoped
public class FhirExceptionMapper implements ExceptionMapper<FhirException> {

    @Context
    private HttpHeaders headers;

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(FhirException exception) {
        return Response.status(exception.status())
                .entity(exception.outcome(), Responses.pretty(uriInfo))
                .type(FhirMediaTypes.negotiate(headers))
                .build();
    }
}
