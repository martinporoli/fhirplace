/**
 * FHIR R5 Evidence resource.
 */
module se.poroli.fhirplace.r5.evidence {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.evidence;
}
