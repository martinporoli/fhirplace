/**
 * FHIR R5 RESTful client on the JDK's {@code java.net.http.HttpClient}:
 * {@link se.poroli.fhirplace.r5.client.FhirClient} for typed interactions, and FHIR body handlers and publishers for
 * plain {@code HttpClient} code.
 */
module se.poroli.fhirplace.r5.client {
    requires transitive java.net.http;
    requires transitive se.poroli.fhirplace.r5;
    requires transitive se.poroli.fhirplace.r5.bundle;
    requires transitive se.poroli.fhirplace.r5.operationoutcome;
    requires transitive se.poroli.fhirplace.r5.rest;
    requires jakarta.json;

    exports se.poroli.fhirplace.r5.client;
}
