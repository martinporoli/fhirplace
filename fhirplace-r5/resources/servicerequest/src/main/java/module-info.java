/**
 * FHIR R5 ServiceRequest resource.
 */
module se.poroli.fhirplace.r5.servicerequest {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.servicerequest;
}
