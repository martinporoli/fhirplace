/**
 * FHIR R5 ImmunizationRecommendation resource.
 */
module se.poroli.fhirplace.r5.immunizationrecommendation {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.immunizationrecommendation;
}
