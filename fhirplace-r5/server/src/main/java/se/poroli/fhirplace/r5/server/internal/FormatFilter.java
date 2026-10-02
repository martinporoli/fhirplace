package se.poroli.fhirplace.r5.server.internal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.ext.Provider;

/** Lets the {@code _format} parameter override the {@code Accept} header, as FHIR requires. */
@Provider
@PreMatching
@ApplicationScoped
public class FormatFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext request) {
        String format = request.getUriInfo().getQueryParameters().getFirst("_format");
        if (format != null && !format.isBlank()) {
            request.getHeaders().putSingle(HttpHeaders.ACCEPT, FhirMediaTypes.forFormat(format.strip()));
        }
    }
}
