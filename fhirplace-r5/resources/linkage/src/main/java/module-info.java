/**
 * FHIR R5 Linkage resource.
 */
module se.poroli.fhirplace.r5.linkage {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.linkage;
}
