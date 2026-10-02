package se.poroli.fhirplace.r5.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.patient.Patient;

/** The body handlers and publishers in plain {@code HttpClient} code, against a real fhirplace server. */
class BodyHandlersTest {

    private final HttpClient http = HttpClient.newHttpClient();

    @Test
    void sendsAndReadsResources() throws Exception {
        Patient patient = Patient.builder().addName(HumanName.builder().family("Plain").build()).build();

        HttpResponse<Patient> created = http.send(HttpRequest.newBuilder(TestServers.fhir().resolve("Patient"))
                        .header("Content-Type", "application/fhir+json")
                        .POST(FhirBodyPublishers.json(patient)).build(),
                FhirBodyHandlers.of(Patient.class));
        HttpResponse<Patient> read = http.send(HttpRequest.newBuilder(
                        TestServers.fhir().resolve("Patient/" + created.body().id()))
                        .header("Accept", "application/fhir+xml").build(),
                FhirBodyHandlers.of(Patient.class));

        assertEquals(201, created.statusCode());
        assertEquals(created.body(), read.body());
    }

    @Test
    void errorsFailTheExchangeWithTheOutcome() {
        IOException e = assertThrows(IOException.class, () -> http.send(
                HttpRequest.newBuilder(TestServers.fhir().resolve("Patient/archived")).build(),
                FhirBodyHandlers.of(Patient.class)));

        FhirClientException cause = assertInstanceOf(FhirClientException.class, e.getCause());
        assertEquals(404, cause.status());
        assertEquals("Patient is archived", cause.outcome().issue().getFirst().details().text().value());
    }
}
