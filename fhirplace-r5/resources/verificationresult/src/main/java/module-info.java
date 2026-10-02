/**
 * FHIR R5 VerificationResult resource.
 */
module se.poroli.fhirplace.r5.verificationresult {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.verificationresult;
}
