# fhirplace-r5-serialization-tests

Tests only; never packaged or published. Proves that every R5 resource reads and writes as FHIR JSON and XML without
loss, using a subset of the official R5 examples in `src/test/resources/examples` (see the README there).

For each example it checks the JSON round-trip, the XML round-trip, that the XML and JSON editions read to the same
resource, and the JSON round-trip through Jakarta JSON Binding (Yasson). A coverage test checks that all 158 resource
types have an example.
