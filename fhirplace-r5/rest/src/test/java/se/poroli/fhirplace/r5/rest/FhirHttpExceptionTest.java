package se.poroli.fhirplace.r5.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;

class FhirHttpExceptionTest {

    @Test
    void factoriesChooseTheStatusAndIssueCode() {
        List<FhirHttpException> errors = List.of(
                FhirHttpException.notFound("Patient", "p1"),
                FhirHttpException.gone("Patient", "p1"),
                FhirHttpException.invalid("Invalid id"),
                FhirHttpException.conflict("Still referenced"),
                FhirHttpException.preconditionFailed("Wrong version"),
                FhirHttpException.unprocessable("Missing identifier"));

        assertEquals(List.of(404, 410, 400, 409, 412, 422),
                errors.stream().map(FhirHttpException::status).toList());
        assertEquals(List.of("not-found", "deleted", "invalid", "conflict", "conflict", "business-rule"),
                errors.stream().map(e -> e.outcome().issue().getFirst().code().valueAsString()).toList());
        assertEquals(List.of("Patient/p1 is not known", "Patient/p1 has been deleted", "Invalid id",
                        "Still referenced", "Wrong version", "Missing identifier"),
                errors.stream().map(e -> e.outcome().issue().getFirst().diagnostics().value()).toList());
        for (FhirHttpException error : errors) {
            assertEquals("error", error.outcome().issue().getFirst().severity().valueAsString());
            assertEquals(Map.of(), error.headers());
        }
    }

    @Test
    void unprocessablePreservesTheEntireOutcome() {
        OperationOutcome outcome = OperationOutcome.builder()
                .id("validation")
                .addIssue(OperationOutcome.Issue.builder()
                        .severity(IssueSeverity.ERROR)
                        .code(IssueType.REQUIRED)
                        .details(CodeableConcept.builder()
                                .addCoding(Coding.builder().system("https://example.org/rules").code("id-1").build())
                                .text("An identifier is required").build())
                        .addExpression("Patient.identifier")
                        .build())
                .addIssue(OperationOutcome.Issue.builder()
                        .severity(IssueSeverity.WARNING)
                        .code(IssueType.VALUE)
                        .diagnostics("Name may be incomplete")
                        .build())
                .build();

        FhirHttpException error = FhirHttpException.unprocessable(outcome);

        assertEquals(422, error.status());
        assertSame(outcome, error.outcome());
        assertEquals("HTTP 422: An identifier is required", error.getMessage());
        assertThrows(NullPointerException.class, () -> FhirHttpException.unprocessable((OperationOutcome) null));
    }

    @Test
    void messagesUseDiagnosticsThenDetailsTextThenCode() {
        OperationOutcome.Issue.Builder issue = OperationOutcome.Issue.builder()
                .severity(IssueSeverity.ERROR)
                .code(IssueType.INVALID)
                .details(CodeableConcept.builder().text("Human-readable details").build())
                .diagnostics("Diagnostic information");

        assertEquals("HTTP 400: Diagnostic information", new FhirHttpException(400,
                OperationOutcome.builder().addIssue(issue.build()).build()).getMessage());
        issue.diagnostics((FhirString) null);
        assertEquals("HTTP 400: Human-readable details", new FhirHttpException(400,
                OperationOutcome.builder().addIssue(issue.build()).build()).getMessage());
        issue.details(null);
        assertEquals("HTTP 400: invalid", new FhirHttpException(400,
                OperationOutcome.builder().addIssue(issue.build()).build()).getMessage());

        FhirHttpException withoutOutcome = new FhirHttpException(502, null, Map.of());
        assertNull(withoutOutcome.outcome());
        assertEquals("HTTP 502", withoutOutcome.getMessage());
        assertEquals("HTTP 400: invalid", new FhirHttpException(400, IssueType.INVALID, "").getMessage());
    }

    @Test
    void headersAreSnapshotsAndLookupsAreCaseInsensitive() {
        List<String> retry = new ArrayList<>(List.of("120", "240"));
        Map<String, List<String>> headers = new LinkedHashMap<>();
        headers.put("Retry-After", retry);
        headers.put("Empty", List.of());
        FhirHttpException error = new FhirHttpException(503, null, headers);

        retry.clear();
        headers.clear();

        assertEquals("120", error.header("retry-after"));
        assertEquals(List.of("120", "240"), error.headers().get("Retry-After"));
        assertNull(error.header("Empty"));
        assertNull(error.header("Missing"));
        assertThrows(UnsupportedOperationException.class, () -> error.headers().clear());
        assertThrows(UnsupportedOperationException.class, () -> error.headers().get("Retry-After").clear());
    }

    @Test
    void onlyHttpErrorStatusesAreAccepted() {
        for (int status : List.of(-1, 200, 399, 600)) {
            assertThrows(IllegalArgumentException.class, () -> new FhirHttpException(status, null));
        }
        assertEquals(400, new FhirHttpException(400, null).status());
        assertEquals(599, new FhirHttpException(599, null).status());
    }
}
