/**
 * FHIR R5 ChargeItemDefinition resource.
 */
module se.poroli.fhirplace.r5.chargeitemdefinition {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.chargeitemdefinition;
}
