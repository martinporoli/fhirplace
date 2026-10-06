package se.poroli.fhirplace.examples.proxy;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.rest.FhirHttpException;
import se.poroli.fhirplace.r5.server.Create;
import se.poroli.fhirplace.r5.server.Delete;
import se.poroli.fhirplace.r5.server.FhirRequest;
import se.poroli.fhirplace.r5.server.FhirResource;
import se.poroli.fhirplace.r5.server.FhirResponse;
import se.poroli.fhirplace.r5.server.FhirServer;
import se.poroli.fhirplace.r5.server.Id;
import se.poroli.fhirplace.r5.server.Read;
import se.poroli.fhirplace.r5.server.Search;
import se.poroli.fhirplace.r5.server.SearchParam;
import se.poroli.fhirplace.r5.server.StringParam;
import se.poroli.fhirplace.r5.server.Update;

/** A regional FHIR server for the tests: in-memory Patients, served by fhirplace on the JDK's HTTP server. */
final class Backend {

    final URI base;
    final PatientStore patients = new PatientStore();

    private Backend(URI base) {
        this.base = base;
    }

    static Backend start() {
        try {
            HttpServer http = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
            Backend backend = new Backend(URI.create("http://localhost:" + http.getAddress().getPort() + "/fhir/"));
            FhirServer fhir = FhirServer.builder().handler(backend.patients).build();
            http.createContext("/fhir/", exchange -> {
                try (exchange) {
                    URI uri = exchange.getRequestURI();
                    FhirResponse response = fhir.handle(new FhirRequest(exchange.getRequestMethod(),
                            uri.getRawPath().substring("/fhir/".length()), uri.getRawQuery(),
                            new HashMap<>(exchange.getRequestHeaders()), exchange.getRequestBody().readAllBytes(),
                            backend.base));
                    response.headers().forEach((name, values) -> exchange.getResponseHeaders().put(name, values));
                    exchange.sendResponseHeaders(response.status(),
                            response.body().length == 0 ? -1 : response.body().length);
                    if (response.body().length > 0) {
                        try (OutputStream out = exchange.getResponseBody()) {
                            out.write(response.body());
                        }
                    }
                }
            });
            http.start();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> http.stop(0)));
            return backend;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /** A versioned in-memory Patient store that remembers the last Authorization header it saw. */
    @FhirResource(Patient.class)
    public static class PatientStore {

        private final Map<String, Patient> patients = new ConcurrentHashMap<>();
        private final AtomicInteger ids = new AtomicInteger();
        volatile String lastAuthorization;

        @Read
        public Optional<Patient> read(@Id String id, FhirRequest request) {
            lastAuthorization = request.header("Authorization");
            return Optional.ofNullable(patients.get(id));
        }

        @Create
        public Patient create(Patient patient) {
            return save("p" + ids.incrementAndGet(), patient);
        }

        @Update
        public Patient update(@Id String id, Patient patient) {
            return save(id, patient);
        }

        @Delete
        public void delete(@Id String id) {
            if (patients.remove(id) == null) {
                throw FhirHttpException.notFound("Patient", id);
            }
        }

        @Search
        public List<Patient> search(@SearchParam("family") StringParam family) {
            return patients.values().stream()
                    .filter(p -> family == null || p.name().stream().anyMatch(name -> name.family() != null
                            && family.anyOf().contains(name.family().value())))
                    .toList();
        }

        private Patient save(String id, Patient patient) {
            Patient current = patients.get(id);
            int version = current == null ? 1 : Integer.parseInt(current.meta().versionId().value()) + 1;
            Patient stored = patient.toBuilder().id(id).meta(Meta.builder()
                    .versionId(String.valueOf(version))
                    .lastUpdated(OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS))
                    .build()).build();
            patients.put(id, stored);
            return stored;
        }
    }
}
