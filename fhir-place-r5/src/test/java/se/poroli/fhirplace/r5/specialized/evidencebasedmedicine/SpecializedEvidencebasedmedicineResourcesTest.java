package se.poroli.fhirplace.r5.specialized.evidencebasedmedicine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
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
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.ArtifactAssessmentDisposition;
import se.poroli.fhirplace.r5.valuesets.ArtifactAssessmentInformationType;
import se.poroli.fhirplace.r5.valuesets.ArtifactAssessmentWorkflowStatus;
import se.poroli.fhirplace.r5.valuesets.CharacteristicCombination;
import se.poroli.fhirplace.r5.valuesets.EvidenceVariableHandling;
import se.poroli.fhirplace.r5.valuesets.ListMode;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;
import se.poroli.fhirplace.r5.valuesets.ReportRelationshipType;

/** Builds every specialized.evidencebasedmedicine resource with all elements and checks the builders and validation. */
class SpecializedEvidencebasedmedicineResourcesTest {

    @Test
    void artifactAssessment() {
        ArtifactAssessment resource = ArtifactAssessment.builder()
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
                .title(FhirString.of("text"))
                .citeAs(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .copyright(FhirMarkdown.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .artifact(Reference.builder().build())
                .addContent(ArtifactAssessment.Content.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .informationType(FhirEnum.of(ArtifactAssessmentInformationType.values()[0]))
                        .summary(FhirMarkdown.of("text"))
                        .type(CodeableConcept.builder().build())
                        .addClassifier(CodeableConcept.builder().build())
                        .quantity(Quantity.builder().build())
                        .author(Reference.builder().build())
                        .addPath(FhirUri.of("http://example.org/uri"))
                        .addRelatedArtifact(RelatedArtifact.builder()
                                .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                                .build())
                        .freeToShare(FhirBoolean.of(true))
                        .addComponent(ArtifactAssessment.Content.builder().build())
                        .build())
                .workflowStatus(FhirEnum.of(ArtifactAssessmentWorkflowStatus.values()[0]))
                .disposition(FhirEnum.of(ArtifactAssessmentDisposition.values()[0]))
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
        assertNotNull(resource.title());
        assertNotNull(resource.citeAs());
        assertNotNull(resource.date());
        assertNotNull(resource.copyright());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.artifact());
        assertFalse(resource.content().isEmpty());
        assertNotNull(resource.workflowStatus());
        assertNotNull(resource.disposition());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ArtifactAssessment.artifact is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().artifact((Reference) null).build()).getMessage());
    }

    @Test
    void citation() {
        Citation resource = Citation.builder()
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
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addSummary(Citation.Summary.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .style(CodeableConcept.builder().build())
                        .text(FhirMarkdown.of("text"))
                        .build())
                .addClassification(Citation.Classification.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .addClassifier(CodeableConcept.builder().build())
                        .build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addCurrentState(CodeableConcept.builder().build())
                .addStatusDate(Citation.StatusDate.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .activity(CodeableConcept.builder().build())
                        .actual(FhirBoolean.of(true))
                        .period(Period.builder().build())
                        .build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .citedArtifact(Citation.CitedArtifact.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .addRelatedIdentifier(Identifier.builder().build())
                        .dateAccessed(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .version(Citation.CitedArtifact.Version.builder()
                                .value(FhirString.of("text"))
                                .build())
                        .addCurrentState(CodeableConcept.builder().build())
                        .addStatusDate(Citation.CitedArtifact.StatusDate.builder()
                                .activity(CodeableConcept.builder().build())
                                .period(Period.builder().build())
                                .build())
                        .addTitle(Citation.CitedArtifact.Title.builder()
                                .text(FhirMarkdown.of("text"))
                                .build())
                        .addAbstractValue(Citation.CitedArtifact.AbstractValue.builder()
                                .text(FhirMarkdown.of("text"))
                                .build())
                        .part(Citation.CitedArtifact.Part.builder().build())
                        .addRelatesTo(Citation.CitedArtifact.RelatesTo.builder()
                                .type(FhirCode.of("code"))
                                .build())
                        .addPublicationForm(Citation.CitedArtifact.PublicationForm.builder().build())
                        .addWebLocation(Citation.CitedArtifact.WebLocation.builder().build())
                        .addClassification(Citation.CitedArtifact.Classification.builder().build())
                        .contributorship(Citation.CitedArtifact.Contributorship.builder().build())
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
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
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.summary().isEmpty());
        assertFalse(resource.classification().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.currentState().isEmpty());
        assertFalse(resource.statusDate().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.citedArtifact());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Citation.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void evidence() {
        Evidence resource = Evidence.builder()
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
                .citeAs(Reference.builder().build())
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .description(FhirMarkdown.of("text"))
                .assertion(FhirMarkdown.of("text"))
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addVariableDefinition(Evidence.VariableDefinition.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .variableRole(CodeableConcept.builder().build())
                        .observed(Reference.builder().build())
                        .intended(Reference.builder().build())
                        .directnessMatch(CodeableConcept.builder().build())
                        .build())
                .synthesisType(CodeableConcept.builder().build())
                .addStudyDesign(CodeableConcept.builder().build())
                .addStatistic(Evidence.Statistic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .statisticType(CodeableConcept.builder().build())
                        .category(CodeableConcept.builder().build())
                        .quantity(Quantity.builder().build())
                        .numberOfEvents(FhirUnsignedInt.of(0))
                        .numberAffected(FhirUnsignedInt.of(0))
                        .sampleSize(Evidence.Statistic.SampleSize.builder().build())
                        .addAttributeEstimate(Evidence.Statistic.AttributeEstimate.builder().build())
                        .addModelCharacteristic(Evidence.Statistic.ModelCharacteristic.builder()
                                .code(CodeableConcept.builder().build())
                                .build())
                        .build())
                .addCertainty(Evidence.Certainty.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirMarkdown.of("text"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .type(CodeableConcept.builder().build())
                        .rating(CodeableConcept.builder().build())
                        .rater(FhirString.of("text"))
                        .addSubcomponent(Evidence.Certainty.builder().build())
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
        assertNotNull(resource.citeAs());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.useContext().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.description());
        assertNotNull(resource.assertion());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.variableDefinition().isEmpty());
        assertNotNull(resource.synthesisType());
        assertFalse(resource.studyDesign().isEmpty());
        assertFalse(resource.statistic().isEmpty());
        assertFalse(resource.certainty().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Evidence.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void evidenceReport() {
        EvidenceReport resource = EvidenceReport.builder()
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
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addIdentifier(Identifier.builder().build())
                .addRelatedIdentifier(Identifier.builder().build())
                .citeAs(Reference.builder().build())
                .type(CodeableConcept.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .subject(EvidenceReport.Subject.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addCharacteristic(EvidenceReport.Subject.Characteristic.builder()
                                .code(CodeableConcept.builder().build())
                                .value(Reference.builder().build())
                                .build())
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .build())
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatesTo(EvidenceReport.RelatesTo.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(FhirEnum.of(ReportRelationshipType.values()[0]))
                        .target(EvidenceReport.RelatesTo.Target.builder().build())
                        .build())
                .addSection(EvidenceReport.Section.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .title(FhirString.of("text"))
                        .focus(CodeableConcept.builder().build())
                        .focusReference(Reference.builder().build())
                        .addAuthor(Reference.builder().build())
                        .text(Narrative.builder()
                                .status(FhirEnum.of(NarrativeStatus.values()[0]))
                                .div(FhirXhtml.of("<div xmlns=\"http://www.w3.org/1999/xhtml\"/>"))
                                .build())
                        .mode(FhirEnum.of(ListMode.values()[0]))
                        .orderedBy(CodeableConcept.builder().build())
                        .addEntryClassifier(CodeableConcept.builder().build())
                        .addEntryReference(Reference.builder().build())
                        .addEntryQuantity(Quantity.builder().build())
                        .emptyReason(CodeableConcept.builder().build())
                        .addSection(EvidenceReport.Section.builder().build())
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
        assertNotNull(resource.status());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.identifier().isEmpty());
        assertFalse(resource.relatedIdentifier().isEmpty());
        assertNotNull(resource.citeAs());
        assertNotNull(resource.type());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatesTo().isEmpty());
        assertFalse(resource.section().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("EvidenceReport.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }

    @Test
    void evidenceVariable() {
        EvidenceVariable resource = EvidenceVariable.builder()
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
                .shortTitle(FhirString.of("text"))
                .status(FhirEnum.of(PublicationStatus.values()[0]))
                .experimental(FhirBoolean.of(true))
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .publisher(FhirString.of("text"))
                .addContact(ContactDetail.builder().build())
                .description(FhirMarkdown.of("text"))
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .purpose(FhirMarkdown.of("text"))
                .copyright(FhirMarkdown.of("text"))
                .copyrightLabel(FhirString.of("text"))
                .approvalDate(FhirDate.parse("2024-01-01"))
                .lastReviewDate(FhirDate.parse("2024-01-01"))
                .effectivePeriod(Period.builder().build())
                .addAuthor(ContactDetail.builder().build())
                .addEditor(ContactDetail.builder().build())
                .addReviewer(ContactDetail.builder().build())
                .addEndorser(ContactDetail.builder().build())
                .addRelatedArtifact(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .actual(FhirBoolean.of(true))
                .addCharacteristic(EvidenceVariable.Characteristic.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirId.of("id1"))
                        .description(FhirMarkdown.of("text"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .exclude(FhirBoolean.of(true))
                        .definitionReference(Reference.builder().build())
                        .definitionCanonical(FhirCanonical.of("http://example.org/canonical"))
                        .definitionCodeableConcept(CodeableConcept.builder().build())
                        .definitionExpression(Expression.builder().build())
                        .definitionId(FhirId.of("id1"))
                        .definitionByTypeAndValue(EvidenceVariable.Characteristic.DefinitionByTypeAndValue.builder()
                                .type(CodeableConcept.builder().build())
                                .value(CodeableConcept.builder().build())
                                .build())
                        .definitionByCombination(EvidenceVariable.Characteristic.DefinitionByCombination.builder()
                                .code(FhirEnum.of(CharacteristicCombination.values()[0]))
                                .addCharacteristic(EvidenceVariable.Characteristic.builder().build())
                                .build())
                        .instances(Quantity.builder().build())
                        .duration(Quantity.builder().build())
                        .addTimeFromEvent(EvidenceVariable.Characteristic.TimeFromEvent.builder().build())
                        .build())
                .handling(FhirEnum.of(EvidenceVariableHandling.values()[0]))
                .addCategory(EvidenceVariable.Category.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .name(FhirString.of("text"))
                        .value(CodeableConcept.builder().build())
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
        assertNotNull(resource.shortTitle());
        assertNotNull(resource.status());
        assertNotNull(resource.experimental());
        assertNotNull(resource.date());
        assertNotNull(resource.publisher());
        assertFalse(resource.contact().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.useContext().isEmpty());
        assertNotNull(resource.purpose());
        assertNotNull(resource.copyright());
        assertNotNull(resource.copyrightLabel());
        assertNotNull(resource.approvalDate());
        assertNotNull(resource.lastReviewDate());
        assertNotNull(resource.effectivePeriod());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.editor().isEmpty());
        assertFalse(resource.reviewer().isEmpty());
        assertFalse(resource.endorser().isEmpty());
        assertFalse(resource.relatedArtifact().isEmpty());
        assertNotNull(resource.actual());
        assertFalse(resource.characteristic().isEmpty());
        assertNotNull(resource.handling());
        assertFalse(resource.category().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("EvidenceVariable.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
