package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.http.HttpClient;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletionException;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.Resource;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.rest.FhirHttpException;

/** The client against a real fhirplace server. */
class FhirClientTest {

    private final FhirClient fhir = FhirClient.of(TestServers.fhir());

    private static Patient patient(String family) {
        return Patient.builder()
                .addName(HumanName.builder().family(family).addGiven("Pat").build())
                .birthDate(LocalDate.of(1980, 5, 5))
                .addIdentifier(Identifier.builder().system("http://acme.org/mrn").value(family + "|mrn").build())
                .build();
    }

    private static String unique() {
        return "F" + UUID.randomUUID().toString().substring(0, 8);
    }

    private List<String> ids(SearchQuery search) {
        return fhir.search(Patient.class, search).body().entry().stream().map(e -> e.resource().id()).toList();
    }

    @Test
    void createReadUpdateAndDelete() {
        FhirClientResponse<Patient> created = fhir.create(patient(unique()));
        Patient patient = created.body();

        assertEquals(201, created.status());
        assertEquals("W/\"1\"", created.etag());
        assertEquals(fhir.baseUri().resolve("Patient/" + patient.id() + "/_history/1"), created.location());
        assertEquals(patient, fhir.read(Patient.class, patient.id()).body());

        FhirClientResponse<Patient> updated = fhir.update(patient.toBuilder().active(true).build());
        assertEquals("W/\"2\"", updated.etag());
        assertEquals(true, updated.body().active().value());
        assertEquals(null, fhir.vread(Patient.class, patient.id(), "1").body().active());

        FhirHttpException conflict = assertThrows(FhirHttpException.class,
                () -> fhir.update(patient.toBuilder().active(false).build()));   // still version 1: stale
        assertEquals(412, conflict.status());

        assertEquals(204, fhir.delete(Patient.class, patient.id()).status());
        assertEquals(410, assertThrows(FhirHttpException.class,
                () -> fhir.read(Patient.class, patient.id())).status());
    }

    @Test
    void errorsCarryTheServersOutcomeAndHeaders() {
        FhirHttpException notFound = assertThrows(FhirHttpException.class,
                () -> fhir.read(Patient.class, "archived"));
        FhirHttpException busy = assertThrows(FhirHttpException.class, () -> fhir.read(Patient.class, "busy"));

        assertEquals(404, notFound.status());
        assertEquals("Patient/archived was archived; ask the records office",
                notFound.outcome().issue().getFirst().diagnostics().value());
        assertEquals("HTTP 404: Patient/archived was archived; ask the records office", notFound.getMessage());
        assertEquals(503, busy.status());
        assertEquals("120", busy.header("retry-after"));
    }

    @Test
    void errorsWithoutAnOutcomeKeepTheirStatusAndHeaders() {
        FhirHttpException error = assertThrows(FhirHttpException.class,
                () -> fhir.read(Patient.class, "no-outcome"));

        assertEquals(503, error.status());
        assertEquals("120", error.header("Retry-After"));
        assertNull(error.outcome());
        assertEquals("HTTP 503", error.getMessage());
    }

    @Test
    void validationErrorsKeepTheirDetailsAndExpression() {
        FhirHttpException error = assertThrows(FhirHttpException.class, () -> fhir.create(patient("Rejected")));

        assertEquals(422, error.status());
        OperationOutcome.Issue issue = error.outcome().issue().getFirst();
        assertEquals("business-rule", issue.code().valueAsString());
        assertEquals("The family name Rejected is not accepted", issue.details().text().value());
        assertEquals("Patient.name[0].family", issue.expression().getFirst().value());
        assertNull(issue.diagnostics());
        assertEquals("HTTP 422: The family name Rejected is not accepted", error.getMessage());
    }

