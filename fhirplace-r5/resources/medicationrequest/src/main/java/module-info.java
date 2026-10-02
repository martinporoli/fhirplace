/**
 * FHIR R5 MedicationRequest resource.
 */
module se.poroli.fhirplace.r5.medicationrequest {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.medicationrequest;
}
