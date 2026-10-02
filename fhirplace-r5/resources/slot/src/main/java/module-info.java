/**
 * FHIR R5 Slot resource.
 */
module se.poroli.fhirplace.r5.slot {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.slot;
}
