/**
 * FHIR R5 GuidanceResponse resource.
 */
module se.poroli.fhirplace.r5.guidanceresponse {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.guidanceresponse;
}
