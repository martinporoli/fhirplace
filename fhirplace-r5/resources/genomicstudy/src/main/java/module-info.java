/**
 * FHIR R5 GenomicStudy resource.
 */
module se.poroli.fhirplace.r5.genomicstudy {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.genomicstudy;
}
