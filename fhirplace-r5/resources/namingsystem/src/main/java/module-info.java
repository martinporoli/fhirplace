/**
 * FHIR R5 NamingSystem resource.
 */
module se.poroli.fhirplace.r5.namingsystem {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.namingsystem;
}
