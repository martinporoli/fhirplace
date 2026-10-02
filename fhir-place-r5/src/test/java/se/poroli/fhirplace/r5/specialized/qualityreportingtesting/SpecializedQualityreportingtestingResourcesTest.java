package se.poroli.fhirplace.r5.specialized.qualityreportingtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.Expression;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDate;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirUrl;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.MeasureReportStatus;
import se.poroli.fhirplace.r5.valuesets.MeasureReportType;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.SubmitDataUpdateType;
import se.poroli.fhirplace.r5.valuesets.TestReportActionResult;
import se.poroli.fhirplace.r5.valuesets.TestReportParticipantType;
import se.poroli.fhirplace.r5.valuesets.TestReportResult;
import se.poroli.fhirplace.r5.valuesets.TestReportStatus;

/** Builds every specialized.qualityreportingtesting resource with all elements and checks the builders and validation. */
class SpecializedQualityreportingtestingResourcesTest {

    @Test
    void measure() {
        Measure resource = Measure.builder()
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
                .addIdentifier(Identifier.builder().build())
                .version(FhirString.of("text"))
                .versionAlgorithm(FhirString.of("text"))
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .subtitle(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .subject(CodeableConcept.builder().build())
                .basis(FhirEnum.of(FHIRTypes.values()[0]))
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
                .usage(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addTopic(CodeableConcept.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .addLibrary(FhirCanonical.of("http://example.org/canonical"))
                .disclaimer(FhirMarkdown.of("text"))
                .scoring(CodeableConcept.builder().build())
                .scoringUnit(CodeableConcept.builder().build())
                .compositeScoring(CodeableConcept.builder().build())
                .addType(CodeableConcept.builder().build())
                .riskAdjustment(FhirMarkdown.of("text"))
                .rateAggregation(FhirMarkdown.of("text"))
                .rationale(FhirMarkdown.of("text"))
                .clinicalRecommendationStatement(FhirMarkdown.of("text"))
                .improvementNotation(CodeableConcept.builder().build())
                .addTerm(Measure.Term.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .definition(FhirMarkdown.of("text"))
                        .build())
                .guidance(FhirMarkdown.of("text"))
                .addGroup(Measure.Group.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .code(CodeableConcept.builder().build())
                        .description(FhirMarkdown.of("text"))
                        .addType(CodeableConcept.builder().build())
                        .subject(CodeableConcept.builder().build())
                        .basis(FhirEnum.of(FHIRTypes.values()[0]))
                        .scoring(CodeableConcept.builder().build())
                        .scoringUnit(CodeableConcept.builder().build())
                        .rateAggregation(FhirMarkdown.of("text"))
                        .improvementNotation(CodeableConcept.builder().build())
                        .addLibrary(FhirCanonical.of("http://example.org/canonical"))
                        .addPopulation(Measure.Group.Population.builder().build())
                        .addStratifier(Measure.Group.Stratifier.builder().build())
                        .build())
                .addSupplementalData(Measure.SupplementalData.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .code(CodeableConcept.builder().build())
                        .addUsage(CodeableConcept.builder().build())
                        .description(FhirMarkdown.of("text"))
                        .criteria(Expression.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.version());
        assertNotNull(resource.versionAlgorithm());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertNotNull(resource.subtitle());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.subject());
        assertNotNull(resource.basis());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.jurisdiction().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.usage());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.topic().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertFalse(resource.library().isEmpty());
        assertNotNull(resource.disclaimer());
        assertNotNull(resource.scoring());
        assertNotNull(resource.scoringUnit());
        assertNotNull(resource.compositeScoring());
        assertFalse(resource.type().isEmpty());
        assertNotNull(resource.riskAdjustment());
        assertNotNull(resource.rateAggregation());
        assertNotNull(resource.rationale());
        assertNotNull(resource.clinicalRecommendationStatement());
        assertNotNull(resource.improvementNotation());
        assertFalse(resource.term().isEmpty());
        assertNotNull(resource.guidance());
        assertFalse(resource.group().isEmpty());
        assertFalse(resource.supplementalData().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Measure.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

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
    void testPlan() {
        TestPlan resource = TestPlan.builder()
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
                .addIdentifier(Identifier.builder().build())
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
                .addCategory(CodeableConcept.builder().build())
                .addScope(Reference.builder().build())
                .testTools(FhirMarkdown.of("text"))
                .addDependency(TestPlan.Dependency.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .predecessor(Reference.builder().build())
                        .build())
                .exitCriteria(FhirMarkdown.of("text"))
                .addTestCase(TestPlan.TestCase.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .sequence(FhirInteger.of(1))
                        .addScope(Reference.builder().build())
                        .addDependency(TestPlan.TestCase.TestCaseDependency.builder().build())
                        .addTestRun(TestPlan.TestCase.TestRun.builder().build())
                        .addTestData(TestPlan.TestCase.TestData.builder()
                                .type(Coding.builder().build())
                                .build())
                        .addAssertion(TestPlan.TestCase.Assertion.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
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
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.scope().isEmpty());
        assertNotNull(resource.testTools());
        assertFalse(resource.dependency().isEmpty());
        assertNotNull(resource.exitCriteria());
        assertFalse(resource.testCase().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("TestPlan.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void testScript() {
        TestScript resource = TestScript.builder()
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
                .addIdentifier(Identifier.builder().build())
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
                .addOrigin(TestScript.Origin.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .index(FhirInteger.of(1))
                        .profile(Coding.builder().build())
                        .url(FhirUrl.of("http://example.org/url"))
                        .build())
                .addDestination(TestScript.Destination.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .index(FhirInteger.of(1))
                        .profile(Coding.builder().build())
                        .url(FhirUrl.of("http://example.org/url"))
                        .build())
                .metadata(TestScript.Metadata.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addLink(TestScript.Metadata.Link.builder()
                                .url(FhirUri.of("http://example.org/uri"))
                                .build())
                        .addCapability(TestScript.Metadata.Capability.builder()
                                .required(FhirBoolean.of(true))
                                .validated(FhirBoolean.of(true))
                                .capabilities(FhirCanonical.of("http://example.org/canonical"))
                                .build())
                        .build())
                .addScope(TestScript.Scope.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .artifact(FhirCanonical.of("http://example.org/canonical"))
                        .conformance(CodeableConcept.builder().build())
                        .phase(CodeableConcept.builder().build())
                        .build())
                .addFixture(TestScript.Fixture.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .autocreate(FhirBoolean.of(true))
                        .autodelete(FhirBoolean.of(true))
                        .resource(Reference.builder().build())
                        .build())
                .addProfile(FhirCanonical.of("http://example.org/canonical"))
                .addVariable(TestScript.Variable.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .defaultValue(FhirString.of("text"))
                        .description(FhirString.of("text"))
                        .expression(FhirString.of("text"))
                        .headerField(FhirString.of("text"))
                        .hint(FhirString.of("text"))
                        .path(FhirString.of("text"))
                        .sourceId(FhirId.of("id1"))
                        .build())
                .setup(TestScript.Setup.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addAction(TestScript.Setup.SetupAction.builder().build())
                        .build())
                .addTest(TestScript.Test.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .description(FhirString.of("text"))
                        .addAction(TestScript.Test.TestAction.builder().build())
                        .build())
                .teardown(TestScript.Teardown.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addAction(TestScript.Teardown.TeardownAction.builder()
                                .operation(TestScript.Setup.SetupAction.Operation.builder()
                                        .encodeRequestUrl(FhirBoolean.of(true))
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
        assertNotNull(resource.url());
        assertFalse(resource.identifier().isEmpty());
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
        assertFalse(resource.origin().isEmpty());
        assertFalse(resource.destination().isEmpty());
        assertNotNull(resource.metadata());
        assertFalse(resource.scope().isEmpty());
        assertFalse(resource.fixture().isEmpty());
        assertFalse(resource.profile().isEmpty());
        assertFalse(resource.variable().isEmpty());
        assertNotNull(resource.setup());
        assertFalse(resource.test().isEmpty());
        assertNotNull(resource.teardown());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("TestScript.name is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().name((FhirString) null).build()).getMessage());
    }

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
}
