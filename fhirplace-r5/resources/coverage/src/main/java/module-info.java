/**
 * FHIR R5 Coverage resource.
 */
module se.poroli.fhirplace.r5.coverage {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.coverage;
}
