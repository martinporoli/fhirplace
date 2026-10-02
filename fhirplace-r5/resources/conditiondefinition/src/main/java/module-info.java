/**
 * FHIR R5 ConditionDefinition resource.
 */
module se.poroli.fhirplace.r5.conditiondefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.conditiondefinition;
}
