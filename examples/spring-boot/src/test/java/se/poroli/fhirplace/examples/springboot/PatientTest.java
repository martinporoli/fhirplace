package se.poroli.fhirplace.examples.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import se.poroli.fhirplace.r5.client.FhirClient;
import se.poroli.fhirplace.r5.client.FhirClientException;
import se.poroli.fhirplace.r5.client.FhirClientResponse;
import se.poroli.fhirplace.r5.client.FhirFormat;
import se.poroli.fhirplace.r5.client.SearchQuery;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.patient.Patient;

/** Uses the Patient endpoints with the fhirplace client, the way another application would. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientTest {

    @Value("${local.server.port}")
    private int port;

    private URI base;

    @BeforeEach
    void setBase() {
        base = URI.create("http://localhost:" + port + "/fhir");
    }

    private FhirClient fhir() {
        return FhirClient.of(base);
    }

    private static Patient newPatient(String family) {
        return Patient.builder()
                .addName(HumanName.builder().family(family).addGiven("Alex").build())
                .birthDate(LocalDate.of(1980, 3, 14))
                .addIdentifier(Identifier.builder().system("http://example.org/mrn").value(family + "-mrn").build())
                .build();
    }

    private static String uniqueFamily() {
        return "Family" + UUID.randomUUID().toString().substring(0, 8);
    }

    @Test
    void createReadUpdateAndDelete() {
        FhirClient fhir = fhir();

        // create: the response carries the stored patient, its version and location
        FhirClientResponse<Patient> created = fhir.create(newPatient(uniqueFamily()));
        Patient patient = created.body();
        assertEquals("W/\"1\"", created.etag());
        assertEquals(URI.create(base + "/Patient/" + patient.id() + "/_history/1"), created.location());

        // read
        assertEquals(patient, fhir.read(Patient.class, patient.id()).body());

        // update: the client sends If-Match from meta.versionId, so a stale copy is rejected
        Patient updated = fhir.update(patient.toBuilder().active(true).build()).body();
        assertEquals("2", updated.meta().versionId().value());
        assertEquals(412, assertThrows(FhirClientException.class,
                () -> fhir.update(patient.toBuilder().active(false).build())).status());

        // the first version is still readable
        assertEquals(null, fhir.vread(Patient.class, patient.id(), "1").body().active());

        // delete, after which the patient is gone
        assertEquals(204, fhir.delete(Patient.class, patient.id()).status());
        assertEquals(410, assertThrows(FhirClientException.class,
                () -> fhir.read(Patient.class, patient.id())).status());
    }

    @Test
    void errorsAreOperationOutcomes() {
        FhirClientException notFound = assertThrows(FhirClientException.class,
                () -> fhir().read(Patient.class, "12345678"));
        FhirClientException unnamed = assertThrows(FhirClientException.class,
                () -> fhir().create(Patient.builder().active(true).build()));

        assertEquals(404, notFound.status());
        assertEquals("not-found", notFound.outcome().issue().getFirst().code().valueAsString());
        assertEquals(422, unnamed.status());
        assertEquals("A patient must have a name", unnamed.outcome().issue().getFirst().diagnostics().value());
    }

    @Test
    void searchByNameIdentifierAndBirthDate() {
        String family = uniqueFamily();
        Patient patient = fhir().create(newPatient(family)).body();

        SearchQuery search = SearchQuery.where("family", family)
                .and("identifier", SearchQuery.token("http://example.org/mrn", family + "-mrn"))
                .and("birthdate", SearchQuery.ge(LocalDate.of(1980, 1, 1)))
                .and("birthdate", SearchQuery.lt(LocalDate.of(1981, 1, 1)));

        try (var matches = fhir().searchAll(Patient.class, search)) {
            assertEquals(List.of(patient.id()), matches.map(Patient::id).toList());
        }
    }

    @Test
    void unknownSearchParametersAreRejectedUnlessLenient() {
        SearchQuery search = SearchQuery.where("shoe-size", 42);

        assertEquals(400, assertThrows(FhirClientException.class,
                () -> fhir().search(Patient.class, search)).status());
        assertEquals(200, fhir().withHeader("Prefer", "handling=lenient").search(Patient.class, search).status());
    }

    @Test
    void speaksXmlToo() {
        FhirClient xml = fhir().withFormat(FhirFormat.XML);

        Patient patient = xml.create(newPatient(uniqueFamily())).body();
        FhirClientResponse<Patient> read = xml.read(Patient.class, patient.id());

        assertEquals(patient, read.body());
        assertEquals(true, read.header("Content-Type").startsWith("application/fhir+xml"));
    }
}
