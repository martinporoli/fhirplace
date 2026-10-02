/**
 * FHIR R5 CoverageEligibilityRequest resource.
 */
module se.poroli.fhirplace.r5.coverageeligibilityrequest {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.coverageeligibilityrequest;
}
