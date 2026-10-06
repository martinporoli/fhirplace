# fhirplace-r5-validation

Profiles as code: validation rules written in Java against the typed FHIR model. They return results independently of
HTTP, with the coded or textual details, diagnostics, severities and locations you choose.

```java
static final Validator<Patient> SE_PATIENT = Validator.builder(Patient.class)
        .rule("se-1", p -> p.identifier().stream().anyMatch(i -> i.system() != null
                        && "http://electronichealth.se/identifier/personnummer".equals(i.system().value())),
                Issue.error(IssueType.REQUIRED, "A Swedish personnummer is required").at("identifier"))
        .each(Patient::name, "name", Validator.builder(HumanName.class)
                .rule("se-2", n -> n.family() != null,
                        Issue.error(IssueType.REQUIRED, "Family name is required").at("family"))
                .build())
        .check("se-3", (p, report) -> p.telecom().forEach(t -> {
            if (t.value() != null && !t.value().value().startsWith("+46")) {
                report.add(Issue.warning(IssueType.VALUE, "Not a Swedish number: " + t.value().value()));
            }
        }))
        .build();

ValidationResult result = SE_PATIENT.validate(patient);
result.issues();               // e.g. details.text = "Family name is required", expression = "Patient.name[1].family"
result.isValid();              // false if any error; warnings are allowed
result.toOperationOutcome();   // one issue each, copying details and diagnostics verbatim, plus expression if present
```

- **Rules:** `rule` reports a fixed issue when a predicate fails; `check` reports computed issues;
  `each` and `nested` validate elements with their own validators; `include`/`and` combine validators.
- **Locations** come out as FHIRPath-style expressions from the resource type, such as `Patient.name[1].family`. An
  issue's `at(...)` is relative to the validated element. Without it, validation locates the issue at the element
  itself. Issues supplied directly to a `ValidationResult` can have no expression.
- **Issue details:** the String factories `error`, `fatal`, `warning` and `information` set `details.text`; their
  `CodeableConcept` overloads preserve coded details. Null or empty String messages leave details absent. The `Issue`
  record also accepts nullable `FhirString` diagnostics; details, diagnostics and expression are independently optional.
- **A built validator is immutable and thread-safe;** keep it as a constant.
- **Adjusting validators you reuse but don't own:** every rule has an id, so `withMessage(id, ...)`,
  `withDetails(id, ...)`, `withSeverity(id, ...)` and `without(id)` change their output without copying their rules.
  `withMessage` changes only `details.text`, preserving coding, other concept metadata and diagnostics; an empty String
  clears text. `withDetails` replaces the whole concept, or clears it with `null`, without changing diagnostics.

For coded details, use the same FHIR datatype as `OperationOutcome.issue.details`:

```java
CodeableConcept details = CodeableConcept.builder()
        .addCoding(Coding.builder().system("urn:example:validation").code("missing-identifier").build())
        .text("An identifier is required")
        .build();
Issue issue = Issue.error(IssueType.REQUIRED, details).at("identifier");
```

Validation runs only when you call it. A server handler decides which profile applies and explicitly maps invalid
results to HTTP. With the separate `fhirplace-r5-rest` module:

```java
import se.poroli.fhirplace.r5.rest.FhirHttpException;

ValidationResult result = SE_PATIENT.validate(patient);
if (!result.isValid()) {
    throw FhirHttpException.unprocessable(result.toOperationOutcome());
}
```

An empty valid result still becomes an OperationOutcome with one informational success issue. The base FHIR rules
(required elements, cardinality, value formats, required value sets) are already enforced when a resource is read or
built; see [core](../core).

**Dependencies:** `fhirplace-r5-core` and the OperationOutcome module. No HTTP or server dependency.

**Testing:** public `Validator` and `ValidationResult` behavior, including nested paths, adjustments, optional issue
fields and OperationOutcome conversion, is covered with JUnit tests using the real FHIR model.
