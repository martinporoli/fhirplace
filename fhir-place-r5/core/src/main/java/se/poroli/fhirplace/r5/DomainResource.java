package se.poroli.fhirplace.r5;

import java.util.List;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.Narrative;

/**
 * A resource that includes narrative, extensions, and contained resources.
 *
 * <p>Implemented by the resource records in the per-resource modules.
 *
 * @see <a href="http://hl7.org/fhir/StructureDefinition/DomainResource">FHIR R5 DomainResource</a>
 */
public interface DomainResource extends Resource {

    /**
     * Text summary of the resource, for human interpretation.
     *
     * @return the text, or {@code null} if absent
     */
    Narrative text();

    /**
     * Contained, inline Resources.
     *
     * @return the contained, never {@code null}
     */
    List<Resource> contained();

    /**
     * Additional content defined by implementations.
     *
     * @return the extension, never {@code null}
     */
    List<Extension> extension();

    /**
     * Extensions that cannot be ignored. Modifier element.
     *
     * @return the modifierExtension, never {@code null}
     */
    List<Extension> modifierExtension();
}
