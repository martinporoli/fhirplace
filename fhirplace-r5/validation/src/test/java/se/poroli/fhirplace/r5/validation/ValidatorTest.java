package se.poroli.fhirplace.r5.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.ContactPoint;
import se.poroli.fhirplace.r5.datatypes.HumanName;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.operationoutcome.IssueSeverity;
import se.poroli.fhirplace.r5.operationoutcome.IssueType;
import se.poroli.fhirplace.r5.operationoutcome.OperationOutcome;
import se.poroli.fhirplace.r5.patient.Patient;

class ValidatorTest {

    private static final String PERSONNUMMER = "http://electronichealth.se/identifier/personnummer";

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
                "A Swedish personnummer is required", "Patient.identifier")), result.issues());
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
        assertEquals("Not a Swedish number: +1 555 123", result.warnings().getFirst().message());
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

        assertEquals("Ange personnummer", result.errors().getFirst().message());
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
        assertEquals("A Swedish personnummer is required", issue.diagnostics().value());
        assertEquals("Patient.identifier", issue.expression().getFirst().value());
        assertEquals("information", SE_PATIENT.validate(valid().build()).toOperationOutcome().issue().getFirst()
                .severity().valueAsString());
    }

    @Test
    void invalidResultsThrowWithTheChosenStatus() {
        ValidationResult invalid = SE_PATIENT.validate(valid().identifier(List.of()).build());

        assertEquals(422, assertThrows(ValidationException.class, invalid::throwIfInvalid).status());
        ValidationException e = assertThrows(ValidationException.class, () -> invalid.throwIfInvalid(400));
        assertEquals(400, e.status());
        assertEquals("Patient.identifier: A Swedish personnummer is required", e.getMessage());
        SE_PATIENT.validate(valid().birthDate((java.time.LocalDate) null).build()).throwIfInvalid();
    }
}
