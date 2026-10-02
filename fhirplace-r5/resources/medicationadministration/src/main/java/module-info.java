/**
 * FHIR R5 MedicationAdministration resource.
 */
module se.poroli.fhirplace.r5.medicationadministration {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.medicationadministration;
}
