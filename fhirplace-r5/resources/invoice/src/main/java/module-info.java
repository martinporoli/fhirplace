/**
 * FHIR R5 Invoice resource.
 */
module se.poroli.fhirplace.r5.invoice {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.invoice;
}
