package se.poroli.fhirplace.r5.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;

class ValidatorTest {

    private static final String PERSONNUMMER = "http://electronichealth.se/identifier/personnummer";

    private static final Extension METADATA = Extension.builder()
            .url("urn:example:validation-metadata").value(FhirString.of("Profile rule")).build();
    private static final CodeableConcept DETAILS = CodeableConcept.builder()
            .id("details")
            .addExtension(METADATA)
            .addCoding(Coding.builder().system("urn:example:validation").code("required-name")
                    .version("1").display("Missing family name").build())
            .addCoding(Coding.builder().system("urn:example:local").code("name-1").build())
            .text("Family name is required")
            .build();
    private static final FhirString DIAGNOSTICS = new FhirString("diagnostics", List.of(METADATA),
            "The profile requires a family name");

    private static final Validator<HumanName> NAME = Validator.builder(HumanName.class)
            .rule("name-1", n -> n.family() != null,
                    Issue.error(IssueType.REQUIRED, "Family name is required").at("family"))
            .build();

    private static final Validator<Patient> SE_PATIENT = Validator.builder(Patient.class)
            .rule("se-1", p -> p.identifier().stream()
                            .anyMatch(i -> i.system() != null && PERSONNUMMER.equals(i.system().value())),
                    Issue.error(IssueType.REQUIRED, "A Swedish personnummer is required").at("identifier"))
            .each(Patient::name, "name", NAME)
            .check("se-2", (p, report) -> {
                for (int i = 0; i < p.telecom().size(); i++) {
                    ContactPoint telecom = p.telecom().get(i);
                    if (telecom.value() != null && !telecom.value().value().startsWith("+46")) {
                        report.add(Issue.warning(IssueType.VALUE, "Not a Swedish number: " + telecom.value().value())
                                .at("telecom[" + i + "].value"));
                    }
                }
            })
            .rule("se-3", p -> p.birthDate() != null, Issue.warning(IssueType.REQUIRED, "Birth date should be known"))
            .build();

    private static Patient.Builder valid() {
        return Patient.builder()
                .addIdentifier(Identifier.builder().system(PERSONNUMMER).value("191212121212").build())
                .addName(HumanName.builder().family("Svensson").build())
                .birthDate(java.time.LocalDate.of(1912, 12, 12));
    }

    @Test
    void aValidValueHasNoIssues() {
        ValidationResult result = SE_PATIENT.validate(valid().build());

        assertTrue(result.isValid());
        assertEquals(List.of(), result.issues());
    }

    @Test
    void rulesReportTheirIssueLocatedAndWithTheirId() {
        ValidationResult result = SE_PATIENT.validate(valid().identifier(List.of()).build());

        assertFalse(result.isValid());
        assertEquals(List.of(new Issue("se-1", IssueSeverity.ERROR, IssueType.REQUIRED,
                CodeableConcept.builder().text("A Swedish personnummer is required").build(), null,
                "Patient.identifier")), result.issues());
    }

    @Test
    void elementsAreLocatedByIndex() {
        Patient patient = valid()
                .name(List.of(HumanName.builder().family("A").build(), HumanName.builder().addGiven("B").build()))
                .build();

        assertEquals(List.of("Patient.name[1].family"),
                SE_PATIENT.validate(patient).issues().stream().map(Issue::expression).toList());
    }

    @Test
    void nestedValidatesASingleElementAndSkipsAbsentOnes() {
        Validator<Patient> validator = Validator.builder(Patient.class)
                .nested(p -> p.name().isEmpty() ? null : p.name().getFirst(), "name[0]", NAME)
                .build();

        assertEquals("Patient.name[0].family", validator.validate(
                Patient.builder().addName(HumanName.builder().addGiven("A").build()).build())
                .issues().getFirst().expression());
        assertTrue(validator.validate(Patient.builder().build()).issues().isEmpty());
    }

    @Test
    void checksReportComputedIssuesAndWarningsKeepTheResultValid() {
        ValidationResult result = SE_PATIENT.validate(valid()
                .addTelecom(ContactPoint.builder().value("+46 8 123").build())
                .addTelecom(ContactPoint.builder().value("+1 555 123").build())
                .birthDate((java.time.LocalDate) null)
                .build());

        assertTrue(result.isValid());
        assertEquals(List.of(), result.errors());
        assertEquals(List.of("se-2", "se-3"), result.warnings().stream().map(Issue::ruleId).toList());
        assertEquals("Patient.telecom[1].value", result.warnings().getFirst().expression());
        assertEquals("Not a Swedish number: +1 555 123", result.warnings().getFirst().details().text().value());
        assertEquals("Patient", result.warnings().get(1).expression());
    }

