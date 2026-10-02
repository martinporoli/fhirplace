/**
 * FHIR R5 RESTful server for MicroProfile runtimes. Applications implement FHIR interactions as CDI beans annotated
 * with {@link se.poroli.fhirplace.r5.server.FhirResource}; this module serves them under the application's Jakarta
 * REST path, following the FHIR RESTful API.
 */
module se.poroli.fhirplace.r5.server {
    requires transitive se.poroli.fhirplace.r5;
    requires transitive se.poroli.fhirplace.r5.operationoutcome;
    requires se.poroli.fhirplace.r5.bundle;
    requires se.poroli.fhirplace.r5.capabilitystatement;
    requires jakarta.ws.rs;
    requires jakarta.cdi;
    requires jakarta.inject;
    requires jakarta.json;

    exports se.poroli.fhirplace.r5.server;

    opens se.poroli.fhirplace.r5.server.internal;
}
