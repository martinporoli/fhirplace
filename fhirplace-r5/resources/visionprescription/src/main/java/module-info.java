/**
 * FHIR R5 VisionPrescription resource.
 */
module se.poroli.fhirplace.r5.visionprescription {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.visionprescription;
}
