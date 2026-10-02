package se.poroli.fhirplace.examples.quarkus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.bundle.Bundle;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.json.FhirJson;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.xml.FhirXml;

/** Uses the Patient endpoints the way a FHIR client would, over HTTP. */
@QuarkusTest
class PatientTest {

    private static final String FHIR_JSON = "application/fhir+json; charset=UTF-8";

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

    private static Patient create(Patient patient) {
        String body = given().contentType(FHIR_JSON).body(FhirJson.write(patient))
                .when().post("/fhir/Patient")
                .then().statusCode(201)
                .extract().asString();
        return FhirJson.read(body, Patient.class);
    }

    @Test
    void createReadUpdateAndDelete() {
        // create: 201 with Location and ETag
        Response created = given().contentType(FHIR_JSON).body(FhirJson.write(newPatient(uniqueFamily())))
                .when().post("/fhir/Patient");
        created.then().statusCode(201)
                .header("ETag", "W/\"1\"")
                .header("Location", startsWith("http://"))
                .header("Location", endsWith("/_history/1"));
        Patient patient = FhirJson.read(created.asString(), Patient.class);
        String url = "/fhir/Patient/" + patient.id();

        // read
        given().when().get(url)
                .then().statusCode(200).contentType(startsWith("application/fhir+json")).header("ETag", "W/\"1\"");

        // version-aware update: the matching version succeeds, a stale one is rejected
        Patient changed = patient.toBuilder().active(true).build();
        given().contentType(FHIR_JSON).header("If-Match", "W/\"1\"").body(FhirJson.write(changed))
                .when().put(url)
                .then().statusCode(200).header("ETag", "W/\"2\"");
        given().contentType(FHIR_JSON).header("If-Match", "W/\"1\"").body(FhirJson.write(changed))
                .when().put(url)
                .then().statusCode(412);

        // the first version is still readable
        Patient first = FhirJson.read(given().when().get(url + "/_history/1").then().statusCode(200)
                .extract().asString(), Patient.class);
        assertEquals(null, first.active());

        // delete, after which the patient is gone
        given().when().delete(url).then().statusCode(204);
        given().when().get(url).then().statusCode(410);
    }

    @Test
    void errorsAreOperationOutcomes() {
        String notFound = given().when().get("/fhir/Patient/12345678")
                .then().statusCode(404).extract().asString();
        String unnamed = given().contentType(FHIR_JSON).body(FhirJson.write(Patient.builder().active(true).build()))
                .when().post("/fhir/Patient")
                .then().statusCode(422).extract().asString();

        assertEquals("not-found", FhirJson.read(notFound, OperationOutcome.class).issue().getFirst().code()
                .valueAsString());
        assertEquals("A patient must have a name", FhirJson.read(unnamed, OperationOutcome.class).issue().getFirst()
                .diagnostics().value());
    }

    @Test
    void searchByNameIdentifierAndBirthDate() {
        String family = uniqueFamily();
        Patient patient = create(newPatient(family));

        List<String> byName = ids(given().when().get("/fhir/Patient?family=" + family));
        List<String> byIdentifier = ids(given().queryParam("identifier", "http://example.org/mrn|" + family + "-mrn")
                .when().get("/fhir/Patient"));
        List<String> byBirthDate = ids(given().when()
                .get("/fhir/Patient?family=" + family + "&birthdate=ge1980-01-01&birthdate=lt1981-01-01"));
        List<String> posted = ids(given().contentType("application/x-www-form-urlencoded")
                .formParam("family", family)
                .when().post("/fhir/Patient/_search"));

        assertEquals(List.of(patient.id()), byName);
        assertEquals(List.of(patient.id()), byIdentifier);
        assertEquals(List.of(patient.id()), byBirthDate);
        assertEquals(List.of(patient.id()), posted);
    }

    @Test
    void unknownSearchParametersAreRejectedUnlessLenient() {
        given().when().get("/fhir/Patient?shoe-size=42").then().statusCode(400);
        given().header("Prefer", "handling=lenient").when().get("/fhir/Patient?shoe-size=42").then().statusCode(200);
    }

    @Test
    void speaksXmlToo() {
        Patient patient = create(newPatient(uniqueFamily()));

        String xml = given().accept("application/fhir+xml").when().get("/fhir/Patient/" + patient.id())
                .then().statusCode(200).contentType(startsWith("application/fhir+xml")).extract().asString();
        String viaFormat = given().when().get("/fhir/Patient/" + patient.id() + "?_format=xml")
                .then().statusCode(200).extract().asString();

        assertEquals(patient, FhirXml.read(xml, Patient.class));
        assertTrue(viaFormat.startsWith("<Patient xmlns=\"http://hl7.org/fhir\">"));
    }

    private static List<String> ids(Response response) {
        Bundle bundle = FhirJson.read(response.then().statusCode(200).extract().asString(), Bundle.class);
        assertEquals("searchset", bundle.type().valueAsString());
        return bundle.entry().stream().map(entry -> entry.resource().id()).toList();
    }
}
