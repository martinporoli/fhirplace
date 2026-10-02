package se.poroli.fhirplace.r5.base.management;

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
import se.poroli.fhirplace.r5.datatypes.ContactDetail;
import se.poroli.fhirplace.r5.datatypes.DataRequirement;
import se.poroli.fhirplace.r5.datatypes.Duration;
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirBoolean;
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
import se.poroli.fhirplace.r5.datatypes.ParameterDefinition;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.datatypes.VirtualServiceDetail;
import se.poroli.fhirplace.r5.valuesets.EncounterLocationStatus;
import se.poroli.fhirplace.r5.valuesets.EncounterStatus;
import se.poroli.fhirplace.r5.valuesets.EpisodeOfCareStatus;
import se.poroli.fhirplace.r5.valuesets.FHIRTypes;
import se.poroli.fhirplace.r5.valuesets.FlagStatus;
import se.poroli.fhirplace.r5.valuesets.ListMode;
import se.poroli.fhirplace.r5.valuesets.ListStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.OperationParameterUse;
import se.poroli.fhirplace.r5.valuesets.PublicationStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;

/** Builds every base.management resource with all elements and checks the builders and validation. */
class BaseManagementResourcesTest {

    @Test
    void encounter() {
        Encounter resource = Encounter.builder()
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
                .status(FhirEnum.of(EncounterStatus.values()[0]))
                .addClassValue(CodeableConcept.builder().build())
                .priority(CodeableConcept.builder().build())
                .addType(CodeableConcept.builder().build())
                .addServiceType(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .subjectStatus(CodeableConcept.builder().build())
                .addEpisodeOfCare(Reference.builder().build())
                .addBasedOn(Reference.builder().build())
                .addCareTeam(Reference.builder().build())
                .partOf(Reference.builder().build())
                .serviceProvider(Reference.builder().build())
                .addParticipant(Encounter.Participant.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addType(CodeableConcept.builder().build())
                        .period(Period.builder().build())
                        .actor(Reference.builder().build())
                        .build())
                .addAppointment(Reference.builder().build())
                .addVirtualService(VirtualServiceDetail.builder().build())
                .actualPeriod(Period.builder().build())
                .plannedStartDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .plannedEndDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .length(Duration.builder().build())
                .addReason(Encounter.Reason.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addUse(CodeableConcept.builder().build())
                        .addValue(CodeableReference.builder().build())
                        .build())
                .addDiagnosis(Encounter.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addCondition(CodeableReference.builder().build())
                        .addUse(CodeableConcept.builder().build())
                        .build())
                .addAccount(Reference.builder().build())
                .addDietPreference(CodeableConcept.builder().build())
                .addSpecialArrangement(CodeableConcept.builder().build())
                .addSpecialCourtesy(CodeableConcept.builder().build())
                .admission(Encounter.Admission.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .preAdmissionIdentifier(Identifier.builder().build())
                        .origin(Reference.builder().build())
                        .admitSource(CodeableConcept.builder().build())
                        .reAdmission(CodeableConcept.builder().build())
                        .destination(Reference.builder().build())
                        .dischargeDisposition(CodeableConcept.builder().build())
                        .build())
                .addLocation(Encounter.Location.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .location(Reference.builder().build())
                        .status(FhirEnum.of(EncounterLocationStatus.values()[0]))
                        .form(CodeableConcept.builder().build())
                        .period(Period.builder().build())
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
        assertFalse(resource.classValue().isEmpty());
        assertNotNull(resource.priority());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.serviceType().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.subjectStatus());
        assertFalse(resource.episodeOfCare().isEmpty());
        assertFalse(resource.basedOn().isEmpty());
        assertFalse(resource.careTeam().isEmpty());
        assertNotNull(resource.partOf());
        assertNotNull(resource.serviceProvider());
        assertFalse(resource.participant().isEmpty());
        assertFalse(resource.appointment().isEmpty());
        assertFalse(resource.virtualService().isEmpty());
        assertNotNull(resource.actualPeriod());
        assertNotNull(resource.plannedStartDate());
        assertNotNull(resource.plannedEndDate());
        assertNotNull(resource.length());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertFalse(resource.account().isEmpty());
        assertFalse(resource.dietPreference().isEmpty());
        assertFalse(resource.specialArrangement().isEmpty());
        assertFalse(resource.specialCourtesy().isEmpty());
        assertNotNull(resource.admission());
        assertFalse(resource.location().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Encounter.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EncounterStatus>) null).build()).getMessage());
    }

    @Test
    void encounterHistory() {
        EncounterHistory resource = EncounterHistory.builder()
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
                .encounter(Reference.builder().build())
                .addIdentifier(Identifier.builder().build())
                .status(FhirEnum.of(EncounterStatus.values()[0]))
                .classValue(CodeableConcept.builder().build())
                .addType(CodeableConcept.builder().build())
                .addServiceType(CodeableReference.builder().build())
                .subject(Reference.builder().build())
                .subjectStatus(CodeableConcept.builder().build())
                .actualPeriod(Period.builder().build())
                .plannedStartDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .plannedEndDate(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .length(Duration.builder().build())
                .addLocation(EncounterHistory.Location.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .location(Reference.builder().build())
                        .form(CodeableConcept.builder().build())
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
        assertNotNull(resource.encounter());
        assertFalse(resource.identifier().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.classValue());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.serviceType().isEmpty());
        assertNotNull(resource.subject());
        assertNotNull(resource.subjectStatus());
        assertNotNull(resource.actualPeriod());
        assertNotNull(resource.plannedStartDate());
        assertNotNull(resource.plannedEndDate());
        assertNotNull(resource.length());
        assertFalse(resource.location().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("EncounterHistory.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EncounterStatus>) null).build()).getMessage());
    }

    @Test
    void episodeOfCare() {
        EpisodeOfCare resource = EpisodeOfCare.builder()
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
                .status(FhirEnum.of(EpisodeOfCareStatus.values()[0]))
                .addStatusHistory(EpisodeOfCare.StatusHistory.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .status(FhirEnum.of(EpisodeOfCareStatus.values()[0]))
                        .period(Period.builder().build())
                        .build())
                .addType(CodeableConcept.builder().build())
                .addReason(EpisodeOfCare.Reason.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .use(CodeableConcept.builder().build())
                        .addValue(CodeableReference.builder().build())
                        .build())
                .addDiagnosis(EpisodeOfCare.Diagnosis.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .addCondition(CodeableReference.builder().build())
                        .use(CodeableConcept.builder().build())
                        .build())
                .patient(Reference.builder().build())
                .managingOrganization(Reference.builder().build())
                .period(Period.builder().build())
                .addReferralRequest(Reference.builder().build())
                .careManager(Reference.builder().build())
                .addCareTeam(Reference.builder().build())
                .addAccount(Reference.builder().build())
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
        assertFalse(resource.statusHistory().isEmpty());
        assertFalse(resource.type().isEmpty());
        assertFalse(resource.reason().isEmpty());
        assertFalse(resource.diagnosis().isEmpty());
        assertNotNull(resource.patient());
        assertNotNull(resource.managingOrganization());
        assertNotNull(resource.period());
        assertFalse(resource.referralRequest().isEmpty());
        assertNotNull(resource.careManager());
        assertFalse(resource.careTeam().isEmpty());
        assertFalse(resource.account().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("EpisodeOfCare.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<EpisodeOfCareStatus>) null).build()).getMessage());
    }

    @Test
    void flag() {
        Flag resource = Flag.builder()
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
                .status(FhirEnum.of(FlagStatus.values()[0]))
                .addCategory(CodeableConcept.builder().build())
                .code(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .period(Period.builder().build())
                .encounter(Reference.builder().build())
                .author(Reference.builder().build())
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
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.code());
        assertNotNull(resource.subject());
        assertNotNull(resource.period());
        assertNotNull(resource.encounter());
        assertNotNull(resource.author());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Flag.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<FlagStatus>) null).build()).getMessage());
    }

    @Test
    void list() {
        List resource = List.builder()
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
                .status(FhirEnum.of(ListStatus.values()[0]))
                .mode(FhirEnum.of(ListMode.values()[0]))
                .title(FhirString.of("text"))
                .code(CodeableConcept.builder().build())
                .addSubject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .source(Reference.builder().build())
                .orderedBy(CodeableConcept.builder().build())
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addEntry(List.Entry.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .flag(CodeableConcept.builder().build())
                        .deleted(FhirBoolean.of(true))
                        .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .item(Reference.builder().build())
                        .build())
                .emptyReason(CodeableConcept.builder().build())
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
        assertNotNull(resource.mode());
        assertNotNull(resource.title());
        assertNotNull(resource.code());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.encounter());
        assertNotNull(resource.date());
        assertNotNull(resource.source());
        assertNotNull(resource.orderedBy());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.entry().isEmpty());
        assertNotNull(resource.emptyReason());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("List.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<ListStatus>) null).build()).getMessage());
    }

    @Test
    void library() {
        Library resource = Library.builder()
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
                .type(CodeableConcept.builder().build())
                .subject(CodeableConcept.builder().build())
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
                .addParameter(ParameterDefinition.builder()
                        .use(FhirEnum.of(OperationParameterUse.values()[0]))
                        .type(FhirEnum.of(FHIRTypes.values()[0]))
                        .build())
                .addDataRequirement(DataRequirement.builder()
                        .type(FhirEnum.of(FHIRTypes.values()[0]))
                        .build())
                .addContent(Attachment.builder().build())
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
        assertNotNull(resource.type());
        assertNotNull(resource.subject());
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
        assertFalse(resource.parameter().isEmpty());
        assertFalse(resource.dataRequirement().isEmpty());
        assertFalse(resource.content().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Library.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<PublicationStatus>) null).build()).getMessage());
    }
}
