/**
 * FHIR R5 CompartmentDefinition resource.
 */
module se.poroli.fhirplace.r5.compartmentdefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.compartmentdefinition;
}
