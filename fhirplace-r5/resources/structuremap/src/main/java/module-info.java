/**
 * FHIR R5 StructureMap resource.
 */
module se.poroli.fhirplace.r5.structuremap {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.structuremap;
}
