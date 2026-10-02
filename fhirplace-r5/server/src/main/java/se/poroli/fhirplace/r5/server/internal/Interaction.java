package se.poroli.fhirplace.r5.server.internal;

import java.lang.annotation.Annotation;
import se.poroli.fhirplace.r5.capabilitystatement.TypeRestfulInteraction;
import se.poroli.fhirplace.r5.server.Create;
import se.poroli.fhirplace.r5.server.Delete;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.Search;
import se.poroli.fhirplace.r5.server.Update;
import se.poroli.fhirplace.r5.server.VRead;

/** The FHIR interactions a handler method can implement, in CapabilityStatement order. */
enum Interaction {
    READ(Read.class, TypeRestfulInteraction.READ),
    VREAD(VRead.class, TypeRestfulInteraction.VREAD),
    UPDATE(Update.class, TypeRestfulInteraction.UPDATE),
    DELETE(Delete.class, TypeRestfulInteraction.DELETE),
    CREATE(Create.class, TypeRestfulInteraction.CREATE),
    SEARCH(Search.class, TypeRestfulInteraction.SEARCH_TYPE);

    private final Class<? extends Annotation> annotation;
    private final TypeRestfulInteraction code;

    Interaction(Class<? extends Annotation> annotation, TypeRestfulInteraction code) {
        this.annotation = annotation;
        this.code = code;
    }

    Class<? extends Annotation> annotation() {
        return annotation;
    }

    TypeRestfulInteraction code() {
        return code;
    }

    String displayName() {
        return "@" + annotation.getSimpleName();
    }
}
