/**
 * FHIR R5 Procedure resource.
 */
module se.poroli.fhirplace.r5.procedure {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.procedure;
}
