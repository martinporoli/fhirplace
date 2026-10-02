# fhirplace-r5-client

A FHIR R5 client on the JDK's `java.net.http.HttpClient`, with the FHIR rules built in: typed resources, search
syntax, paging, versioned updates and errors as OperationOutcomes.

```java
FhirClient fhir = FhirClient.of("https://example.org/fhir");

Patient patient = fhir.create(newPatient).body();                       // POST, 201, Location, ETag
Patient current = fhir.read(Patient.class, patient.id()).body();         // GET
fhir.update(current.toBuilder().active(true).build());                   // PUT with If-Match from meta.versionId
fhir.delete(Patient.class, patient.id());

Search search = Search.where("family", "Chalmers")                       // correct FHIR syntax and escaping
        .and("birthdate", Search.ge(LocalDate.of(1970, 1, 1)))
        .and("identifier", Search.token("http://acme.org/mrn", "123"));
Bundle firstPage = fhir.search(Patient.class, search).body();
try (Stream<Patient> all = fhir.searchAll(Patient.class, search)) {    // follows next links lazily
    all.forEach(System.out::println);
}

fhir.readAsync(Patient.class, "123").thenAccept(response -> ...);       // async variants return CompletableFuture
Bundle everything = fhir.send(fhir.request("Patient/123/$everything").GET(), Bundle.class).body();
```

Error statuses throw `FhirClientException` with `status()`, `outcome()` (the server's OperationOutcome) and the
response headers; a stale update, for example, fails with 412.

**Cheap clients.** A `FhirClient` is an immutable value, the base URL plus an `HttpClient`, headers and a format, so
creating one per request is fine, e.g. in a proxy that routes to many servers. The expensive part, the `HttpClient`
with its connections and threads, is shared: `FhirClient.of(uri)` uses one default client for the whole application,
and `FhirClient.of(uri, httpClient)` uses yours, with your timeouts, TLS and proxy settings.

```java
FhirClient template = FhirClient.of(defaultBase, httpClient).withHeader("Authorization", "Bearer " + token);
FhirClient routed = template.withBaseUri(targetFor(resource));         // same HttpClient and headers
FhirClient xml = template.withFormat(FhirFormat.XML);
```

**Plain `HttpClient`.** `FhirBodyHandlers` and `FhirBodyPublishers` bring the FHIR mapping to ordinary JDK code:

```java
HttpResponse<Patient> response = httpClient.send(
        HttpRequest.newBuilder(uri).header("Accept", "application/fhir+json").build(),
        FhirBodyHandlers.of(Patient.class));
```

**Dependencies:** `fhirplace-r5-core`, the Bundle and OperationOutcome modules, and the Jakarta JSON Processing API.
Add an implementation such as Parsson unless your runtime provides one.

Tested against a real fhirplace server in-process, and against a paging stub for `searchAll`.
