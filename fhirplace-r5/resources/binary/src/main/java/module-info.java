/**
 * FHIR R5 Binary resource.
 */
module se.poroli.fhirplace.r5.binary {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.binary;
}
