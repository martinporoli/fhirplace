package se.poroli.fhirplace.examples.quarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.client.FhirClient;
import se.poroli.fhirplace.r5.client.FhirClientResponse;
import se.poroli.fhirplace.r5.client.FhirFormat;
import se.poroli.fhirplace.r5.client.SearchQuery;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.rest.FhirHttpException;

/** Uses the Patient endpoints with the fhirplace client, the way another application would. */
@QuarkusTest
class PatientTest {

    @TestHTTPResource("fhir")
    URI base;

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
        assertEquals(412, assertThrows(FhirHttpException.class,
                () -> fhir.update(patient.toBuilder().active(false).build())).status());

        // the first version is still readable
        assertEquals(null, fhir.vread(Patient.class, patient.id(), "1").body().active());

        // delete, after which the patient is gone
        assertEquals(204, fhir.delete(Patient.class, patient.id()).status());
        assertEquals(410, assertThrows(FhirHttpException.class,
                () -> fhir.read(Patient.class, patient.id())).status());
    }

    @Test
    void errorsAreOperationOutcomes() {
        FhirHttpException notFound = assertThrows(FhirHttpException.class,
                () -> fhir().read(Patient.class, "12345678"));
        FhirHttpException unnamed = assertThrows(FhirHttpException.class,
                () -> fhir().create(Patient.builder().active(true).build()));

        assertEquals(404, notFound.status());
        assertEquals("not-found", notFound.outcome().issue().getFirst().code().valueAsString());
        assertEquals(422, unnamed.status());
        assertEquals("A patient must have a name", unnamed.outcome().issue().getFirst().details().text().value());
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

        assertEquals(400, assertThrows(FhirHttpException.class,
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
