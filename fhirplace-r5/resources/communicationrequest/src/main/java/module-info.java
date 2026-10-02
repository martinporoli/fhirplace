/**
 * FHIR R5 CommunicationRequest resource.
 */
module se.poroli.fhirplace.r5.communicationrequest {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.communicationrequest;
}
