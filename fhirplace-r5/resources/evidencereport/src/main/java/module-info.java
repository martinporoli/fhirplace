/**
 * FHIR R5 EvidenceReport resource.
 */
module se.poroli.fhirplace.r5.evidencereport {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.evidencereport;
}
