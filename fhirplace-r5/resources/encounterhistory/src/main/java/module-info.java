/**
 * FHIR R5 EncounterHistory resource.
 */
module se.poroli.fhirplace.r5.encounterhistory {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.encounterhistory;
}
