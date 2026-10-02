package se.poroli.fhirplace.r5.datatypes;

import java.util.List;

/**
 * A datatype that, like a backbone element, can carry modifier extensions, such as Timing or Dosage.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/BackboneType">FHIR R5 BackboneType</a>
 */
public sealed interface BackboneType extends DataType
        permits Timing, Dosage, ElementDefinition, ProductShelfLife, MarketingStatus {

    /**
     * Extensions that cannot be ignored even if unrecognized. Modifier element.
     *
     * @return the modifierExtension, never {@code null}
     */
    List<Extension> modifierExtension();
}
