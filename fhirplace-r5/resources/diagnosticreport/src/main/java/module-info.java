/**
 * FHIR R5 DiagnosticReport resource.
 */
module se.poroli.fhirplace.r5.diagnosticreport {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.diagnosticreport;
}
