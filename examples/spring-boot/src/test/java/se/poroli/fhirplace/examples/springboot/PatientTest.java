package se.poroli.fhirplace.examples.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClient;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Uses the Patient endpoints the way a FHIR client would, over HTTP. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientTest {

    @Value("${local.server.port}")
    private int port;

    private RestClient client;

    @BeforeEach
    void createClient() {
        client = FhirClient.create(port);
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

    private ResponseEntity<String> post(Patient patient) {
        return client.post().uri("/Patient").contentType(FhirClient.FHIR_JSON).body(FhirJson.write(patient))
                .retrieve().toEntity(String.class);
    }

    private ResponseEntity<String> put(String url, Patient patient, String ifMatch) {
        return client.put().uri(url).contentType(FhirClient.FHIR_JSON).header("If-Match", ifMatch)
                .body(FhirJson.write(patient)).retrieve().toEntity(String.class);
    }

    private ResponseEntity<String> get(String url) {
        return client.get().uri(url).retrieve().toEntity(String.class);
    }

    @Test
    void createReadUpdateAndDelete() {
        // create: 201 with Location and ETag
        ResponseEntity<String> created = post(newPatient(uniqueFamily()));
        assertEquals(201, created.getStatusCode().value());
        assertEquals("W/\"1\"", created.getHeaders().getETag());
        assertTrue(created.getHeaders().getLocation().toString().endsWith("/_history/1"));
        Patient patient = FhirJson.read(created.getBody(), Patient.class);
        String url = "/Patient/" + patient.id();

        // read
        ResponseEntity<String> read = get(url);
        assertEquals(200, read.getStatusCode().value());
        assertTrue(read.getHeaders().getContentType().toString().startsWith("application/fhir+json"));

        // version-aware update: the matching version succeeds, a stale one is rejected
        Patient changed = patient.toBuilder().active(true).build();
        ResponseEntity<String> updated = put(url, changed, "W/\"1\"");
        assertEquals(200, updated.getStatusCode().value());
        assertEquals("W/\"2\"", updated.getHeaders().getETag());
        assertEquals(412, put(url, changed, "W/\"1\"").getStatusCode().value());

        // the first version is still readable
        assertEquals(null, FhirJson.read(get(url + "/_history/1").getBody(), Patient.class).active());

        // delete, after which the patient is gone
        assertEquals(204, client.delete().uri(url).retrieve().toBodilessEntity().getStatusCode().value());
        assertEquals(410, get(url).getStatusCode().value());
    }

    @Test
    void errorsAreOperationOutcomes() {
        ResponseEntity<String> notFound = get("/Patient/12345678");
        ResponseEntity<String> unnamed = post(Patient.builder().active(true).build());

        assertEquals(404, notFound.getStatusCode().value());
        assertEquals("not-found", FhirJson.read(notFound.getBody(), OperationOutcome.class).issue().getFirst()
                .code().valueAsString());
        assertEquals(422, unnamed.getStatusCode().value());
        assertEquals("A patient must have a name", FhirJson.read(unnamed.getBody(), OperationOutcome.class).issue()
                .getFirst().diagnostics().value());
    }

    @Test
    void searchByNameIdentifierAndBirthDate() {
        String family = uniqueFamily();
        Patient patient = FhirJson.read(post(newPatient(family)).getBody(), Patient.class);

        List<String> byName = ids(get("/Patient?family=" + family));
        List<String> byIdentifier = ids(client.get()
                .uri(uri -> uri.path("/Patient").queryParam("identifier", "{token}")
                        .build("http://example.org/mrn|" + family + "-mrn"))
                .retrieve().toEntity(String.class));
        List<String> byBirthDate = ids(get("/Patient?family=" + family
                + "&birthdate=ge1980-01-01&birthdate=lt1981-01-01"));
        LinkedMultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("family", family);
        List<String> posted = ids(client.post().uri("/Patient/_search")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).body(form)
                .retrieve().toEntity(String.class));

        assertEquals(List.of(patient.id()), byName);
        assertEquals(List.of(patient.id()), byIdentifier);
        assertEquals(List.of(patient.id()), byBirthDate);
        assertEquals(List.of(patient.id()), posted);
    }

    @Test
    void unknownSearchParametersAreRejectedUnlessLenient() {
        assertEquals(400, get("/Patient?shoe-size=42").getStatusCode().value());
        assertEquals(200, client.get().uri("/Patient?shoe-size=42").header("Prefer", "handling=lenient")
                .retrieve().toEntity(String.class).getStatusCode().value());
    }

    @Test
    void speaksXmlToo() {
        Patient patient = FhirJson.read(post(newPatient(uniqueFamily())).getBody(), Patient.class);

        ResponseEntity<String> xml = client.get().uri("/Patient/" + patient.id()).accept(FhirClient.FHIR_XML)
                .retrieve().toEntity(String.class);
        ResponseEntity<String> viaFormat = get("/Patient/" + patient.id() + "?_format=xml");

        assertTrue(xml.getHeaders().getContentType().toString().startsWith("application/fhir+xml"));
        assertEquals(patient, FhirXml.read(xml.getBody(), Patient.class));
        assertTrue(viaFormat.getBody().startsWith("<Patient xmlns=\"http://hl7.org/fhir\">"));
    }

    private static List<String> ids(ResponseEntity<String> response) {
        assertEquals(200, response.getStatusCode().value(), response.getBody());
        Bundle bundle = FhirJson.read(response.getBody(), Bundle.class);
        assertEquals("searchset", bundle.type().valueAsString());
        return bundle.entry().stream().map(entry -> entry.resource().id()).toList();
    }
}
