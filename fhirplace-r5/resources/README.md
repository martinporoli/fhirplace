# FHIR R5 resource modules

One module per FHIR R5 resource type, 158 in total, so applications depend only on the resources they use. Each
module is named after the resource:

| Resource | Artifact | Java module and package |
|---|---|---|
| Patient | `fhirplace-r5-patient` | `se.poroli.fhirplace.r5.patient` |
| MedicationRequest | `fhirplace-r5-medicationrequest` | `se.poroli.fhirplace.r5.medicationrequest` |
| … | `fhirplace-r5-<lowercase name>` | `se.poroli.fhirplace.r5.<lowercase name>` |

A module contains the resource record (with nested records for its backbone elements and a builder) and the value
sets only that resource uses. Everything shared is in [core](../core), which every resource module depends on.

```java
MedicationRequest request = MedicationRequest.builder()
        .status(MedicationrequestStatus.ACTIVE)
        .intent(MedicationRequestIntent.ORDER)
        .medication(CodeableReference.builder().concept(CodeableConcept.builder().text("Amoxicillin").build()).build())
        .subject(Reference.builder().reference("Patient/123").build())
        .build();
```

Required elements and FHIR constraints are checked when a record is built. Resources do not depend on each other:
references are untyped `Reference`s, and nested resources such as `contained` are typed as `Resource`.

Every record carries JSON-B annotations so that Jakarta JSON Binding reads and writes it as FHIR JSON; the JSON-B API
is an optional dependency.
