# fhirplace-r5-validation

Profiles as code: validation rules written in Java against the typed FHIR model, so they are fast, use no extra memory,
and report exactly the messages, codes, severities and locations you choose.

```java
static final Validator<Patient> SE_PATIENT = Validator.builder(Patient.class)
        .rule("se-1", p -> p.identifier().stream().anyMatch(SePatient::isPersonnummer),
                Issue.error(IssueType.REQUIRED, "A Swedish personnummer is required").at("identifier"))
        .each(Patient::name, "name", Validator.builder(HumanName.class)
                .rule("se-2", n -> n.family() != null,
                        Issue.error(IssueType.REQUIRED, "Family name is required").at("family"))
                .build())
        .check("se-3", (p, report) -> p.telecom().forEach(t -> {
            if (!isSwedish(t)) {
                report.add(Issue.warning(IssueType.VALUE, "Not a Swedish number: " + t.value().value()));
            }
        }))
        .build();

ValidationResult result = SE_PATIENT.validate(patient);
result.issues();               // e.g. Issue(se-2, error, required, "Family name is required", "Patient.name[1].family")
result.isValid();              // false if any error; warnings are allowed
result.toOperationOutcome();   // one OperationOutcome issue per issue, with severity, code, diagnostics, expression
result.throwIfInvalid();       // ValidationException: a fhirplace server answers 422 with the OperationOutcome
```

- **Rules:**
  - `rule` reports a fixed issue when a predicate fails;
  - `check` reports computed issues;
  - `each` and `nested` validate elements with their own validators;
  - `include`/`and` combine validators.
- **Locations** come out as FHIRPath-style expressions from the resource type, such as `Patient.name[1].family`. An
  issue's `at(...)` is relative to the validated element.
- **A built validator is immutable and thread-safe;** keep it as a constant.
- **Adjusting validators you reuse but don't own:** every rule has an id, so `withMessage(id, ...)`,
  `withSeverity(id, ...)` and `without(id)` change their output without copying their rules.

Validation runs only when you call it, so the handler decides which profile applies to which interaction, and
`throwIfInvalid(status)` picks the HTTP status. The base FHIR rules (required elements, cardinality, value formats,
required value sets) are already enforced when a resource is read or built; see [core](../core).

**Dependencies:** `fhirplace-r5-core` and the OperationOutcome module.
