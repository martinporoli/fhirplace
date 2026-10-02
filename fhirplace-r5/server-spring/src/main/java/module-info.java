/**
 * Serves a {@link se.poroli.fhirplace.r5.server.FhirServer} in Spring Boot. Adding this module is all the setup
 * needed: its auto-configuration collects the application's {@link se.poroli.fhirplace.r5.server.FhirResource} beans
 * and serves them under {@code fhirplace.server.path}, {@code /fhir} by default.
 */
module se.poroli.fhirplace.r5.server.spring {
    requires transitive se.poroli.fhirplace.r5.server;
    requires jakarta.servlet;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;

    exports se.poroli.fhirplace.r5.server.spring;

    opens se.poroli.fhirplace.r5.server.spring to spring.core, spring.beans, spring.context;
}
