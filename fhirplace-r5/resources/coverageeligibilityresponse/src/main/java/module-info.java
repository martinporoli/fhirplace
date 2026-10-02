/**
 * FHIR R5 CoverageEligibilityResponse resource.
 */
module se.poroli.fhirplace.r5.coverageeligibilityresponse {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.coverageeligibilityresponse;
}
