/**
 * FHIR R5 MessageDefinition resource.
 */
module se.poroli.fhirplace.r5.messagedefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.messagedefinition;
}
