/**
 * FHIR R5 List resource.
 */
module se.poroli.fhirplace.r5.list {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.list;
}
