# FhirPlace example: routing proxy

A FHIR proxy on Spring Boot. It serves `Patient` at `/fhir` with `fhirplace-r5-server-spring` and forwards every
request with `fhirplace-r5-client` to the FHIR server of the region in the request's `X-Region` header. The build
compiles and tests it but never packages or publishes it.

- `Backends` maps regions to backend URLs (`proxy.backends.<region>` in `application.properties`) and creates a
  `FhirClient` per request with `template.at(backend)`. That is cheap: the client is a small immutable value,
  and all backends share one `HttpClient` (a bean in `ProxyApplication`). It also forwards the caller's
  `Authorization` header.
- `PatientRouter` is an ordinary fhirplace handler whose methods call the backend. The fhirplace server still does
  the proxy's own HTTP: `Location` and Bundle links point to the proxy, `If-Match` is checked, and backend errors
  come back with the backend's status and OperationOutcome.

```java
@Read
public Optional<Patient> read(@Id String id, FhirRequest request) {
    return Optional.of(forward(() -> backends.clientFor(request).read(Patient.class, id).body()));
}
```

The tests start two regional backends, each a fhirplace server on the JDK's HTTP server, and use the proxy with the
fhirplace client: creating lands in the right region, reads, updates, deletes and searches stay in it, backend errors
and `Authorization` pass through, and an unknown region is rejected.

To try it, start two backends on ports 8081 and 8082, for example the Spring Boot example twice, then the proxy:

```
./mvnw install -DskipTests
./mvnw -f examples/spring-boot spring-boot:run -Dspring-boot.run.arguments=--server.port=8081 &
./mvnw -f examples/spring-boot spring-boot:run -Dspring-boot.run.arguments=--server.port=8082 &
./mvnw -f examples/routing-proxy spring-boot:run

curl -X POST localhost:8080/fhir/Patient -H 'X-Region: north' -H 'Content-Type: application/fhir+json' \
     -d '{"resourceType":"Patient","name":[{"family":"Chalmers"}]}'
```
