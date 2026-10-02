package se.poroli.fhirplace.r5.server.jaxrs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/** An ordinary Jakarta REST resource in the same application as the FHIR API. */
@ApplicationScoped
@Path("status")
public class StatusResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String status() {
        return "up";
    }
}
