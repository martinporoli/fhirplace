/**
 * FHIR R5 core model: the {@code Resource} and {@code DomainResource} base types, all datatypes, the value sets shared
 * between resources, and reading and writing resources as FHIR JSON and XML.
 *
 * <p>Each resource is in its own module, for example {@code se.poroli.fhirplace.r5.patient}, which requires this one.
 *
 * <p>FHIR XML uses StAX from {@code java.xml}. FHIR JSON uses Jakarta JSON Processing, and Jakarta JSON Binding when it
 * is present; both are optional dependencies that the application or runtime provides.
 */
module se.poroli.fhirplace.r5 {
    requires java.xml;
    requires static jakarta.json;
    requires static jakarta.json.bind;

    exports se.poroli.fhirplace.r5;
    exports se.poroli.fhirplace.r5.datatypes;
    exports se.poroli.fhirplace.r5.json;
    exports se.poroli.fhirplace.r5.valuesets;
    exports se.poroli.fhirplace.r5.xml;
}