    @Test
    void searchEscapesValuesAndCombinesParameters() {
        String family = unique() + ", Jr";
        Patient patient = fhir.create(patient(family)).body();

        assertEquals(List.of(patient.id()), ids(SearchQuery.where("family", family)));
        assertEquals(List.of(patient.id()), ids(SearchQuery.where("family", family)
                .and("identifier", SearchQuery.token("http://acme.org/mrn", family + "|mrn"))
                .and("birthdate", SearchQuery.ge(LocalDate.of(1980, 1, 1)))
                .and("birthdate", SearchQuery.lt(LocalDate.of(1981, 1, 1)))));
        assertEquals(List.of(), ids(SearchQuery.where("family", family)
                .and("birthdate", SearchQuery.lt(LocalDate.of(1980, 1, 1)))));
    }

    @Test
    void searchAllPagesThroughAFhirplaceServer() {
        String family = unique();
        List<String> created = java.util.stream.IntStream.range(0, 5)
                .mapToObj(i -> fhir.create(patient(family)).body().id())
                .sorted()
                .toList();

        try (var all = fhir.searchAll(Patient.class, SearchQuery.where("family", family).count(2))) {
            assertEquals(created, all.map(Patient::id).toList());
        }
        assertEquals(2, fhir.search(Patient.class, SearchQuery.where("family", family).count(2)).body().entry().size());
    }

    @Test
    void searchErrorsAreReported() {
        FhirHttpException e = assertThrows(FhirHttpException.class,
                () -> fhir.search(Patient.class, SearchQuery.where("shoe-size", 42)));

        assertEquals(400, e.status());
        assertTrue(e.outcome().issue().getFirst().diagnostics().value().contains("shoe-size"));
    }

    @Test
    void speaksXml() {
        FhirClient xml = fhir.withFormat(FhirFormat.XML);

        FhirClientResponse<Patient> created = xml.create(patient(unique()));
        FhirClientResponse<Patient> read = xml.read(Patient.class, created.body().id());

        assertTrue(created.header("Content-Type").startsWith("application/fhir+xml"));
        assertEquals(created.body(), read.body());
    }

    @Test
    void defaultHeadersAreSent() {
        FhirClientResponse<Patient> created = fhir.withHeader("X-Correlation-Id", "abc-123").create(patient(unique()));

        assertEquals("abc-123", created.header("X-Correlation-Id"));
    }

    @Test
    void asyncCallsCompleteWithTheResponseOrTheError() {
        Patient patient = fhir.createAsync(patient(unique())).join().body();

        assertEquals(patient, fhir.readAsync(Patient.class, patient.id()).join().body());
        CompletionException e = assertThrows(CompletionException.class,
                () -> fhir.readAsync(Patient.class, "archived").join());
        assertEquals(404, assertInstanceOf(FhirHttpException.class, e.getCause()).status());
    }

    @Test
    void sendCoversOtherInteractions() {
        Patient patient = fhir.create(patient(unique())).body();

        FhirClientResponse<Resource> response = fhir.send(
                fhir.request("Patient/" + patient.id()).header("X-Delete-Mode", "async").DELETE(), Resource.class);

        assertEquals(202, response.status());
        assertInstanceOf(OperationOutcome.class, response.body());
    }

    @Test
    void requestPathsStayBelowTheBaseUrl() {
        Patient patient = fhir.create(patient(unique())).body();
        for (String path : List.of("Patient/" + patient.id(), "/Patient/" + patient.id())) {
            assertEquals(patient, fhir.send(fhir.request(path).GET(), Patient.class).body(), path);
        }
        assertEquals(fhir.baseUri().resolve("other.example/metadata"),
                fhir.request("//other.example/metadata").build().uri());
        assertThrows(IllegalArgumentException.class, () -> fhir.request("https://other.example/metadata"));
    }

    @Test
    void derivedClientsShareTheHttpClient() {
        HttpClient http = HttpClient.newHttpClient();
        FhirClient a = FhirClient.of("https://a.example/fhir", http).withHeader("Authorization", "x");
        FhirClient b = a.at("https://b.example/fhir");

        assertSame(http, b.httpClient());
        assertEquals(URI.create("https://b.example/fhir/"), b.baseUri());
        assertSame(http, a.at(URI.create("https://c.example/fhir")).httpClient());
        assertSame(FhirClient.of("https://a.example").httpClient(), FhirClient.of("https://b.example").httpClient());
    }
}
