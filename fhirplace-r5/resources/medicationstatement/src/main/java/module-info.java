/**
 * FHIR R5 MedicationStatement resource.
 */
module se.poroli.fhirplace.r5.medicationstatement {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.medicationstatement;
}
