/**
 * FHIR R5 Transport resource.
 */
module se.poroli.fhirplace.r5.transport {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.transport;
}
