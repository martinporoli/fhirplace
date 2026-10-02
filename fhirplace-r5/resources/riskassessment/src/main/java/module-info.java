/**
 * FHIR R5 RiskAssessment resource.
 */
module se.poroli.fhirplace.r5.riskassessment {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.riskassessment;
}
