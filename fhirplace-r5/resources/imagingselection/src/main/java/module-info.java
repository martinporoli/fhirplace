/**
 * FHIR R5 ImagingSelection resource.
 */
module se.poroli.fhirplace.r5.imagingselection {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.imagingselection;
}
