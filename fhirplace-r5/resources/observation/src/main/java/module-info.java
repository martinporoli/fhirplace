/**
 * FHIR R5 Observation resource.
 */
module se.poroli.fhirplace.r5.observation {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.observation;
}
