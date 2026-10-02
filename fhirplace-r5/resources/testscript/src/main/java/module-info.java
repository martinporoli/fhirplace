/**
 * FHIR R5 TestScript resource.
 */
module se.poroli.fhirplace.r5.testscript {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.testscript;
}
