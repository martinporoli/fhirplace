package se.poroli.fhirplace.r5.datatypes;

import java.util.List;

/**
 * An element nested inside a resource definition, which can carry modifier extensions. It is implemented by the
 * nested records of the resources, such as Patient.Contact.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/BackboneElement">FHIR R5 BackboneElement</a>
 */
public non-sealed interface BackboneElement extends Element {

    /**
     * Extensions that cannot be ignored even if unrecognized. Modifier element.
     *
     * @return the modifierExtension, never {@code null}
     */
    List<Extension> modifierExtension();
}
