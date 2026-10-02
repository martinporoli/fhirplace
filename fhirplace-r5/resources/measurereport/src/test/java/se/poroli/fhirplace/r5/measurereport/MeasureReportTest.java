package se.poroli.fhirplace.r5.measurereport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;

/** Builds a MeasureReport with all elements and checks the builder and validation. */
class MeasureReportTest {

    @Test
    void measureReport() {
        MeasureReport resource = MeasureReport.builder()
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
                .addIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(MeasureReportStatus.values()[0]))
                .type(FhirEnum.of(MeasureReportType.values()[0]))
                .dataUpdateType(FhirEnum.of(SubmitDataUpdateType.values()[0]))
                .measure(FhirCanonical.of("http://example.org/canonical"))
                .subject(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .reporter(Reference.builder().build())
                .reportingVendor(Reference.builder().build())
                .location(Reference.builder().build())
                .period(Period.builder().build())
                .inputParameters(Reference.builder().build())
                .scoring(CodeableConcept.builder().build())
                .improvementNotation(CodeableConcept.builder().build())
                .addGroup(MeasureReport.Group.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .code(CodeableConcept.builder().build())
                        .subject(Reference.builder().build())
                        .addPopulation(MeasureReport.Group.Population.builder().build())
                        .measureScore(Quantity.builder().build())
                        .addStratifier(MeasureReport.Group.Stratifier.builder().build())
                        .build())
                .addSupplementalData(Reference.builder().build())
                .addEvaluatedResource(Reference.builder().build())
                .build();

        assertNotNull(resource.id());
        assertNotNull(resource.meta());
        assertNotNull(resource.implicitRules());
        assertNotNull(resource.language());
        assertNotNull(resource.text());
        assertFalse(resource.contained().isEmpty());
        assertFalse(resource.extension().isEmpty());
        assertFalse(resource.modifierExtension().isEmpty());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.type());
        assertNotNull(resource.dataUpdateType());
        assertNotNull(resource.measure());
        assertNotNull(resource.subject());
        assertNotNull(resource.date());
        assertNotNull(resource.reporter());
        assertNotNull(resource.reportingVendor());
        assertNotNull(resource.location());
        assertNotNull(resource.period());
        assertNotNull(resource.inputParameters());
        assertNotNull(resource.scoring());
        assertNotNull(resource.improvementNotation());
        assertFalse(resource.group().isEmpty());
        assertFalse(resource.supplementalData().isEmpty());
        assertFalse(resource.evaluatedResource().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("MeasureReport.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<MeasureReportStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(MeasureReportStatus.values(), MeasureReportStatus::fromCode);
        assertCodes(MeasureReportType.values(), MeasureReportType::fromCode);
        assertCodes(SubmitDataUpdateType.values(), SubmitDataUpdateType::fromCode);
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
