/**
 * FHIR R5 ResearchSubject resource.
 */
module se.poroli.fhirplace.r5.researchsubject {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.researchsubject;
}
