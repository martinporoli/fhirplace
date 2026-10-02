/**
 * FHIR R5 NutritionIntake resource.
 */
module se.poroli.fhirplace.r5.nutritionintake {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.nutritionintake;
}
