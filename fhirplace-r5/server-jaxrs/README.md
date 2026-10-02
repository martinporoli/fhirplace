# fhirplace-r5-server-jaxrs

Serves the fhirplace FHIR server on Jakarta REST and CDI: MicroProfile runtimes (tested on Helidon MP) and Quarkus.
Adding the dependency is all the setup needed:

- every CDI bean annotated with `@FhirResource` is served, under the application's Jakarta REST path;
- invalid handlers fail application startup;
- the application's own Jakarta REST resources keep working alongside the FHIR routes.

```java
@ApplicationPath("fhir")
public class FhirApplication extends Application {
}

@ApplicationScoped
@FhirResource(Patient.class)
public class PatientHandler { ... }
```

In Quarkus, set `quarkus.rest.path=/fhir` instead of declaring an `Application`. See
[examples/quarkus](../../examples/quarkus).

**Dependencies:** `fhirplace-r5-server`; Jakarta REST 3.1 and CDI 4 are provided by the runtime.

Tested with the shared HTTP tests on Helidon MP here, and on Quarkus in
[server-jaxrs-quarkus-tests](../server-jaxrs-quarkus-tests).
