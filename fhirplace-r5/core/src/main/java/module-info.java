/**
 * FHIR R5 core model: the {@code Resource} and {@code DomainResource} base types, all datatypes, and the value sets
 * shared between resources.
 *
 * <p>Each resource is in its own module, for example {@code se.poroli.fhirplace.r5.patient}, which requires this one.
 */
module se.poroli.fhirplace.r5 {
    exports se.poroli.fhirplace.r5;
    exports se.poroli.fhirplace.r5.datatypes;
    exports se.poroli.fhirplace.r5.valuesets;
}
