/**
 * FHIR R5 MedicationKnowledge resource.
 */
module se.poroli.fhirplace.r5.medicationknowledge {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.medicationknowledge;
}
