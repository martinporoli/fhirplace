/**
 * FHIR R5 ExplanationOfBenefit resource.
 */
module se.poroli.fhirplace.r5.explanationofbenefit {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.explanationofbenefit;
}
