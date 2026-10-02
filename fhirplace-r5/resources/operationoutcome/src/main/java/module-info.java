/**
 * FHIR R5 OperationOutcome resource.
 */
module se.poroli.fhirplace.r5.operationoutcome {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.operationoutcome;
}
