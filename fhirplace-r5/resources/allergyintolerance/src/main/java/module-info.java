/**
 * FHIR R5 AllergyIntolerance resource.
 */
module se.poroli.fhirplace.r5.allergyintolerance {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.allergyintolerance;
}
