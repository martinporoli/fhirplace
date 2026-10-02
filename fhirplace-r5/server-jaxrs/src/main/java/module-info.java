/**
 * Serves a {@link se.poroli.fhirplace.r5.server.FhirServer} with Jakarta REST and CDI, as on MicroProfile runtimes.
 * Adding this module is all the setup needed: it collects the application's
 * {@link se.poroli.fhirplace.r5.server.FhirResource} beans at startup and serves them under the application's Jakarta
 * REST path.
 */
module se.poroli.fhirplace.r5.server.jaxrs {
    requires transitive se.poroli.fhirplace.r5.server;
    requires jakarta.ws.rs;
    requires jakarta.cdi;
    requires jakarta.inject;

    opens se.poroli.fhirplace.r5.server.jaxrs;
}
