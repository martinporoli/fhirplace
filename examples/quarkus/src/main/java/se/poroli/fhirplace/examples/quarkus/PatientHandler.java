package se.poroli.fhirplace.examples.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.rest.FhirHttpException;
import se.poroli.fhirplace.r5.server.Create;
import se.poroli.fhirplace.r5.server.DateParam;
import se.poroli.fhirplace.r5.server.Delete;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.Saved;
import se.poroli.fhirplace.r5.server.Search;
import se.poroli.fhirplace.r5.server.SearchParam;
import se.poroli.fhirplace.r5.server.StringParam;
import se.poroli.fhirplace.r5.server.TokenParam;
import se.poroli.fhirplace.r5.server.Update;
import se.poroli.fhirplace.r5.server.VRead;
import se.poroli.fhirplace.r5.server.VersionId;
import se.poroli.fhirplace.r5.validation.ValidationResult;

/**
 * Serves {@code Patient} with all interactions fhirplace supports. Everything FHIR-specific in HTTP, such as status
 * codes, headers, content negotiation and OperationOutcome errors, is done by the fhirplace server; this class only
 * holds the application logic, including which profile new and changed patients must follow ({@link Profiles}).
 */
@ApplicationScoped
@FhirResource(Patient.class)
public class PatientHandler {

    private final InMemoryStore<Patient> store = new InMemoryStore<>("Patient",
            (patient, id, meta) -> patient.toBuilder().id(id).meta(meta).build());

    /** {@code GET /fhir/Patient/{id}}: an empty result becomes 404. */
    @Read
    public Optional<Patient> read(@Id String id) {
        return store.current(id);
    }

    /** {@code GET /fhir/Patient/{id}/_history/{vid}}. */
    @VRead
    public Optional<Patient> vread(@Id String id, @VersionId String versionId) {
        return store.version(id, versionId);
    }

    /** {@code POST /fhir/Patient}: answered with 201, {@code Location} and {@code ETag}. */
    @Create
    public Patient create(Patient patient) {
        ValidationResult result = Profiles.PATIENT.validate(patient);
        if (!result.isValid()) {
            throw FhirHttpException.unprocessable(result.toOperationOutcome());
        }
        return store.create(patient);
    }

    /** {@code PUT /fhir/Patient/{id}}: updates, or creates the patient under the client's id. */
    @Update
    public Saved<Patient> update(@Id String id, Patient patient) {
        ValidationResult result = Profiles.PATIENT.validate(patient);
        if (!result.isValid()) {
            throw FhirHttpException.unprocessable(result.toOperationOutcome());
        }
        boolean exists = store.exists(id);
        Patient stored = store.save(id, patient);
        return exists ? Saved.updated(stored) : Saved.created(stored);
    }

    /** {@code DELETE /fhir/Patient/{id}}: answered with 204; later reads answer 410 Gone. */
    @Delete
    public void delete(@Id String id) {
        store.delete(id);
    }

    /**
     * {@code GET /fhir/Patient?family=...&identifier=...&birthdate=...}, also as {@code POST /fhir/Patient/_search}.
     * Comma-separated values are alternatives; a repeated {@code birthdate} must match every occurrence.
     */
    @Search
    public Stream<Patient> search(
            @SearchParam("family") StringParam family,
            @SearchParam("identifier") TokenParam identifier,
            @SearchParam("birthdate") List<DateParam> birthdate) {
        return store.all()
                .filter(patient -> family == null || family.anyOf().stream().anyMatch(f -> hasFamily(patient, f)))
                .filter(patient -> identifier == null
                        || identifier.anyOf().stream().anyMatch(token -> hasIdentifier(patient, token)))
                .filter(patient -> birthdate.stream()
                        .allMatch(date -> date.anyOf().stream().anyMatch(value -> bornIn(patient, value))));
    }

    private static boolean hasFamily(Patient patient, String family) {
        String prefix = family.toLowerCase(Locale.ROOT);
        return patient.name().stream()
                .map(HumanName::family)
                .anyMatch(name -> name != null && name.value().toLowerCase(Locale.ROOT).startsWith(prefix));
    }

    private static boolean hasIdentifier(Patient patient, TokenParam.Token token) {
        for (Identifier identifier : patient.identifier()) {
            String system = identifier.system() == null ? "" : identifier.system().value();
            String value = identifier.value() == null ? null : identifier.value().value();
            if ((token.system() == null || token.system().equals(system))
                    && (token.code() == null || token.code().equals(value))) {
                return true;
            }
        }
        return false;
    }

    private static boolean bornIn(Patient patient, DateParam.Value value) {
        if (patient.birthDate() == null || !(patient.birthDate().value() instanceof LocalDate born)
                || !(value.value().value() instanceof LocalDate date)) {
            return false;
        }
        return switch (value.prefix()) {
            case EQ, AP -> born.equals(date);
            case NE -> !born.equals(date);
            case GT, SA -> born.isAfter(date);
            case LT, EB -> born.isBefore(date);
            case GE -> !born.isBefore(date);
            case LE -> !born.isAfter(date);
        };
    }
}
