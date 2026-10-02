/**
 * FHIR R5 SubstancePolymer resource.
 */
module se.poroli.fhirplace.r5.substancepolymer {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.substancepolymer;
}
