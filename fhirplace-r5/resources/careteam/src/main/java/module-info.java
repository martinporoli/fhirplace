/**
 * FHIR R5 CareTeam resource.
 */
module se.poroli.fhirplace.r5.careteam {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.careteam;
}
