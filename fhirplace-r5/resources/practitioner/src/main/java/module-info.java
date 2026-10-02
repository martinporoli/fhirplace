/**
 * FHIR R5 Practitioner resource.
 */
module se.poroli.fhirplace.r5.practitioner {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.practitioner;
}
