# fhirplace

A small, modern Java 21 library for working with [FHIR R5](https://hl7.org/fhir/R5/) and building FHIR servers. It is
a lightweight alternative to HAPI FHIR:

- **Immutable model.** Every FHIR R5 resource and datatype is a Java record with a builder; values are validated when
  they are built.
- **Small footprint.** Each resource is its own Maven module, so you depend only on the resources you use. The core
  has no mandatory third-party dependencies.
- **Standard APIs.** FHIR JSON goes through Jakarta JSON Processing and JSON Binding, FHIR XML through StAX. The server
  runs on MicroProfile (Jakarta REST + CDI), Quarkus and Spring Boot; the client is built on the JDK's `HttpClient`.
- **Lossless.** Read and written FHIR JSON and XML round-trip without loss, verified against the official R5 examples.

## Model

```java
Patient patient = Patient.builder()
        .addName(HumanName.builder().family("Chalmers").addGiven("Peter").build())
        .birthDate(LocalDate.of(1974, 12, 25))
        .gender(AdministrativeGender.MALE)
        .build();

Patient active = patient.toBuilder().active(true).build();   // records are immutable
```

## JSON and XML

```java
String json = FhirJson.write(patient);                       // FHIR JSON (needs a JSON-P implementation, e.g. Parsson)
Patient fromJson = FhirJson.read(json, Patient.class);

String xml = FhirXml.write(patient);                         // FHIR XML with StAX, JDK only
Resource any = FhirXml.read(xml);                            // the type comes from the document

String viaJsonb = JsonbBuilder.create().toJson(patient);     // JSON-B writes and reads FHIR JSON too
```

## Validation

The base FHIR rules are enforced when a resource is read or built; invalid content raises `FhirFormatException`, which
says what is wrong and where (`Patient.contact[1].gender`). Profiles and business rules are plain Java, fast, and yours
to word:

```java
static final Validator<Patient> SE_PATIENT = Validator.builder(Patient.class)
        .rule("se-1", p -> !p.identifier().isEmpty(),
                Issue.error(IssueType.REQUIRED, "An identifier is required").at("identifier"))
        .build();

SE_PATIENT.validate(patient).throwIfInvalid();   // in a server handler: 422 with an OperationOutcome
```

## Client

A thin layer over the JDK's `HttpClient`: typed resources, FHIR search syntax, paging and errors as OperationOutcomes.
Clients are cheap immutable values, so one per target server or request is fine.

```java
FhirClient fhir = FhirClient.of("https://example.org/fhir");

Patient patient = fhir.read(Patient.class, "123").body();
fhir.update(patient.toBuilder().active(true).build());          // If-Match from meta.versionId; 412 if stale

try (Stream<Patient> all = fhir.searchAll(Patient.class,
        SearchQuery.where("family", "Chalmers").and("birthdate", SearchQuery.ge(LocalDate.of(1970, 1, 1))))) {
    all.forEach(System.out::println);                           // follows the Bundles' next links
}
```

## Server

Write a CDI or Spring bean per resource type; fhirplace serves it as a FHIR RESTful API, including status codes,
`ETag`/`Location` headers, conditional requests, content negotiation, searchset Bundles, OperationOutcome errors and
a generated CapabilityStatement at `/metadata`.

```java
@ApplicationScoped                    // or @Component in Spring Boot
@FhirResource(Patient.class)
public class PatientHandler {

    @Read
    public Optional<Patient> read(@Id String id) { ... }                 // GET /fhir/Patient/123, empty → 404

    @Create
    public Patient create(Patient patient) { ... }                       // POST /fhir/Patient → 201 + Location

    @Search
    public List<Patient> search(@SearchParam("family") StringParam family,
                                @SearchParam("birthdate") List<DateParam> birthdate) { ... }  // GET /fhir/Patient?family=...
}
```

Handlers can also answer with their own OperationOutcomes, statuses and headers, and read the request; see
[custom responses](fhirplace-r5/server#custom-responses).

Add `fhirplace-r5-server-jaxrs` (MicroProfile, Quarkus) or `fhirplace-r5-server-spring` (Spring Boot) and the handlers
are served. Runnable references: [examples/quarkus](examples/quarkus), [examples/spring-boot](examples/spring-boot),
and [examples/routing-proxy](examples/routing-proxy), a FHIR proxy that forwards each request to a regional server with
the client.

## Modules

All artifacts have the group id `se.poroli.fhirplace`.

| Artifact | Contents |
|---|---|
| [`fhirplace-r5-core`](fhirplace-r5/core) | Base types, datatypes, shared value sets, `FhirJson`, `FhirXml` |
| [`fhirplace-r5-<resource>`](fhirplace-r5/resources) | One module per resource, e.g. `fhirplace-r5-patient` |
| [`fhirplace-r5-bom`](fhirplace-r5/bom) | Versions of all R5 artifacts |
| [`fhirplace-r5-all`](fhirplace-r5/all) | Every resource at once (`<type>pom</type>`) |
| [`fhirplace-r5-validation`](fhirplace-r5/validation) | Profiles as code: typed validation rules → OperationOutcome |
| [`fhirplace-r5-client`](fhirplace-r5/client) | FHIR RESTful client on the JDK's `HttpClient` |
| [`fhirplace-r5-server`](fhirplace-r5/server) | Framework-independent FHIR server engine and handler API |
| [`fhirplace-r5-server-jaxrs`](fhirplace-r5/server-jaxrs) | Server adapter for Jakarta REST + CDI (MicroProfile, Quarkus) |
| [`fhirplace-r5-server-spring`](fhirplace-r5/server-spring) | Server adapter for Spring Boot |

A typical server that serves `Patient` needs `fhirplace-r5-server-jaxrs` (or `-spring`) and `fhirplace-r5-patient`;
import `fhirplace-r5-bom` to align the versions.

## Building

```
./mvnw verify
```

Requires Java 21. The build compiles every module, runs all tests, and tests the examples without packaging them.
JMH benchmarks are kept out of the normal build; see [fhirplace-r5/benchmarks](fhirplace-r5/benchmarks).

## License

[Apache License 2.0](LICENSE)
