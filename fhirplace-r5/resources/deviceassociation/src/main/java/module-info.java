/**
 * FHIR R5 DeviceAssociation resource.
 */
module se.poroli.fhirplace.r5.deviceassociation {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.deviceassociation;
}
