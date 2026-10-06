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
- paging with `_count` and `_offset` over the handler's results, with `next` and `previous` links; other result
  parameters such as `_sort` are rejected by name, or ignored with `Prefer: handling=lenient`;
- errors as `OperationOutcome`; handlers throw `se.poroli.fhirplace.r5.rest.FhirHttpException`, shared with the
  client, e.g. `FhirHttpException.notFound("Patient", id)`. Any other exception from a handler is logged with
  `System.Logger` and answered with 500 and an OperationOutcome that does not reveal it;
- a CapabilityStatement at `metadata`, generated from the handlers.

Invalid handlers are reported when the server is built, which makes application startup fail.

## Validation

Request bodies that cannot be read are answered automatically: 400 for malformed or misstructured content, 422 for
content that breaks the FHIR rules (a missing required element, an invalid date, a code outside a required value set),
each with an OperationOutcome issue that has the right code and an `expression` pointing at the element.

The server has no runtime validation-module dependency. Profiles and business rules are yours: optionally add
[fhirplace-r5-validation](../validation) to your application, check its result explicitly, and translate failures
to a shared HTTP error where you want them:

```java
import se.poroli.fhirplace.r5.rest.FhirHttpException;
import se.poroli.fhirplace.r5.validation.ValidationResult;

@Create
public Patient create(Patient patient) {
    ValidationResult validation = SE_PATIENT.validate(patient);
    if (!validation.isValid()) {
        throw FhirHttpException.unprocessable(validation.toOperationOutcome());  // 422, preserving every issue
    }
    return store.save(patient);
}
```

Validation messages are in each issue's `details.text`; optional `diagnostics` carries additional information.
Warnings alone do not block the request. Errors detected while reading the body keep their format diagnostics.

## Custom responses

Throw `FhirHttpException` with your own `OperationOutcome`, status and headers to answer with a specific error:

```java
@Read
public Optional<Patient> read(@Id String id) {
    if (archive.contains(id)) {
        throw new FhirHttpException(404, OperationOutcome.builder()
                .addIssue(OperationOutcome.Issue.builder()
                        .severity(IssueSeverity.ERROR)
                        .code(IssueType.NOT_FOUND)
                        .diagnostics(FhirString.of("Patient/" + id + " is archived; ask the records office"))
                        .build())
                .build());
    }
    if (overloaded()) {
        throw new FhirHttpException(503, outcome, Map.of("Retry-After", List.of("120")));
    }
    return store.find(id);   // Optional.empty() → the standard 404 OperationOutcome
}
```

The outcome may be `null` to send an error without a body; status and headers are still preserved.
The server regenerates body headers and removes connection-specific headers, so a rethrown client error cannot
forward the backend's content length or encoding for a different response body.

Return a `FhirResult` to choose the success status, body and headers; the server still adds `ETag`,
`Last-Modified` and `Location` from the body. Declare a `FhirRequest` parameter to read the request's headers or
base URL:

```java
@Delete
public FhirResult<OperationOutcome> delete(@Id String id, FhirRequest request) {
    deletions.schedule(id, request.header("X-Correlation-Id"));
    return FhirResult.of(202, scheduledOutcome(id)).withHeader("X-Queue", "deletions");
}
```

`FhirServer` is the engine the adapters use; another framework needs only an adapter that passes the raw request to
`FhirServer.handle` and writes the response.

**Dependencies:** `fhirplace-r5-core`, `fhirplace-r5-rest` (shared HTTP errors), the Bundle, OperationOutcome and
CapabilityStatement modules, and the Jakarta JSON Processing API. Validation is test-only in this module; applications
that use it add their own dependency.

The module also publishes its HTTP behaviour tests as a test jar; every adapter runs them against its runtime.
Consumers of that test jar add an explicit test dependency on `fhirplace-r5-validation` for the shared handlers.
