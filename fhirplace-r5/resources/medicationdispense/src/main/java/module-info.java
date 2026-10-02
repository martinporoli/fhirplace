/**
 * FHIR R5 MedicationDispense resource.
 */
module se.poroli.fhirplace.r5.medicationdispense {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.medicationdispense;
}
