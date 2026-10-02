package se.poroli.fhirplace.r5.server;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/** Serves the FHIR API under {@code /fhir}. */
@ApplicationScoped
@ApplicationPath("fhir")
public class TestApplication extends Application {
}
