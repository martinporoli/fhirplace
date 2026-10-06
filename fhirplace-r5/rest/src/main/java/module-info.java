/**
 * Shared FHIR HTTP errors for clients and servers, independent of any HTTP implementation.
 */
module se.poroli.fhirplace.r5.rest {
    requires transitive se.poroli.fhirplace.r5;
    requires transitive se.poroli.fhirplace.r5.operationoutcome;

    exports se.poroli.fhirplace.r5.rest;
}
