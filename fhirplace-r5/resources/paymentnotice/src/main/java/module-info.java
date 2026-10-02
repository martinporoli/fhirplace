/**
 * FHIR R5 PaymentNotice resource.
 */
module se.poroli.fhirplace.r5.paymentnotice {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.paymentnotice;
}
