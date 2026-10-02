package se.poroli.fhirplace.r5.datatypes;


/**
 * A reusable datatype: a primitive or complex type that can, among other things, be the value of an Extension.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DataType">FHIR R5 DataType</a>
 */
public sealed interface DataType extends Element
        permits PrimitiveType, BackboneType, Identifier, HumanName, Address, ContactPoint, Quantity, Attachment,
                Range, Period, Ratio, RatioRange, CodeableConcept, Coding, SampledData, Age, Distance, Duration,
                Count, Money, Annotation, Signature, ContactDetail, Contributor, DataRequirement, ParameterDefinition,
                RelatedArtifact, TriggerDefinition, UsageContext, Expression, ExtendedContactDetail,
                VirtualServiceDetail, Availability, MonetaryComponent, Reference, CodeableReference, Narrative,
                Extension, Meta {

}
