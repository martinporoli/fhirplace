package se.poroli.fhirplace.r5.observationdefinition;

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
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.patient.Patient;
import se.poroli.fhirplace.r5.valuesets.AdministrativeGender;
import se.poroli.fhirplace.r5.valuesets.CodedEnum;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;

/** Builds a ObservationDefinition with all elements and checks the builder and validation. */
class ObservationDefinitionTest {

    @Test
    void observationDefinition() {
        ObservationDefinition resource = ObservationDefinition.builder()
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
                .url(FhirUri.of("http://example.org/uri"))
                .identifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addJurisdiction(CodeableConcept.builder().build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addDerivedFromCanonical(FhirCanonical.of("http://example.org/canonical"))
                .addDerivedFromUri(FhirUri.of("http://example.org/uri"))
                .addSubject(CodeableConcept.builder().build())
                .performerType(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .addPermittedDataType(FhirEnum.of(ObservationDataType.values()[0]))
                .multipleResultsAllowed(FhirBoolean.of(true))
                .bodySite(CodeableConcept.builder().build())
                .method(CodeableConcept.builder().build())
                .addSpecimen(Reference.builder().build())
                .addDevice(Reference.builder().build())
                .preferredReportName(FhirString.of("text"))
                .addPermittedUnit(Coding.builder().build())
                .addQualifiedValue(ObservationDefinition.QualifiedValue.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .context(CodeableConcept.builder().build())
                        .addAppliesTo(CodeableConcept.builder().build())
                        .gender(FhirEnum.of(AdministrativeGender.values()[0]))
                        .age(Range.builder().build())
                        .gestationalAge(Range.builder().build())
                        .condition(FhirString.of("text"))
                        .rangeCategory(FhirEnum.of(ObservationRangeCategory.values()[0]))
                        .range(Range.builder().build())
                        .validCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .normalCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .abnormalCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .criticalCodedValueSet(FhirCanonical.of("http://example.org/canonical"))
                        .build())
                .addHasMember(Reference.builder().build())
                .addComponent(ObservationDefinition.Component.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .addPermittedDataType(FhirEnum.of(ObservationDataType.values()[0]))
                        .addPermittedUnit(Coding.builder().build())
                        .addQualifiedValue(ObservationDefinition.QualifiedValue.builder().build())
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
        assertNotNull(resource.url());
        assertNotNull(resource.identifier());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.derivedFromCanonical().isEmpty());
        assertFalse(resource.derivedFromUri().isEmpty());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.performerType());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertFalse(resource.permittedDataType().isEmpty());
        assertNotNull(resource.multipleResultsAllowed());
        assertNotNull(resource.bodySite());
        assertNotNull(resource.method());
        assertFalse(resource.specimen().isEmpty());
        assertFalse(resource.device().isEmpty());
        assertNotNull(resource.preferredReportName());
        assertFalse(resource.permittedUnit().isEmpty());
        assertFalse(resource.qualifiedValue().isEmpty());
        assertFalse(resource.hasMember().isEmpty());
        assertFalse(resource.component().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ObservationDefinition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void valueSetsResolveEveryCodeAndRejectUnknownOnes() {
        assertCodes(ObservationDataType.values(), ObservationDataType::fromCode);
        assertCodes(ObservationRangeCategory.values(), ObservationRangeCategory::fromCode);
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
