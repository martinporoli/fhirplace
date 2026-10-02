/**
 * FHIR R5 DeviceRequest resource.
 */
module se.poroli.fhirplace.r5.devicerequest {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.devicerequest;
}
