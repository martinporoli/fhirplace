/**
 * FHIR R5 Schedule resource.
 */
module se.poroli.fhirplace.r5.schedule {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.schedule;
}
