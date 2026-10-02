/**
 * FHIR R5 Patient resource.
 */
module se.poroli.fhirplace.r5.patient {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.patient;
}