    @Test
    void validatorsCombine() {
        Validator<Patient> active = Validator.builder(Patient.class)
                .rule("active-1", p -> p.active() != null, Issue.error(IssueType.REQUIRED, "Active is required"))
                .build();

        assertEquals(List.of("active-1"), SE_PATIENT.and(active).validate(valid().build()).issues().stream()
                .map(Issue::ruleId).toList());
        assertEquals(List.of("active-1"), SE_PATIENT.toBuilder().include(active).build().validate(valid().build())
                .issues().stream().map(Issue::ruleId).toList());
        assertTrue(SE_PATIENT.and(active).ruleIds().containsAll(List.of("se-1", "name-1", "active-1")));
    }

    @Test
    void ruleIdsMustBeUnique() {
        Validator.Builder<Patient> builder = Validator.builder(Patient.class)
                .rule("x", p -> true, Issue.error(IssueType.VALUE, "a"))
                .check("x", (p, report) -> { });

        assertThrows(IllegalArgumentException.class, builder::build);
        assertThrows(IllegalArgumentException.class, () -> SE_PATIENT.and(SE_PATIENT));
    }

    @Test
    void reusedValidatorsCanBeAdjustedByRuleId() {
        Patient invalid = valid().identifier(List.of()).name(List.of(HumanName.builder().addGiven("A").build()))
                .build();

        Validator<Patient> adjusted = SE_PATIENT
                .withMessage("se-1", "Ange personnummer")
                .withSeverity("name-1", IssueSeverity.WARNING);
        ValidationResult result = adjusted.validate(invalid);

        assertEquals("Ange personnummer", result.errors().getFirst().details().text().value());
        assertEquals(IssueSeverity.WARNING, result.issues().get(1).severity());
        assertTrue(SE_PATIENT.without("se-1").without("name-1").validate(invalid).isValid());
        assertThrows(IllegalArgumentException.class, () -> SE_PATIENT.without("no-such-rule"));
    }

    @Test
    void resultsBecomeOperationOutcomes() {
        OperationOutcome outcome = SE_PATIENT.validate(valid().identifier(List.of()).build()).toOperationOutcome();
        OperationOutcome.Issue issue = outcome.issue().getFirst();

        assertEquals("error", issue.severity().valueAsString());
        assertEquals("required", issue.code().valueAsString());
        assertEquals("A Swedish personnummer is required", issue.details().text().value());
        assertNull(issue.diagnostics());
        assertEquals("Patient.identifier", issue.expression().getFirst().value());
    }

    @Test
    void issuesMayHaveNoDetailsDiagnosticsOrExpression() {
        ValidationResult result = new ValidationResult(List.of(
                Issue.warning(IssueType.VALUE, "").at(""),
                Issue.information(IssueType.INFORMATIONAL, (CodeableConcept) null),
                new Issue("diagnostic", IssueSeverity.INFORMATION, IssueType.INFORMATIONAL, null, DIAGNOSTICS, "")));

        assertTrue(result.isValid());
        OperationOutcome outcome = result.toOperationOutcome();
        for (int i = 0; i < result.issues().size(); i++) {
            assertNull(result.issues().get(i).details());
            assertNull(result.issues().get(i).expression());
            assertNull(outcome.issue().get(i).details());
            assertEquals(List.of(), outcome.issue().get(i).expression());
        }
        assertEquals("warning", outcome.issue().getFirst().severity().valueAsString());
        assertNull(outcome.issue().getFirst().diagnostics());
        assertNull(outcome.issue().get(1).diagnostics());
        assertEquals(DIAGNOSTICS, outcome.issue().get(2).diagnostics());
    }

    @Test
    void fatalIssuesWithoutDetailsStillMakeResultsInvalid() {
        ValidationResult result = new ValidationResult(List.of(Issue.fatal(IssueType.PROCESSING, (String) null)));

        assertFalse(result.isValid());
        assertEquals(result.issues(), result.errors());
        OperationOutcome.Issue issue = result.toOperationOutcome().issue().getFirst();
        assertEquals("fatal", issue.severity().valueAsString());
        assertEquals("processing", issue.code().valueAsString());
        assertNull(issue.details());
        assertNull(issue.diagnostics());
        assertEquals(List.of(), issue.expression());
    }

