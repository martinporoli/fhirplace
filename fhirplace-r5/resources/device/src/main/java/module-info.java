/**
 * FHIR R5 Device resource.
 */
module se.poroli.fhirplace.r5.device {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.device;
}
