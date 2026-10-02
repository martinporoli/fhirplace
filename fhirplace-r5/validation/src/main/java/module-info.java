/**
 * Profiles as code: {@link se.poroli.fhirplace.r5.validation.Validator}s of typed rules over the FHIR model, with
 * results that become OperationOutcomes.
 */
module se.poroli.fhirplace.r5.validation {
    requires transitive se.poroli.fhirplace.r5;
    requires transitive se.poroli.fhirplace.r5.operationoutcome;

    exports se.poroli.fhirplace.r5.validation;
}
