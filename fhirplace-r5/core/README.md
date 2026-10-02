# fhirplace-r5-core

The foundation every R5 module depends on:

- `Resource` and `DomainResource`, the interfaces all resource records implement.
- All FHIR R5 datatypes as records with builders (`se.poroli.fhirplace.r5.datatypes`), including primitives that keep
  their id, extensions and exact lexical form (`FhirDateTime.parse("2024-05-17T13:28:17.000+00:00")` is written back
  unchanged).
- The value sets used by more than one resource, as enums (`se.poroli.fhirplace.r5.valuesets`).
- FHIR JSON (`FhirJson`, Jakarta JSON Processing) and FHIR XML (`FhirXml`, StAX) for every resource.

```java
String json = FhirJson.write(patient);
Patient patient = FhirJson.read(json, Patient.class);
Resource resource = FhirXml.read(xml);   // the resource type comes from the document
```

Reading looks up resource classes by name, so the module of each resource type you read (e.g. `fhirplace-r5-patient`)
must be on the class or module path.

**Dependencies:** none required. `jakarta.json-api` (plus an implementation such as Parsson) is needed for FHIR JSON,
and `jakarta.json.bind-api` for JSON-B; both are optional dependencies that MicroProfile runtimes provide.
