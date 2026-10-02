/**
 * FHIR R5 NutritionOrder resource.
 */
module se.poroli.fhirplace.r5.nutritionorder {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.nutritionorder;
}
