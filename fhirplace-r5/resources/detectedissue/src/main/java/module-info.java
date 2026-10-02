/**
 * FHIR R5 DetectedIssue resource.
 */
module se.poroli.fhirplace.r5.detectedissue {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.detectedissue;
}
