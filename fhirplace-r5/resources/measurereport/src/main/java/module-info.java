/**
 * FHIR R5 MeasureReport resource.
 */
module se.poroli.fhirplace.r5.measurereport {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.measurereport;
}
