/**
 * FHIR R5 Claim resource.
 */
module se.poroli.fhirplace.r5.claim {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.claim;
}
