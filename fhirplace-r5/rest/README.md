# fhirplace-r5-rest

Shared `FhirHttpException` for FHIR HTTP clients and servers, without an HTTP implementation or a validation dependency.
It carries an error status (400-599), an optional `OperationOutcome` and immutable response headers. Its message starts
with `HTTP <status>` and uses the first issue's diagnostics, details text or code when available.

```java
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.rest.FhirHttpException;

OperationOutcome outcome = OperationOutcome.builder()
        .addIssue(OperationOutcome.Issue.builder()
                .severity(IssueSeverity.ERROR)
                .code(IssueType.BUSINESS_RULE)
                .build())
        .build();
throw FhirHttpException.unprocessable(outcome);  // 422, preserving the complete outcome
```

The fhirplace client throws the same exception for error responses, with `outcome() == null` when the server sent no
readable OperationOutcome. Servers accept it from handlers; callers explicitly decide when validation results should
become HTTP errors. `header(name)` matches names case-insensitively.

Dependencies: `fhirplace-r5-core` and `fhirplace-r5-operationoutcome` only. Public API tests cover error factories,
outcome preservation, message selection, status constraints and immutable headers; client/server integration suites
exercise errors over HTTP.
