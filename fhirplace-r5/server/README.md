# fhirplace-r5-server

A FHIR RESTful server built from annotated handler classes, independent of any web framework. Use it through an
adapter: [server-jaxrs](../server-jaxrs) (MicroProfile, Quarkus) or [server-spring](../server-spring) (Spring Boot).

A handler serves one resource type; each annotated method implements one interaction:

```java
@FhirResource(Patient.class)
public class PatientHandler {
    @Read   public Optional<Patient> read(@Id String id) { ... }
    @VRead  public Optional<Patient> vread(@Id String id, @VersionId String versionId) { ... }
    @Create public Patient create(Patient patient) { ... }
    @Update public Saved<Patient> update(@Id String id, Patient patient) { ... }   // Saved.created(...) → 201
    @Delete public void delete(@Id String id) { ... }
    @Search public Stream<Patient> search(@SearchParam("family") StringParam family,
                                          @SearchParam("identifier") TokenParam identifier,
                                          @SearchParam("birthdate") List<DateParam> birthdate) { ... }
}
```

The server takes care of the FHIR HTTP rules:

- routes and status codes (201, 204, 304, 404, 405, 410, 412, …);
- `ETag`, `Last-Modified` and `Location` from the resource's `meta`;
- `If-Match`, `If-None-Match`, `If-Modified-Since` and `Prefer`;
- FHIR JSON and XML with `Accept`, `_format` and `_pretty`;
- search parameters with OR (`a,b`), AND (repeated), prefixes and escaping, and searchset Bundles;
- errors as `OperationOutcome`; handlers throw `FhirException`, e.g. `FhirException.notFound("Patient", id)`;
- a CapabilityStatement at `metadata`, generated from the handlers.

Invalid handlers are reported when the server is built, which makes application startup fail.

`FhirServer` is the engine the adapters use; another framework needs only an adapter that passes the raw request to
`FhirServer.handle` and writes the response.

**Dependencies:** `fhirplace-r5-core`, the Bundle, OperationOutcome and CapabilityStatement modules, and the Jakarta
JSON Processing API.

The module also publishes its HTTP behaviour tests as a test jar; every adapter runs them against its runtime.
