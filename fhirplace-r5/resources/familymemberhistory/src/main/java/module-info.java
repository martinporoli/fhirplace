/**
 * FHIR R5 FamilyMemberHistory resource.
 */
module se.poroli.fhirplace.r5.familymemberhistory {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.familymemberhistory;
}
