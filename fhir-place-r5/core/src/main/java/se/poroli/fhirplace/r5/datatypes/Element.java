package se.poroli.fhirplace.r5.datatypes;

import java.util.List;

/**
 * Base of all elements in resources and datatypes: an optional id and extensions.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Element">FHIR R5 Element</a>
 */
public sealed interface Element
        permits DataType, BackboneElement, FhirXhtml, Timing.Repeat, DataRequirement.CodeFilter,
                DataRequirement.DateFilter, DataRequirement.ValueFilter, DataRequirement.Sort,
                Availability.AvailableTime, Availability.NotAvailableTime, Dosage.DoseAndRate,
                ElementDefinition.Slicing, ElementDefinition.Slicing.Discriminator, ElementDefinition.Base,
                ElementDefinition.TypeRef, ElementDefinition.Example, ElementDefinition.Constraint,
                ElementDefinition.ElementDefinitionBinding, ElementDefinition.ElementDefinitionBinding.Additional,
                ElementDefinition.Mapping {

    /**
     * Unique id for inter-element referencing.
     *
     * @return the id, or {@code null} if absent
     */
    String id();

    /**
     * Additional content defined by implementations.
     *
     * @return the extension, never {@code null}
     */
    List<Extension> extension();
}
