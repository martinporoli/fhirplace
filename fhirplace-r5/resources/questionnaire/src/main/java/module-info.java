/**
 * FHIR R5 Questionnaire resource.
 */
module se.poroli.fhirplace.r5.questionnaire {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.questionnaire;
}
