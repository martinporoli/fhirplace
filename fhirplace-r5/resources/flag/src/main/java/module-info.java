/**
 * FHIR R5 Flag resource.
 */
module se.poroli.fhirplace.r5.flag {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.flag;
}
