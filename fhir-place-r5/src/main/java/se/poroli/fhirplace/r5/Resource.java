package se.poroli.fhirplace.r5;

import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.foundation.other.Binary;
import se.poroli.fhirplace.r5.foundation.other.Bundle;
import se.poroli.fhirplace.r5.foundation.other.Parameters;

/**
 * This is the base resource type for everything.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/Resource">FHIR R5 Resource</a>
 */
public sealed interface Resource
        permits DomainResource, Binary, Bundle, Parameters {

    /**
     * Logical id of this artifact.
     *
     * @return the id, or {@code null} if absent
     */
    String id();

    /**
     * Metadata about the resource.
     *
     * @return the meta, or {@code null} if absent
     */
    Meta meta();

    /**
     * A set of rules under which this content was created. Modifier element.
     *
     * @return the implicitRules, or {@code null} if absent
     */
    FhirUri implicitRules();

    /**
     * Language of the resource content.
     *
     * @return the language, or {@code null} if absent
     */
    FhirCode language();
}
