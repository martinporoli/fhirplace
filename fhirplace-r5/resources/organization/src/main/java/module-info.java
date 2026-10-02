/**
 * FHIR R5 Organization resource.
 */
module se.poroli.fhirplace.r5.organization {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.organization;
}
