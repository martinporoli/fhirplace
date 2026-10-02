/**
 * FHIR R5 InsurancePlan resource.
 */
module se.poroli.fhirplace.r5.insuranceplan {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.insuranceplan;
}
