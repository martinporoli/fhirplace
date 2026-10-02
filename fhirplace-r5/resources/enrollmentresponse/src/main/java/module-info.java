/**
 * FHIR R5 EnrollmentResponse resource.
 */
module se.poroli.fhirplace.r5.enrollmentresponse {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.enrollmentresponse;
}
