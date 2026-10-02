/**
 * FHIR R5 AuditEvent resource.
 */
module se.poroli.fhirplace.r5.auditevent {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.auditevent;
}
