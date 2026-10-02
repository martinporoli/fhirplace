/**
 * FHIR R5 ArtifactAssessment resource.
 */
module se.poroli.fhirplace.r5.artifactassessment {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.artifactassessment;
}
