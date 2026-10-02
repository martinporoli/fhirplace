/**
 * FHIR R5 Permission resource.
 */
module se.poroli.fhirplace.r5.permission {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.permission;
}
