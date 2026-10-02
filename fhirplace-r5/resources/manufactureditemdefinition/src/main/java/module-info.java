/**
 * FHIR R5 ManufacturedItemDefinition resource.
 */
module se.poroli.fhirplace.r5.manufactureditemdefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.manufactureditemdefinition;
}
