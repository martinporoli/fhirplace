/**
 * FHIR R5 Communication resource.
 */
module se.poroli.fhirplace.r5.communication {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.communication;
}
