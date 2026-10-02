package se.poroli.fhirplace.r5.foundation.documents;

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
import se.poroli.fhirplace.r5.datatypes.Extension;
import se.poroli.fhirplace.r5.datatypes.FhirCode;
import se.poroli.fhirplace.r5.datatypes.FhirDateTime;
import se.poroli.fhirplace.r5.datatypes.FhirEnum;
import se.poroli.fhirplace.r5.datatypes.FhirInstant;
import se.poroli.fhirplace.r5.datatypes.FhirMarkdown;
import se.poroli.fhirplace.r5.datatypes.FhirString;
import se.poroli.fhirplace.r5.datatypes.FhirUri;
import se.poroli.fhirplace.r5.datatypes.FhirXhtml;
import se.poroli.fhirplace.r5.datatypes.Identifier;
import se.poroli.fhirplace.r5.datatypes.Meta;
import se.poroli.fhirplace.r5.datatypes.Narrative;
import se.poroli.fhirplace.r5.datatypes.Period;
import se.poroli.fhirplace.r5.datatypes.Reference;
import se.poroli.fhirplace.r5.datatypes.RelatedArtifact;
import se.poroli.fhirplace.r5.datatypes.UsageContext;
import se.poroli.fhirplace.r5.valuesets.CompositionStatus;
import se.poroli.fhirplace.r5.valuesets.DocumentReferenceStatus;
import se.poroli.fhirplace.r5.valuesets.NarrativeStatus;
import se.poroli.fhirplace.r5.valuesets.RelatedArtifactType;

/** Builds every foundation.documents resource with all elements and checks the builders and validation. */
class FoundationDocumentsResourcesTest {

    @Test
    void composition() {
        Composition resource = Composition.builder()
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
                .status(FhirEnum.of(CompositionStatus.values()[0]))
                .type(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .addSubject(Reference.builder().build())
                .encounter(Reference.builder().build())
                .date(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                .addUseContext(UsageContext.builder()
                        .code(Coding.builder().build())
                        .value(CodeableConcept.builder().build())
                        .build())
                .addAuthor(Reference.builder().build())
                .name(FhirString.of("text"))
                .title(FhirString.of("text"))
                .addNote(Annotation.builder().text(FhirMarkdown.of("text")).build())
                .addAttester(Composition.Attester.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .mode(CodeableConcept.builder().build())
                        .time(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .party(Reference.builder().build())
                        .build())
                .custodian(Reference.builder().build())
                .addRelatesTo(RelatedArtifact.builder()
                        .type(FhirEnum.of(RelatedArtifactType.values()[0]))
                        .build())
                .addEvent(Composition.Event.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .period(Period.builder().build())
                        .addDetail(CodeableReference.builder().build())
                        .build())
                .addSection(Composition.Section.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .title(FhirString.of("text"))
                        .code(CodeableConcept.builder().build())
                        .addAuthor(Reference.builder().build())
                        .focus(Reference.builder().build())
                        .text(Narrative.builder()
                                .status(FhirEnum.of(NarrativeStatus.values()[0]))
                                .div(FhirXhtml.of("<div xmlns=\"http://www.w3.org/1999/xhtml\"/>"))
                                .build())
                        .orderedBy(CodeableConcept.builder().build())
                        .addEntry(Reference.builder().build())
                        .emptyReason(CodeableConcept.builder().build())
                        .addSection(Composition.Section.builder().build())
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
        assertNotNull(resource.status());
        assertNotNull(resource.type());
        assertFalse(resource.category().isEmpty());
        assertFalse(resource.subject().isEmpty());
        assertNotNull(resource.encounter());
        assertNotNull(resource.date());
        assertFalse(resource.useContext().isEmpty());
        assertFalse(resource.author().isEmpty());
        assertNotNull(resource.name());
        assertNotNull(resource.title());
        assertFalse(resource.note().isEmpty());
        assertFalse(resource.attester().isEmpty());
        assertNotNull(resource.custodian());
        assertFalse(resource.relatesTo().isEmpty());
        assertFalse(resource.event().isEmpty());
        assertFalse(resource.section().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("Composition.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<CompositionStatus>) null).build()).getMessage());
    }

    @Test
    void documentReference() {
        DocumentReference resource = DocumentReference.builder()
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
                .version(FhirString.of("text"))
                .addBasedOn(Reference.builder().build())
                .status(FhirEnum.of(DocumentReferenceStatus.values()[0]))
                .docStatus(FhirEnum.of(CompositionStatus.values()[0]))
                .addModality(CodeableConcept.builder().build())
                .type(CodeableConcept.builder().build())
                .addCategory(CodeableConcept.builder().build())
                .subject(Reference.builder().build())
                .addContext(Reference.builder().build())
                .addEvent(CodeableReference.builder().build())
                .addBodySite(CodeableReference.builder().build())
                .facilityType(CodeableConcept.builder().build())
                .practiceSetting(CodeableConcept.builder().build())
                .period(Period.builder().build())
                .date(FhirInstant.parse("2024-01-01T00:00:00Z"))
                .addAuthor(Reference.builder().build())
                .addAttester(DocumentReference.Attester.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .mode(CodeableConcept.builder().build())
                        .time(FhirDateTime.parse("2024-01-01T00:00:00Z"))
                        .party(Reference.builder().build())
                        .build())
                .custodian(Reference.builder().build())
                .addRelatesTo(DocumentReference.RelatesTo.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .code(CodeableConcept.builder().build())
                        .target(Reference.builder().build())
                        .build())
                .description(FhirMarkdown.of("text"))
                .addSecurityLabel(CodeableConcept.builder().build())
                .addContent(DocumentReference.Content.builder()
                        .id("id1")
                        .addExtension(Extension.builder().url("http://example.org/extension").build())
                        .addModifierExtension(Extension.builder().url("http://example.org/extension").build())
                        .attachment(Attachment.builder().build())
                        .addProfile(DocumentReference.Content.Profile.builder()
                                .value(Coding.builder().build())
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
        assertNotNull(resource.version());
        assertFalse(resource.basedOn().isEmpty());
        assertNotNull(resource.status());
        assertNotNull(resource.docStatus());
        assertFalse(resource.modality().isEmpty());
        assertNotNull(resource.type());
        assertFalse(resource.category().isEmpty());
        assertNotNull(resource.subject());
        assertFalse(resource.context().isEmpty());
        assertFalse(resource.event().isEmpty());
        assertFalse(resource.bodySite().isEmpty());
        assertNotNull(resource.facilityType());
        assertNotNull(resource.practiceSetting());
        assertNotNull(resource.period());
        assertNotNull(resource.date());
        assertFalse(resource.author().isEmpty());
        assertFalse(resource.attester().isEmpty());
        assertNotNull(resource.custodian());
        assertFalse(resource.relatesTo().isEmpty());
        assertNotNull(resource.description());
        assertFalse(resource.securityLabel().isEmpty());
        assertFalse(resource.content().isEmpty());
        assertEquals(resource, resource.toBuilder().build());
        assertEquals(resource.hashCode(), resource.toBuilder().build().hashCode());
        assertEquals("DocumentReference.status is required", assertThrows(NullPointerException.class,
                () -> resource.toBuilder().status((FhirEnum<DocumentReferenceStatus>) null).build()).getMessage());
    }
}
