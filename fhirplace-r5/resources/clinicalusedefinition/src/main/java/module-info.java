/**
 * FHIR R5 ClinicalUseDefinition resource.
 */
module se.poroli.fhirplace.r5.clinicalusedefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.clinicalusedefinition;
}
