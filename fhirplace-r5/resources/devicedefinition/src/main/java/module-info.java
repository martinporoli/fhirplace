/**
 * FHIR R5 DeviceDefinition resource.
 */
module se.poroli.fhirplace.r5.devicedefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.devicedefinition;
}
