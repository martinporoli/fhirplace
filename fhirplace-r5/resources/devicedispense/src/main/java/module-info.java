/**
 * FHIR R5 DeviceDispense resource.
 */
module se.poroli.fhirplace.r5.devicedispense {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.devicedispense;
}
