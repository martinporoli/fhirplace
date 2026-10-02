package se.poroli.fhirplace.examples.quarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.client.FhirClient;
import se.poroli.fhirplace.r5.client.FhirClientException;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.observation.Observation;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;

/** What clients see when a resource breaks the base FHIR rules or this server's profiles. */
@QuarkusTest
class ValidationTest {

    @TestHTTPResource("fhir")
    URI base;

    private FhirClient fhir() {
        return FhirClient.of(base);
    }

    private static OperationOutcome.Issue firstIssue(FhirClientException e) {
        return e.outcome().issue().getFirst();
    }

    private static String expression(OperationOutcome.Issue issue) {
        return issue.expression().getFirst().value();
    }

    private static Observation.Builder heartRate() {
        return Observation.builder()
                .status(ObservationStatus.FINAL)
                .code(CodeableConcept.builder()
                        .addCoding(Coding.builder().system("http://loinc.org").code("8867-4").build()).build())
                .subject(Reference.builder().reference("Patient/1").build())
                .value(Quantity.builder().value(new BigDecimal("72")).unit("beats/minute").build());
    }

    @Test
    void profileErrorsAreUnprocessableAndPointAtTheElement() {
        Patient withoutFamily = Patient.builder().addName(HumanName.builder().addGiven("Alex").build()).build();
        Patient bornTomorrow = Patient.builder().addName(HumanName.builder().family("Early").build())
                .birthDate(LocalDate.now().plusDays(1)).build();

        FhirClientException family = assertThrows(FhirClientException.class, () -> fhir().create(withoutFamily));
        FhirClientException birth = assertThrows(FhirClientException.class, () -> fhir().create(bornTomorrow));

        assertEquals(422, family.status());
        assertEquals("Family name is required", firstIssue(family).diagnostics().value());
        assertEquals("Patient.name[0].family", expression(firstIssue(family)));
        assertEquals("Birth date cannot be in the future", firstIssue(birth).diagnostics().value());
        assertEquals("Patient.birthDate", expression(firstIssue(birth)));
    }

    @Test
    void theOutcomeListsAllIssuesIncludingWarnings() {
        FhirClientException e = assertThrows(FhirClientException.class,
                () -> fhir().create(Patient.builder().active(true).build()));

        assertEquals(List.of("error", "warning"), e.outcome().issue().stream()
                .map(issue -> issue.severity().valueAsString()).toList());
        assertEquals("Patients should have a medical record number", e.outcome().issue().get(1).diagnostics().value());
    }

    @Test
    void warningsAloneDoNotBlock() {
        Patient withoutMrn = Patient.builder().addName(HumanName.builder().family("NoMrn").build()).build();

        assertEquals(201, fhir().create(withoutMrn).status());
    }

    @Test
    void observationsFollowTheirProfile() {
        FhirClientException noPatient = assertThrows(FhirClientException.class,
                () -> fhir().create(heartRate().subject(Reference.builder().reference("Group/1").build()).build()));
        FhirClientException wrongUnit = assertThrows(FhirClientException.class,
                () -> fhir().create(heartRate().value(Quantity.builder().value(new BigDecimal("1.2")).unit("Hz")
                        .build()).build()));

        assertEquals("Observation.subject", expression(firstIssue(noPatient)));
        assertEquals("A heart rate must be a quantity in beats/minute", firstIssue(wrongUnit).diagnostics().value());
        assertEquals(201, fhir().create(heartRate().build()).status());
    }

    @Test
    void contentThatBreaksTheBaseRulesIsRejectedBeforeTheProfile() {
        FhirClientException e = assertThrows(FhirClientException.class, () -> fhir().send(
                fhir().request("Patient").header("Content-Type", "application/fhir+json")
                        .POST(HttpRequest.BodyPublishers.ofString(
                                "{\"resourceType\":\"Patient\",\"birthDate\":\"1974-13-45\"}")),
                Patient.class));

        assertEquals(422, e.status());
        assertEquals("value", firstIssue(e).code().valueAsString());
        assertEquals("Patient.birthDate", expression(firstIssue(e)));
    }
}
