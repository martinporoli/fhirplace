/**
 * FHIR R5 Substance resource.
 */
module se.poroli.fhirplace.r5.substance {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.substance;
}
