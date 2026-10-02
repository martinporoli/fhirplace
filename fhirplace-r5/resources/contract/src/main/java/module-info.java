/**
 * FHIR R5 Contract resource.
 */
module se.poroli.fhirplace.r5.contract {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.contract;
}
