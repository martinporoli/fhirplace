/**
 * FHIR R5 DeviceUsage resource.
 */
module se.poroli.fhirplace.r5.deviceusage {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.deviceusage;
}
