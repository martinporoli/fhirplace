package se.poroli.fhirplace.r5.server.shared;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.server.Create;
import se.poroli.fhirplace.r5.server.DateParam;
import se.poroli.fhirplace.r5.server.Delete;
import se.poroli.fhirplace.r5.server.FhirException;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirResult;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.ReferenceParam;
import se.poroli.fhirplace.r5.server.Saved;
import se.poroli.fhirplace.r5.server.Search;
import se.poroli.fhirplace.r5.server.SearchParam;
import se.poroli.fhirplace.r5.server.StringParam;
import se.poroli.fhirplace.r5.server.TokenParam;
import se.poroli.fhirplace.r5.server.Update;
import se.poroli.fhirplace.r5.server.VRead;
import se.poroli.fhirplace.r5.server.VersionId;

/** A versioned in-memory Patient store implementing every supported interaction. */
@ApplicationScoped
@FhirResource(Patient.class)
public class PatientHandler {

    private final Map<String, List<Patient>> versions = new ConcurrentHashMap<>();
    private final Set<String> deleted = ConcurrentHashMap.newKeySet();
    private final AtomicInteger ids = new AtomicInteger();

    /** Patients with these ids exist only to show custom error responses. */
    static final String ARCHIVED = "archived";
    static final String BUSY = "busy";

    @Read
    public Optional<Patient> read(@Id String id) {
        if (id.equals(ARCHIVED)) {
            throw new FhirException(404, OperationOutcome.builder()
                    .addIssue(OperationOutcome.Issue.builder()
                            .severity(IssueSeverity.ERROR)
                            .code(IssueType.NOT_FOUND)
                            .details(CodeableConcept.builder().text("Patient is archived").build())
                            .diagnostics(FhirString.of("Patient/archived was archived; ask the records office"))
                            .build())
                    .build());
        }
        if (id.equals(BUSY)) {
            throw new FhirException(503, OperationOutcome.builder()
                    .addIssue(OperationOutcome.Issue.builder()
                            .severity(IssueSeverity.ERROR)
                            .code(IssueType.TRANSIENT)
                            .diagnostics(FhirString.of("Try again later"))
                            .build())
                    .build(), Map.of("Retry-After", List.of("120")));
        }
        if (deleted.contains(id)) {
            throw FhirException.gone("Patient", id);
        }
        List<Patient> history = versions.get(id);
        return history == null ? Optional.empty() : Optional.of(history.getLast());
    }

    @VRead
    public Optional<Patient> vread(@Id String id, @VersionId String versionId) {
        return versions.getOrDefault(id, List.of()).stream()
                .filter(p -> p.meta().versionId().value().equals(versionId))
                .findFirst();
    }

    /** Echoes the request's {@code X-Correlation-Id} header, to show reading the request and adding headers. */
    @Create
    public FhirResult<Patient> create(Patient patient, FhirRequest request) {
        FhirResult<Patient> result = FhirResult.of(201, store("p" + ids.incrementAndGet(), patient));
        String correlationId = request.header("X-Correlation-Id");
        return correlationId == null ? result : result.withHeader("X-Correlation-Id", correlationId);
    }

    @Update
    public Saved<Patient> update(@Id String id, Patient patient) {
        boolean created = !versions.containsKey(id);
        Patient stored = store(id, patient);
        return created ? Saved.created(stored) : Saved.updated(stored);
    }

    /** With {@code X-Delete-Mode: async}, answers 202 with an OperationOutcome, as an asynchronous delete would. */
    @Delete
    public FhirResult<OperationOutcome> delete(@Id String id, FhirRequest request) {
        if (!versions.containsKey(id)) {
            throw FhirException.notFound("Patient", id);
        }
        deleted.add(id);
        if ("async".equals(request.header("X-Delete-Mode"))) {
            return FhirResult.of(202, OperationOutcome.builder()
                    .addIssue(OperationOutcome.Issue.builder()
                            .severity(IssueSeverity.INFORMATION)
                            .code(IssueType.INFORMATIONAL)
                            .diagnostics(FhirString.of("Deletion of Patient/" + id + " is scheduled"))
                            .build())
                    .build());
        }
        return FhirResult.status(204);
    }

    @Search
    public List<Patient> search(
            @SearchParam("family") StringParam family,
            @SearchParam("identifier") TokenParam identifier,
            @SearchParam("birthdate") List<DateParam> birthdate,
            @SearchParam("general-practitioner") ReferenceParam generalPractitioner) {
        return versions.keySet().stream()
                .filter(id -> !deleted.contains(id))
                .map(id -> versions.get(id).getLast())
                .filter(p -> family == null || family.anyOf().stream().anyMatch(f -> hasFamily(p, f)))
                .filter(p -> identifier == null || identifier.anyOf().stream().anyMatch(t -> hasIdentifier(p, t)))
                .filter(p -> birthdate.stream().allMatch(d -> d.anyOf().stream().anyMatch(v -> bornIn(p, v))))
                .filter(p -> generalPractitioner == null
                        || generalPractitioner.anyOf().stream().anyMatch(r -> hasPractitioner(p, r)))
                .sorted(java.util.Comparator.comparing(Patient::id))
                .toList();
    }

    private Patient store(String id, Patient patient) {
        List<Patient> history = versions.computeIfAbsent(id, k -> new ArrayList<>());
        synchronized (history) {
            Patient stored = patient.toBuilder()
                    .id(id)
                    .meta(Meta.builder()
                            .versionId(String.valueOf(history.size() + 1))
                            .lastUpdated(OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS))
                            .build())
                    .build();
            history.add(stored);
            deleted.remove(id);
            return stored;
        }
    }

    private static boolean hasFamily(Patient patient, String family) {
        for (HumanName name : patient.name()) {
            if (name.family() != null && name.family().value().toLowerCase(Locale.ROOT)
                    .startsWith(family.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasIdentifier(Patient patient, TokenParam.Token token) {
        for (Identifier identifier : patient.identifier()) {
            String system = identifier.system() == null ? null : identifier.system().value();
            String value = identifier.value() == null ? null : identifier.value().value();
            if ((token.system() == null || token.system().equals(system == null ? "" : system))
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

    private static boolean hasPractitioner(Patient patient, String reference) {
        for (Reference practitioner : patient.generalPractitioner()) {
            if (practitioner.reference() != null && practitioner.reference().value().equals(reference)) {
                return true;
            }
        }
        return false;
    }
}
