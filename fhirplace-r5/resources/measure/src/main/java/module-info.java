/**
 * FHIR R5 Measure resource.
 */
module se.poroli.fhirplace.r5.measure {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.measure;
}
