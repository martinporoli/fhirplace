# FhirPlace on Spring Boot

A minimal FHIR R5 server on Spring Boot, built with `fhirplace-r5-server-spring`. Storage is in memory; the point is
to show how an application uses fhirplace. The build compiles and tests it but never packages or publishes it.

- `FhirApplication` is a plain `@SpringBootApplication`. The fhirplace auto-configuration serves every
  `@FhirResource` bean under `fhirplace.server.path` (`/fhir`, see `application.properties`).
- `PatientHandler` implements every supported interaction for `Patient`: read, vread, create, update, delete and
  search.
- `ObservationHandler` implements only read, create and search; fhirplace answers the rest with 405.
- `Profiles` holds the server's validation rules, written with `fhirplace-r5-validation`: every patient needs a
  family name and no future birth date; heart rates must be in beats/minute; missing medical record numbers and
  observation times are warnings. The handlers inspect the `ValidationResult` and explicitly throw
  `FhirHttpException.unprocessable(result.toOperationOutcome())` for errors, so clients get 422 with an
  OperationOutcome that describes the issue in `details.text` and points at the element (`Patient.name[0].family`).
  Warnings alone do not block. Content that breaks the base FHIR rules is rejected by fhirplace before a handler runs.

The handlers are the same as in the Quarkus example except for `@Component` instead of `@ApplicationScoped`.

Dependencies: `fhirplace-r5-server-spring`, the resource modules the application serves (`fhirplace-r5-patient`,
`fhirplace-r5-observation`), the explicit compile dependency `fhirplace-r5-validation`, and `spring-boot-starter-webmvc`.
The server does not bring validation transitively; shared HTTP errors use
`se.poroli.fhirplace.r5.rest.FhirHttpException` from `fhirplace-r5-rest`.

Run it from the repository root with `./mvnw install -DskipTests` once, then
`./mvnw -f examples/spring-boot spring-boot:run`, and try for example:

```
curl -X POST localhost:8080/fhir/Patient -H 'Content-Type: application/fhir+json' \
     -d '{"resourceType":"Patient","name":[{"family":"Chalmers","given":["Peter"]}]}'
curl 'localhost:8080/fhir/Patient?family=chal&_pretty=true'
curl localhost:8080/fhir/metadata -H 'Accept: application/fhir+xml'
```

The tests in `src/test` run the application with `@SpringBootTest` and use it the way another application would,
through the fhirplace client (`fhirplace-r5-client`). `HttpTest` shows the same API on the wire.
