/**
 * FHIR R5 Ingredient resource.
 */
module se.poroli.fhirplace.r5.ingredient {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.ingredient;
}
