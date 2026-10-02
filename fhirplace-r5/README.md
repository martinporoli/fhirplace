# fhirplace FHIR R5

The FHIR R5 modules of fhirplace. Applications depend on the few they need; the [BOM](bom) keeps versions aligned.

| Module | Artifact | Purpose |
|---|---|---|
| [core](core) | `fhirplace-r5-core` | Base types, datatypes, shared value sets, FHIR JSON and XML |
| [resources](resources) | `fhirplace-r5-<resource>` | One module per FHIR R5 resource type (158) |
| [bom](bom) | `fhirplace-r5-bom` | Bill of materials for all R5 artifacts |
| [all](all) | `fhirplace-r5-all` | Depends on every resource module |
| [server](server) | `fhirplace-r5-server` | Framework-independent FHIR RESTful server and handler API |
| [server-jaxrs](server-jaxrs) | `fhirplace-r5-server-jaxrs` | Server on Jakarta REST + CDI (MicroProfile, Quarkus) |
| [server-spring](server-spring) | `fhirplace-r5-server-spring` | Server on Spring Boot |
| [serialization-tests](serialization-tests) | – | Tests: official R5 examples round-trip through JSON and XML |
| [server-jaxrs-quarkus-tests](server-jaxrs-quarkus-tests) | – | Tests: the Jakarta REST adapter on Quarkus |

The test-only modules are never packaged or published.
