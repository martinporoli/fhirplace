/**
 * FHIR R5 TerminologyCapabilities resource.
 */
module se.poroli.fhirplace.r5.terminologycapabilities {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.terminologycapabilities;
}
