package se.poroli.fhirplace.examples.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.stereotype.Component;
import se.poroli.fhirplace.r5.client.FhirClientException;
import se.poroli.fhirplace.r5.client.FhirClientResponse;
import se.poroli.fhirplace.r5.client.SearchQuery;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.server.Create;
import se.poroli.fhirplace.r5.server.Delete;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.Saved;
import se.poroli.fhirplace.r5.server.Search;
import se.poroli.fhirplace.r5.server.SearchParam;
import se.poroli.fhirplace.r5.server.StringParam;
import se.poroli.fhirplace.r5.server.TokenParam;
import se.poroli.fhirplace.r5.server.Update;

/**
 * Serves {@code Patient} by forwarding each interaction to the backend of the request's region. The fhirplace server
 * still handles the proxy's own HTTP: its URLs in {@code Location} and Bundle links, {@code If-Match}, formats and
 * errors. Backend errors are passed on with the backend's status and OperationOutcome.
 */
@Component
@FhirResource(Patient.class)
public class PatientRouter {

    private final Backends backends;

    public PatientRouter(Backends backends) {
        this.backends = backends;
    }

    @Read
    public Optional<Patient> read(@Id String id, FhirRequest request) {
        return Optional.of(forward(() -> backends.clientFor(request).read(Patient.class, id).body()));
    }

    @Create
    public Patient create(Patient patient, FhirRequest request) {
        return forward(() -> backends.clientFor(request).create(patient).body());
    }

    @Update
    public Saved<Patient> update(@Id String id, Patient patient, FhirRequest request) {
        FhirClientResponse<Patient> response = forward(() -> backends.clientFor(request).update(patient));
        return response.status() == 201 ? Saved.created(response.body()) : Saved.updated(response.body());
    }

    @Delete
    public void delete(@Id String id, FhirRequest request) {
        forward(() -> backends.clientFor(request).delete(Patient.class, id));
    }

    @Search
    public List<Patient> search(
            @SearchParam("family") StringParam family,
            @SearchParam("identifier") TokenParam identifier,
            FhirRequest request) {
        SearchQuery search = SearchQuery.all();
        if (family != null) {
            search = search.and(family.modifier() == null ? "family" : "family:" + family.modifier(),
                    family.anyOf().toArray());
        }
        if (identifier != null) {
            search = search.and("identifier", identifier.anyOf().stream()
                    .map(token -> SearchQuery.token(token.system(), token.code())).toArray());
        }
        SearchQuery query = search;
        return forward(() -> {
            try (var matches = backends.clientFor(request).searchAll(Patient.class, query)) {
                return new ArrayList<>(matches.toList());
            }
        });
    }

    /** Calls a backend, passing its errors on with their status, OperationOutcome and Retry-After. */
    private static <T> T forward(Supplier<T> call) {
        try {
            return call.get();
        } catch (FhirClientException e) {
            if (e.outcome() == null) {
                throw new FhirException(502, IssueType.EXCEPTION, "The backend answered " + e.status());
            }
            String retryAfter = e.header("Retry-After");
            throw new FhirException(e.status(), e.outcome(),
                    retryAfter == null ? Map.of() : Map.of("Retry-After", List.of(retryAfter)));
        }
    }
}
