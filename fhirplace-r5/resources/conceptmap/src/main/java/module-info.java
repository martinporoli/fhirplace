/**
 * FHIR R5 ConceptMap resource.
 */
module se.poroli.fhirplace.r5.conceptmap {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.conceptmap;
}
