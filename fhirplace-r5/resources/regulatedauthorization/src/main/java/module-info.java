/**
 * FHIR R5 RegulatedAuthorization resource.
 */
module se.poroli.fhirplace.r5.regulatedauthorization {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.regulatedauthorization;
}
