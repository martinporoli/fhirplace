/**
 * FHIR R5 CapabilityStatement resource.
 */
module se.poroli.fhirplace.r5.capabilitystatement {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.capabilitystatement;
}
