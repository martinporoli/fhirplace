/**
 * FHIR R5 ExampleScenario resource.
 */
module se.poroli.fhirplace.r5.examplescenario {
    requires transitive se.poroli.fhirplace.r5;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5.examplescenario;
}
