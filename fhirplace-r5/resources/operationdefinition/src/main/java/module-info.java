/**
 * FHIR R5 OperationDefinition resource.
 */
module se.poroli.fhirplace.r5.operationdefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.operationdefinition;
}
