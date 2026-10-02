/**
 * FHIR R5 Citation resource.
 */
module se.poroli.fhirplace.r5.citation {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.citation;
}
