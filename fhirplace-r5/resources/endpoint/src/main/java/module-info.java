/**
 * FHIR R5 Endpoint resource.
 */
module se.poroli.fhirplace.r5.endpoint {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.endpoint;
}
