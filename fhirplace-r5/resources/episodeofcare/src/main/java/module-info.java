/**
 * FHIR R5 EpisodeOfCare resource.
 */
module se.poroli.fhirplace.r5.episodeofcare {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.episodeofcare;
}
