/**
 * FHIR R5 PaymentReconciliation resource.
 */
module se.poroli.fhirplace.r5.paymentreconciliation {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.paymentreconciliation;
}
