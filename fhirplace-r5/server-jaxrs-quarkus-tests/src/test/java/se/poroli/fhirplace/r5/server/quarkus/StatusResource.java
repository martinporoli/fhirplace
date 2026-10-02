package se.poroli.fhirplace.r5.server.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/** An ordinary Jakarta REST resource in the same application as the FHIR API. */
@Path("status")
public class StatusResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String status() {
        return "up";
    }
}
