/**
 * FHIR R5 Appointment resource.
 */
module se.poroli.fhirplace.r5.appointment {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.appointment;
}