    @Test
    void emptyResultsProduceAnInformationalSuccessOutcome() {
        ValidationResult result = SE_PATIENT.validate(valid().build());
        OperationOutcome outcome = result.toOperationOutcome();

        assertTrue(result.isValid());
        assertEquals(1, outcome.issue().size());
        OperationOutcome.Issue issue = outcome.issue().getFirst();
        assertEquals("information", issue.severity().valueAsString());
        assertEquals("informational", issue.code().valueAsString());
        assertEquals("No issues found", issue.diagnostics().value());
        assertNull(issue.details());
        assertEquals(List.of(), issue.expression());
    }

    @Test
    void stringFactoriesUseDetailsTextWithoutDiagnostics() {
        ValidationResult result = new ValidationResult(List.of(
                Issue.error(IssueType.REQUIRED, "Error"),
                Issue.fatal(IssueType.PROCESSING, "Fatal"),
                Issue.warning(IssueType.VALUE, "Warning"),
                Issue.information(IssueType.INFORMATIONAL, "Information")));

        assertFalse(result.isValid());
        assertEquals(2, result.errors().size());
        assertEquals(1, result.warnings().size());
        assertEquals(List.of("Error", "Fatal", "Warning", "Information"), result.toOperationOutcome().issue().stream()
                .map(issue -> issue.details().text().value()).toList());
        for (OperationOutcome.Issue issue : result.toOperationOutcome().issue()) {
            assertNull(issue.diagnostics());
            assertEquals(List.of(), issue.expression());
        }
    }

    @Test
    void codedFactoriesPreserveDetailsInOutcomes() {
        ValidationResult result = new ValidationResult(List.of(
                Issue.error(IssueType.REQUIRED, DETAILS),
                Issue.fatal(IssueType.PROCESSING, DETAILS),
                Issue.warning(IssueType.VALUE, DETAILS),
                Issue.information(IssueType.INFORMATIONAL, DETAILS)));

        assertEquals(List.of("error", "fatal", "warning", "information"), result.toOperationOutcome().issue().stream()
                .map(issue -> issue.severity().valueAsString()).toList());
        for (OperationOutcome.Issue issue : result.toOperationOutcome().issue()) {
            assertEquals(DETAILS, issue.details());
            assertNull(issue.diagnostics());
        }
    }

    @Test
    void codedDetailsAndDiagnosticsSurvivePathsSeverityAndTextAdjustments() {
        Issue declared = new Issue(null, IssueSeverity.ERROR, IssueType.REQUIRED, DETAILS, DIAGNOSTICS, null);
        Validator<HumanName> name = Validator.builder(HumanName.class)
                .rule("coded-name", n -> false, declared.at("family"))
                .build();
        Validator<CodeableConcept> maritalStatus = Validator.builder(CodeableConcept.class)
                .check("coded-status", (c, report) -> report.add(declared.at("coding[0]")))
                .build();
        Validator<Patient> included = Validator.builder(Patient.class)
                .rule("coded-patient", p -> false, declared.at("identifier[0]"))
                .build();
        Validator<Patient> original = Validator.builder(Patient.class)
                .each(Patient::name, "name", name)
                .nested(Patient::maritalStatus, "maritalStatus", maritalStatus)
                .include(included)
                .build();
        Patient patient = valid().maritalStatus(CodeableConcept.builder().text("Single").build()).build();
        Validator<Patient> adjusted = original.withMessage("coded-name", "Ange efternamn")
                .withSeverity("coded-name", IssueSeverity.WARNING)
                .withSeverity("coded-status", IssueSeverity.INFORMATION);
        ValidationResult result = adjusted.toBuilder().build().validate(patient);

        assertEquals(List.of("coded-name", "coded-status", "coded-patient"), result.issues().stream()
                .map(Issue::ruleId).toList());
        assertEquals(List.of("Patient.name[0].family", "Patient.maritalStatus.coding[0]", "Patient.identifier[0]"),
                result.issues().stream().map(Issue::expression).toList());
        assertEquals(List.of(IssueSeverity.WARNING, IssueSeverity.INFORMATION, IssueSeverity.ERROR),
                result.issues().stream().map(Issue::severity).toList());
        CodeableConcept changedDetails = DETAILS.toBuilder().text("Ange efternamn").build();
        assertEquals(changedDetails, result.issues().getFirst().details());
        assertEquals(DETAILS, result.issues().get(1).details());
        assertEquals(DETAILS, result.issues().get(2).details());
        OperationOutcome outcome = result.toOperationOutcome();
        for (int i = 0; i < result.issues().size(); i++) {
            assertEquals(IssueType.REQUIRED, result.issues().get(i).code());
            assertEquals(DIAGNOSTICS, result.issues().get(i).diagnostics());
            assertEquals(result.issues().get(i).details(), outcome.issue().get(i).details());
            assertEquals(DIAGNOSTICS, outcome.issue().get(i).diagnostics());
            assertEquals(result.issues().get(i).expression(), outcome.issue().get(i).expression().getFirst().value());
        }
        assertEquals(DETAILS, original.validate(patient).issues().getFirst().details());
        assertEquals(IssueSeverity.ERROR, original.validate(patient).issues().getFirst().severity());
    }

