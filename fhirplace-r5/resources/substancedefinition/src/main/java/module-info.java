/**
 * FHIR R5 SubstanceDefinition resource.
 */
module se.poroli.fhirplace.r5.substancedefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.substancedefinition;
}
