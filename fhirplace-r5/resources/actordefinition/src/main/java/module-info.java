/**
 * FHIR R5 ActorDefinition resource.
 */
module se.poroli.fhirplace.r5.actordefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.actordefinition;
}
