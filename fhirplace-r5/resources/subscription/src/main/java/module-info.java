/**
 * FHIR R5 Subscription resource.
 */
module se.poroli.fhirplace.r5.subscription {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.subscription;
}
