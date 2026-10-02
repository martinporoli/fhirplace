/**
 * FHIR R5 ImagingStudy resource.
 */
module se.poroli.fhirplace.r5.imagingstudy {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.imagingstudy;
}
