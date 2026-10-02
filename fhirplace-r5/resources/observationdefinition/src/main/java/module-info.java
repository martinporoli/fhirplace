/**
 * FHIR R5 ObservationDefinition resource.
 */
module se.poroli.fhirplace.r5.observationdefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.observationdefinition;
}
