/**
 * FHIR R5 SupplyDelivery resource.
 */
module se.poroli.fhirplace.r5.supplydelivery {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.supplydelivery;
}
