/**
 * FHIR R5 TestReport resource.
 */
module se.poroli.fhirplace.r5.testreport {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.testreport;
}
