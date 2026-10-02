/**
 * FHIR R5 RESTful server, independent of any web framework. Applications implement FHIR interactions in classes
 * annotated with {@link se.poroli.fhirplace.r5.server.FhirResource}; {@link se.poroli.fhirplace.r5.server.FhirServer}
 * serves them. The modules {@code fhirplace-r5-server-jaxrs} (MicroProfile) and {@code fhirplace-r5-server-spring}
 * (Spring Boot) connect it to a web framework.
 */
module se.poroli.fhirplace.r5.server {
    requires transitive se.poroli.fhirplace.r5;
    requires transitive se.poroli.fhirplace.r5.operationoutcome;
    requires transitive se.poroli.fhirplace.r5.validation;
    requires se.poroli.fhirplace.r5.bundle;
    requires se.poroli.fhirplace.r5.capabilitystatement;
    requires jakarta.json;

    exports se.poroli.fhirplace.r5.server;
}
