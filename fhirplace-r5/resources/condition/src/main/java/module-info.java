/**
 * FHIR R5 Condition resource.
 */
module se.poroli.fhirplace.r5.condition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.condition;
}
