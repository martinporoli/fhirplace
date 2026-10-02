/**
 * FHIR R5 ClaimResponse resource.
 */
module se.poroli.fhirplace.r5.claimresponse {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.claimresponse;
}
