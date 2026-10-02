/**
 * FHIR R5 Group resource.
 */
module se.poroli.fhirplace.r5.group {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.group;
}
