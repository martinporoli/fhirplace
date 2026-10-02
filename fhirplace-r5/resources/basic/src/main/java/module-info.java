/**
 * FHIR R5 Basic resource.
 */
module se.poroli.fhirplace.r5.basic {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.basic;
}
