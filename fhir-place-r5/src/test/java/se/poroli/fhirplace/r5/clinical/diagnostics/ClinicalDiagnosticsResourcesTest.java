package se.poroli.fhirplace.r5.clinical.diagnostics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import se.poroli.fhirplace.r5.base.individuals.Patient;
import se.poroli.fhirplace.r5.datatypes.Annotation;
import se.poroli.fhirplace.r5.datatypes.Attachment;
import se.poroli.fhirplace.r5.datatypes.CodeableConcept;
import se.poroli.fhirplace.r5.datatypes.CodeableReference;
import se.poroli.fhirplace.r5.datatypes.Coding;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
import se.poroli.fhirplace.r5.datatypes.FhirCanonical;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirDecimal;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirId;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirInteger;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUnsignedInt;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Quantity;
import se.poroli.fhirplace.r5.datatypes.Range;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.valuesets.DiagnosticReportStatus;
import se.poroli.fhirplace.r5.valuesets.GenomicStudyStatus;
import se.poroli.fhirplace.r5.valuesets.ImagingSelection2DGraphicType;
import se.poroli.fhirplace.r5.valuesets.ImagingSelection3DGraphicType;
import se.poroli.fhirplace.r5.valuesets.ImagingSelectionStatus;
import se.poroli.fhirplace.r5.valuesets.ImagingStudyStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.ObservationStatus;
import se.poroli.fhirplace.r5.valuesets.QuestionnaireResponseStatus;
import se.poroli.fhirplace.r5.valuesets.SequenceType;
import se.poroli.fhirplace.r5.valuesets.SpecimenCombined;
import se.poroli.fhirplace.r5.valuesets.SpecimenStatus;
import se.poroli.fhirplace.r5.valuesets.TriggeredBytype;

/** Builds every clinical.diagnostics resource with all elements and checks the builders and validation. */
class ClinicalDiagnosticsResourcesTest {

