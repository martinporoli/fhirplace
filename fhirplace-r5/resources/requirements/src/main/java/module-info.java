/**
 * FHIR R5 Requirements resource.
 */
module se.poroli.fhirplace.r5.requirements {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.requirements;
}
