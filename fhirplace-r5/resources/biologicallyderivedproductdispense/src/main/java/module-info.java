/**
 * FHIR R5 BiologicallyDerivedProductDispense resource.
 */
module se.poroli.fhirplace.r5.biologicallyderivedproductdispense {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.biologicallyderivedproductdispense;
}
