package se.poroli.fhirplace.examples.springboot;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.server.Create;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.ReferenceParam;
import se.poroli.fhirplace.r5.server.Search;
import se.poroli.fhirplace.r5.server.SearchParam;
import se.poroli.fhirplace.r5.server.TokenParam;

/**
 * Serves {@code Observation} with a subset of the interactions: read, create and search. The server answers the
 * others, such as update and delete, with 405 and lists only these in its CapabilityStatement.
 */
@Component
@FhirResource(Observation.class)
public class ObservationHandler {

    private final InMemoryStore<Observation> store = new InMemoryStore<>("Observation",
            (observation, id, meta) -> observation.toBuilder().id(id).meta(meta).build());

    /** {@code GET /fhir/Observation/{id}}. */
    @Read
    public Optional<Observation> read(@Id String id) {
        return store.current(id);
    }

    /** {@code POST /fhir/Observation}. */
    @Create
    public Observation create(Observation observation) {
        return store.create(observation);
    }

    /** {@code GET /fhir/Observation?subject=Patient/1&code=http://loinc.org|8867-4}. */
    @Search
    public List<Observation> search(
            @SearchParam("subject") ReferenceParam subject,
            @SearchParam("code") TokenParam code) {
        return store.all()
                .filter(observation -> subject == null || (observation.subject() != null
                        && observation.subject().reference() != null
                        && subject.anyOf().contains(observation.subject().reference().value())))
                .filter(observation -> code == null || (observation.code() != null
                        && observation.code().coding().stream().anyMatch(coding -> matches(coding, code))))
                .toList();
    }

    private static boolean matches(Coding coding, TokenParam code) {
        String system = coding.system() == null ? "" : coding.system().value();
        String value = coding.code() == null ? null : coding.code().value();
        return code.anyOf().stream().anyMatch(token -> (token.system() == null || token.system().equals(system))
                && (token.code() == null || token.code().equals(value)));
    }
}
