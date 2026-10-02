/**
 * FHIR R5 CodeSystem resource.
 */
module se.poroli.fhirplace.r5.codesystem {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.codesystem;
}
