# FhirPlace on Quarkus

A minimal FHIR R5 server on Quarkus, built with `fhirplace-r5-server-jaxrs`. Storage is in memory; the point is to show
how an application uses fhirplace. The build compiles and tests it but never packages or publishes it.

- `PatientHandler` implements every supported interaction for `Patient`: read, vread, create, update, delete and
  search, plus a business rule that is reported as 422.
- `ObservationHandler` implements only read, create and search; fhirplace answers the rest with 405.
- `application.properties` serves the API under `/fhir`.

Dependencies: `fhirplace-r5-server-jaxrs` (the Jakarta REST adapter of `fhirplace-r5-server`), the resource modules the application serves (`fhirplace-r5-patient`,
`fhirplace-r5-observation`), and the Quarkus extensions `quarkus-rest` and `quarkus-jsonp`.

Run it from the repository root with `./mvnw install -DskipTests` once, then
`./mvnw -f examples/quarkus quarkus:dev`, and try for example:

```
curl -X POST localhost:8080/fhir/Patient -H 'Content-Type: application/fhir+json' \
     -d '{"resourceType":"Patient","name":[{"family":"Chalmers","given":["Peter"]}]}'
curl 'localhost:8080/fhir/Patient?family=chal&_pretty=true'
curl localhost:8080/fhir/metadata -H 'Accept: application/fhir+xml'
```

The tests in `src/test` run the application with `@QuarkusTest` and use it the way another application would,
through the fhirplace client (`fhirplace-r5-client`). `HttpTest` shows the same API on the wire.
