/**
 * FHIR R5 MessageHeader resource.
 */
module se.poroli.fhirplace.r5.messageheader {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.messageheader;
}
