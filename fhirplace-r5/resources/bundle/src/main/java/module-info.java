/**
 * FHIR R5 Bundle resource.
 */
module se.poroli.fhirplace.r5.bundle {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.bundle;
}