    @Test
    void observation() {
        Observation resource = Observation.builder()
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
                .instantiates(FhirCanonical.of("http://example.org/canonical"))
                .addBasedOn(Reference.builder().build())
                .addTriggeredBy(Observation.TriggeredBy.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .observation(Reference.builder().build())
                        .type(FhirEnum.of(TriggeredBytype.values()[0]))
                        .reason(FhirString.of("text"))
                        .build())
                .addPartOf(Reference.builder().build())
                .status(FhirEnum.of(ObservationStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .addFocus(Reference.builder().build())
                .encounter(Reference.builder().build())
                .effective(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .issued(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPerformer(Reference.builder().build())
                .value(Quantity.builder().build())
                .dataAbsentReason(CodeableConcept.builder().build())
                .addInterpretation(CodeableConcept.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .bodySite(CodeableConcept.builder().build())
                .bodyStructure(Reference.builder().build())
                .method(CodeableConcept.builder().build())
                .specimen(Reference.builder().build())
                .device(Reference.builder().build())
                .addReferenceRange(Observation.ReferenceRange.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .low(Quantity.builder().build())
                        .high(Quantity.builder().build())
                        .normalValue(CodeableConcept.builder().build())
                        .type(CodeableConcept.builder().build())
                        .addAppliesTo(CodeableConcept.builder().build())
                        .age(Range.builder().build())
                        .text(FhirMarkdown.of("text"))
                        .build())
                .addHasMember(Reference.builder().build())
                .addDerivedFrom(Reference.builder().build())
                .addComponent(Observation.Component.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .value(Quantity.builder().build())
                        .dataAbsentReason(CodeableConcept.builder().build())
                        .addInterpretation(CodeableConcept.builder().build())
                        .addReferenceRange(Observation.ReferenceRange.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.instantiates());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.triggeredBy().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertFalse(resource.focus().isEmpty());
        assertNotNull(resource.encounter());
        assertNotNull(resource.effective());
        assertNotNull(resource.issued());
        assertFalse(resource.performer().isEmpty());
        assertNotNull(resource.value());
        assertNotNull(resource.dataAbsentReason());
        assertFalse(resource.interpretation().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.bodySite());
        assertNotNull(resource.bodyStructure());
        assertNotNull(resource.method());
        assertNotNull(resource.specimen());
        assertNotNull(resource.device());
        assertFalse(resource.referenceRange().isEmpty());
        assertFalse(resource.hasMember().isEmpty());
        assertFalse(resource.derivedFrom().isEmpty());
        assertFalse(resource.component().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Observation.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ObservationStatus>) null).build()).getMessage());
    }

    @Test
    void diagnosticReport() {
        DiagnosticReport resource = DiagnosticReport.builder()
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
                .addBasedOn(Reference.builder().build())
                .status(FhirEnum.of(DiagnosticReportStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .effective(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .issued(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPerformer(Reference.builder().build())
                .addResultsInterpreter(Reference.builder().build())
                .addSpecimen(Reference.builder().build())
                .addResult(Reference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addStudy(Reference.builder().build())
                .addSupportingInfo(DiagnosticReport.SupportingInfo.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .reference(Reference.builder().build())
                        .build())
                .addMedia(DiagnosticReport.Media.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .comment(FhirString.of("text"))
                        .link(Reference.builder().build())
                        .build())
                .composition(Reference.builder().build())
                .conclusion(FhirMarkdown.of("text"))
                .addConclusionCode(CodeableConcept.builder().build())
                .addPresentedForm(Attachment.builder().build())
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
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.effective());
        assertNotNull(resource.issued());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.resultsInterpreter().isEmpty());
        assertFalse(resource.specimen().isEmpty());
        assertFalse(resource.result().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.study().isEmpty());
        assertFalse(resource.supportingInfo().isEmpty());
        assertFalse(resource.media().isEmpty());
        assertNotNull(resource.composition());
        assertNotNull(resource.conclusion());
        assertFalse(resource.conclusionCode().isEmpty());
        assertFalse(resource.presentedForm().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DiagnosticReport.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<DiagnosticReportStatus>) null).build()).getMessage());
    }

    @Test
    void specimen() {
        Specimen resource = Specimen.builder()
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
                .accessionIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(SpecimenStatus.values()[0]))
                .type(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .receivedTime(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addParent(Reference.builder().build())
                .addRequest(Reference.builder().build())
                .combined(FhirEnum.of(SpecimenCombined.values()[0]))
                .addRole(CodeableConcept.builder().build())
                .addFeature(Specimen.Feature.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .type(CodeableConcept.builder().build())
                        .description(FhirString.of("text"))
                        .build())
                .collection(Specimen.Collection.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .collector(Reference.builder().build())
                        .collected(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .duration(Duration.builder().build())
                        .quantity(Quantity.builder().build())
                        .method(CodeableConcept.builder().build())
                        .device(CodeableReference.builder().build())
                        .procedure(Reference.builder().build())
                        .bodySite(CodeableReference.builder().build())
                        .fastingStatus(CodeableConcept.builder().build())
                        .build())
                .addProcessing(Specimen.Processing.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .description(FhirString.of("text"))
                        .method(CodeableConcept.builder().build())
                        .addAdditive(Reference.builder().build())
                        .time(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .build())
                .addContainer(Specimen.Container.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .device(Reference.builder().build())
                        .location(Reference.builder().build())
                        .specimenQuantity(Quantity.builder().build())
                        .build())
                .addCondition(CodeableConcept.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
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
        assertNotNull(resource.accessionIdentifier());
        assertNotNull(resource.status());
        assertNotNull(resource.type());
        assertNotNull(resource.subject());
        assertNotNull(resource.receivedTime());
        assertFalse(resource.parent().isEmpty());
        assertFalse(resource.request().isEmpty());
        assertNotNull(resource.combined());
        assertFalse(resource.role().isEmpty());
        assertFalse(resource.feature().isEmpty());
        assertNotNull(resource.collection());
        assertFalse(resource.processing().isEmpty());
        assertFalse(resource.container().isEmpty());
        assertFalse(resource.condition().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void bodyStructure() {
        BodyStructure resource = BodyStructure.builder()
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
                .active(FhirBoolean.of(true))
                .morphology(CodeableConcept.builder().build())
                .addIncludedStructure(BodyStructure.IncludedStructure.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .structure(CodeableConcept.builder().build())
                        .laterality(CodeableConcept.builder().build())
                        .addBodyLandmarkOrientation(BodyStructure.IncludedStructure.BodyLandmarkOrientation.builder()
                                
                                .build())
                        .addSpatialReference(Reference.builder().build())
                        .addQualifier(CodeableConcept.builder().build())
                        .build())
                .addExcludedStructure(BodyStructure.IncludedStructure.builder()
                        .structure(CodeableConcept.builder().build())
                        .build())
                .description(FhirMarkdown.of("text"))
                .addImage(Attachment.builder().build())
                .patient(Reference.builder().build())
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
        assertNotNull(resource.active());
        assertNotNull(resource.morphology());
        assertFalse(resource.includedStructure().isEmpty());
        assertFalse(resource.excludedStructure().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.image().isEmpty());
        assertNotNull(resource.patient());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("BodyStructure.includedStructure requires at least one value", assertThrows(
                IllegalArgumentException.class,
                (
                        ) -> resource.toBuilder().includedStructure((java.util.List<BodyStructure.IncludedStructure>) null).build()).getMessage());
    }

    @Test
    void imagingSelection() {
        ImagingSelection resource = ImagingSelection.builder()
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
                .status(FhirEnum.of(ImagingSelectionStatus.values()[0]))
                .subject(Reference.builder().build())
                .issued(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addPerformer(ImagingSelection.Performer.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .function(CodeableConcept.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addBasedOn(Reference.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .studyUid(FhirId.of("id1"))
                .addDerivedFrom(Reference.builder().build())
                .addEndpoint(Reference.builder().build())
                .seriesUid(FhirId.of("id1"))
                .seriesNumber(FhirUnsignedInt.of(0))
                .frameOfReferenceUid(FhirId.of("id1"))
                .bodySite(CodeableReference.builder().build())
                .addFocus(Reference.builder().build())
                .addInstance(ImagingSelection.Instance.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .uid(FhirId.of("id1"))
                        .number(FhirUnsignedInt.of(0))
                        .sopClass(Coding.builder().build())
                        .addSubset(FhirString.of("text"))
                        .addImageRegion2D(ImagingSelection.Instance.ImageRegion2D.builder()
                                .regionType(FhirEnum.of(ImagingSelection2DGraphicType.values()[0]))
                                .addCoordinate(FhirDecimal.parse("1.0"))
                                .build())
                        .addImageRegion3D(ImagingSelection.Instance.ImageRegion3D.builder()
                                .regionType(FhirEnum.of(ImagingSelection3DGraphicType.values()[0]))
                                .addCoordinate(FhirDecimal.parse("1.0"))
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.subject());
        assertNotNull(resource.issued());
        assertFalse(resource.performer().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.studyUid());
        assertFalse(resource.derivedFrom().isEmpty());
        assertFalse(resource.endpoint().isEmpty());
        assertNotNull(resource.seriesUid());
        assertNotNull(resource.seriesNumber());
        assertNotNull(resource.frameOfReferenceUid());
        assertNotNull(resource.bodySite());
        assertFalse(resource.focus().isEmpty());
        assertFalse(resource.instance().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImagingSelection.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ImagingSelectionStatus>) null).build()).getMessage());
    }

    @Test
    void imagingStudy() {
        ImagingStudy resource = ImagingStudy.builder()
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
                .status(FhirEnum.of(ImagingStudyStatus.values()[0]))
                .addModality(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .started(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addBasedOn(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .referrer(Reference.builder().build())
                .addEndpoint(Reference.builder().build())
                .numberOfSeries(FhirUnsignedInt.of(0))
                .numberOfInstances(FhirUnsignedInt.of(0))
                .addProcedure(CodeableReference.builder().build())
                .location(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .description(FhirString.of("text"))
                .addSeries(ImagingStudy.Series.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .uid(FhirId.of("id1"))
                        .number(FhirUnsignedInt.of(0))
                        .modality(CodeableConcept.builder().build())
                        .description(FhirString.of("text"))
                        .numberOfInstances(FhirUnsignedInt.of(0))
                        .addEndpoint(Reference.builder().build())
                        .bodySite(CodeableReference.builder().build())
                        .laterality(CodeableConcept.builder().build())
                        .addSpecimen(Reference.builder().build())
                        .started(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addPerformer(ImagingStudy.Series.Performer.builder()
                                .actor(Reference.builder().build())
                                .build())
                        .addInstance(ImagingStudy.Series.Instance.builder()
                                .uid(FhirId.of("id1"))
                                .sopClass(Coding.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.modality().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.started());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.referrer());
        assertFalse(resource.endpoint().isEmpty());
        assertNotNull(resource.numberOfSeries());
        assertNotNull(resource.numberOfInstances());
        assertFalse(resource.procedure().isEmpty());
        assertNotNull(resource.location());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.series().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("ImagingStudy.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ImagingStudyStatus>) null).build()).getMessage());
    }

    @Test
    void questionnaireResponse() {
        QuestionnaireResponse resource = QuestionnaireResponse.builder()
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
                .addBasedOn(Reference.builder().build())
                .addPartOf(Reference.builder().build())
                .questionnaire(FhirCanonical.of("http://example.org/canonical"))
                .status(FhirEnum.of(QuestionnaireResponseStatus.values()[0]))
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .authored(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .author(Reference.builder().build())
                .source(Reference.builder().build())
                .addItem(QuestionnaireResponse.Item.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .linkId(FhirString.of("text"))
                        .definition(FhirUri.of("http://example.org/uri"))
                        .text(FhirString.of("text"))
                        .addAnswer(QuestionnaireResponse.Item.Answer.builder()
                                .value(FhirBoolean.of(true))
                                .build())
                        .addItem(QuestionnaireResponse.Item.builder()
                                .linkId(FhirString.of("text"))
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
        assertFalse(resource.identifier().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.partOf().isEmpty());
        assertNotNull(resource.questionnaire());
        assertNotNull(resource.status());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.authored());
        assertNotNull(resource.author());
        assertNotNull(resource.source());
        assertFalse(resource.item().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("QuestionnaireResponse.questionnaire is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().questionnaire((FhirCanonical) null).build()).getMessage());
    }

    @Test
    void molecularSequence() {
        MolecularSequence resource = MolecularSequence.builder()
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
                .type(FhirEnum.of(SequenceType.values()[0]))
                .subject(Reference.builder().build())
                .addFocus(Reference.builder().build())
                .specimen(Reference.builder().build())
                .device(Reference.builder().build())
                .performer(Reference.builder().build())
                .literal(FhirString.of("text"))
                .addFormatted(Attachment.builder().build())
                .addRelative(MolecularSequence.Relative.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .coordinateSystem(CodeableConcept.builder().build())
                        .ordinalPosition(FhirInteger.of(1))
                        .sequenceRange(Range.builder().build())
                        .startingSequence(MolecularSequence.Relative.StartingSequence.builder().build())
                        .addEdit(MolecularSequence.Relative.Edit.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.type());
        assertNotNull(resource.subject());
        assertFalse(resource.focus().isEmpty());
        assertNotNull(resource.specimen());
        assertNotNull(resource.device());
        assertNotNull(resource.performer());
        assertNotNull(resource.literal());
        assertFalse(resource.formatted().isEmpty());
        assertFalse(resource.relative().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
    }

    @Test
    void genomicStudy() {
        GenomicStudy resource = GenomicStudy.builder()
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
                .status(FhirEnum.of(GenomicStudyStatus.values()[0]))
                .addType(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .startDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addBasedOn(Reference.builder().build())
                .referrer(Reference.builder().build())
                .addInterpreter(Reference.builder().build())
                .addReason(CodeableReference.builder().build())
                .instantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                .instantiatesUri(FhirUri.of("http://example.org/uri"))
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .description(FhirMarkdown.of("text"))
                .addAnalysis(GenomicStudy.Analysis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addIdentifier(Identifier.builder().build())
                        .addMethodType(CodeableConcept.builder().build())
                        .addChangeType(CodeableConcept.builder().build())
                        .genomeBuild(CodeableConcept.builder().build())
                        .instantiatesCanonical(FhirCanonical.of("http://example.org/canonical"))
                        .instantiatesUri(FhirUri.of("http://example.org/uri"))
                        .title(FhirString.of("text"))
                        .addFocus(Reference.builder().build())
                        .addSpecimen(Reference.builder().build())
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                        .protocolPerformed(Reference.builder().build())
                        .addRegionsStudied(Reference.builder().build())
                        .addRegionsCalled(Reference.builder().build())
                        .addInput(GenomicStudy.Analysis.Input.builder().build())
                        .addOutput(GenomicStudy.Analysis.Output.builder().build())
                        .addPerformer(GenomicStudy.Analysis.Performer.builder().build())
                        .addDevice(GenomicStudy.Analysis.Device.builder().build())
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
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertFalse(resource.type().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.encounter());
        assertNotNull(resource.startDate());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.referrer());
        assertFalse(resource.interpreter().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertNotNull(resource.instantiatesCanonical());
        assertNotNull(resource.instantiatesUri());
        assertFalse(resource.note().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.analysis().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("GenomicStudy.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<GenomicStudyStatus>) null).build()).getMessage());
    }
}
