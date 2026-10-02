/**
 * FHIR R5 SubstanceReferenceInformation resource.
 */
module se.poroli.fhirplace.r5.substancereferenceinformation {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.substancereferenceinformation;
}