    @Test
    void detailsCanBeReplacedOrClearedIndependentlyOfDiagnostics() {
        Validator<Patient> original = Validator.builder(Patient.class)
                .rule("coded", p -> false,
                        new Issue(null, IssueSeverity.ERROR, IssueType.VALUE, DETAILS, DIAGNOSTICS, "identifier"))
                .build();
        CodeableConcept replacement = CodeableConcept.builder()
                .addCoding(Coding.builder().system("urn:example:replacement").code("invalid-id").build())
                .build();
        Validator<Patient> replaced = original.withDetails("coded", replacement);
        ValidationResult result = replaced.validate(valid().build());
        assertEquals(new Issue("coded", IssueSeverity.ERROR, IssueType.VALUE, replacement, DIAGNOSTICS,
                "Patient.identifier"), result.issues().getFirst());
        assertEquals(replacement, result.toOperationOutcome().issue().getFirst().details());

        Validator<Patient> cleared = replaced.withSeverity("coded", IssueSeverity.WARNING).withDetails("coded", null);
        ValidationResult clearedResult = cleared.validate(valid().build());
        assertTrue(clearedResult.isValid());
        assertEquals(new Issue("coded", IssueSeverity.WARNING, IssueType.VALUE, null, DIAGNOSTICS,
                "Patient.identifier"), clearedResult.issues().getFirst());
        assertNull(clearedResult.toOperationOutcome().issue().getFirst().details());
        assertEquals(DIAGNOSTICS, clearedResult.toOperationOutcome().issue().getFirst().diagnostics());
        assertEquals(DETAILS, original.validate(valid().build()).issues().getFirst().details());
        assertEquals(replacement.toBuilder().text("New text").build(), replaced.withMessage("coded", "New text")
                .validate(valid().build()).issues().getFirst().details());
        assertEquals(CodeableConcept.builder().text("Restored").build(), cleared.withMessage("coded", "Restored")
                .validate(valid().build()).issues().getFirst().details());
        assertThrows(IllegalArgumentException.class, () -> original.withDetails("no-such-rule", replacement));
    }

    @Test
    void emptyMessagesClearOnlyTextAndNormalizeTextOnlyDetailsToAbsent() {
        Validator<Patient> original = Validator.builder(Patient.class)
                .rule("coded", p -> false,
                        new Issue(null, IssueSeverity.WARNING, IssueType.VALUE, DETAILS, DIAGNOSTICS, null))
                .rule("text", p -> false, Issue.information(IssueType.INFORMATIONAL, "Information"))
                .rule("absent", p -> false, Issue.information(IssueType.INFORMATIONAL, (String) null))
                .build();
        ValidationResult result = original.withMessage("coded", "").withMessage("text", "")
                .withMessage("absent", "").validate(valid().build());

        assertTrue(result.isValid());
        assertEquals(DETAILS.toBuilder().text((FhirString) null).build(), result.issues().getFirst().details());
        assertEquals(DIAGNOSTICS, result.issues().getFirst().diagnostics());
        assertNull(result.issues().get(1).details());
        assertNull(result.issues().get(2).details());
        assertNull(result.toOperationOutcome().issue().getFirst().details().text());
        assertNull(result.toOperationOutcome().issue().get(1).details());
        assertNull(result.toOperationOutcome().issue().get(2).details());
        assertEquals(List.of("Patient", "Patient", "Patient"), result.issues().stream().map(Issue::expression).toList());
    }

    @Test
    void outcomesPreserveExtensionOnlyDiagnostics() {
        FhirString diagnostics = new FhirString("diagnostics", List.of(METADATA), null);
        ValidationResult result = new ValidationResult(List.of(new Issue(null, IssueSeverity.INFORMATION,
                IssueType.INFORMATIONAL, null, diagnostics, null)));

        assertTrue(result.isValid());
        OperationOutcome.Issue issue = result.toOperationOutcome().issue().getFirst();
        assertEquals(diagnostics, issue.diagnostics());
        assertNull(issue.details());
        assertEquals(List.of(), issue.expression());
    }
}
