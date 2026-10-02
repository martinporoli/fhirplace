/**
 * FHIR R5 ResearchStudy resource.
 */
module se.poroli.fhirplace.r5.researchstudy {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.researchstudy;
}
