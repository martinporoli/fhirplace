# fhirplace-r5-client

A FHIR R5 client on the JDK's `java.net.http.HttpClient`, with the FHIR rules built in: typed resources, search
syntax, paging, versioned updates and errors as OperationOutcomes.

```java
FhirClient fhir = FhirClient.of("https://example.org/fhir");

Patient patient = fhir.create(newPatient).body();                       // POST, 201, Location, ETag
Patient current = fhir.read(Patient.class, patient.id()).body();         // GET
fhir.update(current.toBuilder().active(true).build());                   // PUT with If-Match from meta.versionId
fhir.delete(Patient.class, patient.id());

SearchQuery search = SearchQuery.where("family", "Chalmers")                       // correct FHIR syntax and escaping
        .and("birthdate", SearchQuery.ge(LocalDate.of(1970, 1, 1)))
        .and("identifier", SearchQuery.token("http://acme.org/mrn", "123"));
Bundle firstPage = fhir.search(Patient.class, search).body();
try (Stream<Patient> all = fhir.searchAll(Patient.class, search)) {    // follows next links lazily
    all.forEach(System.out::println);
}

fhir.readAsync(Patient.class, "123").thenAccept(response -> ...);       // async variants return CompletableFuture
Bundle everything = fhir.send(fhir.request("Patient/123/$everything").GET(), Bundle.class).body();
```

`searchAll` follows `next` links only on the client's own server (same scheme, host and port), because each request
carries the client's headers, such as `Authorization`; a link to another server throws `IllegalStateException`. Relative
links are resolved against the base URL.

`request(path)` builds requests for interactions without a method of their own. The path is relative to the FHIR
base, with or without a leading `/`; absolute URLs are rejected, so the client's headers never leave its server.

Error statuses throw `FhirClientException` with `status()`, `outcome()` (the server's OperationOutcome) and the
response headers; a stale update, for example, fails with 412.

**Configuration and cheap clients.** A `FhirClient` is an immutable value: the base URL plus an `HttpClient`, default
headers, a format and an optional request timeout. The expensive part, the `HttpClient` with its connections and
threads, is shared: `FhirClient.of(url)` uses one default `HttpClient.newHttpClient()` for the whole application, and
`FhirClient.of(url, httpClient)` uses yours. Configure HTTP (connect timeout, TLS, proxies, executor) with the JDK's
own builder. The JDK sets the time to wait for a response per request, so set it on the `FhirClient` with
`withTimeout`; it applies to every request the client sends, and by default a client waits indefinitely. Create one
`FhirClient` and derive the rest from it; deriving is cheap enough to do per request, e.g. in a proxy that routes to
many servers.

```java
HttpClient http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
FhirClient fhir = FhirClient.of("https://a.example/fhir", http)
        .withTimeout(Duration.ofSeconds(30))                           // default for every request
        .withHeader("Authorization", "Bearer " + token);

fhir.at("https://b.example/fhir").read(Patient.class, "123");          // same HttpClient, headers, format, timeout
fhir.withFormat(FhirFormat.XML).read(Patient.class, "123");
fhir.withTimeout(Duration.ofMinutes(2)).search(Patient.class, search);    // longer for one slow call
```

A request that times out throws `UncheckedIOException` caused by `HttpTimeoutException`; an async call completes
exceptionally with the `HttpTimeoutException`.

With dependency injection, make the configured client a bean and inject it where needed:

```java
@ApplicationScoped                                  // CDI (MicroProfile, Quarkus)
public class FhirClients {
    @Produces @Singleton                            // not @ApplicationScoped: FhirClient is final, so no proxy
    FhirClient fhirClient() {
        return FhirClient.of("https://a.example/fhir",
                HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build())
                .withTimeout(Duration.ofSeconds(30));
    }
}

@Bean                                               // Spring
FhirClient fhirClient() {
    return FhirClient.of("https://a.example/fhir",
            HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build())
            .withTimeout(Duration.ofSeconds(30));
}
```

**Plain `HttpClient`.** `FhirBodyHandlers` and `FhirBodyPublishers` bring the FHIR mapping to ordinary JDK code:

```java
HttpResponse<Patient> response = httpClient.send(
        HttpRequest.newBuilder(uri).header("Accept", "application/fhir+json").build(),
        FhirBodyHandlers.of(Patient.class));
```

**Dependencies:** `fhirplace-r5-core`, the Bundle and OperationOutcome modules, and the Jakarta JSON Processing API.
Add an implementation such as Parsson unless your runtime provides one.

Tested against a real fhirplace server in-process, including paging with `count(...)`, and against stub servers for
paging edge cases and errors that are not FHIR.
