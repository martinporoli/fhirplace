# fhirplace-r5-server-jaxrs-quarkus-tests

Tests only; never packaged or published. Runs [server-jaxrs](../server-jaxrs) on Quarkus REST:

- the shared HTTP tests of [server](../server), as `@QuarkusTest`s;
- an ordinary Jakarta REST resource next to the FHIR routes;
- an invalid handler stopping a production-mode Quarkus build from starting (`QuarkusProdModeTest`, run in its own
  surefire execution because Quarkus does not mix it with `@QuarkusTest`).
