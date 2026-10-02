/**
 * FHIR R5 DocumentReference resource.
 */
module se.poroli.fhirplace.r5.documentreference {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.documentreference;
}
