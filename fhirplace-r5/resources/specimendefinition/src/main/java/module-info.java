/**
 * FHIR R5 SpecimenDefinition resource.
 */
module se.poroli.fhirplace.r5.specimendefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.specimendefinition;
}
