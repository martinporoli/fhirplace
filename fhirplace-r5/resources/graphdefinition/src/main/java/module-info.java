/**
 * FHIR R5 GraphDefinition resource.
 */
module se.poroli.fhirplace.r5.graphdefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.graphdefinition;
}
