package se.poroli.fhirplace.r5.server.shared;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;

/** A read-only handler, so the server must refuse the other interactions on Observation. */
@ApplicationScoped
@FhirResource(Observation.class)
public class ObservationHandler {

    @Read
    public Optional<Observation> read(@Id String id) {
        return Optional.empty();
    }
}
