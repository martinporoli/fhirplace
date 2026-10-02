# FHIR R5 examples

A subset of the official FHIR R5 examples (https://hl7.org/fhir/R5/downloads.html, `examples-json.zip` and
`examples.zip`): for each resource type, up to three examples that exist in both formats, picked as the smallest,
median and largest example of at most 150 KB. Files are named `<resourceType>-<id>` and are unmodified.

`AdverseEvent-example` is handwritten, because the official R5 examples contain no AdverseEvent. It deliberately
uses `+00:00` offsets, a primitive extension, a choice element and a multi-line string.
