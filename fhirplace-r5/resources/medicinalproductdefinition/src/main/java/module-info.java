/**
 * FHIR R5 MedicinalProductDefinition resource.
 */
module se.poroli.fhirplace.r5.medicinalproductdefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.medicinalproductdefinition;
}
