/**
 * FHIR R5 BiologicallyDerivedProduct resource.
 */
module se.poroli.fhirplace.r5.biologicallyderivedproduct {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.biologicallyderivedproduct;
}
