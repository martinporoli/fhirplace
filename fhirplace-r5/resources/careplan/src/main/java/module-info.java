/**
 * FHIR R5 CarePlan resource.
 */
module se.poroli.fhirplace.r5.careplan {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.careplan;
}
