/**
 * FHIR R5 MolecularSequence resource.
 */
module se.poroli.fhirplace.r5.molecularsequence {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.molecularsequence;
}
