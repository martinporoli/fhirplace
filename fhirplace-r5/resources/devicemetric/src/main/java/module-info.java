/**
 * FHIR R5 DeviceMetric resource.
 */
module se.poroli.fhirplace.r5.devicemetric {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.devicemetric;
}
