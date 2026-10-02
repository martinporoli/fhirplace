package se.poroli.fhirplace.r5.testreport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a TestReport with all elements and checks the builder and validation. */
class TestReportTest {

    @Test
    void testReport() {
        TestReport resource = TestReport.builder()
                .id("id1")
                .meta(Meta.builder().build())
                .implicitRules(FhirUri.of("http://example.org/uri"))
                .language(FhirCode.of("code"))
                .text(Narrative.builder()
                        .status(FhirEnum.of(NarrativeStatus.values()[0]))
                        .div(FhirXhtml.of("<div xmlns=\"http://www.w3.org/1999/xhtml\"/>"))
                        .build())
                .addContained(Patient.builder().build())
                .addExtension(Extension.builder().url("http://example.org/extension").build())
                .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                .identifier(Identifier.builder().build())
                .name(FhirString.of("text"))
                .status(FhirEnum.of(TestReportStatus.values()[0]))
                .testScript(FhirCanonical.of("http://example.org/canonical"))
                .result(FhirEnum.of(TestReportResult.values()[0]))
                .score(FhirDecimal.parse("1.0"))
                .tester(FhirString.of("text"))
                .issued(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addParticipant(TestReport.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(FhirEnum.of(TestReportParticipantType.values()[0]))
                        .uri(FhirUri.of("http://example.org/uri"))
                        .display(FhirString.of("text"))
                        .build())
                .setup(TestReport.Setup.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addAction(TestReport.Setup.SetupAction.builder().build())
                        .build())
                .addTest(TestReport.Test.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .description(FhirString.of("text"))
                        .addAction(TestReport.Test.TestAction.builder().build())
                        .build())
                .teardown(TestReport.Teardown.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addAction(TestReport.Teardown.TeardownAction.builder()
                                .operation(TestReport.Setup.SetupAction.Operation.builder()
                                        .result(FhirEnum.of(TestReportActionResult.values()[0]))
                                        .build())
                                .build())
                        .build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertNotNull(resource.identifier());
        assertNotNull(resource.name());
        assertNotNull(resource.status());
        assertNotNull(resource.testScript());
        assertNotNull(resource.result());
        assertNotNull(resource.score());
        assertNotNull(resource.tester());
        assertNotNull(resource.issued());
        assertFalse(resource.participant().isEmpty());
        assertNotNull(resource.setup());
        assertFalse(resource.test().isEmpty());
        assertNotNull(resource.teardown());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("TestReport.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<TestReportStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(TestReportActionResult.values(), TestReportActionResult::fromCode);
        assertCodes(TestReportParticipantType.values(), TestReportParticipantType::fromCode);
        assertCodes(TestReportResult.values(), TestReportResult::fromCode);
        assertCodes(TestReportStatus.values(), TestReportStatus::fromCode);
    }

    private static <E extends CodedEnum> void assertCodes(E[] values, Function<String, E> fromCode) {
        for (E value : values) {
            assertSame(value, fromCode.apply(value.code()));
            assertTrue(URI.create(value.system()).isAbsolute());
            assertFalse(value.display().isBlank());
        }
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply("no-such-code"));
        assertThrows(IllegalArgumentException.class, () -> fromCode.apply(values[0].code().toUpperCase() + "X"));
    }
}
