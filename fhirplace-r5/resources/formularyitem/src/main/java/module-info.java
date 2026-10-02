/**
 * FHIR R5 FormularyItem resource.
 */
module se.poroli.fhirplace.r5.formularyitem {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.formularyitem;
}
