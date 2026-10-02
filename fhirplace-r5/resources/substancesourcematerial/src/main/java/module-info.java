/**
 * FHIR R5 SubstanceSourceMaterial resource.
 */
module se.poroli.fhirplace.r5.substancesourcematerial {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.substancesourcematerial;
}
