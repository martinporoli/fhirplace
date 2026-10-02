/**
 * FHIR R5 Task resource.
 */
module se.poroli.fhirplace.r5.task {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.task;
}
