/**
 * FHIR R5 InventoryReport resource.
 */
module se.poroli.fhirplace.r5.inventoryreport {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.inventoryreport;
}
